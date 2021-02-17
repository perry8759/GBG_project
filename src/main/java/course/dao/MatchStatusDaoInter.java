package course.dao;

import course.model.MatchStatusBean;

public interface MatchStatusDaoInter {

	// 經由Session介面的get()查詢資料庫內的紀錄
	MatchStatusBean get(int pk);

	void close();

}