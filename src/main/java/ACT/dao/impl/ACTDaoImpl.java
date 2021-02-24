//dao(盡可能只寫sql語法)
package ACT.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ACT.dao.ACTDao;
import ACT.model.ACT;
import ACT.model.ACT_QES;
import ACT.model.ACT_RFORM;
import ACT.model.ACT_RULE;
import ACT.model.ACT_STATUS;
import DOS.model.DOS;
import DOS.model.DOS_SPORT;
import util.HibernateUtils;

public class ACTDaoImpl implements ACTDao {

	SessionFactory factory = null;

	public ACTDaoImpl() {
		factory = HibernateUtils.getSessionFactory();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ACT> select(Integer memberid) {
		List<ACT> act = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM ACT a where a.MEMBER_ID= :member";
		act = session.createQuery(hql).setParameter("member", memberid).list();
		return act;
	}

	@Override
	// 新增一筆活動資料
	public void insertACT(ACT act_bean, Integer dos_id, Integer dos_sport_id, Integer act_status_id,
			Integer act_rule_id) {
		Session session = factory.getCurrentSession();
		// Save the Model objects
		DOS dos = session.get(DOS.class, dos_id);
		DOS_SPORT dos_sport = session.get(DOS_SPORT.class, dos_sport_id);
		ACT_STATUS act_status = session.get(ACT_STATUS.class, act_status_id);
		ACT_RULE act_rule = session.get(ACT_RULE.class, act_rule_id);
		act_bean.setDos_id(dos);
		act_bean.setDos_sport(dos_sport);
		act_bean.setAct_status(act_status);
		act_bean.setAct_rule(act_rule);
		session.save(act_bean);

	}

	@Override
	// 計數所有資料
	public int allACT_Count() {
//		Session session = factory.getCurrentSession();
		int count = 0;
		List<ACT> list = getAct_All();
//		String hql = "from ACT";
//		list = session.createQuery(hql).getResultList();
		count = list.size();
		return count;
	}

	@Override
	// 取得商品第X筆-第X筆資料
	// String select3 = "select * from act_main order by ACT_MAIN_ID desc limit ?,?
	// ";
	@SuppressWarnings("unchecked")
	public List<ACT> getACT_Max(int start, int count) {
		Session session = factory.getCurrentSession();
		List<ACT> list = null;
		String hql = "FROM ACT ORDER BY ACT_ID";
		list = session.createQuery(hql).setFirstResult(start).setMaxResults(count).getResultList();
		return list;
	}
//==================================================
	@Override
	public void persist(ACT act) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(act);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	@Override
	public Object save(ACT act) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		Object key = null;
		try {
			tx = session.beginTransaction();
			key = session.save(act);
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
	
	@Override
	// 以actid取得該筆活動資料
	public ACT get(int pk) {
		System.out.println("get actid:"+pk);
		ACT dos = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dos = (ACT) session.get(ACT.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return dos;
	}

	@Override
	// 更新actid活動紀錄 //目前先不使用hql下特定欄位更新指令，等spring之後再弄)
	public void update(ACT bean) {
		System.out.println("dao- update actid:"+bean.getACT_ID());
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		    session.saveOrUpdate(bean);
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
	@Override
	public void delete(int pk) {
		System.out.println("delete actid:"+pk);
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			ACT act = new ACT();
			act.setACT_ID(pk);
			session.delete(act);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return;
	}

	@Override
	// 查詢所有紀錄
	@SuppressWarnings("unchecked")
	public List<ACT> getAct_All() {
		System.out.println("getAct_All");
		List<ACT> allAct = new ArrayList<>();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			allAct = session.createQuery("FROM ACT").getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return allAct;
	}

//===============================================ActQes

	@Override
	public void persist(ACT_QES qes) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(qes);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
	@Override
	public Object save(ACT_QES qes) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		Object key = null;
		try {
			tx = session.beginTransaction();
			key = session.save(qes);
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

	// 經由Session介面的get()查詢資料庫內的紀錄
	@Override
	public ACT_QES getQesById(int pk) {
		ACT_QES qes = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			qes = (ACT_QES) session.get(ACT_QES.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return qes;
	}

//	 更新紀錄
	@Override
	public void updateQes(ACT_QES qes) {
		ACT_QES old_qes = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); 
			old_qes = (ACT_QES) session.get(ACT_QES.class, qes.getACT_QES_ID());
			if (old_qes != null) {
				old_qes.setMEMBER_ID(qes.getMEMBER_ID());
				old_qes.setACT_QES_COM(qes.getACT_QES_COM());
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
	@Override
	public void deleteQes(int pk) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			ACT_QES qes = new ACT_QES();
			qes.setACT_QES_ID(pk);
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

	
//	------------------------------Form
	@Override
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
	
	@Override
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
	
	@Override
	public ACT_RFORM getFormById(int pk) {
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

	// 更新紀錄
	@Override
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
	@Override
	public void deleteForm(int pk) {
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
	
	//	------------------------status
	
	public ACT_STATUS getStatusById(Integer act_status_id) {
		ACT_STATUS status = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			status = (ACT_STATUS) session.get(ACT_STATUS.class, act_status_id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return status;
	}

	//	------------------------Rule
	public ACT_RULE getRuleById(Integer act_rule_id) {
		ACT_RULE rule = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			rule = (ACT_RULE) session.get(ACT_RULE.class, act_rule_id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return rule;
	}
}
