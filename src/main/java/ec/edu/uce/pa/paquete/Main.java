package ec.edu.uce.pa.paquete;

import jakarta.inject.Inject;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject 
    private PedidoService pedidoService;

    @Inject 
    private CompraService compraService;


    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args){
        System.out.println("Iniciando apliacion Quarkus");
        
        Pedido pedido = new Pedido("Fabricio Topon", "Laptop", "ftmarce@gmail.com",1500.50); // creamos manualmente el objeto de la clase Pedido
        pedido.setTelefono("099999999");
        this.pedidoService.realizar(pedido, "valor 1");


        System.out.println("******************************************************************");

/*         Compra compra = new Compra("Fabricio Topon", "Play", "ftmarce23@gmail.com",500.0);
        compra.setTelefono("088888888");
        this.compraService.realizar(compra); */

        return 0;
    }

}
