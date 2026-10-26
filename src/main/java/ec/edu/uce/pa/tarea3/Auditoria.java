package ec.edu.uce.pa.tarea3;

import java.util.UUID;

import jakarta.enterprise.context.Dependent;

@Dependent
public class Auditoria {

    private final String id = UUID.randomUUID().toString();

    public void registrar(String tipo, double monto, double descuento, double total,
            String idCalculadora) {

        System.out.println("Auditoría ID: " + this.id);
        System.out.println("Calculadora ID: " + idCalculadora);
        System.out.println("Tipo Cliente: " + tipo);
        System.out.println("Monto: $" + monto);
        System.out.println("Descuento: $" + descuento);
        System.out.println("Total a pagar: $" + total);

    }

    public String getId() {
        return this.id;
    }

}
