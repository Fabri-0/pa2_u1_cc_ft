package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.interceptors.Auditoria;
import ec.edu.uce.pa.paquete.interceptors.EnviarEmail;
import ec.edu.uce.pa.paquete.interceptors.EnviarSMS;
import ec.edu.uce.pa.paquete.interceptors.MedirTiempoo;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoService {

    @MedirTiempoo
    @Auditoria
    @EnviarSMS 
    @EnviarEmail 
    public String realizar(Pedido pedido, String valor1) {

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nRealizando pedido...");
        System.out.println("Pedido realizado al cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con exito.\n");

        return  "Pedido realizado con éxito";
    }
}
