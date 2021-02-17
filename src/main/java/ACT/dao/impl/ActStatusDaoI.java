package ACT.dao.impl;

import ACT.model.ACT_STATUS;

public interface ActStatusDaoI {

	// 經由Session介面的get()查詢資料庫內的紀錄
	ACT_STATUS get(int pk);

	void close();

}