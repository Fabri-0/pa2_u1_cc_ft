package ec.edu.uce.pa.paquete.interceptors;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.interceptor.InterceptorBinding;

@InterceptorBinding // LE DA EL COMPORTAMIENTO DE INTERCEPTOR
@Retention(RetentionPolicy.RUNTIME) 
// lOMBOK SE EJECUTA EN COMPILACION
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Auditoria {



}
