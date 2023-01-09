package fichas;

import clientes.Cliente;
import clientes.ControladorCliente;
import clientes.Parser;
import database.ControladorBD;
import database.SQLTable;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorFicha {
    private ControladorBD controladorBD;
    private ControladorCliente controladorCliente;
    public ControladorFicha() {
        controladorBD = ControladorBD.getInstance();
        controladorCliente = new ControladorCliente();
    }
    public Ficha consultarFicha(String ID) throws Exception {
        //Consultar cliente
        SQLTable result = controladorBD.ejecutarSentencia(String.format("select * from ficha_cliente where ID='%s'", ID));

        if(result.getRowCount() == 0) return null;
        Cliente cliente = controladorCliente.consultarCliente((String) result.getValueAt(0,"cliente"));
        //Agregar datos de constructor
        Ficha ficha = new Ficha(
                (String) result.getValueAt(0,"ID"),
                cliente,
                (String) result.getValueAt(0,"fecha_inicio"),
                (String) result.getValueAt(0, "ultima_asistencia"),
                ((Integer)result.getValueAt(0,"esta_activo") > 0));
        ficha.setAltura((Double) result.getValueAt(0, "altura"));
        ficha.setPeso((Double) result.getValueAt(0, "peso"));

        //Consultar Actividades
        result = controladorBD.ejecutarSentencia(String.format(
                "select h.id as horario, h.hora_inicio, h.hora_fin, h.dia, h.actividad, a.nombre, a.descripcion " +
                        "from horarios_actividades as h, actividades as a " +
                        "where h.actividad=a.id and h.ficha='%s'", ficha.getID()));
        for(int i = 0; i < result.getRowCount(); i++){

            Horario horario = new Horario(
                    (String) result.getValueAt(i, "horario"),
                (String) result.getValueAt(i, "hora_inicio"),
                (String) result.getValueAt(i, "hora_fin"),
                new Actividad(
                    (String) result.getValueAt(i, "actividad"),
                    (String) result.getValueAt(i, "nombre"),
                    (String) result.getValueAt(i, "descripcion")
                ), (Integer) result.getValueAt(i, "dia")
            );
            ficha.registrarHorario(horario);
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
                "where ID='" + ficha.getID() + "'");

        for(Horario horario: ficha.getHorarios()){
//            sentencias.add(String.format("UPDATE horarios_actividades SET hora_inicio='%s'," +
//                    "hora_fin='%s', dia=%d WHERE ficha='%s' and actividad='%s'",
//                    Parser.toString(horario.getInicio()),
//                    Parser.toString(horario.getFin()),
//                    horario.getDia(),
//                    ficha.getID(),
//                    horario.getActividad().getID()
//                    ));
//            sentencias.add(String.format("UPDATE actividades SET nombre='%s', descripcion='%s' WHERE id='%s'",
//                    horario.getActividad().getNombre(),
//                    horario.getActividad().getDescripcion(),
//                    horario.getActividad().getID()
//                    ));
            registrarHorario(horario, ficha);
        }

        controladorBD.ejecutarSentencias(sentencias.toArray(new String[0]));
    }

    public void registrarFicha(Ficha ficha) throws SQLException {
        ArrayList<String> consultas = new ArrayList<>();
        consultas.add(String.format("INSERT INTO ficha_cliente VALUES('%s','%s','%s','%s','%s','%s','%d')",
                ficha.getID(), ficha.getCliente().getCedula(), ficha.getPeso(), ficha.getAltura(),
                Parser.toString(ficha.getFechaInicio()), Parser.toString(ficha.getUltimaAsistencia()),
                (ficha.estaActivo())? 1:0
                ));
        for(Horario horario : ficha.getHorarios()) {
            registrarHorario(horario, ficha);
        }
        controladorBD.ejecutarSentencias(consultas.toArray(new String[0]));
    }

    private void registrarHorario(Horario horario, Ficha ficha) throws SQLException {
        SQLTable results = controladorBD.ejecutarSentencia(
                String.format("select * from horarios_actividades where id='%s'",horario.getID()));
        if(results.getRowCount() == 0) {
            controladorBD.ejecutarSentencia(horario.insert(ficha.getID()));
            return;
        }
        ArrayList<String> sentencias = new ArrayList<>();
        sentencias.add(horario.update());
        sentencias.add(horario.getActividad().update());
        controladorBD.ejecutarSentencias(sentencias.toArray(new String[0]));
    }

    public Ficha consultarFichaPorCliente(String cedula) throws Exception {
        String sentencia = String.format("select * from ficha_cliente where cliente='%s'", cedula);
        SQLTable result = controladorBD.ejecutarSentencia(sentencia);
        if (result.getRowCount() == 0) return null;
        return consultarFicha((String) result.getValueAt(0, "ID"));

    }
}
