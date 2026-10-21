package ec.edu.uce.pa.tarea2.transferencia;

public class Transferencia {

    private Cuenta origen;
    private Cuenta destino;
    private double monto;

    public Transferencia() {
    }

    public Transferencia(Cuenta origen, Cuenta destino, double monto) {
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
    }

    // GETTERS Y SETTERS
    public Cuenta getOrigen() {
        return origen;
    }

    public void setOrigen(Cuenta origen) {
        this.origen = origen;
    }

    public Cuenta getDestino() {
        return destino;
    }

    public void setDestino(Cuenta destino) {
        this.destino = destino;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    

    
}
