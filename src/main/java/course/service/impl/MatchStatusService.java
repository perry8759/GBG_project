package course.service.impl;

import course.dao.MatchStatusDaoInter;
import course.dao.impl.MatchStatusDao;
import course.model.MatchStatusBean;
import course.service.MatchStatusServiceI;

public class MatchStatusService implements MatchStatusServiceI {
	MatchStatusDaoInter dao;
	
	public MatchStatusService() {
		dao = new MatchStatusDao();
	}

	@Override
	public MatchStatusBean get(int pk) {
		return dao.get(pk);
	}

	@Override
	public void close() {
		dao.close();
	}

}
