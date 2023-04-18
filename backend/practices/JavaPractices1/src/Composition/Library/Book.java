package Composition.Library;

public class Book {
	private String iSBN;
	private String title;
	private String author;

	public Book (String iSBN, String title, String author) {
		this.iSBN = iSBN;
		this.title = title;
		this.author = author;
	}

	public String getiSBN() {
		return iSBN;
	}

	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return String.format("Title is %s, author is %s.", this.title, this.author);
	}
}
