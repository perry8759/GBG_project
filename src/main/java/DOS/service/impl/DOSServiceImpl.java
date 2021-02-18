package DOS.service.impl;
//直接查看dosservice說明即可
import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import DOS.dao.DOSDao;
import DOS.dao.impl.DOSDaoImpl;
import DOS.model.DOS;
import DOS.model.DOS_PICTURE;
import DOS.model.DOS_SPORT;
import DOS.service.DOSService;
import util.HibernateUtils;

public class DOSServiceImpl implements DOSService{
    DOSDao dosdao;
    SessionFactory factory;
	public DOSServiceImpl() {
		dosdao=new DOSDaoImpl();
		factory=HibernateUtils.getSessionFactory();
	}
	//查詢所有場地
	@Override
	public List<DOS> select() {
		List<DOS> dos = null;
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			dos=dosdao.select();
			tx.commit();
		}catch(NoResultException ex) {
			dos=null;
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return dos;
	}
	//依據編號查詢場地
	@Override
	public DOS selectid(int dOSID) {
		DOS dos = null;
		Session session=factory.getCurrentSession();
		Transaction tx=null;	
		try {
			tx=session.beginTransaction();
			dos=dosdao.selectid(dOSID);
			tx.commit();
		}catch(NoResultException ex) {
			dos=null;
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return dos;
	}
	//查詢此場地的相片集
	@Override
	public List<DOS_PICTURE> selecallpic(int dOSID) {
		List<DOS_PICTURE> result;
		//byte[] sImage = null;
		Session session=factory.getCurrentSession();
		Transaction tx=null;	
		try {
	        tx=session.beginTransaction();
		    result=dosdao.selecallpic(dOSID);
            tx.commit();
		}catch(NoResultException ex) {
			result=null;
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		 return result;
	}

	@SuppressWarnings("unchecked")
	public List<DOS> selectpic() {
		List<DOS> result;
		//byte[] sImage = null;
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		String hql = "FROM DOS ";
		
		try {
			
	        tx=session.beginTransaction();	        
		    result=(List<DOS>)session.createQuery(hql).list();		    
            tx.commit();
		}catch(NoResultException ex) {
			result=null;
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		System.out.println(result);
		 return result;
	}
	@Override
	public int updateid(DOS dos) {
		int n=0;
		Session session=factory.getCurrentSession();
		Transaction tx=null;	
		try {
			tx=session.beginTransaction();
			n=dosdao.updateid(dos);
			tx.commit();
		}catch(NoResultException ex) {
			dos=null;
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return n;
	}
	@Override
	public void insertid(DOS dos) {
		Session session=factory.getCurrentSession();
		Transaction tx=null;	
		try {
			tx=session.beginTransaction();
			dosdao.insertid(dos);
			tx.commit();
		}catch(NoResultException ex) {
			
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}	
	}
	@Override
	public void deleteid(Integer id) {
		Session session=factory.getCurrentSession();
		Transaction tx=null;	
		try {
			tx=session.beginTransaction();
			dosdao.deleteid(id);
			tx.commit();
		}catch(NoResultException ex) {
			
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		
	}
	public Clob getStringclob(String s) throws SerialException, SQLException, IOException {
		Clob myClob = new javax.sql.rowset.serial.SerialClob(s.toCharArray());
		return myClob;
	}
	@Override
	public List<DOS_SPORT> select_sport() {
		List<DOS_SPORT> dos = null;
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			dos=dosdao.select_sport();
			tx.commit();
		}catch(NoResultException ex) {
			dos=null;
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return dos;
	}
	@Override
	public DOS_SPORT select_sportid(int dOS_sport_id) {
		DOS_SPORT dos_sport = null;
		Session session=factory.getCurrentSession();
		Transaction tx=null;	
		try {
			tx=session.beginTransaction();
			dos_sport=dosdao.select_sportid(dOS_sport_id);
			tx.commit();
		}catch(NoResultException ex) {
			dos_sport=null;
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return dos_sport;
	}
	@Override
	public int updateSportId(DOS_SPORT dos_sport) {
		int n=0;
		Session session=factory.getCurrentSession();
		Transaction tx=null;	
		try {
			tx=session.beginTransaction();
			n=dosdao.updateSportId(dos_sport);
			tx.commit();
		}catch(NoResultException ex) {
			dos_sport=null;
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return n;
	}
	@Override
	public void insertSportId(DOS_SPORT dos_sport) {
		Session session=factory.getCurrentSession();
		Transaction tx=null;	
		try {
			tx=session.beginTransaction();
			dosdao.insertSportId(dos_sport);;
			tx.commit();
		}catch(NoResultException ex) {			
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}		
	}
	@Override
	public void deleteSportId(Integer id) {
		Session session=factory.getCurrentSession();
		Transaction tx=null;	
		try {
			tx=session.beginTransaction();
			dosdao.deleteSportId(id);
			tx.commit();
		}catch(NoResultException ex) {
			
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		
	}
}
