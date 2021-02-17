package ACT.dao.impl;

import ACT.model.ACT_RULE;

public interface ActRuleDaoI {

	// 經由Session介面的get()查詢資料庫內的紀錄
	ACT_RULE get(int pk);

	void close();

}