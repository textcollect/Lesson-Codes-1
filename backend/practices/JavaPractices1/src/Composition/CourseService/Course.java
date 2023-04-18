package Composition.CourseService;

public class Course {
	private String name;
	private String id;
	private int credits;

	public Course(String name, String id, int credits) {
		this.name = name;
		this.id = id;
		this.credits = credits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return String.format("Course name: %s, Course ID: %s, Course Credit: %d.",
				this.name, this.id, this.credits);
	}
}
