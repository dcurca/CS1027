/**
 * Class that represents a single country object
 * @author Dana Curca, 250976773, dcurca CS1027
 *
 */
public class Country {
	/*Declaring variables*/
	private String nameCountry; 
	private int pop;
	private int area;
	
	/**
	 * constructor which returns a country object holding a name, population and area
	 */
	public Country(String nameCountry, int pop, int area){
		this.nameCountry = nameCountry;
		this.pop = pop;
		this.area = area;
	}
	/**
	 * getter method that returns the country name 
	 */
	public String getCountryName() {
		return nameCountry;
	}
	/**
	 * getter method that returns the country population
	 */
	public int getPopulation() {
		return pop;
	}
	/**
	 * getter method that returns the country area
	 */
	public int getArea() {
		return area;
	}
	/**
	 * setter method that sets a new population to a particular country
	 */
	public void setPopulation(int pop) {
		this.pop = pop;
	}
	/**
	 * setter method that sets a new area to a particular country
	 */
	public void setArea(int area) {
		this.area = area;
	}
	/**
	 * method which computes and returns the population density for a particular country
	 */
	public double getCountryPopulationDensity() {
		double density;
		density = ((float) pop / (float)area);
		return density;
	}
	/**
	 * method that returns a string containing the values of an instance of the class
	 */
	public String toString() {
		String s = String.format("Country:%-24s\n",getCountryName())
				+ String.format("Population:%-10s\n", getPopulation())
				+ String.format("Area:%-7s\n",getArea())
				+ String.format("Population Density:%-7.2f\n",getCountryPopulationDensity()); //used 7.2 for two decimals however seems to not work but the code is right?
		System.out.println(s);
		return s;		
	}
}
