package _00_init.Act;

import ACT.model.ACT_QES;
import _00_init.Act.service.ActQesService;

public class ActQesFakeDataCreate {
	public static void initVal() {
	    ACT_QES act_qes1=new ACT_QES(null,1,null);
	    ACT_QES act_qes2=new ACT_QES(null,1,null);
	    ACT_QES act_qes3=new ACT_QES(null,1,null);
	    ACT_QES act_qes4=new ACT_QES(null,1,null);

	    ActQesService aqs=new ActQesService();
	    aqs.persist(act_qes1);
	    aqs.persist(act_qes2);
	    aqs.persist(act_qes3);
	    aqs.persist(act_qes4);
		
	}
}
