package _00_init;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ACT.model.ACT_RULE;
import ACT.model.ACT_STATUS;
import DOS.model.DOS_SPORT;
import course.model.MatchStatusBean;
import course.model.RegStatusBean;
import member.model.ManageStatusBean;
import member.model.MemberPermBean;
import member.model.MemberSexBean;
import util.HibernateUtils;

public class InitValCreate {
	public static void main(String arg[]) {

		MemberPermBean memberPerm1 = new MemberPermBean("normal_member");
		MemberPermBean memberPerm2 = new MemberPermBean("company_member");
		MemberPermBean memberPerm3 = new MemberPermBean("manager");
		
		MemberSexBean memberSex1 = new MemberSexBean("male");
		MemberSexBean memberSex2 = new MemberSexBean("female");

		ManageStatusBean manageStatus1 = new ManageStatusBean("unlock");
		ManageStatusBean manageStatus2 = new ManageStatusBean("locking");
		
		DOS_SPORT sport1=new DOS_SPORT(null,"籃球");
		DOS_SPORT sport2=new DOS_SPORT(null,"桌球");
		
		ACT_STATUS act_status1=new ACT_STATUS(null,"未開始報名");
		ACT_STATUS act_status2=new ACT_STATUS(null,"開放報名中");
		ACT_STATUS act_status3=new ACT_STATUS(null,"報名截止");
		ACT_STATUS act_status4=new ACT_STATUS(null,"賽事進行中");
		ACT_STATUS act_status5=new ACT_STATUS(null,"賽事已結束");
		ACT_STATUS act_status6=new ACT_STATUS(null,"賽事已凍結");
		
		ACT_RULE act_rule1=new ACT_RULE(null,"單淘汰");
		ACT_RULE act_rule2=new ACT_RULE(null,"雙淘汰");
		ACT_RULE act_rule3=new ACT_RULE(null,"循環");
		
		MatchStatusBean match_status1=new MatchStatusBean("未開始");
		MatchStatusBean match_status2=new MatchStatusBean("開始");
		MatchStatusBean match_status3=new MatchStatusBean("結束");
		
		RegStatusBean regs_Status1=new RegStatusBean("審核中");
		RegStatusBean regs_Status2=new RegStatusBean("已審核");
		RegStatusBean regs_Status3=new RegStatusBean("已繳款");
		
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
		
			session.persist(manageStatus1);
			session.persist(manageStatus2);
			
			session.persist(sport1);
			session.persist(sport2);
			
			session.persist(act_status1);
			session.persist(act_status2);
			session.persist(act_status3);
			session.persist(act_status4);
			session.persist(act_status5);
			session.persist(act_status6);
			
			session.persist(act_rule1);
			session.persist(act_rule2);
			session.persist(act_rule3);
			
			session.persist(match_status1);
			session.persist(match_status2);
			session.persist(match_status3);
			
			session.persist(regs_Status1);
			session.persist(regs_Status2);
			session.persist(regs_Status3);
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
