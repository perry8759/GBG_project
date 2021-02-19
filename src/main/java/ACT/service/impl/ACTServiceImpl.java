//service
package ACT.service.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ACT.dao.ACTDao;
import ACT.dao.impl.ACTDaoImpl;
import ACT.model.ACT;
import ACT.service.ACTService;
import util.HibernateUtils;



public class ACTServiceImpl implements ACTService{
	
	ACTDao actdao;
    SessionFactory factory;
	public ACTServiceImpl() {
		this.actdao=new ACTDaoImpl();
		this.factory=HibernateUtils.getSessionFactory();
	}	
	
	//接收表單中的datetimepicker後，轉成timeStamp
    public Timestamp changeTS(String date) throws ParseException  {
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd hh:mm:00");
		java.util.Date cdate1 = sdf1.parse(date);
		Timestamp ts = new Timestamp(cdate1.getTime());
		return ts;
    }
	
    //針對開放跟截止時間做目前報名狀態
  	public Integer getTime_to_status(String ACT_MAIN_OPENING,String ACT_MAIN_CLOSING)  {
  		Integer s=null;
  		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  	    java.util.Date date = new java.util.Date();
  	    String current=sdf.format(date);
  	    int result=current.compareTo(ACT_MAIN_OPENING);
  		int result1=current.compareTo(ACT_MAIN_CLOSING);
  		System.out.println(result);
  		System.out.println(result1);
  		if(result<0 && result1<0) {
  			s=1;
  		}
  		else if(result>=0 && result1<=0) {
  			s=2;
  		}
  		else {
  			s=3;
  		}		
  		return s;		
  	}
	
	@Override
	public void insertACT(ACT act_bean,Integer dos_id,Integer dos_sport_id,Integer act_status_id,Integer act_rule_id){
		Session session=factory.getCurrentSession();
		Transaction tx=null;	
		try {
			tx=session.beginTransaction();
			actdao.insertACT(act_bean, dos_id, dos_sport_id, act_status_id, act_rule_id);
			tx.commit();
		}catch(NoResultException ex) {
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	@Override
	public int allACT_Count() {
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		int n=0;
		try {
			tx=session.beginTransaction();
			n=actdao.allACT_Count();
			tx.commit();
		}catch(NoResultException ex) {
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return n;
	}
	@Override
	public List<ACT> getACT_Max(int start, int count) {
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		List<ACT> result;
		try {
			tx=session.beginTransaction();
			result=actdao.getACT_Max(start, count);
			tx.commit();
		}catch(NoResultException ex) {
			if(tx!=null) {
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
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		List<ACT> result;
		try {
			tx=session.beginTransaction();
			result=actdao.select(memberid);
			tx.commit();
		}catch(NoResultException ex) {
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return result;
	}
}
