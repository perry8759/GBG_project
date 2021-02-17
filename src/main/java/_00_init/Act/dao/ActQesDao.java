package _00_init.Act.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ACT.model.ACT_QES;
import util.HibernateUtils;

public class ActQesDao {

	SessionFactory factory;

	public ActQesDao() {
		factory = HibernateUtils.getSessionFactory();
	}

	public void persist(ACT_QES qes) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(qes);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public Object save(ACT_QES qes) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		Object key = null;
		try {
			tx = session.beginTransaction();
			key = session.save(qes);
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
	public ACT_QES get(int pk) {
		ACT_QES qes = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			qes = (ACT_QES) session.get(ACT_QES.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return qes;
	}

//	// 更新紀錄
	public void updateQes(ACT_QES qes) {
		ACT_QES old_qes = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); 
			old_qes = (ACT_QES) session.get(ACT_QES.class, qes.getACT_QES_ID());
			if (old_qes != null) {
				old_qes.setMEMBER_ID(qes.getMEMBER_ID());
				old_qes.setACT_QES_COM(qes.getACT_QES_COM());
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
			ACT_QES qes = new ACT_QES();
			qes.setACT_QES_ID(pk);
			session.delete(qes);
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
	public List<ACT_QES> getAllQes() {
		System.out.println("QesDAO: getAllQes");
		List<ACT_QES> allQes = new ArrayList<>();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			allQes = session.createQuery("FROM ACT_QES").getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return allQes;
	}

	public void close() {
		factory.close();
	}


}
