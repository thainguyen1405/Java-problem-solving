import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String args[]) {
        
        // Welcome the user
        System.out.println("Welcome to the book program!");
        
        String choice;
        Scanner scan = new Scanner(System.in);
        String bookInfo = null;
        
        // Variables for BookstoreBook
        double price = 0;
        String yesno = "";
        String discount = "";
        int bookCount = 0;
        
        // Variables for LibraryBook
        String threeLetters = "";
        String c = "";
        String callNum = "";
        int libraryCount = 0;
        
        // BookList instance to store books
        BookList bookList = new BookList();
        
        // While loop for asking 
        while(true) {
            System.out.printf("Would you like to create a book object? (yes/no): ");
            
            // Check if user's input: yes/no/invalid
            while(true) {
                choice = scan.nextLine();
                
                // Yes case
                if (choice.equalsIgnoreCase("yes")) {
                    System.out.println("");
                    System.out.printf("Please enter the author, title and the isbn of the book separated by /: ");
                    bookInfo = scan.nextLine();
                    System.out.println("Got it!");
                    break;  // Exit this while loop after input is gathered
                } 
                // No case
                else if (choice.equalsIgnoreCase("no")) {
                    System.out.println("Sure!"); 
                    break;  //Break the loop
                } 
                // Invalid case
                else {
                    System.out.printf("I'm sorry but %s isn't a valid answer. Please enter either yes or no: ", choice);
                }
            }
            
            // If the user said yes
            if (choice.equalsIgnoreCase("yes")) {
                String[] bookSeperate = bookInfo.split("/");
                String author = bookSeperate[0].toUpperCase();
                String title = bookSeperate[1].toUpperCase();
                String isbn = bookSeperate[2];
                
                System.out.printf("Now, tell me if it is a bookstore book or a library book (enter BB for bookstore book and LB for library book): ");
                
                // Check if user's input: BB/LB/invalid
                while(true) {
                    String Blb = scan.nextLine();
                    
                    // BookstoreBook
                    if (Blb.equalsIgnoreCase("BB")) {
                        System.out.println("Got it");
                        BookstoreBook b = new BookstoreBook(author, title, isbn, price, yesno, discount);
                        b.askingPrice();
                        bookList.addBook(b);  // Add book to BookList
                        bookCount++;
                        break;
                    } 
                    // LibraryBook
                    else if (Blb.equalsIgnoreCase("LB")) {
                        System.out.println("Got it!");
                        LibraryBook l = new LibraryBook(author, title, isbn, threeLetters, c, callNum);
                        System.out.println("");
                        System.out.println("Here is your library book information: ");
                        System.out.println(l.toString());
                        System.out.println("");
                        bookList.addBook(l);  // Add book to BookList
                        libraryCount++;
                        break;
                    } 
                    // Invalid
                    else {
                        System.out.print("Oops! That's not a valid entry. Please try again: ");
                    }
                }
            } 
            // Exit loop when user said no book created
            else if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }

        // Display all books from list after all
        System.out.println("");
        System.out.println("Here are all your books...");
        bookList.displayBooks();
    }
}

// Class shared by both types of books
abstract class Book {
    // Private fields shared by both types of books
    private String author; 
    private String title;
    private String isbn;
    
    // Constructor to initialize fields
    public Book(String author, String title, String isbn) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }

    // Setter & getter for common field: author, title, isbn.
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
    
    // Abstract method to implement subclasses
    public abstract String toString();
}


// BookstoreBook type
class BookstoreBook extends Book {
    private double price;
    private String yesno;
    private String discount;
    
    // Additional fields
    double updateDiscount;
    double finalprice;
    
    // Constructor BookstoreBook
    public BookstoreBook(String author, String title, String isbn, double price, String yesno, String discount) {
        super(author, title, isbn);
        this.price = price;
        this.yesno = yesno;
        this.discount = discount;
        this.updateDiscount = updateDiscount;
        this.finalprice = finalprice;
    }
    
