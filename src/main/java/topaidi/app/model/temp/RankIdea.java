package topaidi.app.model.temp;

import topaidi.app.model.ideas.Idea;
import topaidi.app.model.persons.Brain;

public class RankIdea{
	
	private Idea idea;
	
	private double percentTops;
	
	private int numberVotes;
	
	public RankIdea() {
		super();
	}

	public RankIdea(int numberVotes, double percentTops, Idea idea) {
		this.numberVotes = numberVotes;
		this.percentTops = percentTops;
		this.idea = idea;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public double getPercentTops() {
		return percentTops;
	}

	public void setPercentTops(double percentTops) {
		this.percentTops = percentTops;
	}

	public int getNumberVotes() {
		return numberVotes;
	}

	public void setNumberVotes(int numberVotes) {
		this.numberVotes = numberVotes;
	}

	
}
