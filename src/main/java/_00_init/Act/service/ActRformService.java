package _00_init.Act.service;

import java.util.List;

import ACT.model.ACT_RFORM;
import _00_init.Act.dao.ActRformDao;



public class ActRformService {
	ActRformDao dao;
	
	public ActRformService() {
		dao = new ActRformDao();
	}

	public void persist(ACT_RFORM form) {
		dao.persist(form);
	}
	
	public Object save(ACT_RFORM form) {
		return dao.save(form);
	}

//	public ACT_RFORM load(int pk) {
//		return dao.load(pk);
//	}

	public ACT_RFORM get(int pk) {
		return dao.get(pk);
	}

	public void update(ACT_RFORM form) {
		dao.update(form);
	}

	public void delete(int pk) {
		dao.delete(pk);
	}

	public List<ACT_RFORM> getAllForms() {
		return dao.getAllForms();
	}

	public void close() {
		dao.close();
	}

}
