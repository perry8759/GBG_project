﻿package ACT.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ACT.dao.impl.ActDaoI;
import ACT.model.ACT;
import util.HibernateUtils;

public class ActDao implements ActDaoI {

	SessionFactory factory;

	public ActDao() {
		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public void persist(ACT act) {
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
	
	@Override
	public Object save(ACT act) {
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
	@Override
	public ACT get(int pk) {
		ACT dos = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dos = (ACT) session.get(ACT.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return dos;
	}

//	// 更新紀錄
	@Override
	public void updateAct(ACT act) {
		ACT old_act = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); 
			old_act = (ACT) session.get(ACT.class, act.getACT_ID()); // Employee: Persistent
			if (old_act != null) {
				old_act.setACT_TITLE(act.getACT_TITLE());
				old_act.setAct_qes(act.getAct_qes());
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
	@Override
	public void delete(int pk) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			ACT dos = new ACT();
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
	@Override
	@SuppressWarnings("unchecked")
	public List<ACT> getAllAct() {
		System.out.println("ActDAO: getAllAct");
		List<ACT> allAct = new ArrayList<>();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			allAct = session.createQuery("FROM ACT").getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return allAct;
	}

	@Override
	public void close() {
		factory.close();
	}

}
