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

import ACT.service.ActService;
import course.model.MatchTeamBean;
import course.service.impl.MatchTeamService;
import course.service.impl.RegStatusService;
import member.model.MemberBean;

@WebServlet("/ACT/ACT_reg")
public class ACT_reg extends HttpServlet {
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
		String teamName = request.getParameter("teamName");
		String unitName = request.getParameter("unitName");

		// 3. 檢查使用者輸入資料
		if (teamName == null || teamName.trim().length() == 0) {
			errorMsg.put("errorIdEmpty", "隊伍名稱必須輸入");
		}
		if (unitName == null || unitName.trim().length() == 0) {
			errorMsg.put("errorPasswordEmpty", "單位名稱必須輸入");
		}
		// 如果有錯誤
		if (!errorMsg.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息(還不會)
			System.out.println("error =========>");
			RequestDispatcher rd = request.getRequestDispatcher("ACTRegForm.jsp");
			rd.forward(request, response);
			return;
		}
		try {
			// 4. 產生MemberDao物件，以便進行Business Logic運算
			MatchTeamService service = new MatchTeamService();
			
			//處理隊伍成員
			//(稍後做)
			Set<MemberBean> set=new HashSet<>();//(先只存報名者)
			set.add((MemberBean)session.getAttribute("LoginOK"));
			System.out.println("=========>"+session.getAttribute("LoginOK"));
			
			
			// 將所有資料封裝到Bean(類別的)物件
			MatchTeamBean team = new MatchTeamBean();
			team.setTeam_name(teamName);
			team.setTeam_unit(unitName);
			team.setMembers(set);
			RegStatusService service2 = new RegStatusService();
			team.setReg_status_id(service2.get(1)); //一開始都是未審核
			
			ActService service3=new ActService();
			team.setAct_id(service3.get(Integer.valueOf(request.getParameter("actid"))));
			
			System.out.println(request.getParameter("actid"));
			// 呼叫MatchTeamDao的save方法
			Object n = service.save(team);
			if (n != null) {
				msgOK.put("InsertOK", "<Font color='red'>報名成功</Font>");
				response.sendRedirect("ACTRegSuccess.jsp");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg.put("errorIdDup", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("ACTRegForm.jsp");
			rd.forward(request, response);
		}

	}

}
