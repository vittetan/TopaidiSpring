package topaidi.app.model.reports;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import topaidi.app.model.ideas.Comment;
import topaidi.app.model.persons.Brain;

@Entity
public class ReportComment extends Report {
	
	@ManyToOne
	@JoinColumn(name="BRAIN_ID")
	private Brain brain;
	
	@ManyToOne
	@JoinColumn(name="COMMENT_ID")
	private Comment comment;

	public ReportComment() {
	}
	
	public ReportComment(Brain brain,Comment comment, String description) {
		super(description);
		setBrain(brain);
		setComment(comment);
	}

	public Brain getBrain() {
		return brain;
	}

	public void setBrain(Brain brain) {
		this.brain = brain;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}	

}
