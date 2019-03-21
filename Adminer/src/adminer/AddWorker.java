package adminer;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AddWorker
 */
@WebServlet("/AddWorker")
public class AddWorker extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DBWork database = new DBWork();
    private Authorization authorization = new Authorization();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWorker() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    }
    
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		
		//информация о работнике
	    String userSurname = (String) request.getParameter("userSurname");
	    String userName = (String) request.getParameter("userName");
	    String userPatronomic = (String) request.getParameter("userPatronomic");
	    String workId = (String) request.getParameter("workId");
	    String tableNumber = (String) request.getParameter("tableNumber");
	    String departament = (String) request.getParameter("departament");
	    String position = (String) request.getParameter("position");
	    String birthday = (String) request.getParameter("birthday");
	    String sound = (String) request.getParameter("sound");
	    String status = (String) request.getParameter("status");
	    String typeCard = (String) request.getParameter("typeCard");
	    String typeWorkingHour = (String) request.getParameter("typeWorkingHour");
	    String idInTable = (String) request.getParameter("idInTable");
	    
	    //информация об отпусках/болезнях
	    String fioEmpl = (String) request.getParameter("fioEmpl");
	    String dateAbsenceStart = (String) request.getParameter("dateAbsenceStart");
	    String dateAbsenceFin = (String) request.getParameter("dateAbsenceFin");
	    String typeOfAbsence = (String) request.getParameter("typeOfAbsence");
	    String idOfAbsence = (String) request.getParameter("idOfAbsence");
	    
	    //информация об отделе
	    String nameDepart = (String) request.getParameter("nameDepart");
	    String typeWorkTimeDepart = (String) request.getParameter("typeWorkTimeDepart");
	    String idDepInTable = (String) request.getParameter("idDepInTable");
	    
	    //информация о типах рабочего времени
	    String startWorkHour = (String) request.getParameter("startWorkHour");
	    String finishWorkHour = (String) request.getParameter("finishWorkHour");
	    String dinnerStart = (String) request.getParameter("dinnerStart");
	    String dinnerFinish = (String) request.getParameter("dinnerFinish");
	    String idWorkHourInTable = (String) request.getParameter("idWorkHourInTable");
	    
	    //информация о пользователях
	    String nameAuthor = (String) request.getParameter("nameAuthor");
	    String paswordAuthor = (String) request.getParameter("paswordAuthor");
	    String roleUserAuthor = (String) request.getParameter("roleUserAuthor");
	    
	    String info = (String) request.getParameter("info");
	    
	    /*System.out.println(workId);
	    System.out.println(tableNumber);
	    System.out.println(userSurname);
	    System.out.println(userName);
	    System.out.println(userPatronomic);
	    System.out.println(departament);*/
	    System.out.println(typeCard);
	    //System.out.println(nameAuthor);
	    //System.out.println(paswordAuthor);
	    //System.out.println(roleUserAuthor);
	    
	  //  System.out.println(position);
	    System.out.println(info);
	  //информация о работниках
	    if (info.equals("showTable")) {
	    	
		    response.setContentType("text/html; charset=UTF-8");
		    response.getWriter().println( database.viewWorker(workId, tableNumber, 
		    		userSurname, userName, userPatronomic, departament, position, birthday, typeCard) );
	    	
	    }if (info.equals("addWorker")) {
		database.addWorkerToTable(workId, tableNumber, userSurname, userName, userPatronomic,
				departament, position, birthday, sound, status, typeWorkingHour, typeCard);
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().println( database.viewWorker(workId, tableNumber, 
			    		userSurname, userName, userPatronomic, departament, position, birthday, typeCard) );
		}
    	if (info.equals("editWorker")) {
    		database.updateWorkInfo(workId, tableNumber, userSurname, userName, userPatronomic, 
    				departament, position, birthday, sound, status, typeWorkingHour, idInTable, typeCard);
    		response.setContentType("text/html; charset=UTF-8");
			response.getWriter().println( database.viewWorker(workId, tableNumber, 
			    		userSurname, userName, userPatronomic, departament, position, birthday, typeCard) );
    	}
    	
    	// информация об отпусках/больничных
    	if (info.equals("addAbsence")) {
    		database.addVacation(fioEmpl, dateAbsenceStart, dateAbsenceFin, typeOfAbsence);
    		response.setContentType("text/html; charset=UTF-8");
		    response.getWriter().println(database.showTableVacation(dateAbsenceStart, dateAbsenceFin));
    	}
    	if (info.equals("showAbsence")) {
    		response.setContentType("text/html; charset=UTF-8");
		    response.getWriter().println(database.showTableVacation(dateAbsenceStart, dateAbsenceFin));
    	}
    	if (info.equals("editAbsence")) {
    		database.editTableVacation(dateAbsenceStart, dateAbsenceFin, fioEmpl, typeOfAbsence, idOfAbsence);
    		response.setContentType("text/html; charset=UTF-8");
		    response.getWriter().println(database.showTableVacation(dateAbsenceStart, dateAbsenceFin));
    	}
    	
    	//информация об отделах
	    	if (info.equals("addDepBut")) {
	    		database.addNewDepartment(nameDepart, typeWorkTimeDepart);
	    		response.setContentType("text/html; charset=UTF-8");
			    response.getWriter().println(database.showTableDepar());
	    	}
	    	if (info.equals("editDeparInfo")) {
	    		database.editDeparInfo(nameDepart, typeWorkTimeDepart, idDepInTable);
	    		response.setContentType("text/html; charset=UTF-8");
			    response.getWriter().println(database.showTableDepar());
	    	}
	    	if (info.equals("showTableDepar")) {
	    		response.setContentType("text/html; charset=UTF-8");
			    response.getWriter().println(database.showTableDepar());
	    	}
    	//информация о типах рабочего времени
		    	if (info.equals("addWorkHourBut")) {
		    		database.addWorkHourBut(startWorkHour, finishWorkHour, dinnerStart, dinnerFinish);
		    		response.setContentType("text/html; charset=UTF-8");
				    response.getWriter().println(database.showTableWorkHour());
				}
				if (info.equals("editWorkHourInfo")) {
					database.editWorkHourInfo(startWorkHour, finishWorkHour, dinnerStart, dinnerFinish, idWorkHourInTable);
					response.setContentType("text/html; charset=UTF-8");
				    response.getWriter().println(database.showTableWorkHour());
				}
				if (info.equals("showTableWorkHour")) {
					response.setContentType("text/html; charset=UTF-8");
				    response.getWriter().println(database.showTableWorkHour());
				}
				
		    	//информация о пользователях
		    	if (info.equals("addAuthorBut")) {
		    		authorization.addUserToDB(nameAuthor, paswordAuthor, roleUserAuthor);
				}
				if (info.equals("editAuthorInfo")) {
					database.editWorkHourInfo(startWorkHour, finishWorkHour, dinnerStart, dinnerFinish, idWorkHourInTable);
				}
				if (info.equals("showTableAuthor")) {
					response.setContentType("text/html; charset=UTF-8");
				    response.getWriter().println(database.showTableWorkHour());
				}
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