    // This method asking for BookstoreBook
    public void askingPrice() {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Please enter the list price of %s by %s: ", getTitle(), getAuthor());
        
        price = scan.nextDouble();
        scan.nextLine();  // Consume the leftover newline after nextDouble()

        System.out.printf("Is it on sale? (y/n): ");
        //Handle the yes/no/invalid case
        while(true){
            yesno = scan.nextLine(); 
            if (yesno.equalsIgnoreCase("y")) {
                System.out.printf("Deduction percentage: ");
                discount = scan.nextLine();
                System.out.println("Got it!");
                break;
            } 
            else if (yesno.equalsIgnoreCase("n")){
                discount = "0";
                break;
            }
            else{
                System.out.printf("I'm sorry but %s isn't a valid answer. Please enter either y or n: ", yesno);
            }
        }
        
        // Deal with the "%" symbol
        if (discount.contains("%")) {
            discount = discount.replace("%", "");
        }
        
        double updateDiscount = Double.parseDouble(discount);
        finalprice = price - (price * (updateDiscount / 100));
        
        // Print the result
        System.out.println("");
        System.out.println("Here is your bookstore book information: ");
        System.out.println("[" + getIsbn() + "-" + getTitle() + " by " + getAuthor() + ", $" + price + " listed for $" + String.format("%.2f", finalprice) + "]");
        System.out.println("");
    }
    
    @Override
    public String toString() {
        return "[" + getIsbn() + " - " + getTitle() + " by " + getAuthor() + ", $" + price + " listed for $" + finalprice + "]";
    }
}

// LibraryBook type
class LibraryBook extends Book {
    private int floors;
    private String strFloors;
    private String[] threeLetters;
    private String c;
    private String callNum;
    
    // Constructor for LibraryBook
    public LibraryBook(String author, String title, String isbn, String threeLetters, String c, String callNum) {
        super(author, title, isbn);
        
        // Assign random number to floors
        Random rand = new Random();
        this.floors = rand.nextInt(100) + 1;
        strFloors = String.format("%d", floors);
        
        // Assign the first three letters of the author to the array
        this.threeLetters = new String[1];
        this.threeLetters[0] = author.substring(0, 3);
        
        // Get the last character of the ISBN
        this.c = isbn.substring(isbn.length() - 1);
        
        // Generate the call number
        this.callNum = strFloors + "." + this.threeLetters[0] + "." + this.c;
    }
    
    @Override
    public String toString() {
        return "[" + getIsbn() + " - " + getTitle() + " by " + getAuthor() + "-" + callNum + "]";
    }
}

// BookList array
class BookList {
    private Book[] list;
    private int count;
    
    public BookList() {
        list = new Book[100];
        count = 0;
    }
    
    // Book array availability
    public void addBook(Book book) {
        if (count < 100) {
            list[count++] = book;
        } else {
            System.out.println("The list is full!");
        }
    }
    
    public void displayBooks() {
        int libraryBookCount = 0;
        int bookstoreBookCount = 0;
        
        // Count the number of books in each category
        for (int i = 0; i < count; i++) {
            if (list[i] instanceof LibraryBook) {
                libraryBookCount++;
            } 
            else if (list[i] instanceof BookstoreBook) {
                bookstoreBookCount++;
            }
        }
        
        // Display the library books
        System.out.println("Library Books (" + libraryBookCount + "):");
        for (int i = 0; i < count; i++) {
            if (list[i] instanceof LibraryBook) {
                System.out.printf("\t\t");
                System.out.println(list[i]);
            }
        }
        System.out.println("_ _ _ _");
        
        // Display the bookstore books
        System.out.println("\nBookstore Books (" + bookstoreBookCount + "):");
        for (int i = 0; i < count; i++) {
            if (list[i] instanceof BookstoreBook) {
                System.out.printf("\t\t");
                System.out.println(list[i]);
            }
        }
        System.out.println("_ _ _ _");
        System.out.println("Take care now!");
    }
}
