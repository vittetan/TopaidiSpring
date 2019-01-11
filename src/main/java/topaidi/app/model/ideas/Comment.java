package topaidi.app.model.ideas;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import topaidi.app.model.persons.Brain;
import topaidi.app.model.reports.ReportComment;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String description;
	
	@Column
	private boolean isActivated;
	
	@ManyToOne
	@JoinColumn(name="IDEA_ID")
	private Idea idea;
	
	@ManyToOne
	@JoinColumn(name="BRAIN_ID")
	private Brain brain;

	@OneToMany(mappedBy="comment")
	private Set<ReportComment> reports;
	

	public Comment() {
	}
	
	public Comment(Brain brain,Idea idea, String description) {
		setBrain(brain);
		setIdea(idea);
		setDescription(description);
		
		setActivated(true);
		
		this.reports = new HashSet<ReportComment>();		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public Brain getBrain() {
		return brain;
	}

	public void setBrain(Brain brain) {
		this.brain = brain;
	}

	public Set<ReportComment> getReports() {
		return reports;
	}

	public void setReports(Set<ReportComment> reports) {
		this.reports = reports;
	}	

}
