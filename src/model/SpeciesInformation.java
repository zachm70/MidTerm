package model;

/**
 * @author kenne-krcutkomp
 * CIS175 - Fall 2022
 */

public class SpeciesInformation {

	private String species;
	private String breed;
	private int avgAge;
	private int healthyWeight;
	
	//no arg default constructor
	public SpeciesInformation() {
		// TODO Auto-generated constructor stub
	}
	
	//constructor with args
	public SpeciesInformation(String species, String breed, int avgAge, int healthyWeight) {
		setSpecies(species);
		setBreed(breed);
		setAvgAge(avgAge);
		setHealthyWeight(healthyWeight);
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public int getAvgAge() {
		return avgAge;
	}
	public void setAvgAge(int avgAge) {
		this.avgAge = avgAge;
	}
	public int getHealthyWeight() {
		return healthyWeight;
	}
	public void setHealthyWeight(int healthyWeight) {
		this.healthyWeight = healthyWeight;
	}
	

}
