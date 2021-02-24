package ACT.controller.management;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ACT.service.ACTService;
import ACT.service.impl.ACTServiceImpl;
import DOS.service.DOSService;
import DOS.service.impl.DOSServiceImpl;
//管理(刪除場地)
/**
 * Servlet implementation class DOS_delete
 */
@WebServlet("/ACT/ACT_delete")
public class ACT_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ACT_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			deleteACT(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void deleteACT(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        String id = request.getParameter("actid");
		        int vale=Integer.parseInt(id);
		        System.out.println("delete act id:"+id);
		        ACTService rs = new ACTServiceImpl();
		        rs.delete(vale);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("ACT_list");		   
		        dispatcher.forward(request, response);
		    }
}
