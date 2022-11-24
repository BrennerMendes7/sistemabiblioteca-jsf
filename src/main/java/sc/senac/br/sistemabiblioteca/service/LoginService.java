package sc.senac.br.sistemabiblioteca.service;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import sc.senac.br.sistemabiblioteca.dao.UsuarioDao;
import sc.senac.br.sistemabiblioteca.exception.UsuarioInvalidoException;
import sc.senac.br.sistemabiblioteca.model.Usuario;
import sc.senac.br.sistemabiblioteca.util.CriptografiaUtil;

public class LoginService {
	
	private UsuarioDao usuarioDao;
	
	public LoginService() {
		usuarioDao = new UsuarioDao();
	}
	
	public void verificarLogin(String email, String senha) throws UsuarioInvalidoException {
		String senhaCriptografada = CriptografiaUtil.criptografar(senha);
		Usuario usuarioLogado = usuarioDao.verificarLogin(email, senhaCriptografada);
		
		if (usuarioLogado == null) {
			throw new UsuarioInvalidoException();
			
		}
		
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext()
				.getSession(false);
		
		session.setAttribute("usuarioLogado", usuarioLogado);
	}
	
	
	
	
}
