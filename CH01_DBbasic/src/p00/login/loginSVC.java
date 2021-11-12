package p00.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class user extends loginSVC {

	// 1.local variable
	private String id;
	private String password;
	private String name;
	private int age;
	private String gender;
	private String email;

	// 2.constructor
	public user(String id, String password, String name, int age, String gender, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}

	// 3.getter(), setter()
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		String result="id: "+id+"password: "+password;
		return result;
	}

}

public class loginSVC {

	Connection c = null;
	Statement st = null;

	static {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void connect() {

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {

			c = DriverManager.getConnection(url, "javalink", "javalink");
			st = c.createStatement();
			System.out.println("Connection Success!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public user login(String id, String passwd) {
				
		connect();
		user u=null;
		
		try{
			
			st= c.createStatement();
			String q = "SELECT * FROM member WHERE id = '" + id + "' AND " +
					"password = '" + passwd + "'";

			ResultSet re=st.executeQuery(q);
				
				if(re.next()) {
					id=re.getString(1);//위의 파라미터 변수로 선언되었기에 String 재입력 하면 안됨
					passwd=re.getString(2);
					String name=re.getString(3);
					int age=re.getInt(4);
					String addr=re.getString(5);
					String email=re.getString(6);
					u=new user(id, passwd, name, age, addr, email);
				}
			
			}catch(SQLException se){
			se.printStackTrace();
			}finally{
					try{
						st.close();
						c.close();
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			return u;
			}

}
