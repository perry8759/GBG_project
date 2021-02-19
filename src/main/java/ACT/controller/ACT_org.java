package ACT.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import ACT.model.ACT;
import ACT.service.ActService;
import DOS.model.DOS;
import DOS.service.impl.DOSServiceImpl;
import course.model.MatchTeamBean;
import course.service.impl.MatchTeamService;
import course.service.impl.RegStatusService;
import member.model.MemberBean;
import util.TransformUtils;

@WebServlet("/ACT/ACT_org")
public class ACT_org extends HttpServlet {
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
		String ACT_TITLE = request.getParameter("ACT_TITLE");
		String ACT_PAY = request.getParameter("ACT_PAY");
		String ACT_MAX_TEAM = request.getParameter("ACT_MAX_TEAM");
		String ACT_MAX_PNUM = request.getParameter("ACT_MAX_PNUM");
		String ACT_DESC = request.getParameter("ACT_DESC");
		String ACT_SIGN_O = request.getParameter("ACT_SIGN_O");
		String ACT_SIGN_C = request.getParameter("ACT_SIGN_C");
		String ACT_RUN_O = request.getParameter("ACT_RUN_O");
		String ACT_RUN_C = request.getParameter("ACT_RUN_C");
		String dos_id = request.getParameter("dos_id");
		// 3. 檢查使用者輸入資料
//		if (teamName == null || teamName.trim().length() == 0) {
//			errorMsg.put("errorIdEmpty", "隊伍名稱必須輸入");
//		}
//		if (unitName == null || unitName.trim().length() == 0) {
//			errorMsg.put("errorPasswordEmpty", "單位名稱必須輸入");
//		}
		// 如果有錯誤
		if (!errorMsg.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息(還不會)
			System.out.println("error =========>");
			RequestDispatcher rd = request.getRequestDispatcher("ACTOrgForm.jsp");
			rd.forward(request, response);
			return;
		}
		try {
			// 4. 產生ActDao物件，以便進行Business Logic運算
			ActService service = new ActService();
			
			// 將所有資料封裝到Bean(類別的)物件
			ACT act=new ACT();
			//因為act存的memberid不是物件，是id，所以要放入的是memberBean.id屬性
			MemberBean member=(MemberBean)session.getAttribute("LoginOK");
			act.setMEMBER_ID(member.getMember_id());
			act.setACT_TITLE(ACT_TITLE);
			act.setACT_PAY(Integer.valueOf(ACT_PAY));
			act.setACT_MAX_TEAM(Integer.valueOf(ACT_MAX_TEAM));
			act.setACT_MAX_PNUM(Integer.valueOf(ACT_MAX_PNUM));
			act.setACT_DESC(ACT_DESC);
			act.setACT_SIGN_O(TransformUtils.stringToTimestamp(ACT_SIGN_O)); 
			act.setACT_SIGN_C(TransformUtils.stringToTimestamp(ACT_SIGN_C));
			act.setACT_RUN_O(TransformUtils.stringToTimestamp(ACT_RUN_O));
			act.setACT_RUN_C(TransformUtils.stringToTimestamp(ACT_RUN_C));
			//這邊要再改...這個時間轉換方式可能有點白痴....
			DOS dos=new DOSServiceImpl().selectid(Integer.valueOf(dos_id));
			act.setDos_id(dos);
			// 呼叫ActDao的save方法
			Object n = service.save(act);
			if (n != null) {
				msgOK.put("InsertOK", "<Font color='red'>主辦成功</Font>");
				response.sendRedirect("Success.jsp");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg.put("errorIdDup", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("ACTOrgForm.jsp");
			rd.forward(request, response);
		}

	}
}
