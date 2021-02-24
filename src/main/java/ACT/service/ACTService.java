package ACT.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import ACT.model.ACT;
import ACT.model.ACT_QES;
import ACT.model.ACT_RFORM;

public interface ACTService {
	ACT get(int pk) ;
	void update(ACT act,Integer dos_id,Integer dos_sport_id,Integer act_status_id,Integer act_rule_id);
	void delete(int pk) ;
	List<ACT> getAct_All() ;
	
	void persist(ACT_QES qes);
	ACT_QES getQesById(int pk);
	void update(ACT_QES qes);
	void deleteQes(int pk);
	int insertQes(int actid, ACT_QES qes);
	
	Object save(ACT_RFORM form);
	ACT_RFORM getFormById(int pk);
//==================================
	void insertACT(ACT act_bean,Integer dos_id,Integer dos_sport_id,Integer act_status_id,Integer act_rule_id);//�������
	int allACT_Count() ;//Ӌ�����л�Ӕ���
	List<ACT> getACT_Max(int start, int count) ;//ȡ��һ���Ҫ�׹P���
	List<ACT> select(Integer memberid);//�������k����̖ȡ�����Ļ��(��ӛ��ֻ���޶����k��memerid==2)

	Integer getTime_to_status(String ACT_MAIN_OPENING,String ACT_MAIN_CLOSING);//��������ᣬ�cĿǰ�r�g�Д࣬�K�����Ӡ�B����dao
	Integer getTime_to_status(ACT act);
	Timestamp changeTS(String date) throws ParseException;//string to timestamp����dao
}
