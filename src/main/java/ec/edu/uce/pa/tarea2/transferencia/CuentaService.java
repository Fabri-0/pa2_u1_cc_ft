package ec.edu.uce.pa.tarea2.transferencia;

import jakarta.inject.Singleton;

@Singleton
public class CuentaService {

    public boolean retiro(Cuenta cuenta, double monto){
        if(cuenta.getSaldo() >= monto && monto > 0){
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            System.out.println("Retiro realizado con éxito...");
            return true;
        } else {
            System.out.println("El saldo en insuficiente o invalido");
            return false;
        }
    }

    public void deposito(Cuenta cuenta, double monto){
        if(cuenta != null && monto > 0){
            cuenta.setSaldo(cuenta.getSaldo() + monto);
        } else {
            System.out.println("La cuenta no existe....");
        }
    }
}
