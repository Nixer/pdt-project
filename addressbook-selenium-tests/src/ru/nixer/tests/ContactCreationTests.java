package ru.nixer.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {	
  @Test
  public void testNonEmptyContactCreation() throws Exception {
    openMainPage();
    initNewContactCreation();
    GroupContactData group = new GroupContactData();
    group.firstname = "Ivan";
    group.lastname = "Ivanov";
    group.address = "12345 Good Street";
    group.home_phone = "123-4658";
    group.mobile_phone = "123-458-78-89";
    group.work_phone = "256-456-78";
    group.email1 = "ivan@ibs.com";
    group.email2 = "hun@hno.com";
    group.bday = "4";
    group.bmonth = "July";
    group.byear = "1980";
    group.group_name = "group 1";
    group.address2 = "45684 Bass avw";
    group.phone2 = "478-4549";
   	fillContactForm(group);  
    submitContactCreation();
    returnToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
    openMainPage();
    initNewContactCreation();
    submitContactCreation();
    returnToHomePage();
  }
}