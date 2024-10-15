import java.util.Scanner;
import java.util.Random;


public class Main {
	public static void main(String args[]) {
        
        System.out.println("Welcome to the book program!");
        
        String choice;
        Scanner scan = new Scanner(System.in);
        String bookInfo = null;
        
        //Variables for BookstoreBook
        double price = 0;
        String yesno = "";
        double discount = 0;
        int bookCount = 0;
        
        //Variables for LibraryBook
        String threeLetters = "";
        String c = "";
        String callNum = "";
        int libraryCount = 0;

        
        while(true){
            System.out.printf("Would you like to create a book object? (yes/no): ");
            choice = scan.nextLine();

            
			
			if(choice.equalsIgnoreCase("yes")) {
				System.out.printf("Please enter the author, title ad the isbn of the book separted by /: ");
				bookInfo = scan.nextLine();
				System.out.println("Got it!");
			}
			else if(choice.equalsIgnoreCase("no")) {
				System.out.println("Sure!");
				break;
			}
			else {
				System.out.printf("I'm sorry but " + choice + " isn't a valid answer. Please enter either yes or no: ");
			}		
		
		
		
		//If the user said yes
		if(choice.equalsIgnoreCase("yes")){
		    String[] bookSeperate = bookInfo.split("/");
		    String author = bookSeperate[0];
		    author = author.toUpperCase();
		    String title = bookSeperate[1];
		    title = title.toUpperCase();
		    String isbn = bookSeperate[2];
		    
			System.out.printf("Now, tell me if it is a bookstore book or a library book (enter BB for bookstore book and LB for library book: ");
			String Blb = scan.nextLine();
			
			while(true) {
				if( (Blb.equalsIgnoreCase("BB"))  ) {
				System.out.println("Got it!");
		        BookstoreBook b = new BookstoreBook(author,title, isbn,price, yesno,discount);
		        b.askingPrice();
		        bookCount++;
				break;
				}
				else if( (Blb.equalsIgnoreCase("LB")) ){
				    LibraryBook l = new LibraryBook(author, title, isbn, threeLetters, c, callNum);
				    l.toString();
				    libraryCount++;
				}
				else {
					System.out.print("Oops! That's not a valid entry. Please try again: ");
					Blb = scan.nextLine();
				}
			}
		}
	}
	
	System.out.println("Here are all your books...");
	System.out.println("Library Books");
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
	    System.out.printf("Please enter the list price of " + title + " by " + author +": ");
	    price = scan.nextDouble();
	    scan.nextLine(); // Consume the leftover newline after nextDouble()
	    
	    System.out.printf("Is it on sale?(y/n): ");
	    yesno = scan.nextLine();

	     if (yesno.equalsIgnoreCase("y")) {
	         System.out.printf("Deduction percentage: ");
	         discount = scan.nextDouble();
	     } else {
	         discount = 0;
	     }
	    
	    finalprice = price - (price*(discount/100));
	    
	    System.out.println("Here is your bookstore book information: ");
	    System.out.println("[" + isbn + "-" + title + " by " + author + ", $" + price + " listed for $" + String.format("%.2f", finalprice) + "]");
	    
	}
	
	//Override
	public String toString() {
		return "[" + isbn + "-" + title + "by" + author + ", $" + price + "listed for $" + finalprice; 
		}
	
}
	
	
//___________________________
class LibraryBook extends Book {
	private int floors;
	private String strFloors;
	private String[] threeLetters;
	private String c;
	private String callNum;
	
	
	//Set & Get for at least 3 constructors
	public LibraryBook(String author, String title, String isbn, String threeLetters, String c, String callNum) {
		super(author, title, isbn);
		
		Random rand = new Random();
	    this.floors = rand.nextInt(100)+1;
	    strFloors = String.format("%d", floors);
	    
		this.threeLetters[0] = author.substring(0,3);
		this.c = isbn.substring(isbn.length()-1);
		this.callNum = callNum;
		
		callNum = strFloors + "." + threeLetters + "." + c;
	}
	
	
	
	
	//Override
	public String toString(){
		return "[" + isbn + "-" + title + "by" + author + "-" + callNum;
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
