package Composition.NewLibrary;

// no need to import `Composition.NewLibrary.Book` as they are in same package :)
import Composition.CourseService.Course;
import Composition.CourseService.Student;
import Composition.NewLibrary.Book;
import java.util.HashMap;

public class Library {
	// Declare `private` instance variables
	private HashMap<String, Book> bookMap; // HashMap of books in a library
	private HashMap<String, Member> memberMap; // HashMap of members of a library

	// Constructor
	public Library() {
		// Initialize instance variables
		this.bookMap = new HashMap<>();
		this.memberMap = new HashMap<>();
	}

	public void addBook(String iSBN, String title, String author) {
		// Add newBook to bookMap (HashMap of books in a library)
		Book newBook = new Book(iSBN, title, author);
		this.bookMap.put(iSBN, newBook);
	}

	public HashMap<String, Book> getBooks() {
		return this.bookMap; //returns all books in this library
	}

	public Book findBook(String bookId) {
		// get the book from this library (assuming it exists)
		return this.bookMap.get(bookId);
	}

	public void addMember(String id, String name) {
		// adds new member into this library's member list(HashMap)

		this.memberMap.put(id, new Member(id, name));
		/*
		Member newMember = new Member(id, name);
		this.memberMap.put(newMember.getId(), newMember); // or just `id` instead of `newMember.getId()`
		 */
	}

	public void loanBookToMember(String memberId, String bookId) {
//		findBook(bookId); //returns Book object
//		this.memberMap.get(memberId); //returns Member object

		// use the loanBook method from `Member` class & add the 2 lines above
		// NOTE: might need to also call the `removeBook` method below to remove from this Library
		this.memberMap.get(memberId).loanBook(findBook(bookId));
	}

	public void returnBookFromMember(String memberId, String bookId) {
//		findBook(bookId); //returns Book object
//		this.memberMap.get(memberId); //returns Member object

		// use the `returnBook` method from `Member` class & add the 2 lines above
		this.memberMap.get(memberId).returnBook(findBook(bookId));
	}

	// Return a specific member's info
	public Member displayMemberInformation(String memberId) {
		// returns a Member object
		return this.memberMap.get(memberId);
	}

	// Return the total no. of books loaned by a member
	public int totalBookLoan(String memberId) {

//		this.memberMap.get(memberId); //returns Member object
		// use the `totalBookLoan` method from `Member` class & add the line above
		return this.memberMap.get(memberId).totalBookLoan();// returns an int
	}

	// Removes a member from this Library
	public void removeMember(String id) {
		this.memberMap.remove(id);
	}

	// Removes a book from this Library
	public void removeBook(String iSBN) {
		this.bookMap.remove(iSBN);
	}

	@Override
	public String toString() {
		String allBooks = "Books available in this library: \n";
		String allMembers = "Members registered to this library: \n";

		String printBooks = "";
		String printMembers = "";

		// for-each element in the `bookMap` HashMap, assign to variable `book` of `Book` datatype
		for (Book book : this.bookMap.values()) {
			printBooks += book + "\n";
		}

		for (Member member : this.memberMap.values()) {
			printMembers += member.getName() + "\n";
		}

		String returnString = String.format(allBooks + printBooks + "\n" + allMembers + printMembers);
		return returnString;
	}
}
