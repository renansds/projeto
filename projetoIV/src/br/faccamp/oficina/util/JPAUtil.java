package br.faccamp.oficina.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("oficinadb");

	public EntityManager getEntityManager() {

		return emf.createEntityManager();
	}
}
