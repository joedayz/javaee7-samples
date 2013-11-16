package pe.joedayz.cdi.service;

import java.util.List;

import javax.ejb.Local;

import pe.joedayz.cdi.model.Articulo;

@Local
public interface ArticuloService {

	public Articulo save(Articulo articulo);
	
	public void remove(Articulo articulo);
	
	public Articulo find(Long id);
	
	public List<Articulo> findAll();
}
