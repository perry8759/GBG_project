package _00_init.dos.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import DOS.model.DOS;
import util.HibernateUtils;

public class DosDao {

	SessionFactory factory;

	public DosDao() {
		factory = HibernateUtils.getSessionFactory();
	}

	public void persist(DOS dos) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(dos);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public Object save(DOS dos) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		Object key = null;
		try {
			tx = session.beginTransaction();
			key = session.save(dos);
			System.out.println("key:" + key);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return key;
	}


//	public DOS load(int pk) {
//
//	}
	
	// 經由Session介面的get()查詢資料庫內的紀錄
	public DOS get(int pk) {
		DOS dos = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dos = (DOS) session.get(DOS.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return dos;
	}

//	// 更新紀錄
	public void updateDos(DOS dos) {
		DOS old_dos = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); 
			old_dos = (DOS) session.get(DOS.class, dos.getDOS_ID()); // Employee: Persistent
			if (old_dos != null) {
				old_dos.setDOS_NAME(dos.getDOS_NAME());
				old_dos.setDOS_ADDR(dos.getDOS_ADDR());
				old_dos.setDOS_LONG(dos.getDOS_LONG());
				old_dos.setDOS_LAT(dos.getDOS_LAT());
				//...沒寫完 (改spring就不用用ㄌ)
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return;
	}

	// 刪除紀錄
	public void delete(int pk) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			DOS dos = new DOS();
			dos.setDOS_ID(pk);
			session.delete(dos);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return;
	}
	
//	// 查詢所有紀錄
	@SuppressWarnings("unchecked")
	public List<DOS> getAllDOS() {
		System.out.println("DOSDAO: getAllDOS");
		List<DOS> allDOS = new ArrayList<DOS>();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			allDOS = session.createQuery("FROM DOS").getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return allDOS;
	}

	public void close() {
		factory.close();
	}

	@SuppressWarnings("unchecked")
	public DOS findDOSByDOSId(String id) {
		DOS dos = null;
		String hql = "FROM DOS d WHERE d.DOS_ID = :did ";
		List<DOS> allDOS = new ArrayList<DOS>();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			allDOS = session.createQuery(hql)
					       .setParameter("did", id)
					       .getResultList();
			if (allDOS.size() > 0) {
				dos = allDOS.get(0);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
		
		return dos;
	}

}
