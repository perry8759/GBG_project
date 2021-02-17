package course.service.impl;

import course.dao.impl.RegStatusDao;
import course.model.RegStatusBean;

public class RegStatusService {
	RegStatusDao dao;
	
	public RegStatusService() {
		dao = new RegStatusDao();
	}

	public RegStatusBean get(int pk) {
		return dao.get(pk);
	}

	public void close() {
		dao.close();
	}

}
