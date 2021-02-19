package ACT.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import ACT.model.ACT;

public interface ACTService {

	void insertACT(ACT act_bean,Integer dos_id,Integer dos_sport_id,Integer act_status_id,Integer act_rule_id);//�������
	int allACT_Count() ;//Ӌ�����л�Ӕ���
	List<ACT> getACT_Max(int start, int count) ;//ȡ��һ���Ҫ�׹P���
	List<ACT> select(Integer memberid);//�������k����̖ȡ�����Ļ��(��ӛ��ֻ���޶����k��memerid==2)

	Integer getTime_to_status(String ACT_MAIN_OPENING,String ACT_MAIN_CLOSING);//��������ᣬ�cĿǰ�r�g�Д࣬�K�����Ӡ�B����dao
	Timestamp changeTS(String date) throws ParseException;//string to timestamp����dao
}
