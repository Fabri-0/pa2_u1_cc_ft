package ec.edu.uce.pa.tarea2.interceptors;

import java.time.LocalDateTime;

import ec.edu.uce.pa.tarea2.transferencia.Transferencia;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@AuditarTransferencia
@Interceptor
@Priority(InterfazPriority.AUDITORIA)
public class AuditoriaInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        Object resultado = context.proceed();

        Object[] parametros = context.getParameters();
        if (parametros.length > 0 && parametros[0] instanceof Transferencia t) {
            System.out.println("\n[AUDITORÍA - " + LocalDateTime.now() + "]");
            System.out.println("De: " + t.getOrigen().getTitular() + " (" + t.getOrigen().getNumeroCuenta() + ")");
            System.out.println("A: " + t.getDestino().getTitular() + " (" + t.getDestino().getNumeroCuenta() + ")");
            System.out.println("Monto transferido: $" + t.getMonto());
        }

        return resultado;
    }
}
