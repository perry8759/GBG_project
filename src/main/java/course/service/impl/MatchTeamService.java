package course.service.impl;

import course.dao.impl.MatchTeamDao;
import course.model.MatchTeamBean;

public class MatchTeamService {
	MatchTeamDao dao;
	
	public MatchTeamService() {
		dao = new MatchTeamDao();
	}


	public void persist(MatchTeamBean match) {
		dao.persist(match);
	}

	public Object save(MatchTeamBean match) {
		return dao.save(match);
	}

	public MatchTeamBean get(int pk) {
		return dao.get(pk);
	}

	public void update(MatchTeamBean e) {
		dao.update(e);
	}

	public void close() {
		dao.close();
	}

}
