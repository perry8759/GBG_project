package ACT.dao.impl;

import java.util.List;

import ACT.model.ActBean;

public interface ActDaoI {

	void persist(ActBean act);

	Object save(ActBean act);

	// 經由Session介面的get()查詢資料庫內的紀錄
	ActBean get(int pk);

	//	// 更新紀錄
	void updateAct(ActBean act);

	// 刪除紀錄
	void delete(int pk);

	//	// 查詢所有紀錄
	List<ActBean> getAllAct();

	void close();

}