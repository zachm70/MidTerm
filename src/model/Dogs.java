package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dogs")
public class Dogs {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@ManyToOne
	private SpeciesInformation breed;
	@Column(name="birthday")
	private LocalDate birthday;
	
	
	public Dogs(String name, SpeciesInformation breed, LocalDate birthday) {
		super();
		this.breed = breed;
		this.name = name;
		this.birthday = birthday;
	}
	
	public Dogs() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	

	public SpeciesInformation getBreed() {
		return breed;
	}

	public void setBreed(SpeciesInformation breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Dogs [id=" + id + ", name=" + name + ", breed=" + breed + ", birthday=" + birthday + "]";
	}

	
	
	
	
}
