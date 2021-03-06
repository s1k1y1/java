package mmms.member.util;
import java.lang.reflect.Member;
import java.util.ArrayList;
//사용자 입력 , 출력
import java.util.Scanner;

import mmms.member.vo.member;

//키보드 입력
public class consoleUtil {
	
	
	
	
    
	public member getMember(Scanner sc) {//1.회원등록
		System.out.println("등록할 회원정보를 입력하세요?");
		System.out.println("이름: ");
		String name=sc.next();
		
		System.out.println("등록할 회원정보를 입력하세요?");
		System.out.println("주소: ");
		String addr=sc.next();
		

		System.out.println("이메일: ");
		String email=sc.next();
		
		System.out.println("국가: ");
		String nation=sc.next();
		
		System.out.println("나이: ");
		int age=sc.nextInt();
		
		return new member(name,addr,email,nation,age);
		
	}
		
		//키보드로 입력받는 내용을 member에서 가져와서 여기다가 써라? 아님 반대
		
	public void printAddSuccessMessage(member newMember) {
		System.out.println(newMember.getName() + " 회원 정보 추가 성공");
	}
	
	public void printAddFailMessage(member newMember) {
		System.out.println(newMember.getName() + " 회원 정보 추가 실패");
	}
		
	
	
	
	
	
	//2.배열에 들어있는 값을 출력하자
	public void printMemberList(ArrayList<member> memberlist) {
		for(int i=0; i<memberlist.size(); i++) {
			System.out.println(memberlist.get(i));
		}
	}
	
	
	
	//3.update
	public String getName(String msgKind, Scanner sc) {//수정할 회원 정보 기입 형식
		System.out.println(msgKind+"회원이름을 입력하세요");
		System.out.println("회원이름: ");
		return sc.next();
	}

	public member getUpdateMember(Scanner sc, member oldMember) {//수정할 정보 기입 형식
		
		System.out.println("이전 주소: "+ oldMember.getAddr());
		System.out.println("수정할 주소: ");
		String addr=sc.next();
		
		System.out.println("이전 국가: "+ oldMember.getNation());
		System.out.println("수정할 국가: ");
		String nation=sc.next();
		
		System.out.println("이전 이메일: "+ oldMember.getEmail());
		System.out.println("수정할 이메일: ");
		String email=sc.next();
		
		System.out.println("이전 나이: "+ oldMember.getAge());
		System.out.println("수정할 나이: ");
		int age=sc.nextInt();
		
		
		return new member(oldMember.getName(),addr,nation,email,age);	

	}

	public void printModifySuccessMessage(member updateMember) {
		System.out.println(updateMember.getName() + " 회원 정보 수정 성공.");	
	}
	
	public void printModifyFailMessage(member updateMember) {	
		System.out.println(updateMember.getName() + " 회원 정보 수정 실패.");	
	}

	
	//4.삭제
	
	
	public void printRemoveSuccessMessage(String name) {	
		System.out.println(name + " 회원의 정보 삭제 성공.");
	}

	public void printRemoveFailMessage(String name) {	
		System.out.println(name + " 회원의 정보 삭제 실패.");
	}	
	
	
}
