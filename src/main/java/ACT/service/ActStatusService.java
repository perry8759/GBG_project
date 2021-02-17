package ACT.service;

import ACT.dao.ActStatusDao;
import ACT.model.ACT_STATUS;


public class ActStatusService {
	ActStatusDao dao;
	
	public ActStatusService() {
		dao = new ActStatusDao();
	}
	
	public ACT_STATUS get(int pk) {
		return dao.get(pk);
	}
}
