package sc.senac.br.sistemabiblioteca.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sc.senac.br.sistemabiblioteca.dao.IBaseDao;
import sc.senac.br.sistemabiblioteca.dao.LocadorDao;
import sc.senac.br.sistemabiblioteca.model.Locador;

@ViewScoped
@ManagedBean
public class LocadorController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Locador locador;
	private List<Locador> locadores;
	private List<Locador> locadoresFiltro;
	private IBaseDao<Locador> locadorDao;
	
	public LocadorController() {
		locadorDao = new LocadorDao(); 
		limpar();
		buscar();
	}
	
	public void salvar() {
		if (locador.getCodigo() == null) {
			locadorDao.salvar(locador);
			
			FacesMessage mensagem = new FacesMessage();
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			mensagem.setSummary("Locador cadastrado com sucesso!");
			
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			
		} else {
			locadorDao.alterar(locador);
			
			FacesMessage mensagem = new FacesMessage();
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			mensagem.setSummary("Locador alterado com sucesso!");
			
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
		}
		
		limpar();
		buscar();
	}
	
	public void excluir() {
		locadorDao.excluir(locador);
		limpar();
		buscar();
		
		FacesMessage mensagem = new FacesMessage();
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		mensagem.setSummary("Locador excluído com sucesso!");
		
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
	
	public void limpar() {
		locador = new Locador();
	}
	
	public void buscar() {
		locadores = locadorDao.buscarTodos();
	}

	public Locador getLocador() {
		return locador;
	}

	public void setLocador(Locador locador) {
		this.locador = locador;
	}

	public List<Locador> getLocadores() {
		return locadores;
	}

	public List<Locador> getLocadoresFiltro() {
		return locadoresFiltro;
	}

	public void setLocadoresFiltro(List<Locador> locadoresFiltro) {
		this.locadoresFiltro = locadoresFiltro;
	}
	
}
