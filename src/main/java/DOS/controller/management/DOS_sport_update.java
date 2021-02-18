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
//管理(更新運動種類)
/**
 * Servlet implementation class DOS_update
 */
@WebServlet("/DOS/DOS_sport_update")
public class DOS_sport_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DOS_sport_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			update_sportForm(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void update_sportForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        DOSService  rs = new DOSServiceImpl();
		        response.setContentType("text/html");
		        request.setCharacterEncoding("UTF-8");
		        Integer id = Integer.parseInt(request.getParameter("id"));
		        String dos_sport_name=request.getParameter("dos_sport_name");
		        DOS_SPORT dosp=new DOS_SPORT(id,dos_sport_name);
		        rs.updateSportId(dosp);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("DOS_sport_list");
		        dispatcher.forward(request, response);

		    }
}
