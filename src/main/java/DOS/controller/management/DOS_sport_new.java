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
//管理(跳轉到運動種類的新增畫面)
/**
 * Servlet implementation class DOS_new
 */
@WebServlet("/DOS/DOS_sport_new")
public class DOS_sport_new extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DOS_sport_new() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			showNew_sportForm(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void showNew_sportForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/management_page/EDIT_DOS_sport_PAGE.jsp");
		    dispatcher.forward(request, response);
		    }
}
