package _00_init.Act;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import ACT.model.ACT;
import ACT.model.ACT_QES;
import ACT.model.ACT_RFORM;
import ACT.service.ACTService;
import ACT.service.impl.ACTServiceImpl;
import DOS.service.impl.DOSServiceImpl;


public class ActFakeDataCreate {
	public static void initVal() {
		ACT act1=new ACT();
		act1.setMEMBER_ID(1);  //(主辦者)沒有設外鍵，因此這樣給會員id就好
		act1.setDos_id(new DOSServiceImpl().selectid(1));
		act1.setACT_TITLE("比賽一");
		
		ACT act2=new ACT();
		act2.setMEMBER_ID(2);
		act2.setDos_id(new DOSServiceImpl().selectid(2));
		act2.setACT_TITLE("比賽二");
		
		 ACTService service=new ACTServiceImpl();
		 
		//多個文件
		ACT_RFORM act_rform1=new ACT_RFORM(null);
		ACT_RFORM act_rform2=new ACT_RFORM(null);
		service.save(act_rform1);
	    service.save(act_rform2);
	    
	    Set<ACT_RFORM> set_form1 = new HashSet<>(Arrays.asList(service.getFormById(1),service.getFormById(2)));
	    act1.setAct_rform(set_form1);
	    
		//多個問答
	    ACT_QES act_qes1=new ACT_QES(null,1,null);
	    ACT_QES act_qes2=new ACT_QES(null,1,null);
	    ACT_QES act_qes3=new ACT_QES(null,1,null);
	    ACT_QES act_qes4=new ACT_QES(null,1,null);
	    service.insertQes(act1.getACT_ID(), act_qes1);
	    service.insertQes(act1.getACT_ID(), act_qes2);
	    service.insertQes(act2.getACT_ID(), act_qes3);
	    service.insertQes(act2.getACT_ID(), act_qes4);
	    
	    service.insertACT(act1, 1, 1, 1, 1);
	    service.insertACT(act1, 2, 2, 2, 2);
	}
}
