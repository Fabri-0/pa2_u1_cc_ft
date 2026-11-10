package ec.edu.uce.pa.paquete;

import jakarta.inject.Inject;
import ec.edu.uce.pa.paquete.extensiones.NotificacionExtension;
import ec.edu.uce.pa.paquete.extensiones.NotificacionExtensionMail;
import ec.edu.uce.pa.paquete.extensiones.NotificacionExtensionSMS;
import ec.edu.uce.pa.paquete.extensiones.NotificacionExtensionWhatsApp;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject 
    private CompraService compraService;

    @Inject 
    private NotificacionExtensionMail notificacionExtensionMail;

    @Inject 
    private NotificacionExtensionSMS notificacionExtensionMailSMS;

    @Inject 
    private NotificacionExtensionWhatsApp notificacionExtensionWhatsApp;


    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args){
        System.out.println("Iniciando apliacion Quarkus");
        
        Compra compra = new Compra("Fabricio Topon", "Play", "fabri@gmail.com",500.0);
        compra.setTelefono("088888888");
        this.compraService.realizar(compra, this.notificacionExtensionMail); 

        System.out.println("******************************************************************");

        Compra compra1 = new Compra("Joss Sanunga", "Refri", "fabri@gmail.com",500.0);
        compra1.setTelefono("088888888");
        this.compraService.realizar(compra1, this.notificacionExtensionMailSMS); 

        System.out.println("******************************************************************");

        Compra compra2 = new Compra("Hugo Paucar", "Refri", "fabri@gmail.com",500.0);
        compra2.setTelefono("088888888");
        this.compraService.realizar(compra2, this.notificacionExtensionWhatsApp); 

        return 0;
    }

}
