package _00_init.Act;

import ACT.model.ACT_RFORM;
import _00_init.Act.service.ActRformService;

public class ActRformFakeDataCreate {
	public static void initVal() {
		ACT_RFORM act_rform1=new ACT_RFORM(null,null);
	    ACT_RFORM act_rform2=new ACT_RFORM(null,null);
	    ACT_RFORM act_rform3=new ACT_RFORM(null,null);
	    ACT_RFORM act_rform4=new ACT_RFORM(null,null);

	    ActRformService ars=new ActRformService();
	    ars.persist(act_rform1);
	    ars.persist(act_rform2);
	    ars.persist(act_rform3);
	    ars.persist(act_rform4);
		
	}
}
