package DOS.dao.impl;
//直接查看dosservice說明即可
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import DOS.dao.DOSDao;
import DOS.model.DOS;
import DOS.model.DOS_PICTURE;
import DOS.model.DOS_SPORT;
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
	//查詢所有運動種類
		@SuppressWarnings("unchecked")
		@Override
		public List<DOS_SPORT> select_sport() {
			List<DOS_SPORT> dos_sport = null;
			Session session=factory.getCurrentSession();
			String hql = "FROM DOS_SPORT ";
		    dos_sport=session.createQuery(hql).list();
			return dos_sport;
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
	//依據編號查詢運動種類
	@Override
	public DOS_SPORT select_sportid(int  dOS_sport_id) {
		DOS_SPORT dos_sport = null;
		Session session=factory.getCurrentSession();
		String hql = "FROM DOS_SPORT d WHERE d.DOS_SPORT_ID = :dos_sportid ";
		dos_sport=(DOS_SPORT) session.createQuery(hql).setParameter("dos_sportid", dOS_sport_id).getSingleResult();	
		return dos_sport;
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
	@Override
	public int updateid(DOS bean) {
		int n=0;
		DOS dos=null;
		Session session=factory.getCurrentSession();
		dos = session.get(DOS.class, bean.getDOS_ID());
		//bean.setDOS_NAME(dos.getDOS_NAME());
		//bean.setDOS_ADDR(dos.getDOS_ADDR());
		//bean.setDOS_CY(dos.getDOS_CY());
		session.evict(dos);
        session.saveOrUpdate(bean);
		n++;
		return n;
	}
	@Override
	public void insertid(DOS dos) {
		Session session = factory.getCurrentSession();
        session.save(dos);
		
	}
	@Override
	public void deleteid(Integer id) {
		Session session = factory.getCurrentSession();
//	    DOS dos=new DOS();
//		dos.setDOS_ID(id);
		//dos=session.get(DOS.class, id); 錯誤邏輯
		
		DOS dos = session.get(DOS.class, id);
		dos.setDos_sport_id(null);//解除關係
		session.delete(dos); 
	}
	@Override
	public int updateSportId(DOS_SPORT bean) {
		int n=0;
		DOS_SPORT dos_Sport=null;
		Session session=factory.getCurrentSession();
		dos_Sport = session.get(DOS_SPORT.class, bean.getDOS_SPORT_ID());
		//bean.setDOS_NAME(dos.getDOS_NAME());
		//bean.setDOS_ADDR(dos.getDOS_ADDR());
		//bean.setDOS_CY(dos.getDOS_CY());
		session.evict(dos_Sport);
        session.saveOrUpdate(bean);
		n++;
		return n;
	}
	@Override
	public void insertSportId(DOS_SPORT dos_sport) {
		Session session = factory.getCurrentSession();
        session.save(dos_sport);
	}
	@Override
	public void deleteSportId(Integer id) {
		Session session = factory.getCurrentSession();		
		DOS_SPORT dos_sport = session.get(DOS_SPORT.class, id);
		
		Set<DOS> alldos=dos_sport.getDos();//解除關係
		Iterator iter = alldos.iterator();
		while (iter.hasNext()) {
		      DOS x = (DOS) iter.next();
		      x.setDos_sport_id(null);
		}
		dos_sport.setDos(null);
		session.delete(dos_sport);
		
	}
	

}
