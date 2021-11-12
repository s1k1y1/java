package mmms.member.dao;

import java.sql.Connection;

import mmms.member.vo.member;

public class memberDAO {

	
	Connection con;
	public memberDAO(Connection con) {
		this.con = con;
	}
	
	public int insertNewMember(member newMember) {
		
		String sql="insert~";
		
		
		return 0;		
		
	}

	
	

}
