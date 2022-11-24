package sc.senac.br.sistemabiblioteca.controller;

import java.io.Serializable;
import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sc.senac.br.sistemabiblioteca.dao.CategoriaDao;
import sc.senac.br.sistemabiblioteca.dao.IBaseDao;
import sc.senac.br.sistemabiblioteca.model.Categoria;

@ViewScoped
@ManagedBean
public class CategoriaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Categoria categoria;
	private List<Categoria> categorias;
	private List<Categoria> categoriasFiltro;
	private IBaseDao<Categoria> categoriaDao;

	public CategoriaController() {
		categoriaDao = new CategoriaDao();
		limpar();
		buscar();
	}

	public void salvar() {
		if (categoria.getCodigo() == null) {
			categoriaDao.salvar(categoria);
			
			FacesMessage mensagem = new FacesMessage();
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			mensagem.setSummary("Categoria cadastrada com sucesso!");
			
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			
		} else {
			categoriaDao.alterar(categoria);
			
			FacesMessage mensagem = new FacesMessage();
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			mensagem.setSummary("Categoria alterada com sucesso!");
			
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
		}
		
		limpar();
		buscar();
	}
	
	public void excluir() {
		categoriaDao.excluir(categoria);
		limpar();
		buscar();
		
		FacesMessage mensagem = new FacesMessage();
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		mensagem.setSummary("Categoria excluída com sucesso!");
		
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
	
	public void limpar() {
		categoria = new Categoria();
	}
	
	public void buscar() {
		categorias = categoriaDao.buscarTodos();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public List<Categoria> getCategoriasFiltro() {
		return categoriasFiltro;
	}

	public void setCategoriasFiltro(List<Categoria> categoriasFiltro) {
		this.categoriasFiltro = categoriasFiltro;
	}

}
