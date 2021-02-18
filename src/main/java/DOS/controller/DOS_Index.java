//導向場地主頁(使用者畫面)
package DOS.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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


@WebServlet("/DOS/DOS_Index")
/**
 * Servlet implementation class DOS_Index
 */
public class DOS_Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DOS_Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
//			DOSService  rs = new DOSServiceImpl();   
//			 
//	     	List<DOS>  dos111 = rs.select() ;
//	     	request.setAttribute("AllDOS", dos111);
//			
//	     	List<DOS>  dos = rs.selectpic();
//	        List<String> dos_pictures=new ArrayList<String>();
//	        List<DOS_PICTURE> ddd=new ArrayList<DOS_PICTURE>();
//	        for(int i=0;i<dos.size();i++) {
//	        	 DOS dosp=(DOS) dos.get(i);
//	        	 ddd.add((DOS_PICTURE) dosp.getDos_picture().toArray()[0]);
//	        	 dos_pictures.add(Base64.getEncoder().encodeToString(ddd.get(i).getDOS_PICTURE_PIC()));
//	         }
//	        System.out.println(dos_pictures.size());
//	     	request.setAttribute("AllDOSP", dos_pictures);
	     	RequestDispatcher rd = request.getRequestDispatcher("/DOS/SportDOS.jsp");
	     	rd.forward(request, response);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
     	return ;
	}

	

}
