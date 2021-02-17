package ACT.service;

import java.util.List;

import ACT.dao.ActQesDao;
import ACT.model.ACT_QES;

public class ActQesService {
	ActQesDao dao;
	
	public ActQesService() {
		dao = new ActQesDao();
	}

	public void persist(ACT_QES act) {
		dao.persist(act);
	}
	
	public Object save(ACT_QES act) {
		return dao.save(act);
	}

//	public DOS load(int pk) {
//		return dao.load(pk);
//	}

	public ACT_QES get(int pk) {
		return dao.get(pk);
	}

	public void updateQes(ACT_QES e) {
		dao.updateQes(e);
	}

	public void delete(int pk) {
		dao.delete(pk);
	}

	public List<ACT_QES> getAllQes() {
		return dao.getAllQes();
	}

	public void close() {
		dao.close();
	}

}
