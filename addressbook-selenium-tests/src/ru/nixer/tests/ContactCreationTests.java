package ru.nixer.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {	

  @Test(dataProvider = "randomValidContactGenerator")
  
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    app.getNavigationHelper().openMainPage();
    
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().initNewContactCreation();
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
 
}