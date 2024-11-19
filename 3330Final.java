import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


// Final Project
// Thai Nguyen


public class FinalProject{
	public static void main(String[] args) throws Exception{
		//Test code
		String user = "";
		Scanner scan = new Scanner(System.in);
		
		//Declare initial variables
		//Student
		String name = "";
		String id = "";
		double gpa = 0;
		int credit = 0;
		
		//Faculty & Staff
		String department = "";
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
			 user = scan.nextLine().trim();  //Remove extra whitespace
			 System.out.println();
			 
			 
			 
			//1st case
			if(user.equals("1")) {
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
			    	    System.out.println();
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
			else if (user.equals("2")) {
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
			    	    System.out.println();
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
			else if(user.equals("3")) {
				Scanner choice3 = new Scanner(System.in);
				String scheck = "";
				boolean sfound = false;
				System.out.print("Enter the student's is: ");
				scheck = choice3.nextLine();
				
				for(int i = 0; i < people.size(); i++) {
					Person p = people.get(i);
					if(p instanceof Student && scheck.equalsIgnoreCase(p.getId())) {
						Student s = (Student) p;
						s.print();
						sfound = true;
					}
				}
				
				if(!sfound) {
					System.out.println("No student matched!");
				}
			}
				
			
			else if(user.equals("4")) {
				Scanner choice4 = new Scanner(System.in);
				String facheck = "";
				boolean fafound = false;
				System.out.print("Enter the Faculty's is: ");
				facheck = choice4.nextLine();
				
				for(int i = 0; i < people.size(); i++) {
					Person p = people.get(i);
					if(p instanceof Faculty && facheck.equalsIgnoreCase(p.getId())) {
						Faculty f = (Faculty) p;
						f.print();
						fafound = true;
					}
				}
					
				if(!fafound) {
					System.out.println("No faculty matched!");
				}
			}
			
			else if(user.equals("5")) {
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
			    	    System.out.println();
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
						if(status.equalsIgnoreCase("F")) {
							status = "Full Time";
						}
						else if(status.equalsIgnoreCase("P")) {
							status = "Part Time";
						}
						break;
					}
					else
						System.out.println("\t\t\"" + status + "\"" + "is invalid");
				}
				
				System.out.println();
				System.out.println("Staff member added!");
				
				people.add(new Staff(name, id, department, status));
			}
			
			else if(user.equals("6")) {
				Scanner choice6 = new Scanner(System.in);
				String sfcheck = "";
				boolean sffound = false;
				System.out.print("Enter the Staff's is: ");
				sfcheck = choice6.nextLine();
				
				for(int i = 0; i < people.size(); i++) {
					Person p = people.get(i);
					if(p instanceof Staff && sfcheck.equalsIgnoreCase(p.getId())) {
						Staff sf = (Staff) p;
						sf.print();
						sffound = true;
					}
				}
				
				if(!sffound) {
					System.out.println("No staff matched!");
				}
			}
				
			else if(user.equals("7")) {
				Scanner choice7 = new Scanner(System.in);
				String decheck = "";
				boolean defound = false;
				System.out.print("Enter the id of the person to delete: ");
				decheck = choice7.nextLine();
				
				for(int i = 0; i < people.size(); i++) {
					Person p = people.get(i);
					if(decheck.equalsIgnoreCase(p.getId())) {	
						people.remove(p);
						System.out.println("Delete successfully!");
						System.out.println();
						defound = true;
					}
				}
				
				if(!defound) {
					System.out.println("Sorry no such person exists.");
					System.out.println();
				}
				
			}
			
			
			else if (user.equals("8")) { // 8th case
			    String yesno;
			    int sort;
			    boolean reportCheck = false;

			    while (reportCheck != true) {
			        Scanner choice8 = new Scanner(System.in);

			        System.out.print("Would you like to create the report? (Y/N): ");
			        yesno = choice8.nextLine();

			        if (yesno.equalsIgnoreCase("Y")) {
			            while (true) {
			                System.out.print("Would you like to sort your students by descending gpa or name (1 for gpa, 2 for name): ");
			                sort = choice8.nextInt();

			                System.out.println("Report created and saved on your hard drive!");
			                System.out.println("Goodbye");

			                PrintWriter writer = null;
			                try {
			                    writer = new PrintWriter("report.txt");
			                    writer.println("\t\tReport created on " + today);
			                    writer.println("\t\t**************************");

			                    writer.println("Faculty Members");
			                    writer.println("-----------------");
			                    for (int i = 0; i < people.size(); i++) {
			                        Person p = people.get(i);
			                        int faculty = 1;
			                        if (p instanceof Faculty) {
			                            Faculty f = (Faculty) p;
			                            writer.println("\t\t" + faculty + ". " + f.getName());
			                            writer.println("\\t\\tID: " + f.getId());
			                            writer.println("\t\t" + f.getRank() + ", " + f.getDepartment());
			                            faculty++;
			                        }
			                    }

			                    writer.println("\nStaff Members");
			                    writer.println("-----------------");
			                    for (int i = 0; i < people.size(); i++) {
			                        Person p = people.get(i);
			                        int staff = 1;
			                        if (p instanceof Staff) {
			                            Staff sf = (Staff) p;
			                            writer.println("\t\t" + staff + ". " + sf.getName());
			                            writer.println("\t\tID: " + sf.getId());
			                            writer.println("\t\t" + sf.getDepartment() + ", " + sf.getStatus());
			                            staff++;
			                        }
			                    }

			                    writer.println("\nStudents");
			                    writer.println("-----------------");
			                    if (sort == 1) {
			                        int student = 1;
			                        sortGpa(people);
			                        for (Person p : people) {
			                            if (p instanceof Student) {
			                                Student s = (Student) p;
			                                writer.println("\t\t" + student + ". " + s.getName());
			                                writer.println("\t\tID: " + s.getId());
			                                writer.println("\t\tGpa: " + s.getGpa());
			                                writer.println("\t\tCredit hours: " + s.getCredit());
			                                writer.println();
			                                student++;
			                            }
			                        }
			                    } else if (sort == 2) {
			                        int student = 1;
			                        sortName(people);
			                        for (Person p : people) {
			                            if (p instanceof Student) {
			                                Student s = (Student) p;
			                                writer.println(student + ". " + s.getName());
			                                writer.println("ID: " + s.getId());
			                                writer.println("Gpa: " + s.getGpa());
			                                writer.println("Credit hours: " + s.getCredit());
			                                writer.println();
			                                student++;
			                            }
			                        }
			                    } else {
			                        System.out.println(sort + " is invalid");
			                    }
			                } catch (Exception e) {
			                    System.err.println("Error: " + e.getMessage());
			                } finally {
			                    if (writer != null) {
			                        writer.close(); // Ensure the writer is closed properly
			                    }
			                }
			                exitLoops = true;
			                break;
			            }
			        } else if (yesno.equalsIgnoreCase("N")) {
			            System.out.println("Goodbye!");
			            exitLoops = true;
			            break;
			        } else {
			            System.out.println(yesno + " is invalid");
			        }
			        
			        reportCheck = true;
			    }
			}
			
			else
				System.out.println("Invalid entry - please try again");
			    System.out.println();
		}
	}
	
		
	
	    //Insertion method in sorting GPA
	public static void sortGpa(ArrayList<Person> people) {
	    for (int i = 1; i < people.size(); i++) {
	        if (people.get(i) instanceof Student) {
	            Student thisStudent = (Student) people.get(i);
	            int j = i - 1;

	            // Compare GPA only for Student objects
	            while (j >= 0 && people.get(j) instanceof Student) {
	                Student prevStudent = (Student) people.get(j);
	                if (prevStudent.getGpa() < thisStudent.getGpa()) {
	                    people.set(j + 1, people.get(j));
	                } else {
	                    break;
	                }
	                j--;
	            }

	            people.set(j + 1, thisStudent);
	        }
	    }
	}

		
		
		//Insertion method in sorting name
	public static void sortName(ArrayList<Person> people) {
	    for (int i = 1; i < people.size(); i++) {
	        if (people.get(i) instanceof Student) {
	            Student thisStudent = (Student) people.get(i);
	            int j = i - 1;

	            // Compare names only for Student objects
	            while (j >= 0 && people.get(j) instanceof Student) {
	                Student prevStudent = (Student) people.get(j);
	                if (prevStudent.getName().compareToIgnoreCase(thisStudent.getName()) < 0) {
	                    people.set(j + 1, people.get(j));
	                } else {
	                    break;
	                }
	                j--;
	            }

	            people.set(j + 1, thisStudent);
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
		this.gpa = gpa;
		this.credit = credit;
	}
	
	public Double getGpa() {
		return gpa;
	}
	
	public int getCredit() {
		return credit;
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
		System.out.println(getDepartment() + " Department, " + status);
		System.out.println("----------------------------");
		System.out.println();
	}
		
}





//_____________
