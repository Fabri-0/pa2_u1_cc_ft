package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@EnviarEmail
@Interceptor
@Priority(InterfazPriority.MAIL)
public class EnviarEmailInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        Object resultado = context.proceed();

        System.out.println("\n[ENVIAR EMAIL] \n\tMensaje enviado por EMAIL");
        return resultado;
    }
}
