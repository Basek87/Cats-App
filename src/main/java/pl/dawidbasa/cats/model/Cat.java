package pl.dawidbasa.cats.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cats")
public class Cat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Size(min = 2, max = 10, message = "D³ugoœæ Imienia powinna byæ od 2 do 8 znaków")
	private String name;
	@Size(min = 2, max = 10, message = "D³ugoœæ Imienia W³aœciciela powinna byæ od 2 do 8 znaków")
	private String ownerName;
	@Max(20)
	private int age;

	@OneToMany(mappedBy = "cat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<CatPhoto> catPhotos = new HashSet<CatPhoto>();

	public Cat() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<CatPhoto> getCatPhotos() {
		return catPhotos;
	}

	public void setCatPhotos(Set<CatPhoto> catPhotos) {
		this.catPhotos = catPhotos;
	}

}
