package ACT.dao.impl;

import java.util.List;

import ACT.model.ACT_QES;

public interface ActQesDaoI {

	void persist(ACT_QES qes);

	Object save(ACT_QES qes);

	// 經由Session介面的get()查詢資料庫內的紀錄
	ACT_QES get(int pk);

	//	// 更新紀錄
	void updateQes(ACT_QES qes);

	// 刪除紀錄
	void delete(int pk);

	//	// 查詢所有紀錄
	List<ACT_QES> getAllQes();

	void close();

}