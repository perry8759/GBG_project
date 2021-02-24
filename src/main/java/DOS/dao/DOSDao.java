//dao(盡可能只寫sql資料)
//hibernate需有交易,web-inf需有lib,bind必備,jstl1.2以上需引號
package DOS.dao;

import java.util.List;
import java.util.Vector;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import DOS.model.DOS;
import DOS.model.DOS_PICTURE;
import DOS.model.DOS_SPORT;
import util.HibernateUtils;

//請查看DOSService說明
public interface DOSDao {
	List<DOS> select();
	List<DOS_SPORT> select_sport();
	DOS selectid(int  dOSID);
	List<DOS_PICTURE> selecallpic(int  dOSID);
	int updateid(DOS dos);
	void insertid(DOS dos);
	void deleteid(Integer id);
	
	DOS_SPORT select_sportid(int  dOS_sport_id);
	int updateSportId(DOS_SPORT dos_sport);
	void insertSportId(DOS_SPORT dos_sport);
	void deleteSportId(Integer id);
	
	DOS get(Integer dos_id);
	DOS_SPORT getSportById(Integer dos_sport_id);
}
