package sc.senac.br.sistemabiblioteca.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sc.senac.br.sistemabiblioteca.dao.IBaseDao;
import sc.senac.br.sistemabiblioteca.dao.UsuarioDao;
import sc.senac.br.sistemabiblioteca.model.Usuario;
import sc.senac.br.sistemabiblioteca.util.CriptografiaUtil;

@ManagedBean
@ViewScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Usuario> usuariosFiltro;
	private IBaseDao<Usuario> usuarioDao;
	
	public UsuarioController() {
		usuarioDao = new UsuarioDao();
		limpar();
		buscar();
	}
	
	public void salvar() {
		if (usuario.getCodigo() == null) {
			CriptografiaUtil criptografia = new CriptografiaUtil();
			usuario.setSenha(criptografia.criptografar(usuario.getSenha()));
			usuarioDao.salvar(usuario);
			
			FacesMessage mensagem = new FacesMessage();
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			mensagem.setSummary("Usuário cadastrado com sucesso!");
			
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			
		} else {
			CriptografiaUtil criptografia2 = new CriptografiaUtil();
			usuario.setSenha(criptografia2.criptografar(usuario.getSenha()));
			usuarioDao.alterar(usuario);
			
			FacesMessage mensagem = new FacesMessage();
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			mensagem.setSummary("Usuário alterado com sucesso!");
			
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
		}
		
		limpar();
		buscar();
	}
	
	public void excluir() {
		usuarioDao.excluir(usuario);
		limpar();
		buscar();
		
		FacesMessage mensagem = new FacesMessage();
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		mensagem.setSummary("Usuário excluído com sucesso!");
		
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
	
	public void limpar() {
		usuario = new Usuario();
	}
	
	public void buscar() {
		usuarios = usuarioDao.buscarTodos();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Usuario> getUsuariosFiltro() {
		return usuariosFiltro;
	}

	public void setUsuariosFiltro(List<Usuario> usuariosFiltro) {
		this.usuariosFiltro = usuariosFiltro;
	}
	
	
	
	

}
