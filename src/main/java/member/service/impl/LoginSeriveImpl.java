package member.service.impl;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import member.dao.LoginDao;
import member.dao.impl.LoginDaoImpl;
import member.model.MemberBean;
import member.service.LoginService;
import util.HibernateUtils;



public class LoginSeriveImpl implements LoginService{
	SessionFactory factory;
	LoginDao dao;
    public LoginSeriveImpl() {
    	this.dao = new LoginDaoImpl();
		factory=HibernateUtils.getSessionFactory();
    }
	@Override
	public MemberBean checkIdPassword(String userId, String password) throws SQLException {
		MemberBean mb=null;
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			mb=dao.checkIdPassword(userId, password);
			tx.commit();
		}catch(Exception ex){
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return mb;
	}

}
