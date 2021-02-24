package ACT.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ACT.model.ACT;
import ACT.model.ACT_RFORM;
import ACT.service.ACTService;
import ACT.service.impl.ACTServiceImpl;
import member.model.MemberBean;
import util.TransformUtils;

@MultipartConfig(location = "")
@WebServlet("/ACT/ACT_Main_Insert2")
public class ACT_Main_Insert2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		String dos_sport= "";
		String DOS_ID = "";
		// 文件所需
		String fileName = "";
		long sizeInBytes = 0;
		InputStream is = null;
		
		ACTService rs = new ACTServiceImpl();
		ACT act=null;
		String actid=request.getParameter("ACT_ID");
		if(actid==null) {
			act = new ACT();//new ActBean 物件作為容器
			// 因為act存的memberid不是物件，是id，所以要放入的是memberBean.id屬性
			MemberBean member = (MemberBean) request.getSession().getAttribute("LoginOK");
			act.setMEMBER_ID(member.getMember_id());
		}else {
			act =rs.get(Integer.valueOf(actid));
		}
		
		// 取出HTTP multipart request內所有的parts
		Collection<Part> parts = request.getParts();
		// 由parts != null來判斷此上傳資料是否為HTTP multipart request
		if (parts != null) { // 如果這是一個上傳資料的表單
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				try {
					if (p.getContentType() == null) {
						if (fldName.equals("ACT_TITLE")) {
							act.setACT_TITLE(value);
						} else if (fldName.equals("ACT_PAY")) {
							act.setACT_PAY(Integer.valueOf(value));
						} else if (fldName.equals("ACT_MAX_TEAM")) {
							act.setACT_MAX_TEAM(Integer.valueOf(value));
						} else if (fldName.equals("ACT_MAX_PNUM")) {
							act.setACT_MAX_PNUM(Integer.valueOf(value));
						} else if (fldName.equals("ACT_DESC")) {
							act.setACT_DESC(value);
						} else if (fldName.equals("ACT_SIGN_O")) {
							act.setACT_SIGN_O(rs.changeTS(value));
						} else if (fldName.equals("ACT_SIGN_C")) {
							act.setACT_SIGN_C(rs.changeTS(value));
						} else if (fldName.equals("ACT_RUN_O")) {
							act.setACT_RUN_O(rs.changeTS(value));
						} else if (fldName.equals("ACT_RUN_C")) {
							act.setACT_RUN_C(rs.changeTS(value));
						} else if (fldName.equals("DOS_ID")) {
							DOS_ID = value;
						}else if (fldName.equals("dos_sport")) {
							dos_sport = value;
						}
					} else {
						// 取出檔名
						fileName = TransformUtils.getFileName(p);
						// 調整檔名的長度，需要檔名中的附檔名，所以調整主檔名以免檔名太長無法寫入表格
						fileName = TransformUtils.adjustFileName(fileName, TransformUtils.IMAGE_FILENAME_LENGTH);
						if (fileName != null && fileName.trim().length() > 0) {
							sizeInBytes = p.getSize();
							is = p.getInputStream();
						}
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		// 處理文件集
		byte[] b = null;
		if (is != null) {
			b = TransformUtils.fileToBytes(is, sizeInBytes);
		}
		try {
			ACT_RFORM form = null;
			if (b != null) {
				form = new ACT_RFORM(b);
				rs.save(form);
				Set<ACT_RFORM> set=act.getAct_rform();
				if(set==null) {
					set=new HashSet<>();
				}
				set.add(form);
				act.setAct_rform(set);
			}
			
			//依時間計算活動舉行狀態
			Integer status = rs.getTime_to_status(act);

			if(actid==null) {
				// 呼叫ActDao的insertACT方法
				rs.insertACT(act, Integer.valueOf(DOS_ID), Integer.valueOf(dos_sport), status, 1);
				//要重寫URL，不然ACT_Main無法篩選顯示活動
				response.sendRedirect("ACT_Main");
			}else {
				rs.update(act, Integer.valueOf(DOS_ID), Integer.valueOf(dos_sport), status, 1);
				RequestDispatcher dispatcher = request.getRequestDispatcher("ACT_list");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("ACT_Main_Form2.jsp");
			rd.forward(request, response);
		}

	}
}
