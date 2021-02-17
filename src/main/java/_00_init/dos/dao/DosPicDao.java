package _00_init.dos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import DOS.model.DOS_PICTURE;
import util.HibernateUtils;

public class DosPicDao {

	SessionFactory factory;

	public DosPicDao() {
		factory = HibernateUtils.getSessionFactory();
	}


	public void persist(DOS_PICTURE pic) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(pic);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	// 經由Session介面的get()查詢資料庫內的紀錄
	public DOS_PICTURE get(int pk) {
		DOS_PICTURE pic = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			pic = (DOS_PICTURE) session.get(DOS_PICTURE.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return pic;
	}

	public void close() {
		factory.close();
	}
}
