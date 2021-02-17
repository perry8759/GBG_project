package _00_init.Act.service;

import ACT.model.ACT_STATUS;
import _00_init.Act.dao.ActStatusDao;

public class ActStatusService {
	ActStatusDao dao;
	
	public ActStatusService() {
		dao = new ActStatusDao();
	}
	
	public ACT_STATUS get(int pk) {
		return dao.get(pk);
	}
}
