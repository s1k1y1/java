package mmms.member.svc;

import java.sql.Connection;

import mmms.member.dao.memberDAO;
import mmms.member.db.jdbcUtil;
import mmms.member.vo.member;

//비지니스 계층으로 데이터값을 연산해줘 서블렛으로 가는 거 위로 보내주는 거
public class memberAddService {

	public boolean addMember(member newMember) throws Exception{
		
		boolean isInsertSuccess=false;
		Connection con=jdbcUtil.getConnet();
		memberDAO memberDA=new memberDAO(con);
		
		int insertcount=memberDA.insertNewMember(newMember);
		if(insertcount>0) {
			jdbcUtil.commit(con);
			isInsertSuccess=true;
		} else {
			jdbcUtil.rollback(con);
		}
		//commit();
		//rollback();
		return isInsertSuccess;

	}

	
	
	
}
