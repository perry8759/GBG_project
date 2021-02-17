package course.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import course.dao.MatchDaoInter;
import course.model.MatchBean;
import util.HibernateUtils;

public class MatchDao implements MatchDaoInter {

	SessionFactory factory;

	public MatchDao() {
		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public void persist(MatchBean bean) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(bean);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
	@Override
	public Object save(MatchBean bean) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		Object key = null;
		try {
			tx = session.beginTransaction();
			key = session.save(bean);
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
	public MatchBean get(int pk) {
		MatchBean bean = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = (MatchBean) session.get(MatchBean.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return bean;
	}

	// 更新紀錄
	@Override
	public void update(MatchBean newData) {
		MatchBean bean = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); 
			bean = (MatchBean) session.get(MatchBean.class, newData.getMatch_id());
			if (bean != null) {
				bean.setAct_id(newData.getAct_id());
				bean.setMatch_status_id(newData.getMatch_status_id());
				bean.setMatch_seq(newData.getMatch_seq());
				bean.setMatch_time(newData.getMatch_time());
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
			MatchBean bean = new MatchBean();
			bean.setMatch_id(pk);
			session.delete(bean);
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
	public List<MatchBean> getAllMatch() {
		System.out.println("MatchDAO: getAllMatch");
		List<MatchBean> allMatch = new ArrayList<>();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			allMatch = session.createQuery("FROM MatchBean").getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return allMatch;
	}

	@Override
	public void close() {
		factory.close();
	}


}
