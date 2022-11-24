package sc.senac.br.sistemabiblioteca.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sc.senac.br.sistemabiblioteca.dao.CategoriaDao;
import sc.senac.br.sistemabiblioteca.dao.IBaseDao;
import sc.senac.br.sistemabiblioteca.dao.LivroDao;
import sc.senac.br.sistemabiblioteca.model.Categoria;
import sc.senac.br.sistemabiblioteca.model.Livro;

@ViewScoped
@ManagedBean
public class LivroController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Livro livro;
	private List<Livro> livros;
	private List<Livro> livrosFiltro;
	private IBaseDao<Livro> livroDao;
	private List<Categoria> categorias;
	private IBaseDao<Categoria> categoriaDao;
	
	public LivroController() {
		livroDao = new LivroDao();
		categoriaDao = new CategoriaDao();
		limpar();
		buscar();
	}
	
	public void salvar() {
		if (livro.getCodigo() == null) {
			livroDao.salvar(livro);
			
			FacesMessage mensagem = new FacesMessage();
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			mensagem.setSummary("Livro salvo com sucesso!");
			
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			
		} else {
			livroDao.alterar(livro);
			
			FacesMessage mensagem = new FacesMessage();
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			mensagem.setSummary("Livro alterado com sucesso!");
			
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
		}
		
		limpar();
		buscar();
	}
	
	public void excluir() {
		livroDao.excluir(livro);
		limpar();
		buscar();
		
		FacesMessage mensagem = new FacesMessage();
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		mensagem.setSummary("Livro excluído com sucesso!");
		
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
	
	public void limpar() {
		livro = new Livro();
	}
	
	public void buscar() {
		livros = livroDao.buscarTodos();
		categorias = categoriaDao.buscarTodos();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public List<Livro> getLivrosFiltro() {
		return livrosFiltro;
	}

	public void setLivrosFiltro(List<Livro> livrosFiltro) {
		this.livrosFiltro = livrosFiltro;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

}
