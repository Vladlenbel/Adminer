package adminer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBDownloder
 */
@WebServlet("/DBDownloder")
public class DBDownloder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBWork database = new DBWork();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBDownloder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String info = (String) request.getParameter("info"); 
		
		if ( info.equals("getLastName") ) {
			//System.out.println("surname");
			response.setContentType("text/html; charset=UTF-8");
		    response.getWriter().println(database.getSurnameWork("surname"));
		}
		if ( info.equals("getName") ) {
			
			response.setContentType("text/html; charset=UTF-8");
		    response.getWriter().println(database.getSurnameWork("name"));
		   // System.out.println(database.getSurnameWork("name"));
		}
		if ( info.equals("getPatronomic") ) {
			//System.out.println("patronymic");
			response.setContentType("text/html; charset=UTF-8");
		    response.getWriter().println(database.getSurnameWork("patronymic"));
		}
		if ( info.equals("getDepar") ) {
			//System.out.println("patronymic");
			response.setContentType("text/html; charset=UTF-8");
		    response.getWriter().println(database.getDepar("title"));
		}
		if ( info.equals("getTypeOfWorkHour") ) {
			//System.out.println("patronymic");
			response.setContentType("text/html; charset=UTF-8");
		    response.getWriter().println(database.getTypeOfWorkHour());
		}
		if ( info.equals("getFIO") ) {
			//System.out.println("patronymic");
			response.setContentType("text/html; charset=UTF-8");
		    response.getWriter().println(database.getFIO());
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
