package ec.edu.uce.pa.paquete;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

//@RequestScoped // Para aplicaciones web
//@ApplicationScoped //Delego el control al contenedor ArC
//@Unremovable
@Singleton
@Named("mail")
public class MailService implements Notificacion {

    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando correo al: " + destino);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Correo enviado con éxito.");
        System.out.println("Fin del envio de correo.");
    }
}
