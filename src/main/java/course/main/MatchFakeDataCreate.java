package course.main;

import ACT.service.ActService;
import course.model.MatchBean;
import course.service.MatchServiceI;
import course.service.MatchStatusServiceI;
import course.service.impl.MatchService;
import course.service.impl.MatchStatusService;


public class MatchFakeDataCreate {
	public static void main(String args[]) {
		ActService as=new ActService();
		MatchStatusServiceI mss=new MatchStatusService();
		
		MatchBean match1=new MatchBean();
		match1.setAct_id(as.get(1));
		match1.setMatch_status_id(mss.get(1));
		match1.setMatch_seq(1);
		
		MatchBean match2=new MatchBean();
		match2.setAct_id(as.get(1));
		match2.setMatch_status_id(mss.get(2));
		match2.setMatch_seq(2);
		
		MatchServiceI ms=new MatchService();
		ms.save(match1);
		ms.save(match2);
	}
}
