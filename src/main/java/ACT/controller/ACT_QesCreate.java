package ACT.controller;

import java.io.IOException;
import java.sql.Clob;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialClob;

import ACT.model.ACT;
import ACT.model.ACT_QES;
import ACT.service.ACTService;
import ACT.service.impl.ACTServiceImpl;
import member.model.MemberBean;

@WebServlet("/ACT/ACT_QesCreate")
public class ACT_QesCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼

		HttpSession session = request.getSession();
		String comment = request.getParameter("comment");

		try {	
			ACT_QES qes=new ACT_QES();// 將所有資料封裝到Bean	
			Clob clob=new SerialClob(comment.toCharArray());
			qes.setACT_QES_COM(clob);
			
			MemberBean member = (MemberBean) session.getAttribute("LoginOK");
			qes.setMEMBER_ID(member.getMember_id());
			
			ACTService service = new ACTServiceImpl();
			int actid=Integer.valueOf(request.getParameter("actid"));

			int n=service.insertQes(actid,qes);
			if (n != 0) {
				response.sendRedirect("ACT_Qes?ACTID="+actid);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("ACTQesForm.jsp");
			rd.forward(request, response);
		}

	}

}
