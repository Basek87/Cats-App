package pl.dawidbasa.cats.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String text;
	private LocalDate dateCreated;

	@JoinColumn(name= "userId")
	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	public Comment() {
		super();
	}

	public Comment(long id, String text, User user) {
		super();
		this.id = id;
		this.text = text;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	

}
