package pe.joedayz.cdi.mb;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import pe.joedayz.cdi.model.Articulo;
import pe.joedayz.cdi.service.ArticuloService;


@Named
@RequestScoped
public class ArticuloMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private ArticuloService service;

	@Inject
	private Articulo articulo;
	
	private Long idSelecionado;
	
	private List<Articulo> mercaderias;
	
	public ArticuloMB() {
		
	}

	public Long getIdSelecionado() {
		return idSelecionado;
	}

	public void setIdSelecionado(Long idSelecionado) {
		this.idSelecionado = idSelecionado;
	}

	public Articulo getArticulo() {
		return articulo;
	}
	
	
	public void editar() {
		if (idSelecionado == null) {
			return;
		}
		articulo = service.find(idSelecionado);
		
	}
	
	public List<Articulo> getMercadorias() {
		System.out.println("service: "+service);
		if (mercaderias == null) {
			mercaderias = service.findAll();
		}
		return mercaderias;
	}

	
	public String salvar() {
		try {
			System.out.println("service: "+service);
			service.save(articulo);
		} catch(Exception ex) {
		
			addMessage(getMessageFromI18N("msg.erro.salvar.mercadoria"), ex.getMessage());
			return "";
		}
		
		return "listaArticulos";
	}
	
	public String remover() {
		try {
			service.remove(articulo);
		} catch(Exception ex) {
			
			addMessage(getMessageFromI18N("msg.erro.remover.mercadoria"), ex.getMessage());
			return "";
		}
		
		return "listaArticulos";
	}
	

	private String getMessageFromI18N(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages_labels", 
				getCurrentInstance().getViewRoot().getLocale());
		return bundle.getString(key);
	}
	

	private void addMessage(String summary, String detail) {
		getCurrentInstance().addMessage(null, new FacesMessage(summary, summary.concat("<br/>").concat(detail)));
	}
	
	
}
