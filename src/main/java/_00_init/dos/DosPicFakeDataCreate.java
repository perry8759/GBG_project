package _00_init.dos;

import DOS.model.DOS_PICTURE;
import _00_init.dos.service.DosPicService;

public class DosPicFakeDataCreate {
	public static void initVal() {
		DOS_PICTURE pic1=new DOS_PICTURE(null,null);
		DOS_PICTURE pic2=new DOS_PICTURE(null,null);
		DOS_PICTURE pic3=new DOS_PICTURE(null,null);
		DOS_PICTURE pic4=new DOS_PICTURE(null,null);
		
		DosPicService dps=new DosPicService();
		dps.persist(pic1);
		dps.persist(pic2);
		dps.persist(pic3);
		dps.persist(pic4);
	}
}
