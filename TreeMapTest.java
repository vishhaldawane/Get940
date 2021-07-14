import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

class Country
{
	String name;
	String capital;
	String primeMinister;
	String population;
	String currency;
	
	public Country(String name, String capital, String primeMinister, String population, String currency) {
		super();
		this.name = name;
		this.capital = capital;
		this.primeMinister = primeMinister;
		this.population = population;
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", capital=" + capital + ", primeMinister=" + primeMinister + ", population="
				+ population + ", currency=" + currency + "]";
	}
	
	
}
public class TreeMapTest {

	public static void main(String[] args) {
		Country c1 = new Country("India", "New Delhi", "Mr. Narendra Modi", "136.64 Crores", "Rs");
		Country c2 = new Country("Pakistan", "Islamabad", "Mr. Imran Khan", "21.66 Crores", "Pakistani Rupee");
		Country c3 = new Country("China", "Beijing", "Mr. Xi Jinping", "139.77 Crores", "Yuan");
		Country c4 = new Country("England", "London", "Mr. Boriss Johnson", "6.66 Crores", "Pound Sterling");
		Country c5 = new Country("America", "Washington DC", "Mr. Joe Biden", "32.82 Crores", "USD");
		
		TreeMap<String,Country> countryMap = new TreeMap<String,Country>();
		System.out.println("Map is ready....");
		
		countryMap.put("IND", c1);
		countryMap.put("PAK", c2);
		countryMap.put("CHI", c3);
		countryMap.put("UK", c4);
		countryMap.put("US", c5);
		
		System.out.println("keys and values are added ....");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter any key : ");
		String theKey = scan.next();
		if(countryMap.containsKey(theKey))
		{
			Country theCountry = countryMap.get(theKey);
			System.out.println("The Country "+theCountry);
		}
		else {
			System.out.println("Key Not Found ");
		}
		
		Set<String> allKeys = countryMap.keySet();
		Iterator<String> keysIterator =  allKeys.iterator();
		
		while(keysIterator.hasNext()) {
			String key = keysIterator.next();
			System.out.println("Key is : "+key);
			Country foundCountry = countryMap.get(key);
			System.out.println("Country is : "+foundCountry);
		}

	}

}
