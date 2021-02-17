package _00_init.Act.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ACT.model.ACT_STATUS;
import util.HibernateUtils;

public class ActStatusDao {

	SessionFactory factory;

	public ActStatusDao() {
		factory = HibernateUtils.getSessionFactory();
	}
	
	// 經由Session介面的get()查詢資料庫內的紀錄
	public ACT_STATUS get(int pk) {
		ACT_STATUS status = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			status = (ACT_STATUS) session.get(ACT_STATUS.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return status;
	}
	
	public void close() {
		factory.close();
	}


}
