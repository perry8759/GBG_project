package ACT.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ACT.dao.impl.ActRuleDaoI;
import ACT.model.ACT_RULE;
import util.HibernateUtils;

public class ActRuleDao implements ActRuleDaoI {

	SessionFactory factory;

	public ActRuleDao() {
		factory = HibernateUtils.getSessionFactory();
	}

	// 經由Session介面的get()查詢資料庫內的紀錄
	@Override
	public ACT_RULE get(int pk) {
		ACT_RULE rule = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			rule = (ACT_RULE) session.get(ACT_RULE.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return rule;
	}

	@Override
	public void close() {
		factory.close();
	}


}
