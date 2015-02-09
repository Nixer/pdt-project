package ru.nixer.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import ru.nixer.fw.ApplicationManager;

public class TestBase {
	
	protected ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	    }
	
	  @DataProvider
	  public Iterator<Object[]> randomValidGroupGenerator() {
		  List<Object[]> list = new ArrayList<Object[]>();
		  for (int i = 0; i < 5; i++){
			  GroupData group = new GroupData()
			  .withName(generateRandomString())
			  .withHeader(generateRandomString())
			  .withFooter(generateRandomString());
			  list.add(new Object[]{group});
		  }
		  return list.iterator();
	  }
		
	  public String generateRandomString() {
		  Random rnd = new Random();
		  if (rnd.nextInt(3) == 0){
			  return "";  
		  } else {
			  return "test" + rnd.nextInt();
		  }
	  }
	  
	  
	  @DataProvider
	  public Iterator<Object[]>	randomValidContactGenerator() {
		  List<Object[]> list = new ArrayList<Object[]>();
		  for (int i = 0; i < 5; i++){
			    ContactData contact = new ContactData();
			    contact.firstname = generateRandomStringContact();
			    contact.lastname = generateRandomStringContact();
			    contact.address = generateRandomStringContact();
			    contact.home_phone = generateRandomStringContact();
			    contact.mobile_phone = generateRandomStringContact();
			    contact.work_phone = generateRandomStringContact();
			    contact.email1 = generateRandomStringContact();
			    contact.email2 = generateRandomStringContact();
			    contact.address2 = generateRandomStringContact();
			    contact.phone2 = generateRandomStringContact();
			    list.add(new Object[]{contact});
			  }
		  return list.iterator();	  
	  }
	  
	  public String generateRandomStringContact() {
		  Random rnd = new Random();
			    if (rnd.nextInt(5) == 0) {
		 		    return "";
			    } else {
		 		    return "test" + rnd.nextInt();
			    }		    		    	  
	  }
	  
}
	
