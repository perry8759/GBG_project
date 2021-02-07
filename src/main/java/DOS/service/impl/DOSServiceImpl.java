package DOS.service.impl;

import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import DOS.dao.DOSDao;
import DOS.dao.impl.DOSDaoImpl;
import DOS.model.DOS;
import DOS.model.DOS_PICTURE;
import DOS.service.DOSService;
import util.HibernateUtils;

public class DOSServiceImpl implements DOSService{
    DOSDao dao;
    SessionFactory factory;
	public DOSServiceImpl() {
		this.dao=new DOSDaoImpl();
		this.factory=HibernateUtils.getSessionFactory();
	}
	//查詢所有場地
	@Override
	public List<DOS> select() {
		List<DOS> dos = null;
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			dos=dao.select();
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
			dos=dao.selectid(dOSID);
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
		    result=dao.selecallpic(dOSID);
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
	
}
