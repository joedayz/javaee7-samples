package pe.joedayz.cdi.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.joedayz.cdi.model.Articulo;

@Stateless
public class ArticuloServiceEJB 
	extends AbstractPersistence<Articulo, Long>
	implements ArticuloService {
	
	@PersistenceContext
	private EntityManager em;

	public ArticuloServiceEJB() {
		super(Articulo.class);
		
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	


}
