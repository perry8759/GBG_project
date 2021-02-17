package course.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import course.dao.MatchStatusDaoInter;
import course.model.MatchStatusBean;
import util.HibernateUtils;

public class MatchStatusDao implements MatchStatusDaoInter {

	SessionFactory factory;

	public MatchStatusDao() {
		factory = HibernateUtils.getSessionFactory();
	}

	// 經由Session介面的get()查詢資料庫內的紀錄
	@Override
	public MatchStatusBean get(int pk) {
		MatchStatusBean bean = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = (MatchStatusBean) session.get(MatchStatusBean.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public void close() {
		factory.close();
	}


}
