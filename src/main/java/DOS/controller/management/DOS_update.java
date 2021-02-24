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
//管理(更新場地)
/**
 * Servlet implementation class DOS_update
 */
@WebServlet("/DOS/DOS_update")
public class DOS_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DOS_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			updateForm(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void updateForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        DOSService  rs = new DOSServiceImpl();
		        response.setContentType("text/html");
		        request.setCharacterEncoding("UTF-8");
		        System.out.println("update dosid:"+request.getParameter("id"));
		        Integer id = Integer.parseInt(request.getParameter("id"));
		        String dosName=request.getParameter("dos_name");
		        String dosAddr=request.getParameter("dos_addr");
		        String dosPS=request.getParameter("dos_ps");
		        Clob dosPS1=rs.getStringclob(dosPS);//string to clob
		        String dosTRANS=request.getParameter("dos_trans");
		        Clob dosTRANS1=rs.getStringclob(dosTRANS);//string to clob
		        Integer dosCy=Integer.parseInt(request.getParameter("dos_cy"));
		        System.out.println(request.getParameter("dos_cy"));
		        Integer dos_sportid=Integer.parseInt(request.getParameter("dos_sport_id"));
		        DOS_SPORT dos_sport=rs.select_sportid(dos_sportid);
			    DOS dos1=new DOS(id, dosName,dosAddr, 0,0, dosCy, 100, "xxx", "xxx", "xxx",dosTRANS1,dosPS1,null,dos_sport);
		        int n=rs.updateid(dos1);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("DOS_list");
		        dispatcher.forward(request, response);

		    }
}
