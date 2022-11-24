package sc.senac.br.sistemabiblioteca.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sc.senac.br.sistemabiblioteca.dao.LocadorDao;
import sc.senac.br.sistemabiblioteca.model.Categoria;
import sc.senac.br.sistemabiblioteca.model.Locador;

@FacesConverter(forClass = Locador.class)
public class LocadorConverter implements Converter {

	private LocadorDao locadorDao;

	public LocadorConverter() {
		locadorDao = new LocadorDao();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}

		return locadorDao.buscarPorID(new Long(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}

		return ((Locador) value).getCodigo().toString();
	}
}
