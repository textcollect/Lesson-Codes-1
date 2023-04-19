package Inheritance;

public class Main {
	public static void main(String[] args) {
		// Create 2 Manager instances
		Manager manager1 = new Manager(111, "Jean", 1000, 1, "Product Manager");
		Manager manager2 = new Manager(112, "Jim", 1200, 2, "Project Manager");

		System.out.println(manager1);
		System.out.println(manager2);

		Specialist specialist1 = new Specialist(113, "Tom", 1600, 'B', "FSD");
		Specialist specialist2 = new Specialist(114, "Timmy", 1500, 'C', "DA");

		System.out.println(specialist1);
		System.out.println(specialist2);
	}
}
