package topaidi.app.model.ideas;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import topaidi.app.model.categories.Category;
import topaidi.app.model.persons.Brain;
import topaidi.app.model.reports.ReportIdea;

@Entity
public class Idea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String title;
	
	@Column
	private String description;
	
	@Column
	private String image;
	
	@Column
	private Date dateCreation;
	
	@Column
	private Date dateEnd;
	
	@Column
	private boolean isActivated;
	
	@ManyToOne
	@JoinColumn(name="BRAIN_ID")
	private Brain brain;
		
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	private Category category;
	
	@OneToMany(mappedBy="idea")
	private Set<Comment> comments;
		
	@OneToMany(mappedBy="idea")
	private Set<Vote> votes;
	
	@OneToMany(mappedBy="idea")
	private Set<ReportIdea> reportIdeas;

	public Idea() {
	}
	
	public Idea(Brain brain, String title, String description, Category category) {
		setBrain(brain);
		setTitle(title);
		setDescription(description);
		setCategory(category);

		setDateCreation();
		setDateEnd();
		setActivated(true);

		this.comments = new HashSet<Comment>();
		this.votes = new HashSet<Vote>();
		this.reportIdeas = new HashSet<ReportIdea>();
	}

	public Idea(Brain brain, String title, String description, String image, Category category) {
		setBrain(brain);
		setTitle(title);
		setDescription(description);
		setCategory(category);
		setImage(image);

		setDateCreation();
		setDateEnd();
		setActivated(true);

		this.comments = new HashSet<Comment>();
		this.votes = new HashSet<Vote>();
		this.reportIdeas = new HashSet<ReportIdea>();
	}

	
	public List<Idea> topRanking(){
		return new ArrayList<Idea>();
	}
	
	public List<Idea> buzzRanking(){
		return new ArrayList<Idea>();
	}
	
	public int myTopRanking() {
		return 0;
	}
	
	public int myBuzzRanking() {
		return 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation() {
		this.dateCreation = new Date();;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd() {
		this.dateEnd = new Date();
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public Brain getBrain() {
		return brain;
	}

	public void setBrain(Brain brain) {
		this.brain = brain;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
	


}
