import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



// Final Project
// Thai Nguyen


public class FinalProject{
	public static void main(String[] args) {
		//Test code
		int user = 0;
		Scanner scan = new Scanner(System.in);
		
		//Declare initial variables
		//Student
		String name = "";
		String id = "";
		double gpa = 0;
		int credit = 0;
		
		//Faculty & Staff
		String department = "";
		String title = "";
		String rank = "";
		String status = "";
		
		//Daily date report
		LocalDate today = LocalDate.now();
		
		ArrayList<Person> people = new ArrayList<>(100);
		
		//Menu display
		System.out.println("\t\t\t Welcome to my Personal Management Program");
		System.out.println();
		
		boolean exitLoops = false;
		
		while(exitLoops != true) {
			System.out.println("Choose one of the options: ");
			System.out.println();
			
			System.out.println("1- Enter the information a faculty");
			System.out.println("2- Enter the information of a student");
			System.out.println("3- Print tuition invoice for a student");
			System.out.println("4- Print faculty information");
			System.out.println("5- Enter the information of a staff member");
			System.out.println("6- Print the information of a staff member");
			System.out.println("7- Delete a person");
			System.out.println("8- Exit Program");
			
			System.out.print("\tEnter your selection: ");
			user = scan.nextInt();
			System.out.println();
			
			//1st case
			if(user == 1) {
				Scanner choice1 = new Scanner(System.in);
				System.out.println("Enter the faculty info:");
				System.out.print("\tName of the faculty: ");
				name = choice1.nextLine();
				
				System.out.print("\tID: ");
				id = choice1.nextLine();
				
				while(true) {
			    	if(id.matches("[a-z]{2}\\d{4}")) {
			    		break;
			    	}
			    	else
			    		System.out.println("\tInvalid ID format. Must be LetterLetterDigitDigitDigitDigit");
			    	    System.out.print("\tID: ");
					    id = choice1.nextLine(); // Read the ID
			    }
				
				System.out.println();
				
				while(true) {
					System.out.print("\tRank: ");
					rank = choice1.nextLine();
					
					if(rank.equalsIgnoreCase("Professor") || rank.equalsIgnoreCase("Adjunct")) {
						break;
					}
					else
						System.out.println("\t\t\"" + rank + "\"" + " is invalid");
				}
				
				while(true) {
					System.out.println();
					System.out.print("\tDepartment: ");
					department = choice1.nextLine();
					
					if(department.equalsIgnoreCase("Mathematics") || department.equalsIgnoreCase("Engineering") || department.equalsIgnoreCase("English")) {
						break;
					}
					else
						System.out.println("\t\t\"" + department + "\"" + " is invalid");
				}
				
				System.out.println("Faculty added!");
				System.out.println();
				
				people.add(new Faculty(name, id, department, rank));
				
			}
			
			
			//2nd case
			if (user == 2) {
				Scanner choice2 = new Scanner(System.in);
			    System.out.println("Enter the student info: ");
			    System.out.print("\tName of Student: ");
			    name = choice2.nextLine(); // Read the name
			    System.out.print("\tID: ");
			    id = choice2.nextLine(); // Read the ID
			    
			    while(true) {
			    	if(id.matches("[a-z]{2}\\d{4}")) {
			    		break;
			    	}
			    	else
			    		System.out.println("\tInvalid ID format. Must be LetterLetterDigitDigitDigitDigit");
			    	    System.out.print("\tID: ");
					    id = choice2.nextLine(); // Read the ID
			    }
			    
			    System.out.print("\tGpa: ");
			    gpa = choice2.nextDouble(); // Read the GPA
			    System.out.print("\tCredit hours: ");
			    credit = choice2.nextInt(); // Read the credit hours
			    System.out.println("\nStudent added!");
			    System.out.println();
			    
			    people.add(new Student(name, id, gpa, credit));
			}
			
			
			//3rd case
			if(user == 3) {
				Scanner choice3 = new Scanner(System.in);
				String scheck = "";
				boolean sfound = false;
				System.out.print("Enter the student's is: ");
				scheck = choice3.nextLine();
				
				for(int i = 0; i < people.size(); i++) {
					Person p = people.get(i);
					Student s = (Student) p;
					if(p instanceof Student && scheck.equalsIgnoreCase(p.getId())) {	
						s.print();
						sfound = true;
					}
				}
				
				if(!sfound) {
					System.out.println("No student matched!");
				}
			}
				
			
			if(user == 4) {
				Scanner choice4 = new Scanner(System.in);
				String facheck = "";
				boolean fafound = false;
				System.out.print("Enter the Faculty's is: ");
				facheck = choice4.nextLine();
				
				for(int i = 0; i < people.size(); i++) {
					Person p = people.get(i);
					Faculty f = (Faculty) p;
					if(p instanceof Faculty && facheck.equalsIgnoreCase(p.getId())) {
						f.print();
						fafound = true;
					}
				}
					
				if(!fafound) {
					System.out.println("No faculty matched!");
				}
			}
			
			if(user == 5) {
				Scanner choice5 = new Scanner(System.in);
				System.out.println("Enter the staff info: ");
				System.out.print("\tName of the staff member: ");
				name =choice5.nextLine();
				
				System.out.print("\tEnter the id: ");
				id = choice5.nextLine();
				
				while(true) {
			    	if(id.matches("[a-z]{2}\\d{4}")) {
			    		break;
			    	}
			    	else
			    		System.out.println("\tInvalid ID format. Must be LetterLetterDigitDigitDigitDigit");
			    	    System.out.print("\tID: ");
					    id = choice5.nextLine(); // Read the ID
			    }
				
				System.out.print("\tDepartment: ");
				department = choice5.nextLine();
				
				while(true) {	
					if(department.equalsIgnoreCase("Mathematics") || department.equalsIgnoreCase("Engineering") || department.equalsIgnoreCase("English")) {
						break;
					}
					else
						System.out.println("\t\t\"" + department + "\"" + " is invalid");
				}
				
				while(true) {
					System.out.print("\tStatus, Enter P for Part Time, or Enter F for Full Time: ");
					status = choice5.nextLine();
					
					if(status.equalsIgnoreCase("P") || status.equalsIgnoreCase("F")) {
						break;
					}
					else
						System.out.println("\t\t\"" + status + "\"" + "is invalid");
				}
				
				System.out.println();
				System.out.println("Staff member added!");
			}
			
			if(user == 6) {
				Scanner choice6 = new Scanner(System.in);
				String sfcheck = "";
				boolean sffound = false;
				System.out.print("Enter the Staff's is: ");
				sfcheck = choice6.nextLine();
				
				for(int i = 0; i < people.size(); i++) {
					Person p = people.get(i);
					Staff sf = (Staff) p;
					if(p instanceof Staff && sfcheck.equalsIgnoreCase(p.getId())) {	
						sf.print();
						sffound = true;
					}
				}
				
				if(!sffound) {
					System.out.println("No staff matched!");
				}
			}
				
			if(user == 7) {
				//Remove the person from array
			}
			
			
			
			if(user == 8) {
				String yesno;
				int sort;
				
				while(true) {
					Scanner scan1 = new Scanner(System.in);
					
					System.out.print("Would you like to create the report? (Y/N): ");
					yesno = scan1.nextLine();
					
					if(yesno.equalsIgnoreCase("Y")) {
						while(true) {
							System.out.println("Would you like to sort your students by descending gpa or name (1 for gpa, 2 for name): ");
							sort = scan1.nextInt();
							
							System.out.println("Report created and saved on your hard drive!");
							System.out.println("Goodbye");
							
							if(sort == 1) {
								//Create a report
								try(PrintWriter writer = new PrintWriter("report.txt")){
									writer.println("Report created on " + today);
									writer.println("****************");
								}
								catch(IOException e) {
									System.err.println("Error while creating report");
								}
							      break;
							}
							else if(sort == 2) {
								//Create a report
								try(PrintWriter writer = new PrintWriter("report.txt")){
									writer.println("Report created on " + today);
									writer.println("****************");
								}
								catch(IOException e) {
									System.err.println("Error while creating report");
								}
							      break;
							}
							else
								System.out.println(sort + "is invalid");
					
							
						}
					}
							
						
					else if(yesno.equalsIgnoreCase("N")){
						System.out.println("Goodbye!");
						exitLoops = true;
						break;
					}
					else
						System.out.println(yesno + "is invalid");
				}
		
			}
			
		}
		
	}
}


