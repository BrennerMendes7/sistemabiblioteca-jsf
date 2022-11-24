package sc.senac.br.sistemabiblioteca.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sc.senac.br.sistemabiblioteca.dao.EmprestimoDao;
import sc.senac.br.sistemabiblioteca.dao.IBaseDao;
import sc.senac.br.sistemabiblioteca.dao.LivroDao;
import sc.senac.br.sistemabiblioteca.dao.LocadorDao;
import sc.senac.br.sistemabiblioteca.model.Emprestimo;
import sc.senac.br.sistemabiblioteca.model.Livro;
import sc.senac.br.sistemabiblioteca.model.Locador;

@ViewScoped
@ManagedBean
public class EmprestimoController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Emprestimo emprestimo;
	private List<Emprestimo> emprestimos;
	private List<Emprestimo> emprestimosFiltro;
	private IBaseDao<Emprestimo> emprestimoDao;
	private List<Locador> locadores;
	private IBaseDao<Locador> locadorDao;
	private List<Livro> livros;
	private IBaseDao<Livro> livroDao;
	
	public EmprestimoController() {
		emprestimoDao = new EmprestimoDao();
		locadorDao = new LocadorDao();
		livroDao = new LivroDao();
		limpar();
		buscar();
	}
	
	public void salvar() {
		if (emprestimo.getCodigo() == null) {
			emprestimoDao.salvar(emprestimo);
			
			FacesMessage mensagem = new FacesMessage();
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			mensagem.setSummary("Empréstimo salvo com sucesso!");
			
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			
		} else {
			emprestimoDao.alterar(emprestimo);
			
			FacesMessage mensagem = new FacesMessage();
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			mensagem.setSummary("Empréstimo alterado com sucesso!");
			
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
		}
		
		limpar();
		buscar();
	}
	
	public void excluir() {
		emprestimoDao.excluir(emprestimo);
		limpar();
		buscar();
		
		FacesMessage mensagem = new FacesMessage();
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		mensagem.setSummary("Empréstimo excluído com sucesso!");
		
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
	
	public void limpar() {
		emprestimo = new Emprestimo();
	}
	
	public void buscar() {
		emprestimos = emprestimoDao.buscarTodos();
		locadores = locadorDao.buscarTodos();
		livros = livroDao.buscarTodos();
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public List<Emprestimo> getEmprestimosFiltro() {
		return emprestimosFiltro;
	}

	public void setEmprestimosFiltro(List<Emprestimo> emprestimosFiltro) {
		this.emprestimosFiltro = emprestimosFiltro;
	}

	public List<Locador> getLocadores() {
		return locadores;
	}

	public List<Livro> getLivros() {
		return livros;
	}
	

}
