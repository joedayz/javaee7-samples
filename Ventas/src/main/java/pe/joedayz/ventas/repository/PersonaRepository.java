package pe.joedayz.ventas.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pe.joedayz.ventas.model.Persona;

public class PersonaRepository {

	
	private EntityManager manager;
	
	@Inject
	public PersonaRepository(EntityManager manager){
		this.manager = manager;
	}
	
	public List<Persona> todas(){
		
		TypedQuery<Persona> query = manager.createQuery("from Persona", Persona.class);
		return query.getResultList();
	}

	public Persona porId(Long id) {
		return manager.find(Persona.class, id);
	}
	
}
