package ACT.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import ACT.model.ACT;

public interface ACTService {

	void insertACT(ACT act_bean,Integer dos_id,Integer dos_sport_id,Integer act_status_id,Integer act_rule_id);//新增活動
	int allACT_Count() ;//計算所有活動數量
	List<ACT> getACT_Max(int start, int count) ;//取得一頁需要幾筆活動
	List<ACT> select(Integer memberid);//依據主辦方編號取得他的活動(忘記寫只能限定主辦方memerid==2)

	Integer getTime_to_status(String ACT_MAIN_OPENING,String ACT_MAIN_CLOSING);//新增活動後，與目前時間判斷，並寫入活動狀態，非dao
	Timestamp changeTS(String date) throws ParseException;//string to timestamp，非dao
}
