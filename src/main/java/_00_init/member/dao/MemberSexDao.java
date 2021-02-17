package _00_init.member.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import member.model.MemberSexBean;
import util.HibernateUtils;

public class MemberSexDao {

	SessionFactory factory;

	public MemberSexDao() {
		factory = HibernateUtils.getSessionFactory();
	}


	// 經由Session介面的get()查詢資料庫內的紀錄
	public MemberSexBean get(int pk) {
		MemberSexBean sex = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			sex = (MemberSexBean) session.get(MemberSexBean.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return sex;
	}

	public void close() {
		factory.close();
	}

}
