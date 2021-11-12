package mmms.member.controller;

import java.util.Scanner;

import mmms.member.action.action;

//사용자 요청을 제한하는 내용
public class membercontrolller {

	public void processRequest(action action,Scanner sc){//파라미터의 다형성
		try{
		action.execute(sc);//스캐너 값에 들어있는 것을 실행시키겠다
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
