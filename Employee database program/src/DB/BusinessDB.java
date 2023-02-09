//Programmer: Samuel Greenlee
//Program: Java06 Program Assignment
//Description: This program allows
//	the user to read and write to
//	a database
//Date Created On: 4/30/2020

package DB;


//These are import statements
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import Business.Business;

public class BusinessDB implements DAO<Business>
{
	//This is the connection to the database
	private Connection getConnection() throws SQLException
	{
        String dbUrl = "jdbc:sqlite:EmployeeDatabase.db";
        java.sql.Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }
	
	//This is the over ridden code that gets all the items from the database
	@Override
    public List<Business> getAll()
	{
        String sql = "SELECT [Employee id], [Employee last name], [Employee first name], [Employee email], [Employee salary] " 
        		+ "FROM Employees ORDER BY [Employee id] ASC";
        List<Business> business = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int employeeId = rs.getInt("Employee id");
                String employeeLastName = rs.getString("Employee last name");
                String employeeFirstName = rs.getString("Employee first name");
                String employeeEmail = rs.getString("Employee email");
                float salary = rs.getFloat("Employee salary");
                Business b = new Business(employeeId, employeeLastName, employeeFirstName, employeeEmail, salary);
                business.add(b);
            }
            return business;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }
	
	//This is the over ridden code that gets stuff from the data base starting with the employeeId variable
	@Override
    public Business get(int employeeId) {
        String sql = "SELECT [Employee id], [Employee last name], [Employee first name], [Employee email], [Employee salary] " 
                   + "FROM Employees "
                   + "WHERE [Employee id] = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	String employeeLastName = rs.getString("Employee last name");
                String employeeFirstName = rs.getString("Employee first name");
                String employeeEmail = rs.getString("Employee email");
                float salary = rs.getFloat("Employee salary");
                Business b = new Business(employeeId, employeeLastName, employeeFirstName, employeeEmail, salary);
                rs.close();
                return b;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    } 
	
	//This is the over ridden code that adds items to the data base
	@Override
    public boolean add(Business b) {
        String sql = "INSERT INTO Employees ([Employee id], [Employee last name], [Employee first name], [Employee email], [Employee salary]) "
                   + "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, b.getEmployeeId());
            ps.setString(2, b.getEmployeeLastName());
            ps.setString(3, b.getEmployeeFirstName());
            ps.setString(4, b.getEmployeeEmail());
            ps.setFloat(5, b.getSalary());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
	
	//This is the over ridden code that deletes items from the database
	@Override
    public boolean delete(Business b) {
        String sql = "DELETE FROM Employees "
                   + "WHERE [Employee id] = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, b.getEmployeeId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
	
	//This is the over ridden code that updates the database
	@Override
    public boolean update(Business b) {
        String sql = "UPDATE Employees SET "
                   + "  [Employee last name] = ?, "
                   + "  [Employee first name] = ?, "
                   + "  [Employee email] = ?, "
                   + "  [Employee salary] = ? "
                   + "WHERE [Employee id] = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, b.getEmployeeLastName());
            ps.setString(2, b.getEmployeeFirstName());
            ps.setString(3, b.getEmployeeEmail());
            ps.setFloat(4, b.getSalary());
            ps.setInt(5, b.getEmployeeId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
}
