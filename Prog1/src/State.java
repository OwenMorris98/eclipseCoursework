/* COSC 310 - 001 Assignemnt 1
 * State.java
 * 
 * A class that creates a State and has the attributes
 * of a state in the CSV file
 * 
 * @author Owen Morris
 * 
 */
public class State {
	private String abbr;
	private String name;
	private int population;
	
	public State(String abbr, String name, int population) {
		super();
		this.abbr = abbr;
		this.name = name;
		this.population = population;
	}
	
	
	public State(String abbr)
	{
		super();
		this.abbr = abbr;
	}


	public String getAbbr() {
		return abbr;
	}

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}
	@Override
	public boolean equals(Object arg)
	{
		return this.abbr.equals( ((State)arg).abbr );
	}

}
