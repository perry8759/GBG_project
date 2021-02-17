package _00_init.Act.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ACT.model.ActBean;
import util.HibernateUtils;

public class ActDao {

	SessionFactory factory;

	public ActDao() {
		factory = HibernateUtils.getSessionFactory();
	}

	public void persist(ActBean act) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(act);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public Object save(ActBean act) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		Object key = null;
		try {
			tx = session.beginTransaction();
			key = session.save(act);
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
	public ActBean get(int pk) {
		ActBean dos = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dos = (ActBean) session.get(ActBean.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return dos;
	}

//	// 更新紀錄
	public void updateAct(ActBean act) {
		ActBean old_act = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); 
			old_act = (ActBean) session.get(ActBean.class, act.getACT_ID()); // Employee: Persistent
			if (old_act != null) {
				old_act.setACT_TITLE(act.getACT_TITLE());
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
			ActBean dos = new ActBean();
			dos.setACT_ID(pk);
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
	public List<ActBean> getAllAct() {
		System.out.println("ActDAO: getAllAct");
		List<ActBean> allAct = new ArrayList<>();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			allAct = session.createQuery("FROM ActBean").getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return allAct;
	}

	public void close() {
		factory.close();
	}


}
