package DOS.service;

import java.util.List;

import DOS.model.DOS;
import DOS.model.DOS_PICTURE;

public interface DOSService {

	
		List<DOS> select();
		DOS selectid(int  dOSID);
		List<DOS_PICTURE> selecallpic(int  dOSID);
		List<DOS> selectpic();

}
