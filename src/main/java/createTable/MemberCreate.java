package createTable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import member.model.ManageStatusBean;
import member.model.MemberBean;
import member.model.MemberPermBean;
import member.model.MemberSexBean;
import member.model.NewsBean;
import util.HibernateUtils;

public class MemberCreate {
	//fff
	public static void main(String[] args) {
		MemberBean member = new MemberBean();
		
		MemberPermBean memberPerm1 = new MemberPermBean("normal_member");
		MemberPermBean memberPerm2 = new MemberPermBean("company_member");
		MemberPermBean memberPerm3 = new MemberPermBean("manager");
		
		MemberSexBean memberSex1 = new MemberSexBean("male");
		MemberSexBean memberSex2 = new MemberSexBean("female");
		
		NewsBean news = new NewsBean();
		ManageStatusBean manageStatus1 = new ManageStatusBean("unlock");
		ManageStatusBean manageStatus2 = new ManageStatusBean("locking");
		
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(memberPerm1);
			session.persist(memberPerm2);
			session.persist(memberPerm3);
			session.persist(memberSex1);
			session.persist(memberSex2);
			session.persist(member);
			session.persist(news);
			session.persist(manageStatus1);
			session.persist(manageStatus2);
			tx.commit();
			System.out.println("資料新增完畢");
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// 需要印出錯誤訊息
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			// 關閉Session物件
			if (session != null)
				session.close();
		}
		factory.close();
	}
}
