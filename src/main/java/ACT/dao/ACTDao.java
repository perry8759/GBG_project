package ACT.dao;

import java.util.List;

import ACT.model.ACT;
import ACT.model.ACT_QES;
import ACT.model.ACT_RFORM;
import ACT.model.ACT_RULE;
import ACT.model.ACT_STATUS;
//ֱ�Ӳ鿴ACTService
public interface ACTDao {

	void insertACT(ACT act_bean,Integer dos_id,Integer dos_sport_id,Integer act_status_id,Integer act_rule_id);
	int allACT_Count() ;
	List<ACT> getACT_Max(int start, int count) ;
	List<ACT> select(Integer memberid);
//	=========
	//--------QesAct
	void persist(ACT act);
	Object save(ACT act);
	ACT get(int pk);
	void update(ACT bean);
	public void delete(int pk);
	List<ACT> getAct_All();
	//--------Qes
	void persist(ACT_QES qes);
	Object save(ACT_QES qes);
	ACT_QES getQesById(int pk);
	void updateQes(ACT_QES qes);
	void deleteQes(int pk);
	//--------Form
	void persist(ACT_RFORM form);
	Object save(ACT_RFORM form);
	ACT_RFORM getFormById(int pk);
	void update(ACT_RFORM form);
	void deleteForm(int pk);
	
	ACT_STATUS getStatusById(Integer act_status_id);
	ACT_RULE getRuleById(Integer act_rule_id);
}
