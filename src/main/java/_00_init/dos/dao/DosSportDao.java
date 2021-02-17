package _00_init.dos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import DOS.model.DOS_SPORT;
import util.HibernateUtils;

public class DosSportDao {

	SessionFactory factory;

	public DosSportDao() {
		factory = HibernateUtils.getSessionFactory();
	}


	// 經由Session介面的get()查詢資料庫內的紀錄
	public DOS_SPORT get(int pk) {
		DOS_SPORT sport = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try { 
			tx = session.beginTransaction();
			sport = (DOS_SPORT) session.get(DOS_SPORT.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return sport;
	}

	public void close() {
		factory.close();
	}
}
