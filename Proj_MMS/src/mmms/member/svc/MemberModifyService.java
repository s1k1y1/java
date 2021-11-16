package mmms.member.svc;

import java.sql.Connection;

import mmms.member.dao.memberDAO;
import mmms.member.db.jdbcUtil;
import mmms.member.vo.member;

public class MemberModifyService {
	public boolean modifyMember(member uqdatemem) {//정상적으로 업데이트가 이루어졌는지 확인하고 커밋하거나 롤백하는 메소드

		Connection con = jdbcUtil.getConnet();// 테이블 연결
		memberDAO dao = new memberDAO(con);

		int updatecount = dao.uqdatemember(uqdatemem);

		boolean ismodifySuccess = false;
		if (updatecount > 0) {
			ismodifySuccess = true;
			jdbcUtil.commit(con);
		} else {
			jdbcUtil.rollback(con);
		}
		jdbcUtil.colse(con);

		return ismodifySuccess;
	}

	public member getOldMember(String name) {//수정할 이름 불러올때 기존 멤버에 대한 정보 가져오기
		
		Connection con = jdbcUtil.getConnet();// 테이블 연결
		memberDAO dao = new memberDAO(con);
		member mem=dao.selectOldMember(name);
		
		jdbcUtil.colse(con);
		return mem;//리턴은 반환타입과 같은 타입이나 주소값이 들어있는 변수

	}

}
