package topaidi.app.model.persons;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import topaidi.app.model.ideas.Comment;
import topaidi.app.model.ideas.Idea;
import topaidi.app.model.ideas.Vote;
import topaidi.app.model.reports.ReportComment;
import topaidi.app.model.reports.ReportIdea;

@Entity
public class Brain extends Person {

	@Column
	private boolean isValidated;
	
	@Column
	private boolean isActivated;

	@OneToMany(mappedBy="brain")
	private Set<Idea> ideas;
	
	@OneToMany(mappedBy="brain")
	private Set<Comment> comments;
	
	@OneToMany(mappedBy="brain")
	private Set<Vote> votes;
	
	@OneToMany(mappedBy="brain")
	private Set<ReportIdea> reportIdeas;
	
	@OneToMany(mappedBy="brain")
	private Set<ReportComment> reportComments;
	
	public Brain() {
	}
	
	public Brain(String login, String password, String pseudo) {
		super(login, password, pseudo);
		setValidated(false);
		setActivated(true);
		
		this.ideas = new HashSet<Idea>();
		this.comments = new HashSet<Comment>();
		this.votes = new HashSet<Vote>();
		this.reportIdeas = new HashSet<ReportIdea>();
		this.reportComments = new HashSet<ReportComment>();
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public Set<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(Set<Idea> ideas) {
		this.ideas = ideas;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Set<Vote> votes) {
		this.votes = votes;
	}

	public Set<ReportIdea> getReportIdeas() {
		return reportIdeas;
	}

	public void setReportIdeas(Set<ReportIdea> reportIdeas) {
		this.reportIdeas = reportIdeas;
	}

	public Set<ReportComment> getReportComments() {
		return reportComments;
	}

	public void setReportComments(Set<ReportComment> reportComments) {
		this.reportComments = reportComments;
	}	

}
