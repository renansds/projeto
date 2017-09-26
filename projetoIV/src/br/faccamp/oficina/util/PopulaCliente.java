package br.faccamp.oficina.util;

import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import br.faccamp.model.Cliente;
import br.faccamp.model.TipoCliente;

public class PopulaCliente {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Cliente c1 = new Cliente();
		Cliente c2 = new Cliente();
		Cliente c3 = new Cliente();
		Cliente c4 = new Cliente();
		Cliente c5 = new Cliente();
		// CLIENTE 1
		c1.setNome("Renan Santos de Siqueira");
		c1.setEmail("r@email.com.br");
		c1.setDataNascimento(new GregorianCalendar(1996, 07, 21).getTime());
		c1.setTipo(TipoCliente.pf);

		// CLIENTE 2
		c2.setNome("Douglas Santos de Siqueira");
		c2.setEmail("douglas@email.com.br");
		c2.setDataNascimento(new GregorianCalendar(1996, 07, 21).getTime());
		c2.setTipo(TipoCliente.pf);

		// CLIENTE 3
		c3.setNome("Cristina Santos de Siqueira");
		c3.setEmail("cristina@email.com.br");// persistindo os clientes
		c3.setDataNascimento(new GregorianCalendar(1996, 07, 21).getTime());
		c3.setTipo(TipoCliente.pf);

		// CLIENTE 4
		c4.setNome("Aguilene Santos de Siqueira");
		c4.setEmail("aguilene@email.com.br");
		c4.setDataNascimento(new GregorianCalendar(1996, 07, 21).getTime());
		c4.setTipo(TipoCliente.pf);

		// CLIENTE 5
		c5.setNome("William Santos de Siqueira");
		c5.setEmail("William@email.com.br");
		c5.setDataNascimento(new GregorianCalendar(1996, 07, 21).getTime());
		c5.setTipo(TipoCliente.pf);
		
		//PERSISTINDO CLIENTES 
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		em.persist(c5);
		
		// FAZENDO O COMMIT 
		em.getTransaction().commit(); 
		em.close();
	}
}
