package br.faccamp.oficina.teste;

import javax.persistence.EntityManager;

import br.faccamp.model.Cliente;
import br.faccamp.model.PessoaFisica;
import br.faccamp.model.TipoEstadoCivil;
import br.faccamp.model.TipoSexo;
import br.faccamp.oficina.util.JPAUtil;

public class TestaRelacionamento {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		PessoaFisica pessoa = new PessoaFisica();
	
		pessoa.setEstadoCivil(TipoEstadoCivil.Casado);
		pessoa.setRg("48.265.520.03");
		pessoa.setCpf("411.506.778.05");
		pessoa.setSexo(TipoSexo.M);
	
		em.getTransaction().begin();
		Cliente cliente = em.find(Cliente.class, 5);
		pessoa.setCliente(cliente);
		em.persist(cliente);
		em.persist(pessoa);
	
		
		em.getTransaction().commit();
		em.close();
	}
}
