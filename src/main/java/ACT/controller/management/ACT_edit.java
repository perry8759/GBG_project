package ACT.controller.management;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ACT.model.ACT;
import ACT.model.ACT_QES;
import ACT.model.ACT_RFORM;
import ACT.service.ACTService;
import ACT.service.impl.ACTServiceImpl;

//管理(跳轉到活動的編輯畫面)
@WebServlet("/ACT/ACT_edit")
public class ACT_edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ACT_edit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			showEditForm(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        String id = request.getParameter("actid");
		        int vale=Integer.parseInt(id);
		        System.out.println("編輯活動 id:"+id);
		        ACTService  rs = new ACTServiceImpl();
		        ACT act1=rs.get(vale);
		        request.setAttribute("act", act1);
		        
		        byte[] b=null;
		        if((b=act1.getACT_LOGO())!=null) {
		        	String act_logo=(Base64.getEncoder().encodeToString(b));
		        	request.setAttribute("act_logo", act_logo);
		        }
		        
		        Set<ACT_RFORM> forms=act1.getAct_rform();	//還沒轉化資料(Blob)
		        request.setAttribute("act_forms", forms);
		        
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ACT/ACT_Main_Form2.jsp");
		        dispatcher.forward(request, response);
		    }
}
