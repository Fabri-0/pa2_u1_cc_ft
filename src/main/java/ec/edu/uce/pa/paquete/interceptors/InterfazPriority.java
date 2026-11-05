package ec.edu.uce.pa.paquete.interceptors;

import jakarta.interceptor.Interceptor;

public interface InterfazPriority {

    int TIEMPO = Interceptor.Priority.APPLICATION + 4;
    int AUDITORIA = Interceptor.Priority.APPLICATION + 3;
    int SMS = Interceptor.Priority.APPLICATION + 2;
    int MAIL = Interceptor.Priority.APPLICATION + 1;
}
