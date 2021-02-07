package member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.MemberBean;
import member.service.impl.LoginSeriveImpl;




@WebServlet("/login/login.do")
public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginSeriveImpl lsi=new LoginSeriveImpl();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		String password = request.getParameter("pswd");
		String requestURI = (String) session.getAttribute("requestURI");
		try {
			MemberBean checkid=lsi.checkIdPassword(userId, password);
			if(checkid!=null) {
				System.out.println("登入成功");
				session.setAttribute("LoginOK", checkid);
			}
			else {
				System.out.println("登入失敗");
			}
			if (requestURI != null) {
				requestURI = (requestURI.length() == 0 ? request.getContextPath() : requestURI);
				if(requestURI.compareTo("/GBG_project/DOS/DOS_detail")==0){
				response.sendRedirect("../DOS/SportDOS.jsp");
				MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
				
				return;
				}
				else {
					response.sendRedirect(response.encodeRedirectURL(requestURI));
					MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
					
					return;
				}
			} else {
				response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
				System.out.print(requestURI);
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
