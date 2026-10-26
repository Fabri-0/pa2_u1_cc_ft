package ec.edu.uce.pa.tarea3;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class VentaService {

    @Inject
    @Named("regular")
    private CalculadoraDescuento descuentoRegular;

    @Inject
    @Named("vip")
    private CalculadoraDescuento descuentoVIP;

    private Auditoria auditoria;

    @Inject
    public VentaService(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public void realizarVenta(String tipoCliente, double monto) {
        CalculadoraDescuento calculadora;

        if ("VIP".equalsIgnoreCase(tipoCliente)) {
            calculadora = this.descuentoVIP;
        } else {
            calculadora = this.descuentoRegular;
        }

        double descuento = calculadora.calcular(monto);
        double total = monto - descuento;

        // Registramos en auditoría
        this.auditoria.registrar(tipoCliente, monto, descuento, total, calculadora.getId());
    }

}
