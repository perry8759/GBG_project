package _00_init.member.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import member.model.MemberBean;
import util.HibernateUtils;

public class MemberDao {

	SessionFactory factory;

	public MemberDao() {
		factory = HibernateUtils.getSessionFactory();
	}

//	public void persist(MemberBean member) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			session.persist(member);
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//	}

	public Object save(MemberBean emp) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		Object key = null;
		try {
			tx = session.beginTransaction();
			key = session.save(emp);
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

//	public MemberBean load(int pk) {
//		MemberBean member = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			member = (MemberBean) session.load(MemberBean.class, pk);
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return member;
//	}
	
	// 經由Session介面的get()查詢資料庫內的紀錄
//	public MemberBean get(int pk) {
//		MemberBean member = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			member = (MemberBean) session.get(MemberBean.class, pk);
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		}
//		return member;
//	}
//
	// 更新紀錄
//	public void updateEmployee(MemberBean newData) {
//		MemberBean member = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			member = (MemberBean) session.get(MemberBean.class, newData.getMember_id());
//			if (member != null) {
//				member.setMember_user_name(newData.getMember_user_name());
//				//沒打完
//			}
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//	}

//	// 刪除紀錄
//	public void delete(int pk) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			MemberBean mem = new MemberBean(pk);
//			session.delete(mem);
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return;
//	}
//	
	// 查詢所有紀錄
//	@SuppressWarnings("unchecked")
//	public List<MemberBean> getAllMembers() {
//		System.out.println("MemberDAO: getAllMembers");
//		List<MemberBean> allMembers = new ArrayList<>();
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			allMembers = session.createQuery("FROM MemberBean").getResultList();
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return allMembers;
//	}

	public void close() {
		factory.close();
	}

}
