package _00_init.Act.service;

import ACT.model.ACT_RULE;
import _00_init.Act.dao.ActRuleDao;

public class ActRuleService {
	ActRuleDao dao;
	
	public ActRuleService() {
		dao = new ActRuleDao();
	}
	
	public ACT_RULE get(int pk) {
		return dao.get(pk);
	}
}
