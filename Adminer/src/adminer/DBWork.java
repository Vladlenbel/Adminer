package adminer;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;




public class DBWork {
	
	private final String user = /*"root"*/"root"/*"passagesys"*/;
    private final String url = "jdbc:mysql://localhost:3306/passage_system?useUnicode=true&characterEncoding=UTF-8";
    private final String password =/*"serverps"*/"valdistroer"/*"AstZhq4"*/;

    private Connection connection;
    private Statement statement;
    private SQLException ex = new SQLException();
    private ResultSet resultSet;
    
   
    
    public DBWork() {
         try {
        	// System.out.println("class foundStart");
        	 Class.forName("com.mysql.jdbc.Driver");
        	// System.out.println("class foundFin");
         } catch (Exception e) {
        	 	//System.out.println("class problem1");
        	 	//System.out.println(e);
        	 	//System.out.println("class problem2");
        	 	e.toString();
        	 	System.out.println(e.toString());
        	 	System.out.println("error connection");
         }
     }
  
    private void sendQuery(String query) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.executeBatch();
            
     
        } catch (SQLException e) {
        	//System.out.println("connection");
        	e.printStackTrace();
        	System.out.println(ex.getErrorCode());
        	//	ex = e;
        } finally {
            try {
            	//System.out.println(ex.toString()); 
                connection.close();
                statement.close();
            } catch (SQLException e) {
            	e.printStackTrace();
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
    
    public String viewWorker (String idCard, String tableNum, 
    		String surname, String name, String patronomic, String departament,
    		String position, String birthday, String typeCard) {
    	
    	if (idCard.equals("") == false) {
    		if (typeCard.equals("hex4")) {
    			 Long numb = Long.parseLong(idCard,16);
    			 idCard = numb.toString();
    		}
    		if (typeCard.equals("hex5")) {
    			typeCard = typeCard.substring(0, 8);
   			 	Long numb = Long.parseLong(idCard,16);
   			 	idCard = numb.toString();
    		}
    	}
    	
    	int where = 0;
    	String answ = new String();
    	String query = "SELECT distinct * FROM (workerfio INNER JOIN sound ON "
    			+ "workerfio.personellNumber = sound.personellNumber) "
    			+ "INNER JOIN department ON workerfio.department = department.id "; 
    	// surname ="
    	//		+ "\"" + surname+ "\"";
    	
    	if (idCard.equals("") == false && where > 0 ) {
    		query += "AND workerIdCard =" + "\"" + idCard.replaceAll("\n","") + "\"";
    	}
    	if (idCard.equals("") == false && where == 0 ) {
    		query += "WHERE workerIdCard =" + "\"" + idCard.replaceAll("\n","") + "\"";
    		where++;
    	}

    	if (tableNum.equals("") == false && where > 0) {
    		query += "AND workerfio.personellNumber =" + "\"" + tableNum.replaceAll("\n","") + "\"";
    	}
    	if (tableNum.equals("") == false && where == 0) {
    		query += "WHERE workerfio.personellNumber =" + "\"" + tableNum.replaceAll("\n","") + "\"";
    		where++;
    	}
    	
    	if (surname.equals("") == false && where > 0 ) {
    		query += "AND surname =" + "\"" + surname.replaceAll("\n","") + "\"";
    	}
    	if (surname.equals("") == false && where == 0 ) {
    		query += "WHERE surname =" + "\"" + surname.replaceAll("\n","") + "\"";
    		where++;
    	}

    	if (name.equals("") == false && where > 0) {
    		query += "AND name =" + "\"" + name.replaceAll("\n","") + "\"";
    	}
    	if (name.equals("") == false && where == 0) {
    		query += "WHERE name =" + "\"" + name.replaceAll("\n","") + "\"";
    		where++;
    	}

    	if (patronomic.equals("") == false && where > 0) {
    		query += "AND patronymic =" + "\"" + patronomic.replaceAll("\n","") + "\"";
    	}
    	if (patronomic.equals("") == false && where == 0) {
    		query += "WHERE patronymic =" + "\"" + patronomic.replaceAll("\n","") + "\"";
    		where++;
    	}

    	if (departament.equals("") == false && where > 0) {
    		query += "AND title =" + "\"" + departament.replaceAll("\n","") + "\"";
    	}
    	if (departament.equals("") == false && where == 0) {
    		query += "WHERE title =" + "\"" + departament.replaceAll("\n","") + "\"";
    		where++;
    	}
    	
    	if (position.equals("") == false && where > 0) {
    		query += "AND position =" + "\"" + position.replaceAll("\n","") + "\"";
    	}
    	if (departament.equals("") == false && where == 0) {
    		query += "WHERE position =" + "\"" + position.replaceAll("\n","") + "\"";
    		where++;
    	}

    	if (birthday.equals("") == false && where > 0) {
    		query += "AND birthday =" + "\"" + birthday + "\"";
    	}
    	if (birthday.equals("") == false && where == 0) {
    		query += "WHERE birthday =" + "\"" + birthday + "\"";
    		where++;
    	}

    	
    	System.out.println("view" + query);

    	
    	try{
	        connection = DriverManager.getConnection(url, user, password);
	        statement = connection.createStatement();
	        statement.executeBatch();
	        resultSet = statement.executeQuery(query);;
	      //  answ += "<html><head><meta charset= \"UTF-8\" ></head>";
	        answ += "<table border= \" 1\">"+  
	        		   "<tr>"+ 
	        		   "<th>ID ������</th>" +
	        		  "<th>���</th>"+ 
	        		  "<th>�����</th>"+
	        		  "<th>���������</th>"+
	        		  "<th>��������� �����</th>"+
	        		  "<th>ID �����</th>" + 
	        		  "<th>���� ��������</th>"+
	        		  "<th>������</th>"+
	        		  "<th>��� �������� �������</th>"+
	        		  "<th>���� ��� �����</th>"+
	        		  "</tr>";
	        while (resultSet.next()) {
	        	
	        	if(resultSet.getString("status").equals("������")) {
	        	   answ += "<tr>";
	        	   answ += "<td style=\"color:#ff0000\">"+ resultSet.getString("id") +" </td>";
	        	   answ += "<td style=\"color:#ff0000\">"+ resultSet.getString("surname")+" "+ resultSet.getString("name")+ " " +resultSet.getString("patronymic") +" </td>";
	        	   answ += "<td style=\"color:#ff0000\">"+ resultSet.getString("title") +" </td>";
	        	   answ += "<td style=\"color:#ff0000\">"+ resultSet.getString("position") +" </td>";
	        	   answ += "<td style=\"color:#ff0000\">"+ resultSet.getString("personellNumber") +" </td>";
	        	   answ += "<td style=\"color:#ff0000\">"+ resultSet.getString("workerIdCard") +" </td>";
	        	   answ += "<td style=\"color:#ff0000\">"+ resultSet.getString("birthday") +" </td>";
	        	   answ += "<td style=\"color:#ff0000\">"+ resultSet.getString("status") +" </td>";
	        	   answ += "<td style=\"color:#ff0000\" >"+ resultSet.getString("typeWorkingHour") +" </td>";        	  
	        	   answ += "<td style=\"color:#ff0000\">"+ resultSet.getString("filename") +" </td>";        	    
	        	  answ += "</tr>";
	        	}else {
		        	   answ += "<tr>";
		        	   answ += "<td>"+ resultSet.getString("id") +" </td>";
		        	   answ += "<td>"+ resultSet.getString("surname")+" "+ resultSet.getString("name")+ " " +resultSet.getString("patronymic") +" </td>";
		        	   answ += "<td>"+ resultSet.getString("title") +" </td>";
		        	   answ += "<td>"+ resultSet.getString("position") +" </td>";
		        	   answ += "<td>"+ resultSet.getString("personellNumber") +" </td>";
		        	   answ += "<td>"+ resultSet.getString("workerIdCard") +" </td>";
		        	   answ += "<td>"+ resultSet.getString("birthday") +" </td>";
		        	   answ += "<td>"+ resultSet.getString("status") +" </td>";
		        	   answ += "<td>"+ resultSet.getString("typeWorkingHour") +" </td>";        	  
		        	   answ += "<td>"+ resultSet.getString("filename") +" </td>";        	    
		        	  answ += "</tr>";
	        	}
	        	

	        
	        }

    	}catch (SQLException e) {

        } finally {
            closeDB();
        }
    	
    System.out.println(answ);
    return answ;
    }

    
    public void addWorkerToTable(String idCard, String tableNum, 
    		String surname, String name, String patronomic, String departament, String position,
    		String birthday, String sound, String status, String typeWorkingHour, String typeCard ) {
    	
    	if (idCard.equals("") == false) {
    		if (typeCard.equals("hex4")) {
    			 Long numb = Long.parseLong(idCard,16);
    			 idCard = numb.toString();
    		}
    		if (typeCard.equals("hex5")) {
    			typeCard = typeCard.substring(0, 8);
   			 	Long numb = Long.parseLong(idCard,16);
   			 	idCard = numb.toString();
    		}
    	}
    	
    	if(idCard.equals("") == false) {
    		String cardQer = "SELECT * FROM workerfio WHERE workerIdCard ="+ "\"" + idCard + "\"";
    		String idOfCard = null;
    		try{
		        connection = DriverManager.getConnection(url, user, password);
		        statement = connection.createStatement();
		        resultSet = statement.executeQuery(cardQer);;
		        while (resultSet.next()) {
		        	idOfCard = resultSet.getString("id");
		        }
	
	    	}catch (SQLException e) {
	
	        } finally {
	            closeDB();
	        }
    		
    		if (idOfCard != null) {
    			String queryWorkFIO = "UPDATE  workerfio SET workerIdCard = null WHERE id ="+ "\"" + idOfCard + "\"";
    				sendQuery(queryWorkFIO);
    		}
    	}
    	
    	if (typeWorkingHour.equals("") ) {
    	String giveDepart = " SELECT typeWorkTime FROM department WHERE title =" + "\"" + departament + "\"";
    	//System.out.println(giveDepart);
	    	try{
		        connection = DriverManager.getConnection(url, user, password);
		        statement = connection.createStatement();
		        resultSet = statement.executeQuery(giveDepart);;
		        while (resultSet.next()) {
		        	typeWorkingHour = resultSet.getString("typeWorkTime");
		        }
	
	    	}catch (SQLException e) {
	
	        } finally {
	            closeDB();
	        }
    	}
    	
    	String idDepar= new String();
		if (departament.equals("") == false) {
			String queryDepart = "SELECT * FROM department WHERE title=" + "\"" + departament.replaceAll("\n","") + "\"";
			
	    	try{
		        connection = DriverManager.getConnection(url, user, password);
		        statement = connection.createStatement();
		        resultSet = statement.executeQuery(queryDepart);;
		        while (resultSet.next()) {
		        	idDepar = resultSet.getString("id");
		        }
	
	    	}catch (SQLException e) {
	
	        } finally {
	            closeDB();
	        }
		}
    	if (birthday.equals("")) {
    		birthday = "null";
    	}
    	
    	
    	String queryWorkFIO = "INSERT INTO workerfio ( workerIdCard, personellNumber," + 
    			"surname, name, patronymic, birthday, status, typeWorkingHour, department, position)  VALUES("  + 
    			"\""+  idCard.replaceAll("\n","") + "\""  + "," +
				"\"" + tableNum.replaceAll("\n","") + "\"" +  "," + 
    			"\"" + surname.replaceAll("\n","") + "\"" +  "," +
				"\"" + name.replaceAll("\n","") + "\"" +  "," + 
    			"\"" + patronomic.replaceAll("\n","") + "\"" + "," +
				"\"" + birthday.replaceAll("\n","") + "\"" +  "," + 
    			"\"" + status.replaceAll("\n","") + "\"" + ","+
				"\"" + typeWorkingHour.replaceAll("\n","") + "\"" + ","+
				"\"" + idDepar.replaceAll("\n","") + "\"" + "," +
				"\"" + position.replaceAll("\n","") + "\""+");" ;
    		
    	//System.out.println(queryWorkFIO);
    		sendQuery(queryWorkFIO);
    		
    		int isThere = 0;
    		String giveSound = " SELECT filename FROM sound WHERE personellNumber =" + "\"" + tableNum.replaceAll("\n","") + "\"";
        	try{
    	        connection = DriverManager.getConnection(url, user, password);
    	        statement = connection.createStatement();
    	        resultSet = statement.executeQuery(giveSound);;
    	        while (resultSet.next()) {
    	        	isThere++;
    	        }

        	}catch (SQLException e) {

            } finally {
                closeDB();
            }
    		//System.out.println(isThere);
    		if (sound.equals("") == false && isThere == 0) {
        	String queryWorkSound = "INSERT INTO sound VALUES(" + 
    		"\"" +  tableNum.replaceAll("\n","") + "\""  + "," +
    		"\"" + sound.replaceAll("\n","") + "\"" +  ");" ;
    		
        		sendQuery(queryWorkSound);
    		}	
    		
    		if(sound.equals("")  && isThere == 0 ) {
    			//System.out.println("I'm here");
    			String soundName = " SELECT soundInSound FROM soundAndName WHERE nameSound =" + "\"" + name.replaceAll("\n","") + "\"";
    			String soundInTable = new String();
    			int haveSound = 0;
            	try{
        	        connection = DriverManager.getConnection(url, user, password);
        	        statement = connection.createStatement();
        	        resultSet = statement.executeQuery(soundName);;
        	        while (resultSet.next()) {
        	        	soundInTable = resultSet.getString("soundInSound");
        	        	haveSound++;
        	        }

            	}catch (SQLException e) {

                } finally {
                    closeDB();
                }
    			if (haveSound == 0) {
    			String queryWorkSound = "INSERT INTO sound VALUES(" + 
    		    		"\"" +  tableNum.replaceAll("\n","") + "\""  + "," +
    		    		"\"" +"nullsound" + "\"" +  ");" ;
    		    		
    		       sendQuery(queryWorkSound);
    			}else {
    				String queryWorkSound = "INSERT INTO sound VALUES(" + 
        		    		"\"" +  tableNum.replaceAll("\n","") + "\""  + "," +
        		    		"\"" +soundInTable + "\"" +  ");" ;
        		    		
        		       sendQuery(queryWorkSound);
    			}
    		}
    		
    		
    		
    		int isThereDep = 0;
    		String giveDepar = " SELECT id FROM departament WHERE title =" + "\"" + departament.replaceAll("\n","") + "\"";
        	try{
    	        connection = DriverManager.getConnection(url, user, password);
    	        statement = connection.createStatement();
    	        resultSet = statement.executeQuery(giveDepar);;
    	        while (resultSet.next()) {
    	        	isThereDep++;
    	        }

        	}catch (SQLException e) {

            } finally {
                closeDB();
            }
    		//System.out.println(isThere);
    		if (sound.equals("") == false && isThereDep == 0) {
        	String queryWorkDepar = "INSERT INTO departament (title,typeWorkTime) VALUES(" + 
    		"\"" +  departament.replaceAll("\n","") + "\""  + "," +
    		"\"" + typeWorkingHour.replaceAll("\n","") + "\"" +  ");" ;
    		
        		sendQuery(queryWorkDepar);
    		}	
    }
    
    public void addDepart() {
    	
    }
    
    
    public void updateWorkInfo(String idCard, String tableNum, 
    		String surname, String name, String patronomic, String departament, String position,
    		String birthday, String sound, String status, String typeWorkingHour, String idInTable, String typeCard ) {
    	System.out.println("typeCard" + typeCard);
       	if (idCard.equals("") == false) {
    		if (typeCard.equals("hex4")) {
    			 Long numb = Long.parseLong(idCard,16);
    			 idCard = numb.toString();
    		}
    		if (typeCard.equals("hex5")) {
    			idCard = idCard.substring(0, 8);
   			 	Long numb = Long.parseLong(idCard,16);
   			 	idCard = numb.toString();
    		}
    	}
       	
       	if(idCard.equals("") == false) {
    		String cardQer = "SELECT * FROM workerfio WHERE workerIdCard ="+ "\"" + idCard + "\"";
    		String idOfCard = null;
    		try{
		        connection = DriverManager.getConnection(url, user, password);
		        statement = connection.createStatement();
		        resultSet = statement.executeQuery(cardQer);;
		        while (resultSet.next()) {
		        	idOfCard = resultSet.getString("id");
		        }
	
	    	}catch (SQLException e) {
	
	        } finally {
	            closeDB();
	        }
    		System.out.println("����� ����� = " + idCard);
    		System.out.println("id  ���������� = " + idOfCard);
    		if (idOfCard != null) {
    			String queryWorkFIO = "UPDATE  workerfio SET workerIdCard = null WHERE id ="+ "\"" + idOfCard + "\"";
    				sendQuery(queryWorkFIO);
    		}
    	}
    	
		if (tableNum.equals("") == false) {
			String queryTableNum = "SELECT personellNumber FROM workerfio WHERE id=" + "\"" + idInTable + "\"";
			String lastTableNum = new String();
	    	try{
		        connection = DriverManager.getConnection(url, user, password);
		        statement = connection.createStatement();
		        resultSet = statement.executeQuery(queryTableNum);;
		        while (resultSet.next()) {
		        	lastTableNum = resultSet.getString("personellNumber");
		        }
	
	    	}catch (SQLException e) {
	
	        } finally {
	            closeDB();
	        }
	    	
	    	
		
		//System.out.println(tableNum);
		//System.out.println(lastTableNum);
    	String queryWorkSound = "UPDATE sound SET " + 
    			"personellNumber =" + "\"" + tableNum.replaceAll("\n","") + "\"" + 
    			"WHERE personellNumber= " + "\"" +  lastTableNum.replaceAll("\n","") + "\""  + ";" ;
    	//System.out.println(queryWorkSound);
    		sendQuery(queryWorkSound);
		}
		
		String idDepar= new String();
		if (departament.equals("") == false) {
			String queryDepart = "SELECT * FROM department WHERE title=" + "\"" + departament.replaceAll("\n","") + "\"";
			
	    	try{
		        connection = DriverManager.getConnection(url, user, password);
		        statement = connection.createStatement();
		        resultSet = statement.executeQuery(queryDepart);;
		        while (resultSet.next()) {
		        	idDepar = resultSet.getString("id");
		        }
	
	    	}catch (SQLException e) {
	
	        } finally {
	            closeDB();
	        }
	    	
	    	
		
		//System.out.println(tableNum);
		//System.out.println(lastTableNum);
    	/*String queryWorkSound = "UPDATE sound SET " + 
    			"personellNumber =" + "\"" + tableNum + "\"" + 
    			"WHERE personellNumber= " + "\"" +  lastTableNum + "\""  + ";" ;
    	//System.out.println(queryWorkSound);
    		sendQuery(queryWorkSound);*/
		}
		
		//System.out.println("idDepar ="+idDepar);
    	
    	int isFirst = 0;
    	String queryWorkFIO = "UPDATE  workerfio SET " ;
    			if (idCard.equals("") == false) {
    				queryWorkFIO += "workerIdCard =" + "\"" +  idCard.replaceAll("\n","") + "\""  ;
    				isFirst++;
    			}
    			
    			if (tableNum.equals("") == false && isFirst == 1 ) {
    				queryWorkFIO += "," + "personellNumber =" + "\"" + tableNum.replaceAll("\n","")+ "\"" ;
    			}
    			if (tableNum.equals("") == false && isFirst == 0 ) {
    				queryWorkFIO += "personellNumber =" + "\"" + tableNum.replaceAll("\n","") + "\"" ;
    				isFirst++;
    			}

    			if (surname.equals("") == false && isFirst == 1 ) {
    				queryWorkFIO += "," + "surname =" + "\"" + surname.replaceAll("\n","") + "\""  ;
    			}
    			if (surname.equals("") == false && isFirst == 0 ) {
    				queryWorkFIO +="surname =" + "\"" + surname.replaceAll("\n","") + "\""  ;
    				isFirst++;
    			}
    			
    			if (name.equals("") == false && isFirst == 1 ) {
    				queryWorkFIO += "," + "name =" + "\"" + name.replaceAll("\n","") + "\"" ;
    			}
    			if (name.equals("") == false && isFirst == 0 ) {
    				queryWorkFIO += "name =" + "\"" + name.replaceAll("\n","") + "\""  ;
    				isFirst++;
    			}
    			
    			
    			if (patronomic.equals("") == false && isFirst == 1 ) {
    				queryWorkFIO += "," + "patronymic =" + "\"" + patronomic.replaceAll("\n","") + "\"";
    			}
    			if (patronomic.equals("") == false && isFirst == 0 ) {
    				queryWorkFIO += "patronymic =" + "\"" + patronomic.replaceAll("\n","") + "\"";
    				isFirst++;
    			}

    			if (birthday.equals("") == false && isFirst == 1 ) {
    				queryWorkFIO += "," + "birthday =" + "\"" + birthday.replaceAll("\n","") + "\"";
    			}
    			if (birthday.equals("") == false && isFirst == 0 ) {
    				queryWorkFIO +="birthday =" + "\"" + birthday.replaceAll("\n","") + "\"";
    				isFirst++;
    			}

    			if (status.equals("") == false  && isFirst == 1 ) {
    				queryWorkFIO += "," + "status =" + "\"" + status.replaceAll("\n","") + "\"";
    			}
    			
    			if (status.equals("") == false  && isFirst == 0 ) {
    				queryWorkFIO += "status =" + "\"" + status.replaceAll("\n","") + "\"";
    				isFirst++;
    			}

    			if (typeWorkingHour.equals("") == false && isFirst == 1 ) {
    				queryWorkFIO += "," + "typeWorkingHour =" + "\"" + typeWorkingHour.replaceAll("\n","") + "\"";
    			}
    			if (typeWorkingHour.equals("") == false && isFirst == 0 ) {
    				queryWorkFIO +="typeWorkingHour =" + "\"" + typeWorkingHour.replaceAll("\n","") + "\"";
    				isFirst++;
    			}
    			
    			if (departament.equals("") == false && isFirst == 1 ) {
    				queryWorkFIO += "," + "department =" + "\"" + idDepar.replaceAll("\n","") + "\"";
    			}
    			if (departament.equals("") == false && isFirst == 0 ) {
    				queryWorkFIO +="department =" + "\"" + idDepar.replaceAll("\n","") + "\"";
    				isFirst++;
    			}

    			if (position.equals("") == false && isFirst == 1 ) {
    				queryWorkFIO += "," + "position =" + "\"" + position.replaceAll("\n","") + "\"";
    			}
    			if (position.equals("") == false && isFirst == 0 ) {
    				queryWorkFIO +="position =" + "\"" + position.replaceAll("\n","") + "\"";
    				isFirst++;
    			}

    			
    			queryWorkFIO += "WHERE id =" + "\"" + idInTable.replaceAll("\n","") + "\"" + ";" ;
	
    	System.out.println(queryWorkFIO);
    		sendQuery(queryWorkFIO);
    		

    		
    		if(sound.equals("") == false) {
	    		if(tableNum.equals("")) {
	    			String queryTableNum = "SELECT personellNumber FROM workerfio WHERE id=" + "\"" + idInTable + "\"";
	    	    	try{
	    		        connection = DriverManager.getConnection(url, user, password);
	    		        statement = connection.createStatement();
	    		        resultSet = statement.executeQuery(queryTableNum);;
	    		        while (resultSet.next()) {
	    		        	tableNum = resultSet.getString("personellNumber");
	    		        }
	    	
	    	    	}catch (SQLException e) {
	    	
	    	        } finally {
	    	            closeDB();
	    	        }
	    		}
	    		//System.out.println(tableNum);
	        	String queryWorkSound = "UPDATE sound SET " + 
	        			"filename =" + "\"" + sound.replaceAll("\n","") + "\"" + 
	        			"WHERE personellNumber= " + "\"" +  tableNum.replaceAll("\n","") + "\""  + ";" ;
	        	//System.out.println(queryWorkSound);
	        		sendQuery(queryWorkSound);
    		}
    	
    }
    
    public void addNewDepartment (String title, String typeWorkTime ) {
    	String queryNewDep = "INSERT INTO department (title,typeWorkTime) VALUES(" + 
    "\"" +  title.replaceAll("\n","") + "\""  + "," +
	"\"" + typeWorkTime.replaceAll("\n","") + "\"" +  ");" ;
	
    		sendQuery(queryNewDep);
    	//	showTableDepar();
    }
    
    public void editDeparInfo (String title, String typeWorkTime, String idInTable) {
    	
    	int isFirst = 0;
    	String queryWorkDepar = "UPDATE  department SET ";
    		if ( title.equals("") == false) {
    			queryWorkDepar += "title =" + "\"" +  title.replaceAll("\n","") + "\"";
    			isFirst++;
    		}
    		if (typeWorkTime.equals("") == false && isFirst == 0 ) {
    			queryWorkDepar += "typeWorkTime =" + "\"" + typeWorkTime.replaceAll("\n","") + "\"";
    		}
    		if (typeWorkTime.equals("") == false && isFirst == 1 ) {
    			queryWorkDepar += "," + "typeWorkTime =" + "\"" + typeWorkTime.replaceAll("\n","") + "\"";
    		}
    			  
    		queryWorkDepar += "WHERE id =" + "\"" + idInTable.replaceAll("\n","") + "\"" + ";" ;
	
    	//System.out.println(queryWorkDepar);
    		sendQuery(queryWorkDepar);
    }
    
    public String showTableDepar() {
    
    	String answ = new String();
    	String query = "SELECT * FROM department";
    	
    	try{
	        connection = DriverManager.getConnection(url, user, password);
	        statement = connection.createStatement();
	        resultSet = statement.executeQuery(query);;
	      //  answ += "<html><head><meta charset= \"UTF-8\" ></head>";
	        answ += "<table border= \" 1\">"+  
	        		   "<tr>"+ 
	        		   "<th>ID ������</th>" +
	        		   "<th>�������� ������</th>" + 
	        		  "<th>��� �������� �������</th>"+ 
	        		  "</tr>";
	        while (resultSet.next()) {
	        	
	        	
	        	   answ += "<tr>";
	        	   answ += "<td>"+ resultSet.getString("id") +" </td>";
	        	   answ += "<td>"+ resultSet.getString("title") +" </td>";
	        	   answ += "<td>"+ resultSet.getString("typeWorkTime") +" </td>";
        	    
	        	  answ += "</tr>";
	        	

	        
	        }

    	}catch (SQLException e) {

        } finally {
            closeDB();
        }
    	
    
    return answ + showTableWorkHour();
    }

    public void addWorkHourBut (String startWorkHour, String finishWorkHour, 
    		String dinnerStart, String dinnerFinish) {
    	
    	String queryWorkingHour = "INSERT INTO workingHours (startWorkTime, finishWork," + 
    			"dinnerStart, dinnerFinish) VALUES("  + 
    			"\""+  startWorkHour.replaceAll("\n","") + "\""  + "," +
				"\"" + finishWorkHour.replaceAll("\n","") + "\"" +  "," + 
    			"\"" + dinnerStart.replaceAll("\n","") + "\"" +  "," +
				"\"" + dinnerFinish.replaceAll("\n","") + "\""  +");"; 
    	//System.out.println(queryWorkingHour);
    	sendQuery(queryWorkingHour);
    	
    }

    public void editWorkHourInfo(String startWorkHour, String finishWorkHour, 
    		String dinnerStart, String dinnerFinish, String idWorkHourInTable) {
    	
    	int isFirst = 0;
    	String queryWorkingHour = "UPDATE workingHours SET ";
    			if (startWorkHour.equals("") == false) {
    				queryWorkingHour +="startWorkTime =" + "\"" +  startWorkHour.replaceAll("\n","") + "\"";
    				isFirst++;
    			}
    			if ( finishWorkHour.equals("") == false && isFirst == 0 ) {
    				queryWorkingHour += "finishWork =" + "\"" + finishWorkHour.replaceAll("\n","") + "\"";
    				isFirst++;
    			}
    			if ( finishWorkHour.equals("") == false && isFirst == 1 ) {
    				queryWorkingHour += "," + "finishWork =" + "\"" + finishWorkHour.replaceAll("\n","") + "\"";
    			}
    			
    			if (dinnerStart.equals("") == false && isFirst == 0 ) {
    				queryWorkingHour +="dinnerStart =" + "\"" + dinnerStart.replaceAll("\n","") + "\"";
    				isFirst++;
    			}
    			if (dinnerStart.equals("") == false && isFirst == 1 ) {
    				queryWorkingHour += "," + "dinnerStart =" + "\"" + dinnerStart.replaceAll("\n","") + "\"";
    			}
    			
    			if (dinnerFinish.equals("") ==false && isFirst == 0 ) {
    				queryWorkingHour += "dinnerFinish =" + "\"" + dinnerFinish.replaceAll("\n","") + "\"";
    				isFirst++;
    			}
    			if (dinnerFinish.equals("") ==false && isFirst == 1 ) {
    				queryWorkingHour += "," + "dinnerFinish =" + "\"" + dinnerFinish.replaceAll("\n","") + "\"";
    			}
    			queryWorkingHour += "WHERE id =" + "\"" + idWorkHourInTable.replaceAll("\n","") + "\"" + ";" ;
	
    	//System.out.println(queryWorkingHour);
    		sendQuery(queryWorkingHour);
    		//showTableWorkHour();
    }
   
    public String showTableWorkHour() {
    
    	String answ = new String();
    	String query = "SELECT * FROM workingHours";
    	
    	try{
	        connection = DriverManager.getConnection(url, user, password);
	        statement = connection.createStatement();
	        resultSet = statement.executeQuery(query);;
	      //  answ += "<html><head><meta charset= \"UTF-8\" ></head>";
	        answ += "<table border= \" 1\">"+  
	        		   "<tr>"+ 
	        		   "<th>ID ������(��� �������� �������)</th>" +
	        		   "<th>������ �������� �������</th>" + 
	        		   "<th>����� �������� �������</th>"+ 
	        		   "<th>������ �����</th>" + 
	        		  "<th>����� �����</th>"+
	        		  "</tr>";
	        while (resultSet.next()) {
	        	
	        	
	        	   answ += "<tr>";
	        	   answ += "<td>"+ resultSet.getString("id") +" </td>";
	        	   answ += "<td>"+ resultSet.getString("startWorkTime") +" </td>";
	        	   answ += "<td>"+ resultSet.getString("finishWork") +" </td>";
	        	   answ += "<td>"+ resultSet.getString("dinnerStart") +" </td>";
	        	   answ += "<td>"+ resultSet.getString("dinnerFinish") +" </td>";
        	    
	        	  answ += "</tr>";
	        	

	        
	        }
	        
    	}catch (SQLException e) {

        } finally {
            closeDB();
        }
    	
    
    return answ;
    }
    
    public String getSurnameWork(String request) {
        
    	String answ = new String();
    	String query = "SELECT distinct(" + request + ") FROM workerfio;";
    	
    	try{
	        connection = DriverManager.getConnection(url, user, password);
	        statement = connection.createStatement();
	        resultSet = statement.executeQuery(query);;
	        int kol = 0;
	        while (resultSet.next()) {
	        	
	        	
	        	if (kol != 0) {
	        		answ += ",";
	        	}
	        	  // answ+= '"';
	        	   answ += resultSet.getString(request);
	        	  // answ+= '"';
	        	   kol++;
        	    
	        	  
	        	

	        
	        }
	       // System.out.println(kol);   
    	}catch (SQLException e) {

        } finally {
            closeDB();
        }
    	

    return answ;
    }
    
    public String getDepar(String request) {
    	System.out.println("I'm hereDep");
    	String answ = new String();
    	String query = "SELECT * FROM department;";
    	
    	try{
	        connection = DriverManager.getConnection(url, user, password);
	        statement = connection.createStatement();
	        resultSet = statement.executeQuery(query);;
	        int kol = 0;
	        while (resultSet.next()) {        	
	        	
	        	if (kol != 0) {
	        		answ += ",";
	        	}
	        	   answ += resultSet.getString(request);
	        	   kol++;     	
	        }
	        
    	}catch (SQLException e) {

        } finally {
            closeDB();
        }
    	
   // System.out.println(answ);
    return answ;
    }
    
    public String getTypeOfWorkHour() {
    	System.out.println("I'm here");
    	String answ = new String();
    	String query = "SELECT * FROM workingHours;";
    	
    	try{
	        connection = DriverManager.getConnection(url, user, password);
	        statement = connection.createStatement();
	        resultSet = statement.executeQuery(query);;
	        int kol = 0;
	        while (resultSet.next()) {        	
	        	
	        	if (kol != 0) {
	        		answ += ",";
	        	}
	        	   answ += resultSet.getString("id");
	        	   kol++;     	
	        }
	        
    	}catch (SQLException e) {

        } finally {
            closeDB();
        }
    	
   // System.out.println(answ);
    return answ;
    	
    }
    
    public String getFIO() {
 	   
 	   	String fio = new String();
 	   	int index = 0;
 	   	String query = "SELECT *  FROM workerfio WHERE surname != \"Unknown\";";
 	   	try{
 		        connection = DriverManager.getConnection(url, user, password);
 		        statement = connection.createStatement();
 		        resultSet = statement.executeQuery(query);
 		        int kol = 0;
 		        while (resultSet.next()) {
 		        	if (kol != 0) {
 		        		fio += ",";
 		        	}
 		        	fio+= resultSet.getString("surname");
 		        	fio+= " ";
 		        	fio+= resultSet.getString("name");
 		        	fio+= " ";
 		        	fio+= resultSet.getString("patronymic");
 		        	   kol++;
 		        }
 		        	
 	   	}catch (SQLException e) {

 	       } finally {
 	           closeDB();
 	       } 

 	   	return fio;
 	   }
    
    
    public void addVacation (String fio, String dateStart, 
    		String dateFinish, String typeOfAbsence) {
    	
    	String[] surname = fio.split("\\s+");
    	
    	
    	String queryToKnowPersNum = "SELECT personellNumber FROM workerfio WHERE surname = "; 
    			queryToKnowPersNum +=  "\"" + surname[0].replaceAll("\n","") + "\"";
    			queryToKnowPersNum += "AND name =" + "\"" + surname[1].replaceAll("\n","") + "\"";
    			queryToKnowPersNum += "AND patronymic =" + "\"" + surname[2].replaceAll("\n","") + "\""+ ";";
    	//System.out.println(queryWorkingHour);
    	//sendQuery(queryToKnowPersNum);
    			String personellNumberEmpl = new String();
    			try{
     		        connection = DriverManager.getConnection(url, user, password);
     		        statement = connection.createStatement();
     		        resultSet = statement.executeQuery(queryToKnowPersNum);
     		        int kol = 0;
     		        while (resultSet.next()) {
     		        	personellNumberEmpl =  resultSet.getString("personellNumber");
      		        }
     		        	
     	   	}catch (SQLException e) {

     	       } finally {
     	           closeDB();
     	       } 
    			
    			changeStatusWorker(dateStart, dateFinish, typeOfAbsence, personellNumberEmpl);
    		
    			String queryInsertAbsence = "INSERT INTO vacation (personellNumber, startVacation," + 
    	    			"finishVacation, typeOfAbsence) VALUES("  + 
    	    			"\""+  personellNumberEmpl.replaceAll("\n","") + "\""  + "," +
    					"\"" + dateStart.replaceAll("\n","") + "\"" +  "," + 
    	    			"\"" + dateFinish.replaceAll("\n","") + "\"" +  "," +
    					"\"" + typeOfAbsence.replaceAll("\n","") + "\""  +");"; 
    	    	//System.out.println(queryWorkingHour);
    	    	sendQuery(queryInsertAbsence);

    }
    
    public String showTableVacation(String dateStart, String dateFin) {
    	
        
    	String answ = new String();
    	String query = "SELECT * FROM vacation inner join workerfio"
    			+ " ON vacation.personellNumber = workerfio.personellNumber "
    			+ "WHERE startVacation >=";
    		
    		if (dateStart.equals("") == false) {
    			
    			query +=  "\"" + dateStart.replaceAll("\n","") + "\"";
    			if(dateFin.equals("") == false) {
    				query += "AND startVacation <=" + "\"" + dateFin.replaceAll("\n","") + "\"";
    				 query += "or (finishVacation >= " +  "\"" + dateStart.replaceAll("\n","") + "\""
      		    		   + "AND finishVacation <=" +"\"" + dateFin.replaceAll("\n","") + "\"" + ")";
      		       query += "or (startVacation <="  +  "\"" + dateStart.replaceAll("\n","") +  "\""
      		    		   +"AND finishVacation >=" +"\"" + dateFin.replaceAll("\n","") + "\""+ ")";
      		    		   
    			}
    		}else {
    			   SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM"); //HH:mm:ss");
    		       String curDate = dateFormat.format(new Date());
    		       String curDateStart = curDate+ "-01";
    		       String curDateFin = curDate+"-31";
    		       query +=  "\"" + curDateStart.replaceAll("\n","") + "\"";
    		       query += "AND  startVacation <=" + "\"" + curDateFin.replaceAll("\n","") + "\"";
    		       query += "or (finishVacation >= " +  "\"" + curDateStart.replaceAll("\n","") + "\""
    		    		   + "AND finishVacation <=" +"\"" + curDateFin.replaceAll("\n","") + "\"" + ")";
    		       query += "or (startVacation <="  +  "\"" + curDateStart.replaceAll("\n","") +  "\""
    		    		   +"AND finishVacation >=" +"\"" + curDateFin.replaceAll("\n","") + "\""+ ")";
    		    		   
    		       
    		}
    //	System.out.println(query);
    	try{
	        connection = DriverManager.getConnection(url, user, password);
	        statement = connection.createStatement();
	        resultSet = statement.executeQuery(query);;
	      //  answ += "<html><head><meta charset= \"UTF-8\" ></head>";
	        answ += "<table border= \" 1\">"+  
	        		   "<tr>"+ 
	        		   "<th>ID ������</th>" +
	        		   "<th>��� ����������</th>" + 
	        		   "<th>������ �������</th>"+ 
	        		   "<th>����� �������</th>" + 
	        		  "<th>������� ����������</th>"+
	        		  "</tr>";
	        while (resultSet.next()) {
	        	
	        	
	        	   answ += "<tr>";
	        	   answ += "<td>"+ resultSet.getString("id") +" </td>";
	        	   answ += "<td>"+ resultSet.getString("surname")+" "+ resultSet.getString("name")+ " " +resultSet.getString("patronymic") +" </td>";
	        	   answ += "<td>"+ resultSet.getString("startVacation") +" </td>";
	        	   answ += "<td>"+ resultSet.getString("finishVacation") +" </td>";
	        	   answ += "<td>"+ resultSet.getString("typeOfAbsence") +" </td>";
        	    
	        	  answ += "</tr>";
	        	

	        
	        }
	        
    	}catch (SQLException e) {

        } finally {
            closeDB();
        }
    	
    
    return answ;
    }
    
    public void editTableVacation(String dateStart, String dateFin, String fio, String typeOfAbsence, String id) {
    	String personellNumberEmpl  = new String();;
    	if (fio.equals("") == false) {
    		String[] surname = fio.split("\\s+");
        	
        	
        	String queryToKnowPersNum = "SELECT personellNumber FROM workerfio WHERE surname = "; 
        			queryToKnowPersNum +=  "\"" + surname[0].replaceAll("\n","") + "\"";
        			queryToKnowPersNum += "AND name =" + "\"" + surname[1].replaceAll("\n","") + "\"";
        			queryToKnowPersNum += "AND patronymic =" + "\"" + surname[2].replaceAll("\n","") + "\""+ ";";
        	//System.out.println(queryWorkingHour);
        	//sendQuery(queryToKnowPersNum);
        			
        			try{
         		        connection = DriverManager.getConnection(url, user, password);
         		        statement = connection.createStatement();
         		        resultSet = statement.executeQuery(queryToKnowPersNum);
         		        int kol = 0;
         		        while (resultSet.next()) {
         		        	personellNumberEmpl =  resultSet.getString("personellNumber");
          		        }
         		        	
         	   	}catch (SQLException e) {

         	       } finally {
         	           closeDB();
         	       } 
    	}
    	int isFirst = 0;
    	String queryVacation = "UPDATE vacation SET ";
    			if (dateStart.equals("") == false) {
    				queryVacation +="startVacation =" + "\"" +  dateStart.replaceAll("\n","") + "\"";
    				isFirst++;
    			}
    			
    			if ( dateFin.equals("") == false && isFirst == 1 ) {
    				queryVacation += "," + "finishVacation =" + "\"" + dateFin.replaceAll("\n","") + "\"";
    			}
    			if ( dateFin.equals("") == false && isFirst == 0 ) {
    				queryVacation += "finishVacation =" + "\"" + dateFin.replaceAll("\n","") + "\"";
    				isFirst++;
    			}
    			
    			if ( typeOfAbsence.equals("") == false && isFirst == 1 ) {
    				queryVacation += "," + "typeOfAbsence =" + "\"" + typeOfAbsence.replaceAll("\n","") + "\"";
    			}
    			if (typeOfAbsence.equals("") == false && isFirst == 0 ) {
    				queryVacation +="typeOfAbsence =" + "\"" + typeOfAbsence.replaceAll("\n","") + "\"";
    				isFirst++;
    			}
    			
    			if (personellNumberEmpl.equals("") == false && isFirst == 1 ) {
    				queryVacation += "," + "personellNumber =" + "\"" + personellNumberEmpl.replaceAll("\n","") + "\"";
    			}
    			if (personellNumberEmpl.equals("") == false && isFirst == 0 ) {
    				queryVacation +="personellNumber =" + "\"" + personellNumberEmpl.replaceAll("\n","") + "\"";
    				isFirst++;
    			}
    			   			
    			queryVacation += "WHERE id =" + "\"" + id.replaceAll("\n","") + "\"" + ";" ;
	
    	System.out.println(queryVacation);
    		sendQuery(queryVacation);
    }
    
    private void changeStatusWorker(String dateStart, 
    		String dateFinish, String typeOfAbsence, String personellNum) {
    	
    	String statusEmpt = new String();
    	
			if (typeOfAbsence.equals("����������")) {
				statusEmpt = "302";
			}
			if (typeOfAbsence.equals("������")) {
				statusEmpt = "301";
			}
			
			String queryToShangeStatus = "SELECT * from worker where eventTime >="; 
			queryToShangeStatus +=  "\"" + dateStart.replaceAll("\n","") + "\"";
			queryToShangeStatus += "AND eventTime <= " + "\"" + dateFinish.replaceAll("\n","")+" 23:59:59" + "\"";
			queryToShangeStatus += "AND workerId =" + "\"" + personellNum.replaceAll("\n","") + "\"";
			queryToShangeStatus += "AND statuscom <= " + "\"" + 300 + "\""+ ";";

			try{
 		        connection = DriverManager.getConnection(url, user, password);
 		        statement = connection.createStatement();
 		        resultSet = statement.executeQuery(queryToShangeStatus);
 		     
 		        while (resultSet.next()) {
 		        	String  sqlSafeOff = "SET SQL_SAFE_UPDATES = 0;";
      				sendQuery(sqlSafeOff);
      				
      				String queryOutEarly = "update worker set statuscom =+"+ 
      						"\"" + statusEmpt  + "\""  + "where workerId = " + 
      						"\"" + personellNum  + "\""  + "and eventTime = " +
	     	    				"\"" + resultSet.getString("eventTime") + "\"" +  ";" ;
	        			//System.out.println(queryOut);
	        			sendQuery(queryOutEarly);
	        			
	        			String  sqlSafeOn = "SET SQL_SAFE_UPDATES = 1;";
      					sendQuery(sqlSafeOn);	
  		        }
 		        	
 	   	}catch (SQLException e) {

 	       } finally {
 	           closeDB();
 	       } 
			
    }
}

