package topaidi.app.model.temp;

import topaidi.app.model.persons.Brain;

public class RankBrain{
	
	private Brain brain;
	
	private int numberIdeas;

	public RankBrain(int numberIdeas, Brain brain) {
		this.numberIdeas = numberIdeas;
		this.brain = brain;
	}

	public Brain getBrain() {
		return brain;
	}

	public void setBrain(Brain brain) {
		this.brain = brain;
	}

	public int getNumberIdeas() {
		return numberIdeas;
	}

	public void setNumberIdeas(int numberIdeas) {
		this.numberIdeas = numberIdeas;
	}
	
	


}
