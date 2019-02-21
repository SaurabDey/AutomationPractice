package my.auto.com.AutomationPractice.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBClass {

	/*<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.11</version>
	</dependency>*/
	public String getDataFromDB() 
	{
		String email = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root",
					"selenium");

			System.out.println("Connection establish");

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from employees where employeeNumber='1143';");

			while (rs.next()) {
				email= rs.getString("email");
				String first = rs.getString("firstName");
				System.out.println(email + " " + first);
			}
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Connection not establish");
		}
		
		return email;
	}

}
