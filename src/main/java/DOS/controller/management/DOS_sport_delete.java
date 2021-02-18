package DOS.controller.management;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DOS.service.DOSService;
import DOS.service.impl.DOSServiceImpl;
//管理(刪除運動種類)
/**
 * Servlet implementation class DOS_delete
 */
@WebServlet("/DOS/DOS_sport_delete")
public class DOS_sport_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DOS_sport_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			deleteDOS_sport(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void deleteDOS_sport(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        String id = request.getParameter("dos_sport_id");
		        int vale=Integer.parseInt(id);
		        System.out.println(id);
		        DOSService  rs = new DOSServiceImpl();
		        rs.deleteSportId(vale);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("DOS_sport_list");		   
		        dispatcher.forward(request, response);
		    }
}
