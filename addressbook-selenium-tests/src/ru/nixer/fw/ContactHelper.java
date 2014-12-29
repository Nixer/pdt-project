package ru.nixer.fw;

import org.openqa.selenium.By;

import ru.nixer.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void initNewContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData group) {
		type(By.name("firstname"), group.firstname);
		type(By.name("lastname"), group.lastname);
		type(By.name("address"), group.address);
		type(By.name("home"), group.home_phone);
		type(By.name("mobile"), group.mobile_phone);
		type(By.name("work"), group.work_phone);
		type(By.name("email"), group.email1);
		type(By.name("email2"), group.email2);
	    selectByText(By.name("bday"), group.bday);
	    selectByText(By.name("bmonth"), group.bmonth);
	    //selectByText(By.name("new_group"), group.group_name);
		type(By.name("address2"), group.address2);
		type(By.name("phone2"), group.phone2);
	}

}
