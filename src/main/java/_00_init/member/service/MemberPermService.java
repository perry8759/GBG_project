package _00_init.member.service;


import _00_init.member.dao.MemberPermDao;
import member.model.MemberPermBean;



public class MemberPermService {
	MemberPermDao dao;
	
	public MemberPermService() {
		dao = new MemberPermDao();
	}

	public MemberPermBean get(int pk) {
		return dao.get(pk);
	}

	public void close() {
		dao.close();
	}


}
