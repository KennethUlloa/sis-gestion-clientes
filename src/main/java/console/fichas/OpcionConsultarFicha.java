package console.fichas;

import clientes.excepciones.ErrorCedula;
import console.Opcion;
import database.exceptions.NoSuchColumn;
import fichas.ControladorFicha;
import fichas.Ficha;

import java.sql.SQLException;
import java.util.Scanner;

public class OpcionConsultarFicha extends Opcion {
    public OpcionConsultarFicha() {
        super("Consultar Ficha");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Identificador de ficha >> ");
        String idFicha = scanner.next();
        try {
            Ficha ficha = new ControladorFicha().consultarFicha(idFicha);
            if(ficha != null){
                System.out.println(ficha);
            }else{
                System.out.println("No existe la ficha");
            }

        } catch (SQLException | NoSuchColumn e) {
            System.out.println("No se pudo realizar la acción solicitada");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
