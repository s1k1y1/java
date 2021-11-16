package mmms.member.action;

import java.util.Scanner;

import mmms.member.svc.memberAddService;
import mmms.member.util.consoleUtil;
import mmms.member.vo.member;

public class memberAddAction implements action {

	@Override
	public void execute(Scanner sc) throws Exception {//콘솔유틸과 에드서비스를 구현하기 위한 클래스
		consoleUtil c=new consoleUtil();
		member newMember=c.getMember(sc);//회원등록 입력 완성내용
		
		memberAddService memberAddser=new memberAddService();
		
		memberAddser.addMember(newMember);//boolean값 출력
		boolean isAddSuccess=memberAddser.addMember(newMember);
		if(isAddSuccess) {
			c.printAddSuccessMessage(newMember);
		} else {
			c.printAddSuccessMessage(newMember);
		}
		
		

	}

}
