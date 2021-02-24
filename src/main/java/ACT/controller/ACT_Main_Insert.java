//新增新的活動表單後，導入到活動主頁
package ACT.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ACT.dao.impl.ACTDaoImpl;
import ACT.model.ACT;
import ACT.model.ACT_STATUS;
import ACT.service.ACTService;
import ACT.service.impl.ACTServiceImpl;
import member.model.MemberBean;



@WebServlet("/ACT/ACT_Main_Insert")
public class ACT_Main_Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ACT_Main_Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
	    ACTService  rs = new ACTServiceImpl();
	    request.setCharacterEncoding("UTF-8");	
	    String DOS_ID = request.getParameter("DOS_ID");
	    String ACT_MAIN_TITLE=request.getParameter("ACT_MAIN_TITLE");
	    String ACT_MAIN_DESC = request.getParameter("ACT_MAIN_DESC");
	    String ACT_MAIN_PERSON = request.getParameter("ACT_MAIN_PERSON");
	    String ACT_MAIN_OPENING = request.getParameter("ACT_MAIN_OPENING");
	    String ACT_MAIN_CLOSING = request.getParameter("ACT_MAIN_CLOSING");
	    String ACT_MAIN_TIME = request.getParameter("ACT_MAIN_TIME");
	    String ACT_MAIN_PAY = request.getParameter("ACT_MAIN_PAY");
	    Integer s=rs.getTime_to_status(ACT_MAIN_OPENING, ACT_MAIN_CLOSING);
	    Timestamp amo = null;
	    Timestamp amc=null;
	    Timestamp amt=null;
		try {
			amo = rs.changeTS(ACT_MAIN_OPENING);
		    amc=rs.changeTS(ACT_MAIN_CLOSING);
	        amt=rs.changeTS(ACT_MAIN_TIME);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //建立新的功能，使用seesion找出dos,act_type,act_status編號的物件
	    //回傳act_bean給rs.selectid新增 一筆紀錄
	    ACT act_bean=new ACT(null,mb.getMember_id(),null, ACT_MAIN_TITLE, ACT_MAIN_DESC, Integer.parseInt(ACT_MAIN_PERSON),
	    		1,amo, amc, amt,amt, Integer.parseInt(ACT_MAIN_PAY),null,null,null,
	    		Integer.parseInt(ACT_MAIN_PERSON),null,null,null,null);
	    rs.insertACT(act_bean, Integer.parseInt(DOS_ID), 1,s,1);
	    	 //rs.selectid(act_bean);
//	    	 rs.selectid1(ACT_MAIN_OPENING, ACT_MAIN_CLOSING);
//	    	 System.out.print(date);
//
	    	 //rs.select4();
//	    	 rs.select2();
//			request.setAttribute("ACT", act_bean);	//DOS資訊
			//request.setAttribute("ACT_List", act_list);
	    	 
	          RequestDispatcher rd =                       		
	                 request.getRequestDispatcher("ACT_Main");
	          rd.forward(request, response);
	    	 //response.sendRedirect("ACT_Main");
	    	 
	    	 
		
	    
		
	}

}
