package mmms.member.svc;

import java.sql.Connection;
import java.util.ArrayList;

import mmms.member.dao.memberDAO;
import mmms.member.db.jdbcUtil;
import mmms.member.vo.member;

public class memberListService {
	
	public ArrayList<member> getMemberList(){
		
		Connection con=jdbcUtil.getConnet();//객체생성이 아닌 변수에 메소드 넣어줘서 이용하기
		memberDAO dao=new memberDAO(con);
		ArrayList<member> memberlist=dao.selectMemberList();

		return memberlist;
		
	}
}
