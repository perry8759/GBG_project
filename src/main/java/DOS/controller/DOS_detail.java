//controller 導向場地詳細資料
package DOS.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import DOS.dao.DOSDao;
import DOS.model.DOS;
import DOS.model.DOS_PICTURE;
import DOS.service.DOSService;
import DOS.service.impl.DOSServiceImpl;



@WebServlet("/DOS/DOS_detail")
public class DOS_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
			  DOSService  rs = new DOSServiceImpl();   
	          request.setCharacterEncoding("UTF-8");			
	          String DOSID = request.getParameter("DOSID"); 
	          int vale=Integer.parseInt(DOSID.toString().trim()); 
	          DOS selectid=rs.selectid(vale);
	          List<DOS_PICTURE> selectid1=rs.selecallpic(vale);
	          Iterator<DOS_PICTURE> iter =selectid1.iterator();
	          List<String> dos_pictures=new ArrayList<String>();
	          while(iter.hasNext()) {
	        	  DOS_PICTURE dosp=(DOS_PICTURE) iter.next();
	        	  dos_pictures.add(Base64.getEncoder().encodeToString(dosp.getDOS_PICTURE_PIC()));
	          }
	          request.setAttribute("DOSID", selectid);	//場地編號
	          request.setAttribute("DOSPICID", dos_pictures);	//場地相片集
	        	          
	          RequestDispatcher rd =                       		
	                 request.getRequestDispatcher("/DOS/DOSDetail.jsp");
	          rd.forward(request, response);               		
	          return ;                                     		
	       } catch(UnsupportedEncodingException e) {
	          throw new ServletException(e); 
	       }

	}
}
