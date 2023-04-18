package BasicOOP;

public class Shoes {
	// Properties of the Class (aka Attributes/instance variables)
	// private makes the instance variable inaccessible to other classes
	//unless there is Getter and Setter methods
	private double size;
	private String color;


	// Constructor - a special method that initializes the object
	// every Class object will have at least one Constructor

	// The name of the constructor is the same as the name of the class.
	// Constructors have no return type (and no return value)
	// The keyword static is omitted
	public Shoes() {
		// The name `this` is a keyword that refers to the object we are creating
		this.size = 7; // Initializes the instance variable `size` to 7
		this.color = "Black"; // Initializes the instance variable `color` to "Black"
	}

	// Value Constructors (ThinkJavav2, Chapter 11.3)
	// constructors can be overloaded (i.e. you can
	// provide multiple constructors with different parameters)
	public Shoes(double size, String color) {
		/*
		To invoke this constructor, you have to provide arguments to the `new` operator
		e.g. in another method: Shoes shoes = new Shoes(7, "red");

		arguments passed in will be the default values
		 */
		this.size = size;
		this.color = color;
	}

	// Getters & Setters: to let other classes access & modify the instance variables
	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		//this.size = size;

		// Check if the size is within the size limit: 4 - 11
		if (size >= 4 && size <= 11) {
			this.size = size;
		}
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		// Check if the color is within the correct value
		this.color = color;
	}
}

class ShoesClient {
	public static void main(String[] args) {
		// When you use `new`, Java creates the object and invokes your constructor to
		//initialize the instance variables

		// When the constructor is done, `new` returns a reference to the new object.
		Shoes sport = new Shoes(6, "Blue"); //calling the constructor from the Shoes class
		Shoes sandal = new Shoes(8, "Brown");
		Shoes highheel = new Shoes(7, "White");

		System.out.println(sport.getColor());
		System.out.println("Sport size: " + sport.getSize());

		sport.setSize(1); // Will not change due to if-else statement in setter method
		System.out.println("New sport size: " + sport.getSize());

		// Change sandal size to 6
		sandal.setSize(6);
		System.out.println("New sandal size: " + sandal.getSize());
	}
}