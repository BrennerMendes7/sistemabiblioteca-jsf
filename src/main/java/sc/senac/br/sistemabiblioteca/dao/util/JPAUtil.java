package sc.senac.br.sistemabiblioteca.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
private final static EntityManagerFactory factory;
	
	static {
		factory = Persistence
			.createEntityManagerFactory("Biblioteca-PU");
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
