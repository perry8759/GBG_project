package member.dao.impl;


import java.sql.SQLException;


import javax.persistence.NoResultException;


import org.hibernate.Session;
import org.hibernate.SessionFactory;



import member.model.MemberBean;
import util.HibernateUtils;

public class LoginDaoImpl implements member.dao.LoginDao{
   SessionFactory factory;
	

	public LoginDaoImpl() {
		this.factory=HibernateUtils.getSessionFactory();
	}	
	//檢查帳號密碼
	public MemberBean checkIdPassword(String userId, String password) throws SQLException {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean m WHERE m.member_account = :mid and m.member_pw = :pswd";
		try {
			mb = (MemberBean) session.createQuery(hql)
									 .setParameter("mid", userId)
									 .setParameter("pswd", password)
									 .getSingleResult();
		} catch (NoResultException ex) {
			;
		}
		return mb;
	}
}
