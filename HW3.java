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

        // Create a BookList instance to store books
        BookList bookList = new BookList();

        while(true){
            System.out.printf("Would you like to create a book object? (yes/no): ");
            choice = scan.nextLine();

            if(choice.equalsIgnoreCase("yes")) {
                System.out.printf("Please enter the author, title and the isbn of the book separated by /: ");
                bookInfo = scan.nextLine();
                System.out.println("Got it!");
            }
            else if(choice.equalsIgnoreCase("no")) {
                System.out.println("Sure!");
                break;
            }
            else {
                System.out.printf("I'm sorry but %s isn't a valid answer. Please enter either yes or no: ", choice);
            }
            
            // If the user said yes
            if(choice.equalsIgnoreCase("yes")){
            String[] bookSeperate = bookInfo.split("/");
            String author = bookSeperate[0];
            author = author.toUpperCase();
            String title = bookSeperate[1];
            title = title.toUpperCase();
            String isbn = bookSeperate[2];
            
            System.out.printf("Now, tell me if it is a bookstore book or a library book (enter BB for bookstore book and LB for library book): ");
            
            while(true){
                String Blb = scan.nextLine();
                
                if (Blb.equalsIgnoreCase("BB")) {
                    // Handle BookstoreBook creation
                    BookstoreBook b = new BookstoreBook(author, title, isbn, price, yesno, discount);
                    b.askingPrice();
                    bookList.addBook(b);  // Add book to BookList
                    bookCount++;
                    break;
                } 
                else if (Blb.equalsIgnoreCase("LB")) {
                    // Handle LibraryBook creation
                    System.out.println("Got it!");
                    LibraryBook l = new LibraryBook(author, title, isbn, threeLetters, c, callNum);
                    System.out.println(l.toString());
                    bookList.addBook(l);  // Add book to BookList
                    libraryCount++;
                    break;
                } 
                else {
                    System.out.print("Oops! That's not a valid entry. Please try again: ");
                }
            }
        }
                
            }
            

        System.out.println("Here are all your books...");
        bookList.displayBooks(); // Display all books from BookList
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
	
public void askingPrice() {
    Scanner scan = new Scanner(System.in); // Declare Scanner here
    System.out.printf("Please enter the list price of %s by %s: ", title, author);
    
    price = scan.nextDouble();
    scan.nextLine();  // Consume the leftover newline after nextDouble()

    System.out.printf("Is it on sale? (y/n): ");
    yesno = scan.nextLine();  // Capture 'y' or 'n' for sale status
    
    if (yesno.equalsIgnoreCase("y")) {
        System.out.printf("Deduction percentage: ");
        discount = scan.nextDouble();
        scan.nextLine();  // Consume the leftover newline after nextDouble()
    } else {
        discount = 0;
    }

    finalprice = price - (price * (discount / 100));

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
    
    // Constructor
    public LibraryBook(String author, String title, String isbn, String threeLetters, String c, String callNum) {
        super(author, title, isbn);
        
        Random rand = new Random();
        this.floors = rand.nextInt(100) + 1;
        strFloors = String.format("%d", floors);
        
        // Initialize the threeLetters array with size 1 (or any other size if needed)
        this.threeLetters = new String[1]; 
        
        // Assign the first three letters of the author to the array
        this.threeLetters[0] = author.substring(0, 3);
        
        // Get the last character of the ISBN
        this.c = isbn.substring(isbn.length() - 1);
        
        // Generate the call number
        this.callNum = strFloors + "." + this.threeLetters[0] + "." + this.c;
    }
    
    // Override toString method
    @Override
    public String toString() {
        return "[" + isbn + "-" + title + " by " + author + "-" + callNum + "]";
    }
}


//___________________________
class BookList {
	private Book[] list;
	private int count;
	public BookList() {
		list = new Book[100];
		count++;
	}
	
	 public void addBook(Book book) {
        if (count < list.length) {
            list[count++] = book;
        } else {
            System.out.println("The list is full!");
        }
    }
    
     public void displayBooks() {
        int libraryBookCount = 0;
        int bookstoreBookCount = 0;

        System.out.println("Library Books:");
        for (int i = 0; i < count; i++) {
            if (list[i] instanceof LibraryBook) {
                System.out.println(list[i]);
                libraryBookCount++;
            }
        }

        System.out.println("\nBookstore Books:");
        for (int i = 0; i < count; i++) {
            if (list[i] instanceof BookstoreBook) {
                System.out.println(list[i]);
                bookstoreBookCount++;
            }
        }
     }

}
