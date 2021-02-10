package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		

		Pessoa p5 = new Pessoa(null, "Gustavo", "gustavo@gmail");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); ///--- Responsavel pela conexão
		EntityManager em = emf.createEntityManager(); ///--- Responsavel pela conexão
		
		//em.getTransaction().begin(); ----- Qualquer coisa que não for consulta precisa de get.Transaction
		Pessoa p = em.find(Pessoa.class, 4);
		//em.persist(p5); ----- Adiciona ao Bando de dados
		em.getTransaction().begin();
		em.remove(p); //----Remove do Banco de dados
		em.getTransaction().commit(); //----- Qualquer coisa que não for consulta precisa de get.Commit
		
		
		System.out.println("Pronto");
		em.close();
		emf.close();
		
	}

}
