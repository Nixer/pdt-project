package ru.nixer.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests  extends TestBase {
	
	@Test
	public void deleteSomeContact(){
	  app.getNavigationHelper().openMainPage();
	  app.getContactHelper().initContactEdit();
	  app.getContactHelper().submitContactDelete();
	  app.getNavigationHelper().returnToHomePage();
	}
}
