package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.extensiones.NotificacionExtension;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class CompraService {

    public void realizar(Compra compra, NotificacionExtension notificacionExtension) {

        System.out.println("Realizando pedido...");
        System.out.println("Pedido realizado al cliente: " + compra.getCliente());
        System.out.println("Producto: " + compra.getProducto());
        System.out.println("Total: " + compra.getTotal());
        System.out.println("Correo: " + compra.getCorreo());
        System.out.println("Pedido realizado con exito.");

        // aqui voy a programar el envio de la notificacion
        notificacionExtension.enviar("Su pedido ha sido realizado con exito", compra.getCliente());
        



    }

}