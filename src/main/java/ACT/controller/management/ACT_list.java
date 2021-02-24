package ACT.controller.management;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ACT.dao.impl.ACTDaoImpl;
import ACT.model.ACT;
import ACT.service.ACTService;
import ACT.service.impl.ACTServiceImpl;
import member.model.MemberBean;

@WebServlet("/ACT/ACT_list")
public class ACT_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ACT_list() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listACT(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void listACT(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        HttpSession session = request.getSession(false);
		        MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
				
				ACTService actservice=new ACTServiceImpl();
				List<ACT> act=actservice.select(mb.getMember_id());
				request.setAttribute("AllACT", act);	
			    RequestDispatcher rd =                       		
			         request.getRequestDispatcher("/management_page/MGT_ACT_Page.jsp");
			         rd.forward(request, response);               		
			    return ;                                     		
			    }
}
