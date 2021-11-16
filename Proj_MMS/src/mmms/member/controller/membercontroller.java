package mmms.member.controller;

import java.util.Scanner;

import mmms.member.action.action;

//사용자 요청을 제한하는 내용
public class membercontroller {//액션에 들어있는 내용을 찾아가 실행하기 위한 메소드 

	public void processRequest(action action,Scanner sc){//파라미터의 다형성
		try{
		action.execute(sc);//스캐너 값에 들어있는 것을 실행시키겠다
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
