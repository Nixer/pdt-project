package ru.nixer.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ru.nixer.tests.GroupData;
import ru.nixer.utils.SortedListOf;

public class GroupHelper extends HelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	private SortedListOf<GroupData> cacheGroups;
		
	public SortedListOf<GroupData> getGroups() {
		if (cacheGroups == null) {
			rebuildCache();
		}
		return cacheGroups;
		
	}
	
	private void rebuildCache() {
		SortedListOf<GroupData> cacheGroups = new SortedListOf<GroupData>();

		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]")); 
		for  (WebElement checkbox : checkboxes){
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length() - ")".length());
			cacheGroups.add(new GroupData().withName(name));
		}
	}

	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
	    initGroupCreation();
	    fillGroupForm(group);
	    submitGroupCreation();
	    returnToGroupsPage();
	    rebuildCache();
		return this;
	}
	
	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupsPage();
		rebuildCache();
		return this;
	}
	
	public GroupHelper modifyGroup(int index, GroupData group) {
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupsPage();
		rebuildCache();
		return this;
	}

//----------------------------------------------------------------------------------------------------------
	
	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		cacheGroups = null;
		return this;
	}

	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}

	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cacheGroups = null;
		return this;
	}
	
	private void submitGroupDeletion() {
		click(By.name("delete"));
		cacheGroups = null;
	}

}
