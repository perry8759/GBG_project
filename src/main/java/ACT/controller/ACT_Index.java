//controller導向場地主頁
package ACT.controller;

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


@WebServlet("/ACT/ACT_Index")
public class ACT_Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ACT_Index() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	     	RequestDispatcher rd = request.getRequestDispatcher("/ACT/ACT_Index.jsp");
	     	rd.forward(request, response);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	

}
