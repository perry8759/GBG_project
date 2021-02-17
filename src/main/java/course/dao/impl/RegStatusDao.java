package course.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import course.model.RegStatusBean;
import util.HibernateUtils;

public class RegStatusDao {

	SessionFactory factory;

	public RegStatusDao() {
		factory = HibernateUtils.getSessionFactory();
	}

	public RegStatusBean get(int pk) {
		RegStatusBean bean = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = (RegStatusBean) session.get(RegStatusBean.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return bean;
	}

	public void close() {
		factory.close();
	}


}
