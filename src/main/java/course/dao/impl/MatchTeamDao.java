package course.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import course.model.MatchTeamBean;
import util.HibernateUtils;

public class MatchTeamDao{

	SessionFactory factory;

	public MatchTeamDao() {
		factory = HibernateUtils.getSessionFactory();
	}

	public void persist(MatchTeamBean bean) {
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
	

	public Object save(MatchTeamBean bean) {
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

	public MatchTeamBean get(int pk) {
		MatchTeamBean bean = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			bean = (MatchTeamBean) session.get(MatchTeamBean.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return bean;
	}


	public void update(MatchTeamBean newData) {
		MatchTeamBean bean = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); 
			bean = (MatchTeamBean) session.get(MatchTeamBean.class, newData.getMatch_team_id());
			if (bean != null) {
				bean.setAct_id(newData.getAct_id());
				bean.setMembers(newData.getMembers());
				bean.setReg_status_id(newData.getReg_status_id());
				bean.setTeam_name(newData.getTeam_name());
				bean.setTeam_unit(newData.getTeam_unit());
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

	public void close() {
		factory.close();
	}


}
