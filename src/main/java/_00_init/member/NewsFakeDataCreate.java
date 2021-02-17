package _00_init.member;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import member.model.NewsBean;
import util.HibernateUtils;

public class NewsFakeDataCreate {
	public static void initVal() {
		NewsBean news1=new NewsBean();
		news1.setNews_title("公告一");
		news1.setNews_content("這是公告一");
		
		NewsBean news2=new NewsBean();
		news2.setNews_title("公告二");
		news2.setNews_content("這是公告二");
		
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(news1);
			session.persist(news2);
			
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