//______________________
interface Int1{
	public void info();
	
}


//____________________
abstract class Person{
	private String name;
	private String id;
	
	public Person(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	
	public abstract void print();
}


//___________________
class Student extends Person{
	private double gpa;
	private int credit;
	
	public Student(String name, String id, double gpa, int credit) {
		super(name, id);
		this.credit = credit;
	}	
	
	public void print() {
			System.out.println("Here is the tuition invoice for " + getName() + ":");
			System.out.println();
			System.out.println("--------------------------------------------------");
			System.out.println(getName() + "\t\t" + getId());
			System.out.println("Credit Hours: " + credit + " ($236.45/credit hour)");
			System.out.println("Fees: $52");
			
			double discount = 0;
			double total = 0.0;
			if(gpa >= 3.85) {
				total = (236.45*credit + 52) - 0.25*(236.45*credit + 52);
				total = Math.round(total*100.0)/100.0;
			}
			else
				total = (236.45*credit + 52);
			    total = Math.round(total*100.0)/100.0;
			
			System.out.println("Total payment (after discount): $" + total + "\t\t($" + discount + " discount applied)");
			System.out.println("--------------------------------------------------");

		}
}

abstract class Employees extends Person{
	private String title;
	private String department;
	
	public Employees(String name, String id, String department) {
		super(name,id);
		this.department = department;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public abstract void print();
}

class Faculty extends Employees{
	private String rank;
	
	public Faculty(String name, String id, String department, String rank) {
		super(name, id, department);
		this.rank = rank;
	}
	
	public String getRank() {
		return rank;
	}
	
	public void print() {
		System.out.println("----------------------------");
		System.out.println(getName() + "\t\t" + getId());
		System.out.println(getDepartment() + " Department, " + rank);
		System.out.println("-----------------------------");
		System.out.println();
	}	
}


class Staff extends Employees{
	private String status;
	
	public Staff(String name, String id, String department, String status) {
		super(name, id, department);
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void print() {
		System.out.println("----------------------------");
		System.out.println(getName() + "\t\t" + getId());
		System.out.println(getDepartment() + "Department, " + status);
		System.out.println("----------------------------");
		System.out.println();
	}
		
}





//_____________
