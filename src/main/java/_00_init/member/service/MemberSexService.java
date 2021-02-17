package _00_init.member.service;


import _00_init.member.dao.MemberSexDao;
import member.model.MemberSexBean;



public class MemberSexService {
	MemberSexDao dao;
	
	public MemberSexService() {
		dao = new MemberSexDao();
	}

	public MemberSexBean get(int pk) {
		return dao.get(pk);
	}

	public void close() {
		dao.close();
	}


}
