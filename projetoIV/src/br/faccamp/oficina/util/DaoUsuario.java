package br.faccamp.oficina.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.faccamp.model.Login;


public class DaoUsuario {

	public boolean loginUser(String nome, String senha) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		String jpql = "select p from Login p ";
		// PASSANDO PARAMETRO ABAIXO E USANDO A JPQL CRIADO OU SEJA A CONSULTA.
		Query query = em.createQuery(jpql);
		

		List<Login> resultados = query.getResultList();
        
		for (Login login : resultados) {
			if(login.getNome().equals(nome) && login.getSenha().equals(senha))
				return true;
		}
		return false;
	}
}
