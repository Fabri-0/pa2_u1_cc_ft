package ec.edu.uce.pa.tarea2.transferencia;

import ec.edu.uce.pa.tarea2.interceptors.MedirTiempo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped 
public class TransferenciaService {

    @Inject 
    private CuentaService cuentaService;

    @MedirTiempo
    public void transferir(Transferencia transferencia) {

        System.out.println("\nSistema de transferencias");
        System.out.println("Cuenta origen: " + transferencia.getOrigen().getTitular());
        System.out.println("Cuenta destino: " + transferencia.getDestino().getTitular());
        System.out.println("Monto: " + transferencia.getMonto() + "\n");

        if (this.cuentaService.retiro(transferencia.getOrigen(), transferencia.getMonto())) {
            this.cuentaService.deposito(transferencia.getDestino(), transferencia.getMonto());

            System.out.println("Deposito realizado con exito...\n");

        } else {
            System.out.println("Transferencia fallida...\n");
        }
    }
}
