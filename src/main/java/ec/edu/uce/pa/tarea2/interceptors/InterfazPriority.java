package ec.edu.uce.pa.tarea2.interceptors;

import jakarta.interceptor.Interceptor;

public interface InterfazPriority {

    int VALIDACION = Interceptor.Priority.APPLICATION + 1;
    int AUDITORIA = Interceptor.Priority.APPLICATION + 2;
    int TIEMPO = Interceptor.Priority.APPLICATION + 3;
}
