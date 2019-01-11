package topaidi.app.model.reports;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import topaidi.app.model.ideas.Idea;
import topaidi.app.model.persons.Brain;

@Entity
public class ReportIdea extends Report {

	@ManyToOne
	@JoinColumn(name = "IDEA_ID")
	private Idea idea;

	@ManyToOne
	@JoinColumn(name = "BRAIN_ID")
	private Brain brain;

	public ReportIdea() {
	}

	public ReportIdea(Idea idea, Brain brain, String description) {
		super(description);
		setIdea(idea);
		setBrain(brain);
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

}
