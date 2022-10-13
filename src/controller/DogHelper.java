package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Dogs;

public class DogHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MidTerm");
	
	public void insertNewDog(Dogs d) {
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Dogs> showAllDogs(){
		EntityManager em = emfactory.createEntityManager();
		List<Dogs> allDogs = em.createQuery("SELECT d FROM Dogs d").getResultList();
		return allDogs;
	}
	
	public void deleteDog(Dogs toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Dogs> typedQuery = em.createQuery("select d from Dogs d where d.id =:selectedId", Dogs.class);
		
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		
		Dogs result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Dogs searchForDogById(int tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Dogs found = em.find(Dogs.class, tempId);
		
		em.close();
		
		return found;
	}
	
	public void updateDog(Dogs toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	
}
