package course.dao;

import java.util.List;

import course.model.MatchBean;

public interface MatchDaoInter {

	void persist(MatchBean bean);

	Object save(MatchBean bean);

	// 經由Session介面的get()查詢資料庫內的紀錄
	MatchBean get(int pk);

	// 更新紀錄
	void update(MatchBean newData);

	// 刪除紀錄
	void delete(int pk);

	//	// 查詢所有紀錄
	List<MatchBean> getAllMatch();

	void close();

}