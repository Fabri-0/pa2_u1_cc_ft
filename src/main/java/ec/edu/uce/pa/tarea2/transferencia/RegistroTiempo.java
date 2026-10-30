package ec.edu.uce.pa.tarea2.transferencia;

import jakarta.enterprise.context.Dependent;

@Dependent
public class RegistroTiempo {

    public void registrar(String metodo, long duracion) {
        System.out.println("Método: " + metodo);
        System.out.println("Tiempo de ejecución: " + duracion + " ns");
    }
}
