/**
 * Class that represents a single continent object
 * @author Dana Curca, 250976773, dcurca CS1027
 *
 */
public class Continent {
	/*Declaring variables*/
	private String country;
	private String continent;
	/**
	 * constructor creates an instance(object) of class continent 
	 */
	public Continent(String country, String continent) {
		this.country = country;
		this.continent = continent;
	}
	/**
	 * getter method that returns the country name of a continent object pair
	 */
	public String getCountryName() {
		return country;
	}
	/**
	 * getter method that returns the continent name of a continent object pair 
	 */
	public String getContinentName() {
		return continent;
	}
	/**
	 * setter method that allows a new country name to be set to an existing object 
	 */
	public void setCountryName(String newName) {
		this.country = newName;
	}
	/**
	 * setter method that allows a new continent name to be set to an existing object 
	 */
	public void setContinentName(String newContinent) {
		this.continent = newContinent;
	}
	/**
	 * method that returns a string containing the values of an instance of the class
	 */
	public String toString() {
		String s = String.format("Country:%-24s\n",getCountryName()) + String.format("Continent:%-13s\n",getContinentName());
		return s;
	}
}
	
