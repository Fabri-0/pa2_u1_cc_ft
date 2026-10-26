package ec.edu.uce.pa.tarea3;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private VentaService ventaService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) {
        System.out.println("Iniciando simulador de descuentos");

        System.out.println("\n--- VENTA 1 ---");
        this.ventaService.realizarVenta("REGULAR", 100.0);

        System.out.println("\n--- VENTA 2 ---");
        this.ventaService.realizarVenta("VIP", 200.0);

        System.out.println("\n--- VENTA 3 ---");
        this.ventaService.realizarVenta("REGULAR", 300.0);

        System.out.println("\n--- VENTA 4 ---");
        this.ventaService.realizarVenta("VIP", 500.0);

        return 0;
    }
}