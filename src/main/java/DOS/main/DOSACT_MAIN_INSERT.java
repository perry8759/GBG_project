package DOS.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ACT.model.ACT;
import ACT.model.ACT_QES;
import ACT.model.ACT_RFORM;
import ACT.model.ACT_RULE;
import ACT.model.ACT_STATUS;

import DOS.model.DOS;
import DOS.model.DOS_PICTURE;
import DOS.model.DOS_SPORT;
import util.HibernateUtils;

//活動及場地資料庫新增
public class DOSACT_MAIN_INSERT {

	public DOSACT_MAIN_INSERT() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	    //將照片集list
	    DOS_PICTURE dos_p1=new DOS_PICTURE(null,null);
	    DOS_PICTURE dos_p11=new DOS_PICTURE(null,null);
	    Set<DOS_PICTURE>   setp1 = new HashSet<>(Arrays.asList(dos_p1,dos_p11));
	    DOS_PICTURE dos_p2=new DOS_PICTURE(null,null);
	    Set<DOS_PICTURE>   setp2 = new HashSet<>(Arrays.asList(dos_p2));
	    DOS_PICTURE dos_p3=new DOS_PICTURE(null,null);
	    Set<DOS_PICTURE>   setp3 = new HashSet<>(Arrays.asList(dos_p3));
	    DOS_PICTURE dos_p4=new DOS_PICTURE(null,null);
	    Set<DOS_PICTURE>   setp4 = new HashSet<>(Arrays.asList(dos_p4));
	    //運動種類
	    DOS_SPORT dept1 = new DOS_SPORT(null,"籃球");
	    DOS_SPORT dept2 = new DOS_SPORT(null,"桌球");
	    //場地資訊
	    DOS dos1=new DOS(null, "百齡球場", "新光路1段166號旁", 6,6, 6, 100, "xxx", "xxx", "xxx",null,null,setp1,dept2);
	    DOS dos2=new DOS(null, "百齡球場", "新光路1段166號旁", 6,6, 6, 100, "xxx", "xxx", "xxx",null,null,setp1,dept1);
	    DOS dos3=new DOS(null, "百齡球場", "新光路1段166號旁", 6,6, 6, 100, "xxx", "xxx", "xxx",null,null,setp1,dept2);
	    DOS dos4=new DOS(null, "百齡球場", "新光路1段166號旁", 6,6, 6, 100, "xxx", "xxx", "xxx",null,null,setp1,dept1);
	    //活動狀態
	    ACT_STATUS act_status=new ACT_STATUS(null,"未開始報名");
	    //活動賽制
	    ACT_RULE act_rule=new ACT_RULE(null,"單淘汰");
	    //活動文件
	    ACT_RFORM act_rform=new ACT_RFORM(null,null);
	    ACT_RFORM act_rform1=new ACT_RFORM(null,null);
	    Set<ACT_RFORM> set_form = new HashSet<>(Arrays.asList(act_rform,act_rform1));
	    //活動問答
	    ACT_QES act_qes=new ACT_QES(null,1,null);
	    ACT_QES act_qes1=new ACT_QES(null,1,null);
	    Set<ACT_QES> set_qes = new HashSet<>(Arrays.asList(act_qes,act_qes1));
	    //活動資訊
	    ACT act1=new ACT( null, 1, dos1,"xxx", "xxx", 8, 50, null, null, null,null, 500,dept1,act_status,null, 0,act_rule,null,set_form,set_qes);
	    
        System.out.println("--------------------------------------");
        //並不會立即執行insert，適合長流程
        //無法持久化
        session.persist(dos1);
        session.persist(dos2);
        session.persist(dos3);
        session.persist(dos4);
        session.persist(act1);
        //立即持久化，並執行insert，因此當流程過多時會當機。
        //若是id已有，則會自動生成
//      session.save(actype);
//      session.save(actstatis);
//      session.save(dos_p1);
//      session.save(dos_p2);
//      session.save(dos_p3);
//      session.save(dos_p4);
//      session.save(dept1);
//      session.save(dept2);
		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();

	}

}
