package pe.joedayz.ventas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class MiCiudadBean {

	private String ciudadNatal;
	private List<String> todasCiudades;
	
	public MiCiudadBean(){
		this.todasCiudades = new ArrayList<>();
		this.todasCiudades.add("Huacho");
		this.todasCiudades.add("Barranca");
		this.todasCiudades.add("Chimbote");
		this.todasCiudades.add("Huarmey");
		this.todasCiudades.add("Paramonga");
		this.todasCiudades.add("Huaraz");
		this.todasCiudades.add("Trujillo");
		this.todasCiudades.add("Chiclayo");
		this.todasCiudades.add("Piura");
	}

	public String getCiudadNatal() {
		return ciudadNatal;
	}

	public void setCiudadNatal(String ciudadNatal) {
		this.ciudadNatal = ciudadNatal;
	}

	public List<String> getTodasCiudades() {
		return todasCiudades;
	}

	public void setTodasCiudades(List<String> todasCiudades) {
		this.todasCiudades = todasCiudades;
	}
	
	
}
