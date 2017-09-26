package br.faccamp.oficina.teste;

import javax.persistence.EntityManager;

import br.faccamp.model.Cliente;
import br.faccamp.oficina.util.JPAUtil;

public class BuscaCliente {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		// Buscando cliente direto do banco de dados
		Cliente cliente = em.find(Cliente.class, 5);

		System.out.println(cliente.getNome());
		em.getTransaction().commit();
		em.close();
	}
}
