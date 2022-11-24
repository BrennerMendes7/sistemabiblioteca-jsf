package sc.senac.br.sistemabiblioteca.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sc.senac.br.sistemabiblioteca.dao.CategoriaDao;
import sc.senac.br.sistemabiblioteca.model.Categoria;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {
	
	private CategoriaDao categoriaDao;
	
    public CategoriaConverter() {
		categoriaDao = new CategoriaDao();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		
		return categoriaDao.buscarPorID(new Long(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		
		return ((Categoria) value).getCodigo().toString();
	}

}
