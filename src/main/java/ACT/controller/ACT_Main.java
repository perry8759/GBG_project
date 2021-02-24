//查詢活動主頁
package ACT.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ACT.model.ACT;
import ACT.service.ACTService;
import ACT.service.impl.ACTServiceImpl;



//查詢全部活動資料+分頁
@WebServlet("/ACT/ACT_Main")
public class ACT_Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//LoginBean mb = (LoginBean) session.getAttribute("LoginOK");
		Integer start=0;
		Integer count=5;
		Integer total=0;
		ACTService actservice=new ACTServiceImpl();
		total=actservice.allACT_Count();
		try {
		    start = Integer.parseInt(request.getParameter("start"));//取得jsp上的start參數 
		}catch (NumberFormatException e) {
            System.out.println("沒有起始值");
        } 
		//response.setHeader( "Refresh" ,"10" );
	    response.setCharacterEncoding("UTF-8");	
	    //0+5=5，下一頁就從第5筆開始
	    int next=start+count;
	    //5-5=0，上一頁就從第0筆開始
	    int pre=start-count;
	    
	    int last;
	    //總共10筆資料 每頁5個 ，則最後一頁開始就是第5筆
	    if(total % count == 0) {
	    	last=total-count;
	    //總共21筆資料 每頁5個，則最後一頁開始就是第20筆
	    }else {
	    	last=total-total%count;
	    }
	    //邊界
	    pre=pre<0 ? 0 : pre;
	    next=next>last ? last : next;
	    List<ACT> act_all=null;
		act_all=actservice.getACT_Max(start, count);
	    request.setAttribute("next", next);	//下一頁
	    request.setAttribute("pre", pre);	//上一頁
	    request.setAttribute("last",last);	//最後一頁
	    request.setAttribute("Act", act_all);
	    //request.setAttribute("Act_Status", act_all.);
	    RequestDispatcher rd =                       		
	         request.getRequestDispatcher("ACT_Main.jsp");
	         rd.forward(request, response);               		
	    return ;                                     		
	    } 	
}

