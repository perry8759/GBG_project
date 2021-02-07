package DOS.controller;

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
import DOS.service.DOSService;
import DOS.service.impl.DOSServiceImpl;

/**
 * Servlet implementation class DOS_management
 */
@WebServlet("/")
public class DOS_management extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DOS_management() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
        
        try {
            switch (action) {
                
            case "/DOS/DOS_management/edit":
				showEditForm(request, response);
				break;
            default:
                listDOS(request, response);
                System.out.println(action);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	private void listDOS(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    DOSService  rs = new DOSServiceImpl();   
		    
    	    List<DOS>  dos111 = rs.select() ;
    	    request.setAttribute("AllDOS", dos111);		        
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/management_page/MGT_DOS_Page.jsp");
		    dispatcher.forward(request, response);
		    }
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        String id = request.getParameter("dosid");
		        
		        int vale=Integer.parseInt(id);
		        System.out.println(id);
		        DOSService  rs = new DOSServiceImpl();
		        DOS dos1=rs.selectid(vale);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/management_page/EDIT_DOS_PAGE.jsp");
		        request.setAttribute("dos", dos1);
		        dispatcher.forward(request, response);

		    }
}
