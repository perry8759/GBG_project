package ACT.service;

import ACT.dao.ActRuleDao;
import ACT.model.ACT_RULE;

public class ActRuleService {
	ActRuleDao dao;
	
	public ActRuleService() {
		dao = new ActRuleDao();
	}
	
	public ACT_RULE get(int pk) {
		return dao.get(pk);
	}
}
