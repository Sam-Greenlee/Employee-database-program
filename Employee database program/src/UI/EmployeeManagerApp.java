//Programmer: Samuel Greenlee
//Program: Java06 Program Assignment
//Description: This program allows
//	the user to read and write to
//	a database
//Date Created On: 4/30/2020

package UI;

//These are the imports
import java.util.List;
import java.time.LocalDate;
import Business.Business;
import DB.BusinessDB;

public class EmployeeManagerApp
{
	//This instantiates the BusinessDB class
	private static BusinessDB businessDB = new BusinessDB();
	
	public static void main(String[] args)
	{
		//Ask for username and password
		String username = "";
		String password = "";
		boolean isUser = false;
		boolean isAdmin = false;
		while (! isUser && ! isAdmin)
		{
			System.out.println("Enter Your Username And Password\n");
			
			username = Console.getString("Enter Username : ");
			
			password = Console.getString("Enter Passowrd : ");
			
			//Check the username
			if(username .equals("1234"))
			{
				isUser = true;
			}
			else if(username .equals("4567"))
			{
				isAdmin = true;
			}
			else System.out.println("ERROR, Please Enter The Right Username\n");
			
			//Check the password
			if(isUser && password .equals("user"))
			{
				
			}
			else if(isAdmin && password .equals("admin") )
			{
				
			}
			else
			{
				isUser = false;
				
				isAdmin = false;
				
				System.out.println("ERROR, Please Enter The Right Passoword\n");
			}
			
		}
		
		//Display Date at the top of the program
		System.out.println(LocalDate.now());
		
		System.out.println("Welcome to the Employee Manager\n");
        displayMenu(isAdmin);
        
        // perform 1 or more actions
        String action = "";
        while (!action.equalsIgnoreCase("exit")) {
        	
            // get the input from the user
            action = Console.getString("Enter a command: "); 
            System.out.println();

            if (action.equalsIgnoreCase("list")) {
                displayAllEmployees();
            } else if (action.equalsIgnoreCase("add")) {
                addEmployee();
            } else if (action.equalsIgnoreCase("update")) {
                updateEmployee();
            } else if (action.equalsIgnoreCase("del") || 
                       action.equalsIgnoreCase("delete")) {
            	deleteEmployee();
            } else if (action.equalsIgnoreCase("help") || 
                       action.equalsIgnoreCase("menu")) {
                displayMenu(isAdmin);
            } else if (action.equalsIgnoreCase("exit")) {
                exit();
            } else {
                System.out.println("Error! Not a valid command.\n");
            }
        }
	}
	
	//This is the method that displays the menu
	public static void displayMenu(boolean isAdminHere) {
        System.out.println("COMMAND MENU");
        System.out.println("list    - List all employees");
        if(isAdminHere == true)
        {
        	System.out.println("add     - Add a employee");
            System.out.println("update  - update the database");
            System.out.println("del     - Delete a employee");
        }
        System.out.println("help    - Show this menu");
        System.out.println("exit    - Exit this application\n");
    }
	
	//This is the method that displays all of the employees
	public static void displayAllEmployees() {
        System.out.println("EMPLOYEE LIST");

        List<Business> business = businessDB.getAll();
        if (business == null) {
            System.out.println("Error! Unable to get products.\n");
        } else {
            Business b;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < business.size(); i++) {
                b = business.get(i);
                sb.append(StringUtils.padWithSpaces(b.getEmployeeId()+"",9));
                sb.append(StringUtils.padWithSpaces(
                        b.getEmployeeLastName(), 12));
                sb.append(StringUtils.padWithSpaces(
                        b.getEmployeeFirstName(), 12));
                sb.append(StringUtils.padWithSpaces(
                        b.getEmployeeEmail(), 30));
                sb.append(b.getSalary());
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }
	
	//This is the method that adds all the employees
	public static void addEmployee() {
		//These are the getters
        int employeeId = Console.getEmployeeIdRangeChecker("Enter Employee Id: ");
        String employeeLastName = Console.getEmployeeLastNameString("Enter last name: ");
        String employeeFirstName = Console.getEmployeeFirstNameString("Enter first name: ");
        String employeeEmail = Console.getEmployeeEmailString("Enter email name: ");
        float salary = Console.getSalaryRangeChecker("Enter salary: ");
        
        //These are the setters
        Business business = new Business();
        business.setEmployeeId(employeeId);
        business.setEmployeeLastName(employeeLastName);
        business.setEmployeeFirstName(employeeFirstName);
        business.setEmployeeEmail(employeeEmail);
        business.setSalary(salary); 

        //Success Or Fail statements
        boolean success = businessDB.add(business);  
        if (success) {
            System.out.println(employeeId
                    + " has been added to the database.\n");
        } else {
            System.out.println("Error! Unable to add product.\n");
        }
    }
	
	//This is the method that updates the EmployeeDatabase
	public static void updateEmployee()
	{
		int employeeId = Console.getEmployeeIdRangeChecker("Enter Employee Id: ");
		Business business = businessDB.get(employeeId);
		if(business != null)
		{
			//These are the getters
			String employeeLastName = Console.getEmployeeLastNameString("Enter last name: ");
	        String employeeFirstName = Console.getEmployeeFirstNameString("Enter first name: ");
	        String employeeEmail = Console.getEmployeeEmailString("Enter email name: ");
	        float salary = Console.getSalaryRangeChecker("Enter salary: ");
			
	        //These are the setters
			business.setEmployeeLastName(employeeLastName);
	        business.setEmployeeFirstName(employeeFirstName);
	        business.setEmployeeEmail(employeeEmail);
	        business.setSalary(salary); 
	        
	        //This is the command that updates the database
			businessDB.update(business);

		}
		else  System.out.println("Error! Unable to update employee.\n");
	}
	
	//This is the method that deletes any employee the user wants to delete
	public static void deleteEmployee() {
		int employeeId = Console.getEmployeeIdRangeChecker("Enter employee Id to delete: ");

        Business business = businessDB.get(employeeId);
        if (business != null) {
            boolean success = businessDB.delete(business);
            if (success) {
                System.out.println(business.getEmployeeId()
                        + " has been deleted from the database.\n");
            } else {
                System.out.println("Error! Unable to delete employee.\n");
            }
        } else {
            System.out.println("No employee matches that code.\n");
        }
    }
	
	//This is the exit method that exits the program
	public static void exit() {
        System.out.println("Bye.\n");        
    }

}
