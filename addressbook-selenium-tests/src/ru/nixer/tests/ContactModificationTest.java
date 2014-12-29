package ru.nixer.tests;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
	
	@Test
	public void modifySomeContact(){
	  app.getNavigationHelper().openMainPage();
	  app.getContactHelper().initContactEdit();
	  ContactData contact = new ContactData();
	  contact.firstname = "Vasya";
	  contact.lastname = "Vasiliev";
	  app.getContactHelper().fillContactForm(contact);	  
	  app.getContactHelper().submitContactUpdate();
	  app.getNavigationHelper().returnToHomePage();
    }
}
