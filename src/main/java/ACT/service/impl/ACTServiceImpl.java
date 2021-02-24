//service
package ACT.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ACT.dao.ACTDao;
import ACT.dao.impl.ACTDaoImpl;
import ACT.model.ACT;
import ACT.model.ACT_QES;
import ACT.model.ACT_RFORM;
import ACT.service.ACTService;
import DOS.dao.DOSDao;
import DOS.dao.impl.DOSDaoImpl;
import util.HibernateUtils;

public class ACTServiceImpl implements ACTService {

	ACTDao actdao;
	DOSDao dosdao;
	SessionFactory factory;

	public ACTServiceImpl() {
		this.actdao = new ACTDaoImpl();
		this.dosdao = new DOSDaoImpl();
		this.factory = HibernateUtils.getSessionFactory();
	}

	// 接收表單中的datetimepicker後，轉成timeStamp
	public Timestamp changeTS(String date) throws ParseException {
		if (date != null) {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd hh:mm:00");
			java.util.Date cdate1 = sdf1.parse(date);
			Timestamp ts = new Timestamp(cdate1.getTime());
			return ts;
		}
		return null;
	}

//	-----------------------------------------ACT

	@Override
	public ACT get(int pk) {
		return actdao.get(pk);
	}

	@Override
	public void update(ACT act, Integer dos_id, Integer dos_sport_id, Integer act_status_id, Integer act_rule_id) {
		act.setDos_id(dosdao.get(dos_id));
		act.setDos_sport(dosdao.getSportById(dos_sport_id));
		act.setAct_status(actdao.getStatusById(act_status_id));
		act.setAct_rule(actdao.getRuleById(act_rule_id));
		actdao.update(act);
	}

	@Override
	public List<ACT> getAct_All() {
		return actdao.getAct_All();
	}

	@Override
	public void delete(int pk) {
		actdao.delete(pk);
	}

//-----------------------------------------ACT_Qes
	@Override
	public void persist(ACT_QES qes) {
		actdao.persist(qes);
	}

	@Override
	public int insertQes(int actid, ACT_QES qes) {
		int n = 0;
		ACT act = actdao.get(actid);
		actdao.save(qes);

		Set<ACT_QES> set = act.getAct_qes();
		set.add(qes);
		act.setAct_qes(set);
		actdao.update(act);
		n++;
		return n;
	}

	@Override
	public ACT_QES getQesById(int pk) {
		return actdao.getQesById(pk);
	}

	@Override
	public void update(ACT_QES e) {
		actdao.updateQes(e);
	}

	@Override
	public void deleteQes(int pk) {
		actdao.delete(pk);
	}

	// -----------------------------------------ACT_Qes
	@Override
	public Object save(ACT_RFORM form) {
		return actdao.save(form);
	}
	
	@Override
	public ACT_RFORM getFormById(int pk) {
		return actdao.getFormById(pk);
	}
//==============================
	@Override
	// 針對開放跟截止時間做目前報名狀態
	public Integer getTime_to_status(String ACT_MAIN_OPENING, String ACT_MAIN_CLOSING) {
		Integer s = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		java.util.Date date = new java.util.Date();
		String current = sdf.format(date);
		int result = current.compareTo(ACT_MAIN_OPENING);
		int result1 = current.compareTo(ACT_MAIN_CLOSING);
		System.out.println(result);
		System.out.println(result1);
		if (result < 0 && result1 < 0) {
			s = 1;
		} else if (result >= 0 && result1 <= 0) {
			s = 2;
		} else {
			s = 3;
		}
		return s;
	}

	@Override
	// 針對開放跟截止時間做目前報名狀態(NEW)
	public Integer getTime_to_status(ACT act) {
		Integer s = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		java.util.Date date = new java.util.Date();
		String current = sdf.format(date);
		int result = current.compareTo(sdf.format(act.getACT_SIGN_O()));
		int result1 = current.compareTo(sdf.format(act.getACT_SIGN_C()));
		int result2 = current.compareTo(sdf.format(act.getACT_RUN_C()));
		int result3 = current.compareTo(sdf.format(act.getACT_RUN_O()));
		if (result < 0 && result1 < 0) {
			s = 1;// 未開始報名
		} else if (result >= 0 && result1 <= 0) {
			s = 2;// 開放報名中
		} else if (result1 >= 0 && result2 <= 0) {
			s = 3;// 報名截止
		} else if (result2 <= 0 && result3 <= 0) {
			s = 4;// 賽事進行中
		} else {
			s = 5;// 賽事已結束
		}
		return s;
	}

	@Override
	public void insertACT(ACT act_bean, Integer dos_id, Integer dos_sport_id, Integer act_status_id,
			Integer act_rule_id) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			actdao.insertACT(act_bean, dos_id, dos_sport_id, act_status_id, act_rule_id);
			tx.commit();
		} catch (NoResultException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	@Override
	public int allACT_Count() {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		int n = 0;
		try {
			tx = session.beginTransaction();
			n = actdao.allACT_Count();
			tx.commit();
		} catch (NoResultException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return n;
	}

	@Override
	public List<ACT> getACT_Max(int start, int count) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		List<ACT> result;
		try {
			tx = session.beginTransaction();
			result = actdao.getACT_Max(start, count);
			tx.commit();
		} catch (NoResultException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return result;
	}
//	public List<ACT_Bean> getallList() throws SQLException, ParseException{
//		return dao.select4();
//	}

	@Override
	public List<ACT> select(Integer memberid) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		List<ACT> result;
		try {
			tx = session.beginTransaction();
			result = actdao.select(memberid);
			tx.commit();
		} catch (NoResultException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return result;
	}

}
