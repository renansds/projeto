package br.faccamp.oficina.teste;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.faccamp.model.Cliente;
import br.faccamp.model.PessoaFisica;
import br.faccamp.oficina.util.JPAUtil;

public class TestaJPQL {
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		Cliente cliente = new Cliente();
		cliente.setCodigo_cliente(5);
		
		em.getTransaction().begin();
		String jpql ="select p from Pessoa_Fisica p where p.cliente.codigo_cliente= :pCliente" ;
		// PASSANDO PARAMETRO ABAIXO E USANDO A JPQL CRIADO OU SEJA A CONSULTA.
		Query query = em.createQuery(jpql);
		query.setParameter("pCliente", cliente.getCodigo_cliente());
		
		List<PessoaFisica> resultados = query.getResultList();
		
		for (PessoaFisica pessoa_Fisica : resultados) {
			System.out.println(pessoa_Fisica.getCliente().getNome());
			System.out.println(pessoa_Fisica.getCpf());
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
}
