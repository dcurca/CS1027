import java.io.*;
import java.util.*;
import java.util.List;
import java.util.StringTokenizer;
/**
 * Class that holds information about countries and the continents they are on
 * @author Dana Curca, 250976773, dcurca CS1027
 *
 */
public class CountryContinentQuery {
	/*Declaring Variables*/
	private String countryName;
	private String continentName;
	private int countryCt = 0;
	private int continentCt = 0;
	int countryPopulation;
	int countryArea;
	final int DEFAULT_SIZE = 30;
	StringTokenizer tokenizer;
	Country[] countryArray = new Country[DEFAULT_SIZE];
	Continent[] continentArray = new Continent[DEFAULT_SIZE];
	/**
	 * constructor method with 3 parameters which creates an instance of the class 
	 */
	public CountryContinentQuery(Country[] countryArray, Continent[] continentArray, int countryCt) {
		this.countryArray=countryArray.clone();
		this.continentArray=continentArray.clone();
		this.countryCt = countryCt;
	}
	/**
	 * method that returns a string of all countries in a continent
	 * @param continentName name of continent in which all countries should be located within
	 * @return string that contains a list of all countries for a continent name parameter
	 */
	public String getCountriesOnContinent(String continentName) {
		this.continentName = continentName;
		Boolean found = false;
		String countryList = String.format("The country(s) located in %s", this.continentName + ":");
		for(int i = 0; i < countryCt; i++) { // traverse through entire list 
			if(this.continentName.equals(continentArray[i].getContinentName())) { // when continent names match do..
				found = true; 
				this.countryName = continentArray[i].getCountryName(); //obtain country name for which continent[x] matches parameter continentName
				countryList += String.format(this.countryName + ",");
			}
	}
		if(!found) {
			countryList = String.format("There are no country(s) in the continent %s \n", this.continentName); //return if no countries are found located in parameter continentName
		}
		return countryList;
}
	/**
	 * method which returns the population of all countries in a continent 
	 * @param continentStg represents a continent in which we are searching for all countries located within it
	 * @return population of all countries on a continent name parameter
	 */
	public String getPopulationOfContinent(String continentStg) {
		int totalPopulation = 0;
		int index;
		Boolean found;
		for(int i=0; i < countryCt; i++) { //traverse through entire list
			if(continentArray[i].getContinentName().equals(continentStg)) //if continent equals continent parameter inputted do..
			{
			countryName = continentArray[i].getCountryName(); //obtain country of continent which we are looking for 
			found = false;
			index = 0;
			while(index < countryCt && !found) //while a country is not found do..
				{
				if(countryArray[index].getCountryName().equals(countryName)) {
					found = true; }
					else {
						index++; }
				}
			if(found) totalPopulation += countryArray[index].getPopulation(); //add each country's population within continent to totalPOP
		}
	}
	String totalPOP = String.valueOf(totalPopulation);
	return totalPOP;
}
	/**
	 * method that prints each country and the corresponding continent information 
	 */
	public String toString() {
		int x = 0;
		String print = "";
		for (int i = 0; i < countryCt; i++) { //traverse through entire list
		print = String.format("Country:%-24s\n",countryArray[x].getCountryName())
				+ String.format("Population:%-10s\n",countryArray[x].getPopulation())
				+ String.format("Area:%-7s\n", countryArray[x].getArea())
				+ String.format("Population Density:%-24.2f\n", countryArray[x].getCountryPopulationDensity())
				+ String.format("Continent:%-13s\n",continentArray[x].getContinentName());
		System.out.println(print);
		x++; //increment for all objects in list
			}
		return print;
		}
	}
