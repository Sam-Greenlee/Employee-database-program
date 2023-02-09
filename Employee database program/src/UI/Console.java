//Programmer: Samuel Greenlee
//Program: Java06 Program Assignment
//Description: This program allows
//	the user to read and write to
//	a database
//Date Created On: 4/30/2020

package UI;

////These are import statements
import java.util.Scanner;
import Business.Validation;

public class Console
{
	private static Scanner sc = new Scanner(System.in);
	
	//Broad scope variable
	//static boolean errorCheck = false;
	
	public static String getString(String prompt)
	{
        System.out.print(prompt);
        String s = sc.next();        
        sc.nextLine();     
        return s;
    }
	
	//This is the first method that validates employeeId.
	//	It is based on if employeeId is an int or not
	public static int getEmployeeId(String prompt) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid Input. Must Be An Integer. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }

	//This is the second method that validates employeeId.
	//	It is based off whether employeeId is between 10000 and 90000
    public static int getEmployeeIdRangeChecker(String prompt) {
    	int i = 0;
    	int min = 10000;
    	int max = 90000;
        boolean isValid = false;
        while (!isValid) {
            i = getEmployeeId(prompt);
            if (i <= min) { 
                System.out.println(
                        "Error! Number must be greater than " + min + "."); 
            } else if (i >= max) { 
                System.out.println(
                        "Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return i;
    }
    
    //This method gets and then checks the employee last name
    public static String getEmployeeLastNameString(String prompt)
    {
    	String employeeLastNameString = "";
    	boolean errorCheck = false;
        do
        {
        	System.out.print(prompt);
            employeeLastNameString = sc.nextLine(); 
        	errorCheck = Validation.isStringPresent(employeeLastNameString, "Employee last name");
        }while(!errorCheck);
        
        return employeeLastNameString;
    }
    
  //This method gets and then checks the employee first name
    public static String getEmployeeFirstNameString(String prompt)
    {
    	String employeeFirstNameString = "";
    	boolean errorCheck = false;
    	do
    	{
    		System.out.print(prompt);
            employeeFirstNameString = sc.nextLine();  
            errorCheck = Validation.isStringPresent(employeeFirstNameString, "Employee first name");
    	}while(!errorCheck);
        return employeeFirstNameString;
    }
    
  //This method gets and then checks the employee email
    public static String getEmployeeEmailString(String prompt)
    {
    	String employeeEmailString = "";
    	boolean errorCheck = false;
    	do
    	{
    		System.out.print(prompt);
    		employeeEmailString = sc.nextLine(); 
    		errorCheck = Validation.isStringPresent(employeeEmailString, "Employee email");
    	}while(!errorCheck);  
        return employeeEmailString;
    }
    
    //This is the first method that validates salary.
  	//	It is based on if salary is an double or not
    public static float getSalary(String prompt) {
        float f = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextFloat()) {
                f = sc.nextFloat();
                isValid = true;
            } else {
                System.out.println("Error! Invalid Input. Must Be An Integer. Try again.");
            }
            sc.nextLine();  
        }
        return f;
    }
    
    //This is the second method that validates salary.
  	//	It is based off whether salary is between 5000 and 125000
    public static float getSalaryRangeChecker(String prompt) { 
        float f = 0;
        float minimum = 5000;
        float maximum = 125000;
        boolean isValid = false;
        while (!isValid) {
            f = getSalary(prompt);
            if (f <= minimum) {
                System.out.println(
                        "Error! Number must be greater than " + minimum + ".");
            } else if (f >= maximum) {
                System.out.println(
                        "Error! Number must be less than " + maximum + ".");
            } else {
                isValid = true;
            }
        }
        return f;
    }	
}
