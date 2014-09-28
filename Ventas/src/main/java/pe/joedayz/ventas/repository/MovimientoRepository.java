package pe.joedayz.ventas.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pe.joedayz.ventas.model.Movimiento;

public class MovimientoRepository {

	private EntityManager manager;
	
	@Inject
	public MovimientoRepository(EntityManager manager){
		this.manager = manager;
	}
	
	public List<Movimiento> todos(){
		TypedQuery<Movimiento> query = manager.createQuery("from Movimiento", Movimiento.class);
		return query.getResultList();
	}

	
	public List<String> descripcionesQueContienen(String descripcion){
		TypedQuery<String> query = manager.createQuery(
				"select distinct descripcion from Movimiento "
				+ " where upper(descripcion) like upper(:descripcion)", String.class);
		query.setParameter("descripcion", "%" + descripcion + "%");
		return query.getResultList();
	}
	
	public void adicionar(Movimiento movimiento) {
		this.manager.persist(movimiento);
	}
	
	public void guardar(Movimiento movimiento) {
		this.manager.merge(movimiento);
	}
		
	
	public Movimiento porId(Long id){
		return manager.find(Movimiento.class, id);
	}
	
	public void eliminar(Movimiento movimiento){
		this.manager.remove(movimiento);
	}
	
}
