package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchingDAtaFromDataBAse {

	public static void main(String[] args) throws Throwable {

		// Step1:- register/load mysql database

		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		// step2:-get the connect of database //database name
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainer_details", "root", "root");

		// step3:- create SQL Statement
		Statement state = conn.createStatement();
		// tablename
		String query = "select * from trainer";

		// step4:- execute statement
		// reading data from DB
		ResultSet result = state.executeQuery(query);

		while (result.next()) {
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t"
					+ result.getString(4));
		}

		// step5:- close the database
		conn.close();
	}

}
