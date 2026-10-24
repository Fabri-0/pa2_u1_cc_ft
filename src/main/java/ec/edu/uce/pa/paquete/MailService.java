package ec.edu.uce.pa.paquete;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

// Ambitos y contextos
//@ApplicationScoped // su ambito es durante toda la aplicacion, es decir se crea una sola instancia de la clase y se comparte entre todos los componentes que la utilizan
//@Singleton // su ambito es durante toda la aplicacion, es decir se crea una sola instancia de la clase y se comparte entre todos los componentes que la utilizan
//@RequestScope // Su ambito es en aplicaciones web, durante el request/peticion http
//@SessionScope // su ambito es en aplicaciones web, durante la sesion del usuario, es decir se crea una sola instancia de la clase y se comparte entre todos los componentes que la utilizan durante la session
//@Dependent // Su ambito es durante la inyeccion de dependecias, es decir se crea una sola instancia de la clase y se comparte entre todos los componentes que la utiliza durante la inyeccion de dependicias


//@Dependent
@Singleton
@Named("mail")
public class MailService implements Notificacion {

  private Integer cantidad = 0;
    private String nombre;

    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando correo a: " + destino);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Correo enviado con éxito.");
        System.out.println("Fin del envío del correo.");
        cantidad ++;
    }

    @Override
    public Integer getCantidad() {
        return cantidad;
    }

    @Override
    public void setCantidad(Integer cantidad) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
