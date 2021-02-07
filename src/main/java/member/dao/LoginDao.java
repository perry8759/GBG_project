package member.dao;

import java.sql.SQLException;


import member.model.MemberBean;

public interface LoginDao {
	public MemberBean checkIdPassword(String userId, String password) throws SQLException;
}
