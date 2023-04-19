package Composition.NewLibrary;

public class Main {
	public static void main(String[] args) {
		Member member1 = new Member("001", "Harry");
		Book book1 = new Book("9780553212419", "Sherlock Holmes: The Complete Novels and Stories, Volume I",
				"Arthur Conan Doyle");
		Book book2 = new Book("9780553212426", "Sherlock Holmes: The Complete Novels and Stories, Volume II",
				"Arthur Conan Doyle");

		member1.loanBook(book1);
		member1.loanBook(book2);

		System.out.println(member1);
		System.out.println(member1.totalBookLoan());

		// Test Library class
		Library national = new Library();
		national.addBook(book1.getiSBN(), book1.getTitle(), book1.getAuthor());
		national.addBook(book2.getiSBN(), book2.getTitle(), book2.getAuthor());
		national.addBook("9781435122963", "The Complete Fiction of H.P. Lovecraft", "H.P. Lovecraft");

		national.addMember(member1.getId(), member1.getName());
		national.addMember("009", "John");
		System.out.println(national);
	}
}
