
public class Helper {
	DbConnector dbConnector=new DbConnector();
	public void showDetails(){
		dbConnector.showAll();
		
	}
	public void editEmployee(int id, int salary) {
		dbConnector.editEmployee(id, salary);
	}
	public void deleteEmployee(int id) {
		
		dbConnector.deleteEmployee(id);
	}
	public void insertEmployee(int id, String firstName,
			String lastName, String title, int salary, String acc, String tel) {
		dbConnector.insertEmployee(id, firstName, lastName, title, salary, acc, tel);
	}
	public void showEmployee(int id) {
		dbConnector.showEmployee(id);
	}

}
