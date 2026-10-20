package ec.edu.uce.pa.paquete;

import jakarta.inject.Inject;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject 
    private PedidoService pedidoService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args){
        System.out.println("Iniciando apliacion Quarkus");
        
        Pedido pedido = new Pedido("Fabricio Topon", "Laptop", 1500.00, "ftmarce@gmail.com"); // creamos manualmente el objeto de la clase Pedido
        this.pedidoService.realizar(pedido);

        return 0;
    }

}
