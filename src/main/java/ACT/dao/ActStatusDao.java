package ACT.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ACT.dao.impl.ActStatusDaoI;
import ACT.model.ACT_STATUS;
import util.HibernateUtils;

public class ActStatusDao implements ActStatusDaoI {

	SessionFactory factory;

	public ActStatusDao() {
		factory = HibernateUtils.getSessionFactory();
	}
	
	// 經由Session介面的get()查詢資料庫內的紀錄
	@Override
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
	
	@Override
	public void close() {
		factory.close();
	}


}
