package tallermrrobot_ciclo3;

public class MovimientoDinero {
    
    private int monto;
    private String concepto;

    public MovimientoDinero(int monto, String concepto) {
        this.monto = monto;
        this.concepto = concepto;
    }
    
    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
}
