package mmms.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mmms.member.db.jdbcUtil;
import mmms.member.vo.member;

public class memberDAO {

	Connection con;

	public memberDAO(Connection con) {
		this.con = con;
	}

	// 1.회원등록
	public int insertNewMember(member newMember) {

		PreparedStatement pr = null;
		int insertCount = 0;

		try {
			String sql = "insert into mms_member values(mms_member_id_seq.nextval,?,?,?,?,?)";
			pr = con.prepareStatement(sql);
			pr.setString(1, newMember.getName());
			pr.setString(2, newMember.getAddr());
			pr.setString(3, newMember.getNation());
			pr.setString(4, newMember.getEmail());
			pr.setInt(5, newMember.getAge());
			insertCount = pr.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			jdbcUtil.colse(pr);
		}

		return insertCount;

	}

	// 2.회원목록 보기. 멤버클래스 덩어리를 순차적으로 배열에 넣겠다
	public ArrayList<member> selectMemberList() {

		ArrayList<member> memberlist = new ArrayList<member>();
		String sql = "SELECT * FROM mms_member";
		member mem = null;
		PreparedStatement pr = null;
		ResultSet re;
		try {
			pr = con.prepareStatement(sql);
			re = pr.executeQuery();
			while (re.next()) {
				String name = re.getString("name");
				String addr = re.getString("addr");
				String nation = re.getString("nation");
				String email = re.getString("email");
				int age = re.getInt("age");

				mem = new member(name, addr, nation, email, age);// 테이블에 저장된 값 입력

				memberlist.add(mem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.colse(pr);
		}
		return memberlist;
	}

	// 3.특정 회원 정보 보기
	public member selectOldMember(String name) {

		String sql = "SELECT * FROM mms_member  where name=?";
		member mem = null;
		PreparedStatement pr = null;
		ResultSet re;
		try {
			pr = con.prepareStatement(sql);
			pr.setString(1, name);
			re = pr.executeQuery();
			if (re.next()) {
				String addr = re.getString("addr");
				String nation = re.getString("nation");
				String email = re.getString("email");
				int age = re.getInt("age");

				mem = new member(name, addr, nation, email, age);// 테이블에 저장된 값 입력
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.colse(pr);
		}

		return mem;

	}

	// 4.회원정보 수정
	public int uqdatemember(member newMember) {

		PreparedStatement pr = null;

		String sql = "update mms_member ser addr=?,nation=?,email=?,age=? where name=?";
		try {
			pr = con.prepareStatement(sql);
			pr.setString(1, newMember.getAddr());
			pr.setString(2, newMember.getNation());
			pr.setString(3, newMember.getEmail());
			pr.setInt(4, newMember.getAge());
			pr.setString(5, newMember.getName());

			int count = pr.executeUpdate();
			if (count > 0) {
				System.out.println("uqdate Success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.colse(pr);
		}

		return 0;
	}

	// 5.회원정보 삭제
	public int deleteMember(String name) {
		
		int deleteCount=0;
		PreparedStatement pr = null;
		String sql = "update mms_member where name=?";
		
		try {
			pr = con.prepareStatement(sql);
			pr.setString(1, name);
			
			deleteCount=pr.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.colse(pr);
		}

		return deleteCount;
	}

}
