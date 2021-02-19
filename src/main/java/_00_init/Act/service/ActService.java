package _00_init.Act.service;

import java.util.List;

import ACT.model.ACT;
import _00_init.Act.dao.ActDao;



public class ActService {
	ActDao dao;
	
	public ActService() {
		dao = new ActDao();
	}

	public void persist(ACT act) {
		dao.persist(act);
	}
	
	public Object save(ACT act) {
		return dao.save(act);
	}

//	public DOS load(int pk) {
//		return dao.load(pk);
//	}

	public ACT get(int pk) {
		return dao.get(pk);
	}

	public void updateAct(ACT e) {
		dao.updateAct(e);
	}

	public void delete(int pk) {
		dao.delete(pk);
	}

	public List<ACT> getAllAct() {
		return dao.getAllAct();
	}

	public void close() {
		dao.close();
	}

}
