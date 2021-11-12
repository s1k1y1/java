package p00.stored_procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class procedure_test {
	
	Connection conn;
	PreparedStatement p ;
	colla

	static {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	}

	public void Connect() {
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			conn=DriverManager.getConnection(url, "javalink", "javalink");
			System.out.println("sucess");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void insert() {
		Connect();
		
		try {
			String cs="inset into member3 values(?,?,?,?,?,?)";
			 p=conn.prepareStatement(cs);
			 p.setString(1, "Alpha");
			 p.setString(2, "1234");
			 p.setString(3, "Al");
			 p.setInt(4, 20);
			 p.setString(5, "LA");
			 p.setString(6, "Alpha@");
			 int count=p.executeUpdate();
			 if(count>0) {
				 System.out.println("insert success");
			 } else {
				 System.out.println("insert fail");
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				p.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void select() {
		Connect();
		ResultSet re;
		
		try {
			String sel="select*from member3";
			p=conn.prepareStatement(sel);
			re=p.executeQuery();
			while(re.next()) {
				System.out.println("아이디: "+re.getString(1)+"비밀번호: "+re.getString(2)+"이름: "+re.getString(3)+
						"나이: "+re.getString(4)+"주소: "+re.getString(5)+"이메일: "+re.getString(6));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				p.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	public void insertMember(){
		
	}
	
	
	public static void main(String[] args) {
		
		procedure_test pr=new procedure_test();
		
		pr.select();
		//pr.insert();
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
