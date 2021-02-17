package ACT.service;

import java.util.List;

import ACT.dao.ActDao;
import ACT.model.ActBean;



public class ActService {
	ActDao dao;
	
	public ActService() {
		dao = new ActDao();
	}

	public void persist(ActBean act) {
		dao.persist(act);
	}
	
	public Object save(ActBean act) {
		return dao.save(act);
	}

//	public DOS load(int pk) {
//		return dao.load(pk);
//	}

	public ActBean get(int pk) {
		return dao.get(pk);
	}

	public void updateAct(ActBean e) {
		dao.updateAct(e);
	}

	public void delete(int pk) {
		dao.delete(pk);
	}

	public List<ActBean> getAllAct() {
		return dao.getAllAct();
	}

	public void close() {
		dao.close();
	}


}
