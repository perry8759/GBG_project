package DOS.service;

import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import DOS.model.DOS;
import DOS.model.DOS_PICTURE;
import DOS.model.DOS_SPORT;

public interface DOSService {

		DOS_SPORT select_sportid(int  dOS_sport_id);//找出該編號的運動種類
		int updateSportId(DOS_SPORT dos_sport);//更新該運動種類
		void insertSportId(DOS_SPORT dos_sport);//新增一筆運動種類
		void deleteSportId(Integer id);//刪除點選之編號的運動種類
		List<DOS_SPORT> select_sport();//列出所有的運動種類
		
		//場地圖像集動作
		List<DOS_PICTURE> selecallpic(int  dOSID);//找出該單一場地的所有照片
		List<DOS> selectpic();//無作用，之後刪除
		
		//場地資訊動作
		List<DOS> select();//列出所有場地資訊
		DOS selectid(int  dOSID);//查詢單一場地
		int updateid(DOS dos);//更新單一場地
		void insertid(DOS dos);//新增單一場地
		void deleteid(Integer id);//刪除單一場地
		
		Clob getStringclob(String s) throws SerialException, SQLException, IOException;//string to clob(非dao)
}
