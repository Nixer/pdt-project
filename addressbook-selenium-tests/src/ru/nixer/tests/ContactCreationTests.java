package ru.nixer.tests;

import java.util.Collections;
import java.util.List;



import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {	
  @Test
  public void testNonEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().initNewContactCreation();
    ContactData contact = new ContactData();
    contact.firstname = "Ivan";
    contact.lastname = "Ivanov";
    contact.address = "12345 Good Street";
    contact.home_phone = "123-4658";
    contact.mobile_phone = "123-458-78-89";
    contact.work_phone = "256-456-78";
    contact.email1 = "ivan@ibs.com";
    contact.email2 = "hun@hno.com";
    contact.bday = "4";
    contact.bmonth = "July";
    contact.byear = "1980";
    contact.group_name = "group 1";
    contact.address2 = "45684 Bass ave";
    contact.phone2 = "478-4549";
   	app.getContactHelper().fillContactForm(contact);  
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
    
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states        
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);
  }
  
  //@Test
  public void testEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().initNewContactCreation();
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
  }
}