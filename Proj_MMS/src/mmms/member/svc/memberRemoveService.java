package mmms.member.svc;

import java.sql.Connection;

import mmms.member.dao.memberDAO;
import mmms.member.db.jdbcUtil;

public class memberRemoveService {
	
	public boolean removeMember(String name) {
		

		Connection con = jdbcUtil.getConnet();// 테이블 연결
		memberDAO dao = new memberDAO(con);

		int deleteCount = dao.deleteMember(name);

		boolean isdeleteSuccess = false;
		if (deleteCount > 0) {
			isdeleteSuccess = true;
			jdbcUtil.commit(con);
		} else {
			jdbcUtil.rollback(con);
		}
		jdbcUtil.colse(con);

		return isdeleteSuccess;
		
		
	}

}
