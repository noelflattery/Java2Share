package com.android;

public class Country implements Comparable<Country>{
	/*
	 * all of these fields correspond to a field/column in our country table in the world database
	 * we will use the country table to create a country object for every record\row\tuple
	 */
	String id;//Code field in country table
	String name;//Name field in country table
	String continent;//Continent field in country table
	int population;//Population field in country table
	double lifeExpect;//lifeExceptancy field in country table
	double area;//SurfaceArea field in country table
	
	public  Country(String id, String name, String continent, int population, double lifeExpect, double area) {
		super();
		this.id = id;
		this.name = name;
		this.continent = continent;
		this.population = population;
		this.lifeExpect = lifeExpect;
		this.area = area;
	}
	
	@Override
	public String toString() {
		//System.out.println();
		return "Country [id=" + id + ", name=" + name + ", continent=" + continent + ", population=" + population
				+ ", lifeExpect=" + lifeExpect + ", area=" + area + "\n";
	}
/*
 * can use sorted in streams and also can add this to treesets, this means that countries will be sorted by
 * name
 * this will sort by names alphabetically
 */
	@Override
	public int compareTo(Country country) {
		return name.compareTo(country.name);
	}

}
