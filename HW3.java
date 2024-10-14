import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
        
        System.out.println("Welcome to the book program!");
		System.out.printf("Would you like to create a book object? (yes/no): ");
		
		
        //Loop yes/no
		String choice;
		String bookInfo = null;
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			
			choice = scan.nextLine();
			
			if(choice.equalsIgnoreCase("yes")) {
				System.out.printf("Please enter the author, title ad the isbn of the book separted by /: ");
				bookInfo = scan.nextLine();
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
		    String[] bookSeperate = bookInfo.split("/");
		    String author = bookSeperate[0];
		    String title = bookSeperate[1];
		    String isbn = bookSeperate[2];
		    
			System.out.printf("Now, tell me if it is a bookstore book or a library book (enter BB for bookstore book and LB for library book: ");
			String Blb = scan.nextLine();
			
			while(true) {
				if( (Blb.equalsIgnoreCase("BB")) || (Blb.equalsIgnoreCase("LB")) ) {
				System.out.println("Got it!");
				break;
				}
				else {
					System.out.print("Oops! That's not a valid entry. Please try again: ");
					Blb = scan.nextLine();
				}
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
    public String toString() {
    	return "[" + isbn + "-" + title + "by" + author + "]";
    }
    
}

//___________________________
class BookstoreBook extends Book {
	private double price;
	private String yesno;
	private double discount;
	double finalprice;
	
	//Set & Get for at least 3 constructors
	public BookstoreBook(String author, String title, String isbn, double price, String yesno, double discount) {
		super(author, title, isbn);
		this.price = price;
		this.yesno = yesno;
		this.discount = discount;
		this.finalprice = finalprice;
	}
	
	public void askingPrice(){
	    Scanner scan = new Scanner(System.in); // Declare Scanner here
	    System.out.println("Please enter the list price of " + title + "by " + author +": ");
	    price = scan.nextInt();
	    
	    System.out.println("Is it on sale?(y/n): ");
	    yesno = scan.nextLine();
	    
	    if(yesno == "y"){
	        System.out.println("Deduction percentage: " + discount + "%");
	        discount = scan.nextInt();
	    }
	    else{
	        discount = 0;
	    }
	    
	    finalprice = price - (price - (price*(discount/100)));
	    
	    System.out.println("Here is your bookstore book information: ");
	    System.out.println("[" + isbn + "-" + title + " by " + author + ",$" + price + " listed for $" + finalprice);
	    
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
	
	//Override
	public String toString(){
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
