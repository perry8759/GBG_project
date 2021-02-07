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
import util.HibernateUtils;


public interface DOSDao {
	List<DOS> select();//取得所有場地
	DOS selectid(int  dOSID);//取得編號場地
	List<DOS_PICTURE> selecallpic(int  dOSID);//取得該場地之所有圖片
}
