package mmms.member.ui;

import java.util.Scanner;

import mmms.member.action.MemberModifyAction;
import mmms.member.action.action;
import mmms.member.action.memberAddAction;
import mmms.member.action.memberRemoveAction;
import mmms.member.action.memberlistAction;
import mmms.member.controller.membercontroller;
import mmms.member.svc.memberListService;

public class memberUI {

	public static void main(String[] args) {
		
	
	boolean isStop = false;
	membercontroller memberController = new membercontroller();
	Scanner sc = new Scanner(System.in);
	
	do {

		System.out.println("1.회원등록");
		System.out.println("2.회원목록보기");
		System.out.println("3.회원정보수정");
		System.out.println("4.회원정보삭제");
		System.out.println("5.프로그램 종료");
		
		int menu=sc.nextInt();
		action action=null;
		
		
		switch(menu) {
		case 1:
			action=new memberAddAction();
			break;	
			
		case 2:
			action=new memberlistAction();
			break;	
		
		case 3:
			action=new MemberModifyAction();
			break;
			
		case 4:
			action=new memberRemoveAction();
			break;
			
		case 5:
			System.out.println("program close");
			break;
			
		default:
			break;	
		}
		
		if(action !=null) {
			memberController.processRequest(action, sc);
		}

	} while (!isStop);

	
	
	
	
	}
}
