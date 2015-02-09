package ru.nixer.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ru.nixer.tests.ContactData;

public class ContactHelper extends HelperBase{

public static boolean CREATION = true;
public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void initNewContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact, boolean formType) {
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
		if (formType == CREATION) {
			//selectByText(By.name("new group"), "group 1");
		} else {
			if  (driver.findElements(By.name("new group")).size() != 0){
			throw new Error	("Group selector exists in contact modification form");		
			}
			}
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
