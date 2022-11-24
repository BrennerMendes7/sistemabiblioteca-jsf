package sc.senac.br.sistemabiblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import sc.senac.br.sistemabiblioteca.dao.util.JPAUtil;
import sc.senac.br.sistemabiblioteca.dto.LivrosPorCategoriaDTO;
import sc.senac.br.sistemabiblioteca.model.Livro;

public class LivroDao extends BaseDao<Livro>{
	
	public List<LivrosPorCategoriaDTO> buscarLivrosPorCategoria() {
		EntityManager manager = JPAUtil.getEntityManager();
		
		StringBuilder jpqlBuilder = new StringBuilder();
		jpqlBuilder.append(
				  "select new sc.senac.br.sistemabiblioteca.dto.LivrosPorCategoriaDTO( "
				+ "		cat.descricao,  "
				+ "	    count(liv)      " 
				+ ")   "
				+ "from "
				+ "		Livro liv "
				+ "right join liv.categoria cat  "
				+ "group by"
				+ "		cat.descricao");
		
		TypedQuery<LivrosPorCategoriaDTO> query =
				manager.createQuery(jpqlBuilder.toString(), LivrosPorCategoriaDTO.class);
		
		List<LivrosPorCategoriaDTO> resultado = query.getResultList();
		
		manager.close();
		
		return resultado;
	}
	
	public static void main(String[] args) {
		LivroDao livroDao = new LivroDao();
		livroDao.buscarLivrosPorCategoria();
	}

}
