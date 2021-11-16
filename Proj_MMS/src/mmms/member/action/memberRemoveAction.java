package mmms.member.action;

import java.util.Scanner;

import mmms.member.svc.MemberModifyService;
import mmms.member.util.consoleUtil;
import mmms.member.vo.member;

public class memberRemoveAction implements action {

	@Override
	public void execute(Scanner sc) throws Exception {
		
	
		consoleUtil cu=new consoleUtil();
		String name=cu.getName("수정함", sc);
		MemberModifyService memberModifyService=new MemberModifyService();
		
		
		member oldMember=memberModifyService.getOldMember(name);
		member updateMembe=cu.getUpdateMember(sc,oldMember);
		boolean ismodifySuccess =memberModifyService
		
		if(ismodifySuccess) {
			cu.printModifyFailMessage(updateMembe);
		} else {
			cu.printAddFailMessage(updateMembe);
		
	}
	
	

}
