/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.automoviles.entidades;

import com.mycompany.automoviles.validation.MaxAnoMasActual;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.validation.constraints.Min;

/**
 *
 * @author josediaz
 */
@NamedQueries({
    @NamedQuery(name = Automovil.LISTAR_DESTACADOS, query = "select a from Automovil a", hints = {
        @QueryHint(name = "org.hibernate.cacheable", value = "true"),
        @QueryHint(name = "org.hibernate.cacheRegion", value = Automovil.LISTAR_DESTACADOS)})
})
@Entity
@Cacheable
public class Automovil implements Serializable {

    private static final long serialVersionUID = 9183366721265460766L;
    public static final String LISTAR_DESTACADOS = "Automovil.buscarDestacados";

 
    	@Id @GeneratedValue
	private Long id;
	@ManyToOne
	private Modelo modelo;
	@ManyToOne
	private Color color;
	@OneToMany(mappedBy="automovil")
	private List<Foto> fotos;
	@Min(1900) @MaxAnoMasActual(message="El valor maximo del año de fabricacion es {0}")
	private Integer anoFabricacion;
	@Min(1900) @MaxAnoMasActual(value=1, message="El valor maximo del año del modelo es {0}")
	private Integer anoModelo;
	private Float precio;
	private Float kilometraje;
	private String observaciones;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public Integer getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(Integer anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Float kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Automovil other = (Automovil) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Automovil{" + "id=" + id + ", modelo=" + modelo + ", color=" + color + ", fotos=" + fotos + ", anoFabricacion=" + anoFabricacion + ", anoModelo=" + anoModelo + ", precio=" + precio + ", kilometraje=" + kilometraje + ", observaciones=" + observaciones + '}';
    }
	
        
}
