//Programmer: Samuel Greenlee
//Program: Java06 Program Assignment
//Description: This program allows
//	the user to read and write to
//	a database
//Date Created On: 4/30/2020

package Business;

public class Business 
{
	//These are the instance variables
	private int employeeId;
	private String employeeLastName;
	private String employeeFirstName;
	private String employeeEmail;
	private float salary;
	
	//This is the constructor that sets each instance variable
	public Business()
	{		
		employeeId = 0;
		employeeLastName = "";
		employeeFirstName = "";
		employeeEmail = "";
		salary = 0.0f;
	}
	
	//This is the Constructor that accepts five arguments, and assigns those values into class variables
	public Business(int employeeId, String employeeLastName, String employeeFirstName, String employeeEmail,
			float salary)
	{
		this.employeeId = employeeId;
		this.employeeLastName = employeeLastName;
		this.employeeFirstName = employeeFirstName;
		this.employeeEmail = employeeEmail;
		this.salary = salary;
	}

	//These are the get and set methods
	public int getEmployeeId()
	{
		return employeeId;
	}

	public void setEmployeeId(int employeeID)
	{
		this.employeeId = employeeID;
	}

	public String getEmployeeLastName()
	{
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName)
	{
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeFirstName()
	{
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName)
	{
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeEmail()
	{
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail)
	{
		this.employeeEmail = employeeEmail;
	}

	public float getSalary()
	{
		return salary;
	}

	public void setSalary(float salary)
	{
		this.salary = salary;
	}
	
	
	
}
