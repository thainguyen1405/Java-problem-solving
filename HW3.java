import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
        
        System.out.println("Welcome to the book program!");
		System.out.printf("Would you like to create a book object? (yes/no): ");
		
		
        //Loop yes/no
		String choice;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			choice = scan.nextLine();
			
			if(choice.equalsIgnoreCase("yes")) {
				System.out.printf("Please enter the author, title ad the isbn of the book separted by /: ");
				String bookInfo = scan.nextLine();
				System.out.println("Got it!");
				break;
			}
			else if(choice.equalsIgnoreCase("no")) {
				System.out.println("Sure!");
				break;
			}
			else {
				System.out.printf("I'm sorry but " + choice + " isn't a valid answer. Please enter either yes or no: ");
			}		
		}
		
		//If the user said yes
		if(choice.equalsIgnoreCase("yes")){
			System.out.printf("Now, tell me if it is a bookstore book or a library book (enter BB for bookstore book and LB for library book: ");
			String Blb = scan.nextLine();
			
			while(true) {
				if( (Blb.equalsIgnoreCase("BB")) || (Blb.equalsIgnoreCase("LB")) ) {
				System.out.println("Got it!");
				break;
				}
				else {
					System.out.println("Oops! That's not a valid entry. Please try again: ");
					Blb = scan.nextLine();
				}
			}
		}
}
	

	
//___________________________
abstract class Book {
	// Common fields shared by both types of books
    protected String author; 
    protected String title;
    protected String isbn;
    
    // Constructor to initialize common fields
    public Book(String author, String title, String isbn) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }
    

    
    // Common setter and getter methods for author, title, and isbn
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
    
 // Abstract method that subclasses will implement
    public abstract String toString() {
    	return "[" + isbn + "-" + title + "by" + author + "]";
    }
    
}

//___________________________
class BookstoreBook extends Book {
	private double price;
	private boolean yesno;
	private double discount;
	double finalprice;
	
	//Set & Get for at least 3 constructors
	public BookstoreBook(String author, String title, String isbn, double price, boolean yesno, double discount) {
		super(author, title, isbn);
		this.price = price;
		this.yesno = yesno;
		this.discount = discount;
		
		if(yesno == true) {
			finalprice = price - (price * (discount/100));
		}
	}
	
	//Override
	public String toString() {
		return "[" + isbn + "-" + title + "by" + author + ", $" + price + "listed for $" + finalprice; 
		}
	
}
	
	
//___________________________
class LibraryBook extends Book {
	private String callNum;
	
	//Set & Get for at least 3 constructors
	public LibraryBook(String author, String title, String isbn, String callNum) {
		super(author, title, isbn);
		this.callNum = callNum;
	}
	
	
		
		
		
	//Setter & Getter for author, title & isbn
	public String setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
	public String setTitle(String title) {
		this.title = title;
	}
	public String getTitle(String title) {
		return title;
	}
	public String setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getIsbn(String isbn) {
		return isbn;
	}
		
	//Override
	public String toString() {
		return "[" + isbn + "-" + title + "by" + author + "]";
	}
}

//___________________________
class BookList {
	private Book[] list;
	public BookList() {
		list = new Book[100];
		// Additional code goes here if needed...
	}
}
