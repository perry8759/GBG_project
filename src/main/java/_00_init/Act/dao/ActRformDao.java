package _00_init.Act.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ACT.model.ACT_RFORM;
import util.HibernateUtils;

public class ActRformDao {

	SessionFactory factory;

	public ActRformDao() {
		factory = HibernateUtils.getSessionFactory();
	}

	public void persist(ACT_RFORM form) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(form);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public Object save(ACT_RFORM form) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		Object key = null;
		try {
			tx = session.beginTransaction();
			key = session.save(form);
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
	public ACT_RFORM get(int pk) {
		ACT_RFORM form = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			form = (ACT_RFORM) session.get(ACT_RFORM.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return form;
	}

//	// 更新紀錄
	public void update(ACT_RFORM form) {
		ACT_RFORM old_form = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); 
			old_form = (ACT_RFORM) session.get(ACT_RFORM.class, form.getACT_RFORM_id());
			if (old_form != null) {
				old_form.setACT_RFORM_doc(form.getACT_RFORM_doc());
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
	public void delete(int pk) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			ACT_RFORM qes = new ACT_RFORM();
			qes.setACT_RFORM_id(pk);
			session.delete(qes);
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
	@SuppressWarnings("unchecked")
	public List<ACT_RFORM> getAllForms() {
		System.out.println("FormDAO: getAllForms");
		List<ACT_RFORM> allForm = new ArrayList<>();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			allForm = session.createQuery("FROM ACT_QES").getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return allForm;
	}

	public void close() {
		factory.close();
	}


}
