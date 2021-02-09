package DOS.dao.impl;

import java.util.List;
import java.util.Vector;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DOS.dao.DOSDao;
import DOS.model.DOS;
import DOS.model.DOS_PICTURE;
import util.HibernateUtils;

public class DOSDaoImpl implements DOSDao{

	SessionFactory factory=null;
	
	public DOSDaoImpl() {
		factory=HibernateUtils.getSessionFactory();
	}
	//查詢所有場地
	@SuppressWarnings("unchecked")
	@Override
	public List<DOS> select() {
		List<DOS> dos = null;
		Session session=factory.getCurrentSession();
		String hql = "FROM DOS ";
	    dos=session.createQuery(hql).list();
		return dos;
	}
	
	
	
	//依據編號查詢場地
	//private static final String SELECT_BY_ID = "Select  DOS_NAME, DOS_ADDR, DOS_CY, DOS_PHONE, DOS_PAY, DOS_PIC from dos where DOS_ID = ?";
	@Override
	public DOS selectid(int  dOSID) {
		DOS dos = null;
		Session session=factory.getCurrentSession();
		String hql = "FROM DOS d WHERE d.DOS_ID = :dosid ";
		dos=(DOS) session.createQuery(hql).setParameter("dosid", dOSID).getSingleResult();	
		return dos;
	}
	
	//查詢此場地的相片集
	@SuppressWarnings("null")
	@Override
	public List<DOS_PICTURE> selecallpic(int  dOSID) {
		List<DOS_PICTURE> result= null;
		//byte[] sImage = null;
		Session session=factory.getCurrentSession();
		DOS dept = session.get(DOS.class, dOSID);
		result=new Vector<DOS_PICTURE>();
		if (dept != null) {
	       for (DOS_PICTURE dosp : dept.getDos_picture()) {
				System.out.println("發現ㄧ個圖片"+dosp.getDOS_PICTURE_ID());
				result.add(dosp);				
			   }
		    } else {
		        System.out.println("查無資料");
		    }
	     System.out.print(result.size());
		 return result;
	}

}
