package ACT.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import ACT.model.ACT;
//直接查看ACTService
public interface ACTDao {

	void insertACT(ACT act_bean,Integer dos_id,Integer dos_sport_id,Integer act_status_id,Integer act_rule_id);
	int allACT_Count() ;
	List<ACT> getACT_Max(int start, int count) ;
	List<ACT> select(Integer memberid);
}
