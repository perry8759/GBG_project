package _00_init.dos.service;

import java.util.List;

import DOS.model.DOS;
import _00_init.dos.dao.DosDao;



public class DosService {
	DosDao dao;
	
	public DosService() {
		dao = new DosDao();
	}

	public void persist(DOS dos) {
		dao.persist(dos);
	}
	
	public Object save(DOS dos) {
		return dao.save(dos);
	}

//	public DOS load(int pk) {
//		return dao.load(pk);
//	}

	public DOS get(int pk) {
		return dao.get(pk);
	}

	public void updateDos(DOS e) {
		dao.updateDos(e);
	}

	public void delete(int pk) {
		dao.delete(pk);
	}

	public List<DOS> getAllDOS() {
		return dao.getAllDOS();
	}

	public void close() {
		dao.close();
	}

	public DOS findDOSByDOSId(String id) {
		return dao.findDOSByDOSId(id);
	}

}
