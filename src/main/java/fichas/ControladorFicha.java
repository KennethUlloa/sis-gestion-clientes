package fichas;

import clientes.Cliente;
import clientes.ControladorCliente;
import clientes.Parser;
import database.ControladorBD;
import database.SQLTable;
import database.exceptions.NoSuchColumn;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ControladorFicha {
    private ControladorBD controladorBD;
    private ControladorCliente controladorCliente;
    public ControladorFicha() {
        controladorBD = ControladorBD.getInstance();
        controladorCliente = new ControladorCliente();
    }
    public Ficha consultarFicha(String ID) throws SQLException, NoSuchColumn {
        //Consultar cliente
        SQLTable result = controladorBD.ejecutarSentencia("select f.ID, f.cliente, f.peso, f.altura, f.fecha_inicio, f.ultima_asistencia, f.esta_activo, h.hora_inicio, h.hora_fin, h.dia, h.actividad, a.nombre, a.descripcion\n" +
                "from ficha_cliente as f, horarios_actividades as h, actividades as a \n" +
                "where f.ID=h.ficha AND h.actividad=a.id AND f.ID='"+ID+"';");
        if(result.getRowCount() == 0) return null;
        Cliente c = controladorCliente.consultarCliente((String) result.getValueAt(0,"cliente"));
        //Agregar datos de constructor
        Ficha ficha = new Ficha((String) result.getValueAt(0,"ID"), c, (String) result.getValueAt(0,"fecha_inicio"),
                (String) result.getValueAt(0, "ultima_asistencia"),
                ((Integer)result.getValueAt(0,"esta_activo") == 1));
        ficha.setAltura((Double) result.getValueAt(0, "altura"));
        ficha.setPeso((Double) result.getValueAt(0, "peso"));

        //Consultar Actividades
        for(int i = 0; i < result.getRowCount(); i++){
            RegistroActividad registroActividad = new RegistroActividad(
                    new Actividad(
                            (String) result.getValueAt(i, "actividad"),
                            (String) result.getValueAt(i, "nombre"),
                            (String) result.getValueAt(0, "descripcion")
                    ),
                    new Horario(
                            (String) result.getValueAt(i, "hora_inicio"),
                            (String) result.getValueAt(i, "hora_fin")
                    ),
                    (Integer) result.getValueAt(i, "dia")
            );
            ficha.registrarActividad(registroActividad);
        }

        return ficha;
    }

    public void actualizarFicha(Ficha ficha) throws SQLException {
        //Actualizar los datos propios de la ficha
        ArrayList<String> sentencias = new ArrayList<>();

        sentencias.add("UPDATE ficha_cliente\n" +
                "SET peso=" + ficha.getPeso() + ",\n" +
                "altura=" + ficha.getAltura() + ",\n" +
                "fecha_inicio='" + Parser.toString(ficha.getFechaInicio()) + "',\n" +
                "ultima_asistencia='" + Parser.toString(ficha.getUltimaAsistencia()) + "',\n" +
                "esta_activo=" + (ficha.estaActivo()? 1 : 0) + "\n" +
                "where ID='F1';");

        for(RegistroActividad registroActividad: ficha.getRegistroActividades()){
            sentencias.add(String.format("UPDATE horarios_actividades SET hora_inicio='%s'," +
                    "hora_fin='%s', dia=%d WHERE ficha='%s' and actividad='%s'",
                    Parser.toString(registroActividad.getHorario().getInicio()),
                    Parser.toString(registroActividad.getHorario().getFin()),
                    registroActividad.getDia(),
                    ficha.getID(),
                    registroActividad.getActividad().getID()
                    ));
            sentencias.add(String.format("UPDATE actividades SET nombre='%s', descripcion='%s' WHERE id='%s'",
                    registroActividad.getActividad().getNombre(),
                    registroActividad.getActividad().getDescripcion(),
                    registroActividad.getActividad().getID()
                    ));
        }

        controladorBD.ejecutarSentencias(sentencias.toArray(new String[0]));
    }
}
