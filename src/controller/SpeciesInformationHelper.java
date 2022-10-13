package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.SpeciesInformation;


/**
 * @author kenne-krcutkomp
 * CIS175 - Fall 2022
 */
public class SpeciesInformationHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MidTerm2");
	
	public SpeciesInformationHelper() {
		// TODO Auto-generated constructor stub
	}
	public void insertItem(SpeciesInformation si) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(si);
		em.getTransaction().commit();
		em.close();
	}

	public List<SpeciesInformation> showAllSpecies() {
		EntityManager em = emfactory.createEntityManager();
		List<SpeciesInformation> allItems = em.createQuery("SELECT i FROM SpeciesInformation i").getResultList();
		return allItems;
	}

	public void deleteSpecies(SpeciesInformation toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SpeciesInformation> typedQuery = em.createQuery(
				"select mi from SpeciesInformation mi where mi.PKID =:selectedID",
				SpeciesInformation.class);
		//typedQuery.setParameter("selectedTitle", toDelete.getMovieTitle());
		typedQuery.setParameter("selectedID", toDelete.getPKID());
		typedQuery.setMaxResults(1);
		SpeciesInformation result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public SpeciesInformation searchForSpeciesById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		SpeciesInformation found = em.find(SpeciesInformation.class, idToEdit);
		em.close();
		return found;
	}
	
	public List<SpeciesInformation> searchForSpeciesByIdx(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SpeciesInformation> typedQuery = em.createQuery("select mi from SpeciesInformation mi where mi.PKID = :selectedID",
				SpeciesInformation.class);
		typedQuery.setParameter("selectedID", idToEdit);
		List<SpeciesInformation> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}


	public void updateSpecies(SpeciesInformation toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();

	}


	public List<SpeciesInformation> searchForSpeciesBySpecies(String species) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SpeciesInformation> typedQuery = em.createQuery("select mi from SpeciesInformation mi where mi.Species = :selectedTitle",
				SpeciesInformation.class);
		typedQuery.setParameter("selectedSpecies", species);
		List<SpeciesInformation> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	


	public void cleanUp() {
		emfactory.close();
	}

}
