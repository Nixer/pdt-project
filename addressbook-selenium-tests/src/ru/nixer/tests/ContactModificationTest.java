package ru.nixer.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import static ru.nixer.fw.ContactHelper.MODIFICATION;

public class ContactModificationTest extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact){
	  app.navigateTo().mainPage();
	  
      //save old state
	  List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	  Random rnd = new Random();
      int index = rnd.nextInt(oldList.size()-1);

	  //actions
	  app.getContactHelper().initContactEdit();	  
	  app.getContactHelper().fillContactForm(contact, MODIFICATION);	  
	  app.getContactHelper().submitContactUpdate();
	  app.navigateTo().returnToHomePage();
	  
	  //save new state
	  List<ContactData> newList = app.getContactHelper().getContacts();
	    
	  //compare states  
      oldList.remove(0);
	  oldList.add(contact);
	  Collections.sort(oldList);
	  Collections.sort(newList);
	  assertEquals(newList, oldList);
    }
}
