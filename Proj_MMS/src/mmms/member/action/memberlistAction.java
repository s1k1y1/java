package mmms.member.action;

import java.util.ArrayList;
import java.util.Scanner;

import mmms.member.svc.memberListService;
import mmms.member.util.consoleUtil;
import mmms.member.vo.member;

//7-2.회원정보 보기
public class memberlistAction implements action {

	@Override
	public void execute(Scanner sc) throws Exception {
		consoleUtil cu=new consoleUtil();
		memberListService memberlistservice=new memberListService();
		
		ArrayList<member> memberlist=memberlistservice.getMemberList();
		cu.printMemberList(memberlist);//
		
		
		
	}

}
