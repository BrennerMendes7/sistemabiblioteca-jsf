package sc.senac.br.sistemabiblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import sc.senac.br.sistemabiblioteca.dao.util.JPAUtil;
import sc.senac.br.sistemabiblioteca.dto.EmprestimosPorLocadorDTO;
import sc.senac.br.sistemabiblioteca.model.Emprestimo;

public class EmprestimoDao extends BaseDao<Emprestimo> {
	
	public List<EmprestimosPorLocadorDTO> buscarEmprestimosPorLocador() {
		EntityManager manager = JPAUtil.getEntityManager();
		
		StringBuilder jpqlBuilder = new StringBuilder();
		jpqlBuilder.append("select new sc.senac.br.sistemabiblioteca.dto.EmprestimosPorLocadorDTO( "
				+ " loc.nome, "
				+ " count(emp) "
				+ " ) "
				+ " from "
				+ " Emprestimo emp "
				+ " right join emp.locador loc "
				+ " group by "
				+ " loc.nome ");
		
		TypedQuery<EmprestimosPorLocadorDTO> query =
				manager.createQuery(jpqlBuilder.toString(), EmprestimosPorLocadorDTO.class);
		
		List<EmprestimosPorLocadorDTO> resultado = query.getResultList();
		
		manager.close();
		
		return resultado;
	}

}
