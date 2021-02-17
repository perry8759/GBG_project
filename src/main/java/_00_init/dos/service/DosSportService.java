package _00_init.dos.service;

import DOS.model.DOS_SPORT;
import _00_init.dos.dao.DosSportDao;



public class DosSportService {
	DosSportDao dao;
	
	public DosSportService() {
		dao = new DosSportDao();
	}

	public DOS_SPORT get(int pk) {
		return dao.get(pk);
	}

	public void close() {
		dao.close();
	}

}
