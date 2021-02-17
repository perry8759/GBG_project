package _00_init.member;

import _00_init.member.service.MemberPermService;
import _00_init.member.service.MemberService;
import _00_init.member.service.MemberSexService;
import member.model.MemberBean;

public class MemberFakeDataCreate {
	public static void initVal() {
		MemberSexService mss=new MemberSexService();
		MemberPermService mps=new MemberPermService();
		
		MemberBean member1 = new MemberBean();
		member1.setMember_account("normal");
		member1.setMember_pw("1");
		member1.setMember_sex_id(mss.get(1));
		member1.setMember_perm_id(mps.get(1));
		
		MemberBean member2 = new MemberBean();
		member2.setMember_account("company");
		member2.setMember_pw("1");
		member2.setMember_sex_id(mss.get(2));
		member2.setMember_perm_id(mps.get(2));
		
		MemberBean member3 = new MemberBean();
		member3.setMember_account("manager");
		member3.setMember_pw("1");
		member3.setMember_sex_id(mss.get(2));
		member3.setMember_perm_id(mps.get(3));
		MemberService ms = new MemberService();
		
		ms.save(member1);
		ms.save(member2);
		ms.save(member3);
	}
}
