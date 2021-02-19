package _00_init.Act;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import ACT.model.ACT_QES;
import ACT.model.ACT_RFORM;
import ACT.model.ACT;
import ACT.service.ActQesService;
import ACT.service.ActRformService;
import ACT.service.ActRuleService;
import ACT.service.ActService;
import ACT.service.ActStatusService;
import _00_init.dos.service.DosService;
import _00_init.dos.service.DosSportService;


public class ActFakeDataCreate {
	public static void initVal() {
		ACT act1=new ACT();
		act1.setMEMBER_ID(1);  //(主辦者)沒有設外鍵，因此這樣給會員id就好
		act1.setDos_id(new DosService().get(1));
		act1.setACT_TITLE("比賽一");
		act1.setDos_sport(new DosSportService().get(1));
		act1.setAct_status(new ActStatusService().get(1));
		act1.setAct_rule(new ActRuleService().get(1));
		
		ACT act2=new ACT();
		act2.setMEMBER_ID(2);
		act2.setDos_id(new DosService().get(2));
		act2.setACT_TITLE("比賽二");
		act2.setDos_sport(new DosSportService().get(2));
		act2.setAct_status(new ActStatusService().get(2));
		act2.setAct_rule(new ActRuleService().get(2));
		
		//多個文件
		ActRformService ars=new ActRformService();
	    Set<ACT_RFORM> set_form1 = new HashSet<>(Arrays.asList(ars.get(1),ars.get(2)));
	    Set<ACT_RFORM> set_form2 = new HashSet<>(Arrays.asList(ars.get(3),ars.get(4)));
	    act1.setAct_rform(set_form1);
	    act2.setAct_rform(set_form2);
	    
		//多個問答
	    ActQesService aqs=new ActQesService();
	    Set<ACT_QES> set_qes1 = new HashSet<>(Arrays.asList(aqs.get(1),aqs.get(2)));
	    Set<ACT_QES> set_qes2 = new HashSet<>(Arrays.asList(aqs.get(3),aqs.get(4)));
	    act1.setAct_qes(set_qes1);
	    act2.setAct_qes(set_qes2);
	    
		ActService as=new ActService();
		as.save(act1);
		as.save(act2);
	}
}
