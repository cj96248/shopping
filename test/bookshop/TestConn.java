package bookshop;

import java.sql.Timestamp;
import java.util.List;

import com.spsp.model.UserBean;
import com.spsp.service.UserService;
import com.spsp.util.DBConnection;

public class TestConn {
	
	public static void main1(String[] args) {
		System.out.println(DBConnection.getConnection());
		
	}
	
	public static void main2(String[] args) {
		UserBean user = new UserBean();
		user.setAge(2);
		user.setId("100102");
		user.setName("测试2");
		user.setStatus("A");
		user.setRdate(new Timestamp(System.currentTimeMillis()));
		UserService uService = new UserService();
		uService.save(user);
	}
	
	public static void main3(String[] args){
		UserService service = new UserService();
		List<UserBean> list = service.getUsers();
		System.out.println(list);
	}
	
	public static void main(String[] args){
		UserService service = new UserService();
		UserBean u = service.getUserByName("2");
		System.out.println(u);
	}
	
}
