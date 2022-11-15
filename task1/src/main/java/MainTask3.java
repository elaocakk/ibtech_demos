import java.util.HashMap;
import java.util.List;

import org.hibernate.mapping.Map;

import task1.bag.Bag;
import task1.bag.BagKey;
import task1.cmd.CommandExecuter;
import task1.dao.CommandDao;
import task1.dao.CustomerDao;
import task1.model.Command;
import task1.model.Customer;

public class MainTask3 {

	public static void main(String[] args) {
		
//		CommandDao commandDao = new CommandDao();		
//		commandDao.runCommands();		
		
//		HashMap<String,Object> hashMap = new HashMap();
//		Customer customer = new Customer("123456589", "ela","ocak");
//		Customer customer2 = new Customer("564542121", "elif","ocak");		
//		
//		hashMap.put("customer_add", customer);
//		hashMap.put("customer_update", customer);
//		hashMap.put("customer_add", customer);
//		hashMap.put("customer_delete", customer);		
//		hashMap.put("customer_delete", customer);
		
		CommandDao commandDao = new CommandDao();

		// add
		Command cmd = commandDao.getCommand("customer_add");
		if (!commandCheck(cmd)) {
			return;
		}

		Bag bagAdd = new Bag();
		bagAdd.put(BagKey.TCKN, "1111111111111");
		bagAdd.put(BagKey.NAME, "Elanur");
		bagAdd.put(BagKey.SURNAME, "Ocak");

		CommandExecuter cmdExecuter = new CommandExecuter();
		Bag customerNewBag = cmdExecuter.execute(cmd, bagAdd);
		
		// update
		Command cmdUpdate = commandDao.getCommand("customer_update");
		if (!commandCheck(cmdUpdate)) {
			return;
		}

	    // öncesinde customer eklenmesi lazım
		Bag bagUpdate = new Bag();
		int updateid = (int) customerNewBag.getValue(BagKey.ID);	
		bagUpdate.put(BagKey.ID, updateid);
		bagUpdate.put(BagKey.TCKN, "2222222");
		bagUpdate.put(BagKey.NAME, "Ela");
		bagUpdate.put(BagKey.SURNAME, "Ocak");

		System.out.println("***********************" + bagUpdate.getValue(BagKey.ID));
		cmdExecuter = new CommandExecuter();
		Bag testBag = cmdExecuter.execute(cmdUpdate, bagUpdate);
		
		// delete
		Command cmdDelete = commandDao.getCommand("customer_delete");
		if (!commandCheck(cmdDelete)) {
			return;
		}

		Bag bagDelete = new Bag();
		int customerId = (int) customerNewBag.getValue(BagKey.ID);
		bagDelete.put(BagKey.ID, customerId);

		cmdExecuter = new CommandExecuter();
		Bag deletedCustomerBag = cmdExecuter.execute(cmdDelete, bagDelete);

		// list
		Command cmdlist = commandDao.getCommand("customer_list");
		if (!commandCheck(cmdlist)) {
			return;
		}
		
		cmdExecuter = new CommandExecuter();
		Bag customersBag = cmdExecuter.execute(cmdlist, new Bag()); // listeleme diye boş bag gönderiyoruz 
		List<Customer> customerList = (List<Customer>) customersBag.getValue(BagKey.LIST);

		CustomerDao customerDao = new CustomerDao();
		List<Customer> cus = customerDao.getCustomers();
		System.out.println(cus);
		
		System.out.println(" List<Customer> customers : " );
		for (Customer customerItem : customerList) {
			System.out.print(" Id: " + customerItem.getId());
			System.out.print(" TCKN: " + customerItem.getTckn());
			System.out.print(" Name: " + customerItem.getName());
			System.out.println(" Surname: " + customerItem.getSurname());
		}


	}
	
	public static boolean commandCheck(Command command) {
		if (command == null) {
			System.out.println("*** NOT FOUND ***");
			return false;
		}
		System.out.println("-> Command Information; \n\t" + command.getCommand_name() + "\n\t"
				+ command.getCommand_description() + "\n\t" + command.getClass_name() + "\n\t" + command.getMethod_name());
		return true;
	}
	
}
