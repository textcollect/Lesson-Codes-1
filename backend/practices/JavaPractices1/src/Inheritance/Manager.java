package Inheritance;

public class Manager extends Employee{
	// own variables
	private int roleLevel;
	private String roleDescription;

	// Constructor
	public Manager(int id, String name, double salary, int roleLevel, String roleDescription) {
		/*
		`super` is a keyword that refers to
		the superclass of the current class. When `super` is used as a method, as in
		this example, it invokes the constructor of the superclass.

		So in this case, `super` invokes the `Employee` constructor, which
		initializes the attributes `id`, `name` and `salary`
		 */
		super(id, name, salary);
		this.roleLevel = roleLevel;
		this.roleDescription = roleDescription;
	}

	// Getter & Setter

	public int getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(int roleLevel) {
		this.roleLevel = roleLevel;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	@Override
	public String toString() {
		String thisToString = String.format(" Role level: %d, Role description: %s.",
				this.roleLevel, this.roleDescription);

		// `super.toString()` invokes the `toString()` method of the superclass
		String newString = super.toString() + thisToString;

		return newString;
	}
}
