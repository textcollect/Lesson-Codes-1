package Composition.Library;

import java.util.ArrayList;

public class Library {
	// Stores a list of Book and Member objects
	// e.g. 3 books, 3 members
	private String branchName;
	private String address;
	private int phoneNumber;

	// Create 2 empty arraylists for the Book and Member objects
	ArrayList<Book> books;
	ArrayList<Member> members;

	// Constructor
	public Library(String branchName, String address, int phoneNumber) {
		this.branchName = branchName;
		this.address = address;
		this.phoneNumber = phoneNumber;

		// Connect to database, access the Book table,
		// retrieve all the relevant records SPECIFIC TO THE BRANCHNAME,ETC. (specific to params passed in in Main)
		// and store in the ArrayList<Book> books
		// Then, return the arraylist of books to frontend
		Book book1 = new Book("111-111-111", "Effective Java", "Joe Tan");
		Book book2 = new Book("111-111-222", "Effective HTML", "Jim Tan");
		Book book3 = new Book("111-111-333", "Effective CSS", "Jane Tan");

		books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		books.add(book3);

		Member member1 = new Member(001, "Harry", 12);
		Member member2 = new Member(002, "David", 50);
		members = new ArrayList<>();
		members.add(member1);
		members.add(member2);
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public ArrayList<Member> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}

	public void display() {
		// Print the list of books and the list of members
		for (Book displayBook : books) {
			// toString() method from Book class is called indirectly in print/println
			System.out.println(displayBook);
		}

		for (Member displayMembers : members) {
			System.out.println(displayMembers);
		}
	}
}
