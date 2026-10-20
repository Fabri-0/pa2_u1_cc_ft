package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Singleton;

//@RequestScoped // Para aplicaciones web
//@ApplicationScoped //Delego el control al contenedor ArC
@Singleton 
public class MailService {

    public void enviar(String correo, String asunto, String cuerpo) {
        System.out.println("Enviando correo al: " + correo);
        System.out.println("Asunto: " + asunto);
        System.out.println("Cuerpo: " + cuerpo);
        System.out.println("Correo enviado cone exito.");
    }
}
