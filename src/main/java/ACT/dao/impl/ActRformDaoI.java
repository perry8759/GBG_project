package ACT.dao.impl;

import java.util.List;

import ACT.model.ACT_RFORM;

public interface ActRformDaoI {

	void persist(ACT_RFORM form);

	Object save(ACT_RFORM form);

	// 經由Session介面的get()查詢資料庫內的紀錄
	ACT_RFORM get(int pk);

	//	// 更新紀錄
	void update(ACT_RFORM form);

	// 刪除紀錄
	void delete(int pk);

	//	// 查詢所有紀錄
	List<ACT_RFORM> getAllForms();

	void close();

}