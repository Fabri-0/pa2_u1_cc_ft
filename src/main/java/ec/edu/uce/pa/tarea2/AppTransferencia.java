package ec.edu.uce.pa.tarea2;

import ec.edu.uce.pa.tarea2.transferencia.Cuenta;
import ec.edu.uce.pa.tarea2.transferencia.Transferencia;
import ec.edu.uce.pa.tarea2.transferencia.TransferenciaService;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

//@QuarkusMain
public class AppTransferencia implements QuarkusApplication {

    @Inject
    private TransferenciaService transferenciaService;

    public static void main(String[] args) {
        Quarkus.run(AppTransferencia.class, args);
    }

    //@Override
    public int run(String... args){
        System.out.println("Iniciando apliacion Quarkus");

        Cuenta cuenta1 = new Cuenta("Fabrii", "1234", 3000.23);
        Cuenta cuenta2 = new Cuenta("Joss", "1235", 800.23);

        Transferencia transferencia = new Transferencia(cuenta1, cuenta2, 300.20);
        this.transferenciaService.transferir(transferencia);

        System.out.println(cuenta1.getSaldo());
        System.out.println(cuenta2.getSaldo());

        return 0;
    }

}

