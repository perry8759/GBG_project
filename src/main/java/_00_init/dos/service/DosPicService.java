package _00_init.dos.service;

import DOS.model.DOS_PICTURE;
import _00_init.dos.dao.DosPicDao;



public class DosPicService {
	DosPicDao dao;
	
	public DosPicService() {
		dao = new DosPicDao();
	}
	
	public void persist(DOS_PICTURE pic) {
		dao.persist(pic);
	}
	
	public DOS_PICTURE get(int pk) {
		return dao.get(pk);
	}

	public void close() {
		dao.close();
	}

}
