//按下租用導向至新增活動表單的頁面
package ACT.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DOS.dao.DOSDao;
import DOS.dao.impl.DOSDaoImpl;
import DOS.model.DOS;
import DOS.model.DOS_SPORT;
import DOS.service.DOSService;
import DOS.service.impl.DOSServiceImpl;


@WebServlet("/ACT/ACT_Index")

public class ACT_Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
    
	
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
			  DOSService  rs = new DOSServiceImpl();
	          request.setCharacterEncoding("UTF-8");			
	          String DOSID = request.getParameter("DOSID"); 
	          int vale=Integer.parseInt(DOSID.toString().trim()); 
	          DOS selectid=rs.selectid(vale);
	          request.setAttribute("DOSID", selectid);	//DOS資訊
	          List<DOS_SPORT> SPORT=rs.select_sport();
	          request.setAttribute("SPORT", SPORT);  //運動種類
	          
	          RequestDispatcher rd =                       		
	                 request.getRequestDispatcher("ACT_Main_Form2.jsp");
//	          RequestDispatcher rd =                       		
//		                 request.getRequestDispatcher("ACT_Main_Form.jsp");
	          rd.forward(request, response);               		
	          return ;                                     		
	       } catch(UnsupportedEncodingException e) {
	          throw new ServletException(e); 
	       }

	}
}
