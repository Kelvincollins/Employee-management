import java.sql.Connection;
import java.util.Calendar;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class DbConnector{
	String dbUrl ="jdbc:mysql://localhost:3306/employee";
	String username ="root";
	String password ="";
	String myDriver="com.mysql.jdbc.Driver";
	Connection myConnection=null;
	Calendar calendar= Calendar.getInstance();
	
public void insertEmployee(int id, String firstName,
		String lastName, String title, int salary, String acc, String tel) {
	try {
		
		Class.forName(myDriver);
		System.out.print("\nConnecting to the database to insert new record");
		myConnection= DriverManager.getConnection(dbUrl,username,password);
		java.sql.Date startDate= new java.sql.Date(calendar.getTime().getTime());
          String query="insert into info(idno, date_created, firstname, lastname, title, salary, acno, tel) values(?,?,?,?,?,?,?,?)";
		
		PreparedStatement myStatement =myConnection.prepareStatement(query);
		myStatement.setInt(1, id);
		myStatement.setDate(2, startDate);
		myStatement.setString(3, firstName);
		myStatement.setString(4, lastName);
		myStatement.setString(5, title);
		myStatement.setInt(6, salary);
		myStatement.setString(7, acc);
		myStatement.setString(8, tel);
		
		
		
		myStatement.execute();
		
	} 
	catch(Exception e) {
		System.out.println(e);
		
	}
	
}

public void showAll() {
	try{
		Class.forName(myDriver);
		System.out.print("\nConnecting to the database to show all the  records");
	myConnection=DriverManager.getConnection(dbUrl,username, password);
		// create a statement object
		Statement myStatement =myConnection.createStatement();
		//execute query
		ResultSet myResultSet=myStatement.executeQuery("select * from info");
		while(myResultSet.next()){
			System.out.println("Employee's full names: "  +myResultSet.getString("firstname")+ " " +myResultSet.getString("lastname"));
			System.out.println("Id number: " +myResultSet.getInt("idno"));
			System.out.println("Start Date: " +myResultSet.getString("date_created"));
			System.out.println("Salary: " +myResultSet.getInt("salary"));
			System.out.println("Title: " +myResultSet.getString("title"));
			System.out.println("Account No: " +myResultSet.getString("acno"));
			System.out.println("Phone: " +myResultSet.getString("tel"));
		}
	}catch(Exception e){
		System.out.println(e);
	
	}

}
public void showEmployee(int id) {
	
	try{
		Class.forName(myDriver);
		System.out.print("\nConnecting to the database to show employee");
	myConnection=DriverManager.getConnection(dbUrl,username, password);
		// create a statement object
		Statement myStatement =myConnection.createStatement();
		//execute query
		String query ="select * from info where idno="+id;
		ResultSet myResultSet=myStatement.executeQuery(query);
		while(myResultSet.next()){
			System.out.println("Employee's full names: "  +myResultSet.getString("firstname")+ " " +myResultSet.getString("lastname"));
			System.out.println("Id number: " +myResultSet.getInt("idno"));
			System.out.println("Salary: " +myResultSet.getInt("salary"));
			System.out.println("Title: " +myResultSet.getString("title"));
			System.out.println("Account No: " +myResultSet.getString("acno"));
			System.out.println("Phone: " +myResultSet.getString("tel"));
		}
	}catch(Exception e){
		System.out.println(e);
	
	}

}

public void editEmployee(int id, int salary) {
	try {
		Class.forName(myDriver);
		System.out.print("\nConnecting to the database to edit employee  record");
		//connecting to the database
		myConnection= DriverManager.getConnection(dbUrl,username, password);
		
		String editQuerry="update  info set salary=? where idno=?";
		//using PreparedStatement to edit the information
		PreparedStatement preparedstatement= myConnection.prepareStatement(editQuerry);
		preparedstatement.setInt(1, salary);
		preparedstatement.setInt(2, id);
		preparedstatement.execute();
	}
	catch(Exception e) {
		System.out.print(e);
	}
		
	
	
}

public void deleteEmployee(int id) {
	try {
		Class.forName(myDriver);
		System.out.print("\nConnecting to the database to delete employee  record");
		// create mysql connection
		myConnection = DriverManager.getConnection(dbUrl,username, password);
		
		String deleteQuery= "delete from info where salary =?";
		PreparedStatement preparedstatement= myConnection.prepareStatement(deleteQuery);
		preparedstatement.setInt(1, id);
		
		// execute the preparedstatement
		preparedstatement.execute();
		
		
	}catch(Exception e) {
		
		
	}
	
	
}

}