package ru.nixer.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.home_phone);
		type(By.name("mobile"), contact.mobile_phone);
		type(By.name("work"), contact.work_phone);
		type(By.name("email"), contact.email1);
		type(By.name("email2"), contact.email2);
	    selectByText(By.name("bday"), contact.bday);
	    selectByText(By.name("bmonth"), contact.bmonth);
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.phone2);
	}
	
	public void initContactEdit() {
		click(By.cssSelector("img[alt=\"Edit\"]"));
	}
	
	public void submitContactDelete() {
		click(By.xpath("//*[@value='Delete']"));
	}
	
	public void submitContactUpdate() {
		click(By.xpath("//*[@value='Update']"));
	}
	
	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
	    List<WebElement> entries = driver.findElements(By.name("entry"));
	    for (WebElement entry : entries) {
	    	List<WebElement> cells = entry.findElements(By.tagName("td"));
	    	ContactData contact = new ContactData();
	    	contact.firstname = cells.get(2).getText();
			contacts.add(contact);		    						
		}
		return contacts;
	}

	
}
