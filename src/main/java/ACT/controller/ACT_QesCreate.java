package ACT.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ACT.model.ActBean;
import ACT.service.ActService;
import course.model.MatchTeamBean;
import course.service.impl.MatchTeamService;
import course.service.impl.RegStatusService;
import member.model.MemberBean;

@WebServlet("/ACT/ACT_QesCreate")
public class ACT_QesCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsg = new HashMap<String, String>();
		// 準備存放報名成功之訊息的Map物件
		Map<String, String> msgOK = new HashMap<String, String>();

		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
		session.setAttribute("reg_MsgOK", msgOK); // 顯示正常訊息
		String comment = request.getParameter("comment");
		
		// 3. 檢查使用者輸入資料
		if (comment == null || comment.trim().length() == 0) {
			errorMsg.put("errorIdEmpty", "不能為空");
		}

		// 如果有錯誤
		if (!errorMsg.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息(還不會)
			System.out.println("error =========>");
			RequestDispatcher rd = request.getRequestDispatcher("ACTQesForm.jsp");
			rd.forward(request, response);
			return;
		}
		try {
			// 4. 對act/act_qes做更新
			ACT_Qes qes=new ACT_Qes();
			
			ActService service1 = new ActService();
			ActBean act=service1.get(Integer.valueOf(request.getParameter("actid")));
//			act.getAct_qes().add();
			
			// 將所有資料封裝到Bean(類別的)物件

			
			ActService service3=new ActService();
			
			
			System.out.println(request.getParameter("actid"));
			// 呼叫MatchTeamDao的save方法
//			Object n = service.save(team);
//			if (n != null) {
//				msgOK.put("InsertOK", "<Font color='red'>發表成功</Font>");
//				response.sendRedirect("ACTQesSuccess.jsp");
//				return;
//			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg.put("errorIdDup", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("ACTRegForm.jsp");
			rd.forward(request, response);
		}

	}

}
