package br.faccamp.view;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.faccamp.model.Cliente;
import br.faccamp.model.TipoCliente;
import br.faccamp.oficina.util.JPAUtil;

public class Main {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();

		cliente.setNome("Renan Santos De Siqueira");
		cliente.setEmail("email@seuemail.com.br");
		cliente.setTipo(TipoCliente.pf);
		cliente.setDataNascimento(new GregorianCalendar(1992, 06, 20).getTime());

		// JPA CHAMANDO PARA PERSISTENCIA
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();

		em.close();

	}
}
