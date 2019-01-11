package topaidi.app.model.categories;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import topaidi.app.model.ideas.Idea;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String name;
	
	@Column
	private String description;
	
	
	@OneToMany(mappedBy="category")
	private Set<Idea> ideas;
	

	public Category() {
	}
	
	
	public Category(String name, String description, Set<Idea> ideas) {
		setName(name);
		setDescription(description);
		setIdeas(ideas);
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Set<Idea> getIdeas() {
		return ideas;
	}


	public void setIdeas(Set<Idea> ideas) {
		this.ideas = ideas;
	}
		


}
