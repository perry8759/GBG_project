package course.service.impl;

import java.util.List;

import course.dao.MatchDaoInter;
import course.dao.impl.MatchDao;
import course.model.MatchBean;
import course.service.MatchServiceI;

public class MatchService implements MatchServiceI {
	MatchDaoInter dao;
	
	public MatchService() {
		dao = new MatchDao();
	}

	@Override
	public void persist(MatchBean match) {
		dao.persist(match);
	}
	
	@Override
	public Object save(MatchBean match) {
		return dao.save(match);
	}

//	public DOS load(int pk) {
//		return dao.load(pk);
//	}

	@Override
	public MatchBean get(int pk) {
		return dao.get(pk);
	}

	@Override
	public void update(MatchBean e) {
		dao.update(e);
	}

	@Override
	public void delete(int pk) {
		dao.delete(pk);
	}

	@Override
	public List<MatchBean> getAllMatch() {
		return dao.getAllMatch();
	}

	@Override
	public void close() {
		dao.close();
	}

}
