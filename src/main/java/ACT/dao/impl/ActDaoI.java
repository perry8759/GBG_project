package ACT.dao.impl;

import java.util.List;

import ACT.model.ACT;

public interface ActDaoI {

	void persist(ACT act);

	Object save(ACT act);

	// 經由Session介面的get()查詢資料庫內的紀錄
	ACT get(int pk);

	//	// 更新紀錄
	void updateAct(ACT act);

	// 刪除紀錄
	void delete(int pk);

	//	// 查詢所有紀錄
	List<ACT> getAllAct();

	void close();

}