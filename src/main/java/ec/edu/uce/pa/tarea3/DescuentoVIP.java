package ec.edu.uce.pa.tarea3;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("vip")
public class DescuentoVIP implements CalculadoraDescuento {

    private final String id = UUID.randomUUID().toString();

    @Override
    public double calcular(double monto) {
        return monto * 0.15;
    }

    @Override
    public String getId() {
        return this.id;
    }

}
