package sc.senac.br.sistemabiblioteca.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sc.senac.br.sistemabiblioteca.dao.LivroDao;
import sc.senac.br.sistemabiblioteca.model.Livro;
import sc.senac.br.sistemabiblioteca.model.Locador;

@FacesConverter(forClass = Livro.class)
public class LivroConverter implements Converter {
	
	private LivroDao livroDao;
	
	public LivroConverter() {
		livroDao = new LivroDao();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}

		return livroDao.buscarPorID(new Long(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}

		return ((Livro) value).getCodigo().toString();
	}

}
