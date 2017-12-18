package bookshop;

import org.junit.Test;

import com.spsp.model.Employe;
import com.spsp.service.EmployeService;

public class EmployeTest {
	
	@Test
	public void testSave() throws Exception {
		EmployeService service = new EmployeService();
		Employe employe = new Employe();
		employe.setId("19");
		employe.setAge(20);
		employe.setName("test9");
		employe.setStatus("Active");
//		employe.setIdcard("612325201206072730");
		service.save(employe);
	}
}
