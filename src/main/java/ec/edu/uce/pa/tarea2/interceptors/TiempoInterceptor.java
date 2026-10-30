package ec.edu.uce.pa.tarea2.interceptors;

import ec.edu.uce.pa.tarea2.transferencia.RegistroTiempo;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class TiempoInterceptor {

    @Inject
    private RegistroTiempo registroTiempo;

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        long inicio = System.nanoTime();

        Object resultado = context.proceed();

        long duracion = System.nanoTime() - inicio;
        String metodo = context.getMethod().getName();

        this.registroTiempo.registrar(metodo, duracion);

        return resultado;
    }
}
