//dao(盡可能只寫sql語法)
package ACT.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ACT.dao.ACTDao;
import ACT.model.ACT;
import ACT.model.ACT_RULE;
import ACT.model.ACT_STATUS;

import DOS.model.DOS;
import DOS.model.DOS_SPORT;
import util.HibernateUtils;





public class ACTDaoImpl implements ACTDao{
	
	SessionFactory factory=null;
	
	public ACTDaoImpl() {
		factory=HibernateUtils.getSessionFactory();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ACT> select(Integer memberid) {
		List<ACT> act = null;
		Session session=factory.getCurrentSession();
		String hql = "FROM ACT a where a.MEMBER_ID= :member";
	    act=session.createQuery(hql).setParameter("member", memberid).list();
		return act;
	}
    @Override
    //新增一筆活動資料
    public void insertACT(ACT act_bean,Integer dos_id,Integer dos_sport_id,Integer act_status_id,Integer act_rule_id) {
    	Session session=factory.getCurrentSession();
  		//Save the Model objects
    	DOS dos=session.get(DOS.class, dos_id);
    	DOS_SPORT dos_sport=session.get(DOS_SPORT.class, dos_sport_id);
    	ACT_STATUS act_status=session.get(ACT_STATUS.class, act_status_id);
    	ACT_RULE act_rule=session.get(ACT_RULE.class, act_rule_id);
    	act_bean.setDos_id(dos);
    	act_bean.setDos_sport(dos_sport);
    	act_bean.setAct_status(act_status);
    	act_bean.setAct_rule(act_rule);
    	session.save(act_bean);   		
    	
    }

	@Override
	//計數所有資料
	public int allACT_Count() {
		Session session=factory.getCurrentSession();
		int count=0;
		List<ACT> list = null;
		String hql="from ACT";
		list = session.createQuery(hql).getResultList();
		count=list.size();
	    return count;
	}

	@Override
    //取得商品第X筆-第X筆資料
	//String select3 = "select * from act_main order by ACT_MAIN_ID desc limit ?,? ";
	@SuppressWarnings("unchecked")
	public List<ACT> getACT_Max(int start, int count) {
		Session session=factory.getCurrentSession();
		List<ACT> list = null;
		String hql="FROM ACT ORDER BY ACT_ID";
		list = session.createQuery(hql)
			   .setFirstResult(start)
			   .setMaxResults(count)
			   .getResultList();	
		return list;
	}
}
