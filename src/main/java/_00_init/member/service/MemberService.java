package _00_init.member.service;

import _00_init.member.dao.MemberDao;
import member.model.MemberBean;



public class MemberService {
	MemberDao dao;
	
	public MemberService() {
		dao = new MemberDao();
	}

	public Object save(MemberBean emp) {
		return dao.save(emp);
	}

//	public MemberBean load(int pk) {
//		return dao.load(pk);
//	}

//	public MemberBean get(int pk) {
//		return dao.get(pk);
//	}
//
//	public void updateEmployee(MemberBean e) {
//		dao.updateEmployee(e);
//		
//	}
//
//	public void delete(int pk) {
//		dao.delete(pk);
//	}
//
//	public List<MemberBean> getAllEmployees() {
//		return dao.getAllEmployees();
//	}
//
//	public void close() {
//		dao.close();
//	}
//
//	public void persist(MemberBean emp) {
//		dao.persist(emp);
//	}
//
//	public MemberBean findEmployeeByemployeeId(String id) {
//		return dao.findEmployeeByemployeeId(id);
//	}

}
