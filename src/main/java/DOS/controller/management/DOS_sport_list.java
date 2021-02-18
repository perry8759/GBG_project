package DOS.controller.management;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
//管理(列出所有運動種類之畫面)
/**
 * Servlet implementation class DOS_list
 */
@WebServlet("/DOS/DOS_sport_list")
public class DOS_sport_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DOS_sport_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listDOS_sport(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void listDOS_sport(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    DOSService  rs = new DOSServiceImpl();   		    
    	    List<DOS_SPORT>  dos111 = rs.select_sport() ;
    	    request.setAttribute("AllDOS_sport", dos111);		        
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/management_page/MGT_DOS_sport_Page.jsp");
		    dispatcher.forward(request, response);
		    }
}
