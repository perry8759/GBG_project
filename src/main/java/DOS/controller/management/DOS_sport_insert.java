package DOS.controller.management;

import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DOS.model.DOS;
import DOS.model.DOS_SPORT;
import DOS.service.DOSService;
import DOS.service.impl.DOSServiceImpl;
//管理(新增運動種類)
/**
 * Servlet implementation class DOS_insert
 */
@WebServlet("/DOS/DOS_sport_insert")
public class DOS_sport_insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DOS_sport_insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			insertDOS_sport(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void insertDOS_sport(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		 
	     DOSService  rs = new DOSServiceImpl();
	     response.setContentType("text/html");
	     request.setCharacterEncoding("UTF-8");	     
	     String dos_sport_name=request.getParameter("dos_sport_name");	
	     DOS_SPORT dos_sport=new DOS_SPORT(null,dos_sport_name);
	     rs.insertSportId(dos_sport);
	     RequestDispatcher dispatcher = request.getRequestDispatcher("DOS_sport_list");		   
	     dispatcher.forward(request, response);
		 }
	
	
	 
}
