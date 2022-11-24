package sc.senac.br.sistemabiblioteca.controller;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class IdiomaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idiomaSelecionado;

	public void setIdiomaSelecionado(String idiomaSelecionado) {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(idiomaSelecionado));
	}

}
