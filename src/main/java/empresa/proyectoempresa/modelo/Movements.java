package empresa.proyectoempresa.modelo;

public class Movements {
    
    private int monto, id;
    private String concepto, tipoMonto;
    
    public Movements(int monto, String concepto, int idEmpleado){
        this.id=idEmpleado;
        this.monto=monto;
        this.concepto=concepto;
        this.tipoMonto=tipoDeMovimiento(monto);
    }
    
    private String tipoDeMovimiento(int monto){
        String movimientoTipo=(monto>=0)?"Positivo":"Negativo";
        return movimientoTipo;
    }

    public int getMonto() {
        return monto;
    }

    public int getId() {
        return id;
    }

    public String getConcepto() {
        return concepto;
    }

    public String getTipoMonto() {
        return tipoMonto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public void setTipoMonto(String tipoMonto) {
        this.tipoMonto = tipoMonto;
    }
    
}
