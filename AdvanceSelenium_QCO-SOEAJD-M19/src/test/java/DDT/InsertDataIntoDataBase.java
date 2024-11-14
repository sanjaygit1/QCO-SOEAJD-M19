package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataIntoDataBase {

	public static void main(String[] args) throws Throwable {

		// Step1:- register/load mysql database

		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		// step2:-get the connect of database //database name
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainer_details", "root", "root");

		// step3:- create SQL Statement
		Statement state = conn.createStatement();
		String query = "insert into trainer(first_name,last_name,address)values('Ram','sam','goa')";

		int result = state.executeUpdate(query);

		if (result == 1) {
			System.out.println("data is created");
		} else {
			System.out.println("data not created");
		}
		conn.close();
	}

}
