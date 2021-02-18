package DOS.controller.management;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DOS.model.DOS;
import DOS.model.DOS_PICTURE;
import DOS.model.DOS_SPORT;
import DOS.service.DOSService;
import DOS.service.impl.DOSServiceImpl;

//管理(跳轉到運動種類的編輯畫面)
/**
 * Servlet implementation class DOS_edit
 */
@WebServlet("/DOS/DOS_sport_edit")
public class DOS_sport_edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DOS_sport_edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			showEditForm(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        String id = request.getParameter("dos_sport_id");
		        int vale=Integer.parseInt(id);
		        System.out.println(id);
		        DOSService  rs = new DOSServiceImpl();
		        DOS_SPORT dos1=rs.select_sportid(vale);
		        
		        
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/management_page/EDIT_DOS_sport_PAGE.jsp");
		        request.setAttribute("dos_sport", dos1);
		        dispatcher.forward(request, response);
		    }
}
