package ec.edu.uce.pa.tarea2.interceptors;

import ec.edu.uce.pa.tarea2.transferencia.Transferencia;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@ValidarTransferencia
@Interceptor
@Priority(InterfazPriority.VALIDACION)
public class ValidarTransferenciaInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        Object[] parametros = context.getParameters();

        if (parametros.length > 0 && parametros[0] instanceof Transferencia transferencia) {
            if (transferencia.getMonto() <= 0) {
                throw new IllegalArgumentException("El monto a transferir debe ser mayor a 0.");
            }
            if (transferencia.getOrigen() == null || transferencia.getDestino() == null) {
                throw new IllegalArgumentException("Las cuentas origen y destino son obligatorias.");
            }
            if (transferencia.getOrigen().getNumeroCuenta() != null
                    && transferencia.getOrigen().getNumeroCuenta().equals(transferencia.getDestino().getNumeroCuenta())) {
                throw new IllegalArgumentException("No se puede transferir a la misma cuenta.");
            }
        }

        System.out.println("[VALIDACIÓN]: Todo sale bien, datos de transferencia validados con éxito.");
        return context.proceed();
    }
}
