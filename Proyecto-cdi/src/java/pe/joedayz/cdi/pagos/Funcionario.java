package pe.joedayz.cdi.pagos;

import java.io.Serializable;

public class Funcionario implements Serializable{

    private String nombre;
    private Cargo cargo;
    private Escolaridad escolaridad;
    private int anoAdmision;

    public Funcionario() {
    }

    public Funcionario(String nome, Cargo cargo, Escolaridad escolaridade, int anoAdmision) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.escolaridad = escolaridad;
        this.anoAdmision = anoAdmision;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Escolaridad getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(Escolaridad escolaridad) {
        this.escolaridad = escolaridad;
    }

    public int getAnoAdmision() {
        return anoAdmision;
    }

    public void setAnoAdmision(int anoAdmision) {
        this.anoAdmision = anoAdmision;
    }

    
    
    @Override
    public String toString() {
        return nombre;
    }
    
    
}
