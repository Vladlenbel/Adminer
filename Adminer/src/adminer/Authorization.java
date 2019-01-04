package adminer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Authorization {
    private final String user = "root";
    private final String url = "jdbc:mysql://localhost:3306/tomcat_realm";
    private final String password = "valdistroer";

    private Connection connection;
    private Statement statement;
    private SQLException ex = new SQLException();
    private ResultSet resultSet;
    
    public Authorization() {
         try {
             Class.forName("com.mysql.jdbc.Driver");
         } catch (ClassNotFoundException e) {

         }
     }
    
    private void sendQuery(String query) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
        		ex = e;
        } finally {
            try {
            	System.out.println(ex.toString()); 
                connection.close();
                statement.close();
            } catch (SQLException e) {

            }
        }
    }
    
    private void closeDB() {
        try {
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {

        }
    }
    
    public void addUserToDB(String userName, String password, String role) {
    	
    	int count = 0;
    	
    	String addUser = "INSERT INTO tomcat_roles (user_name, password)  VALUES("  + 
    			"\""+  userName + "\""  + "," +
				"\"" + password + "\""+");" ;
    	sendQuery(addUser);

    	/*String giveRoleName = " SELECT * FROM tomcat_roles WHERE role_name =" + "\"" + role + "\"";
    	//System.out.println(giveDepart);
	    	try{
		        connection = DriverManager.getConnection(url, user, password);
		        statement = connection.createStatement();
		        resultSet = statement.executeQuery(giveRoleName);;
		        while (resultSet.next()) {
		        	count++;
		        	//typeWorkingHour = resultSet.getString("typeWorkTime");
		        }
	
	    	}catch (SQLException e) {
	
	        } finally {
	            closeDB();
	        }*/
	    if (count == 0) {
	    	 String addRole = "INSERT INTO tomcat_roles ( role_name)  VALUES("  + 
	 				"\"" + role + "\""+");" ;
	    }
	    String addRole = "INSERT INTO tomcat_users_roles (user_name, role_name)  VALUES("  + 
    			"\""+  userName + "\""  + "," +
				"\"" + role + "\""+");" ;
    	sendQuery(addRole);
	    	
    }
    	
    

}
