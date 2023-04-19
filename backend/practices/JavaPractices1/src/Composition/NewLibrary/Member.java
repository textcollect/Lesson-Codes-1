package Composition.NewLibrary;
import java.util.ArrayList;
public class Member {
	private String id;
	private String name;
	private ArrayList<Book> bookLoan;

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
		//Book book = new Book("", "", "");

		//initialise new ArrayList to store the books an individual loans
		this.bookLoan = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void loanBook(Book book) {
		// adds a new book object into the `bookLoan` ArrayList
		this.bookLoan.add(book);
	}

	public void returnBook(Book book) {
		// removes the Book object (named "book") from the `bookLoan` ArrayList
		this.bookLoan.remove(book);
	}

	public int totalBookLoan() {
		// Returns the total no. of books this member is borrowing
		return this.bookLoan.size();
	}

	public ArrayList<Book> getBookLoan() {
		// Returns ArrayList of books this member is borrowing
		return bookLoan;
	}

	@Override
	public String toString() {
		return String.format("%s is currently borrowing these books:\n %s", this.name, this.bookLoan);
	}
}