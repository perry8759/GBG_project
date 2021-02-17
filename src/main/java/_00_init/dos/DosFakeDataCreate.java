package _00_init.dos;

import java.util.HashSet;
import java.util.Set;

import DOS.model.DOS;
import DOS.model.DOS_PICTURE;
import _00_init.dos.service.DosPicService;
import _00_init.dos.service.DosService;
import _00_init.dos.service.DosSportService;

public class DosFakeDataCreate {
	public static void initVal() {
		DosSportService dss=new DosSportService();
		DosPicService dps=new DosPicService();
		
		DOS dos1 = new DOS();
		dos1.setDOS_NAME("場地一");
		dos1.setDOS_ADDR("地址");
		dos1.setDos_sport_id(dss.get(1));
		
		Set<DOS_PICTURE> dos_picture1=new HashSet<>();
		dos_picture1.add(dps.get(1));
		dos_picture1.add(dps.get(2));
		dos1.setDos_picture(dos_picture1);

//		==============
		DOS dos2 = new DOS();
		dos2.setDOS_NAME("場地二");
		dos2.setDOS_ADDR("地址");
		dos2.setDos_sport_id(dss.get(2));
		
		Set<DOS_PICTURE> dos_picture2=new HashSet<>();
		dos_picture2.add(dps.get(3));
		dos_picture2.add(dps.get(4));
		dos2.setDos_picture(dos_picture2);
		
		DosService ds = new DosService();
//		ds.persist(dos1);
//		ds.persist(dos2);
		ds.save(dos1);  //這邊不能用persist
		ds.save(dos2);
	}
}
