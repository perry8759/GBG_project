//controller 導向場地詳細資料
package ACT.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ACT.model.ACT;
import ACT.service.ACTService;
import ACT.service.impl.ACTServiceImpl;



@WebServlet("/ACT/ACT_Qes")
public class ACT_Qes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
			  ACTService  as = new ACTServiceImpl();   
	          request.setCharacterEncoding("UTF-8");			
	          String ACTID = request.getParameter("ACTID"); 
	          int vale=Integer.parseInt(ACTID.toString().trim()); 
	          ACT selectedBean=as.get(vale);

	          request.setAttribute("ActBean", selectedBean);	//放入活動bean
  
	          RequestDispatcher rd =                       		
	                 request.getRequestDispatcher("ACT_Qes.jsp");
	          rd.forward(request, response);               		
	          return ;                                     		
	       } catch(UnsupportedEncodingException e) {
	          throw new ServletException(e); 
	       }

	}
}
