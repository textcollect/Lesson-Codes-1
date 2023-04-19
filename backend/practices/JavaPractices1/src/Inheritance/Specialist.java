package Inheritance;

public class Specialist extends Employee{
	private char roleRank;
	private String specialisation;
	public Specialist(int id, String name, double salary, char roleRank, String specialisation) {
		super(id, name, salary);
		this.roleRank = roleRank;
		this.specialisation = specialisation;
	}

	public char getRoleRank() {
		return roleRank;
	}

	public void setRoleRank(char roleRank) {
		this.roleRank = roleRank;
	}

	public String getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" Role rank: %c, Role description: %s",
				this.roleRank, this.specialisation);
	}
}
