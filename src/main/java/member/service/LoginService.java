package member.service;

import java.sql.SQLException;

import member.model.MemberBean;



public interface LoginService {
	MemberBean checkIdPassword(String userId, String password) throws SQLException;
}
