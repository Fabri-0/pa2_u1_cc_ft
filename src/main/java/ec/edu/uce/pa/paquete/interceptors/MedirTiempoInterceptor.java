package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempoo
@Interceptor
@Priority(InterfazPriority.TIEMPO)
public class MedirTiempoInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        long inicio = System.currentTimeMillis();

        Object resultado = context.proceed();

        long duracion = System.currentTimeMillis() - inicio;
        System.out.println("\n[MEDIR TIEMPO] \n\tEl método tardo: " + duracion + "\n");
        return resultado;
    }
}
