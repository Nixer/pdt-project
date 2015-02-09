package ru.nixer.tests;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

import static ru.nixer.fw.ContactHelper.CREATION;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {	

  @Test(dataProvider = "randomValidContactGenerator")
  
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    app.navigateTo().mainPage();
    
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().initNewContactCreation();
   	app.getContactHelper().fillContactForm(contact, CREATION);  
    app.getContactHelper().submitContactCreation();
    app.navigateTo().returnToHomePage();
    
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states        
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);
  }
 
}