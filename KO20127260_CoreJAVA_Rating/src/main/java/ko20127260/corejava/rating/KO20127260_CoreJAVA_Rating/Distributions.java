package ko20127260.corejava.rating.KO20127260_CoreJAVA_Rating;
import java.util.*;

public class Distributions 
{
	//Creating a HashMap to store Distributions table data to avoid duplicates
	public TreeMap<String,Integer> Distributions = new TreeMap<String,Integer>();

	//Constructor to load Distributions with sample data
	public Distributions() {
		this.Distributions.put("TEST", 40);
		this.Distributions.put("QUIZ", 20);
		this.Distributions.put("LAB WORK", 10);
		this.Distributions.put("PROJECT", 30);
	}

	//Method to CREATE a new Assignment Category in Distributions table
	public void createAssignmentCategory(String Assignment_Category, int Weight) {
		Assignment_Category = Assignment_Category.toUpperCase(); 
		if(Distributions.containsKey(Assignment_Category)) {
			System.out.println("Assignment Category '"+Assignment_Category + "' already exists.");
		}
		else {
			this.Distributions.put(Assignment_Category, Weight);
			System.out.println("Assignment Category '"+Assignment_Category + "' created successfully.");
		}
	}

	//Method to READ a new Assignment Category in Distributions table
	public void readAssignmentCategory(String Assignment_Category) {
		Assignment_Category = Assignment_Category.toUpperCase(); 
		if(Distributions.containsKey(Assignment_Category)) {
			System.out.println("Assignment Category        Weight");
			System.out.println(Assignment_Category + "        "+ this.Distributions.get(Assignment_Category)	);
		}
		else
			System.out.println("Assignment Category '"+Assignment_Category + "' doesn't exist.");
	}

	//Method to UPDATE a new Assignment Category in Distributions table
	public void updateAssignmentCategory(String Assignment_Category, int Weight) {
		Assignment_Category = Assignment_Category.toUpperCase(); 
		if(Distributions.containsKey(Assignment_Category)) {
			this.Distributions.put(Assignment_Category, Weight);	
			System.out.println("Assignment Category '"+Assignment_Category + "' updated successfully.");
		}
		else
			System.out.println("Assignment Category '"+Assignment_Category + "' doesn't exist.");
	}

	//Method to DELETE a Assignment Category from Distributions table
	public void deleteAssignmentCategory(String Assignment_Category) {
		Assignment_Category = Assignment_Category.toUpperCase(); 
		if(Distributions.containsKey(Assignment_Category)) {
			this.Distributions.remove(Assignment_Category);	
			System.out.println("Assignment Category '"+Assignment_Category + "' deleted successfully.");
		}
		else
			System.out.println("Assignment Category '"+Assignment_Category + "' doesn't exist.");
	}

	//Method to DISPLAY all assignment categories with their weights from Distributions table
	public void displayAssignmentCategories() {
		System.out.println("Assignment Category	| Weight(%)");
		System.out.println("-----------------------------------");
		for(Map.Entry<String, Integer> entry : Distributions.entrySet()) {			
			System.out.println(entry.getKey()+ "			| "+ entry.getValue());
		}
	}

}
