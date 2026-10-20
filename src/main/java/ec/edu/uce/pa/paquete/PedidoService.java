package ec.edu.uce.pa.paquete;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

//@RequestScoped 
@ApplicationScoped //Delego el control al contenedor ArC
//@Singleton 
public class PedidoService {

    @Inject 
    private MailService mailService;

    public void realizar(Pedido pedido) {
        System.out.println("Realizar pedido");
        System.out.println("Pedido realizado para cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con exito.");

        String asunto = "Confirmacion de pedido";
        String cuerpo = "Estimado " + pedido.getCliente() + ", su pedido de " + pedido.getProducto()
                + " por un total de $" + pedido.getTotal() + " ha sido realizado con exito.";

        this.mailService.enviar(pedido.getCorreo(), asunto, cuerpo);

    }
}
