package ru.nixer.tests;

public class GroupContactData {
	public String firstname;
	public String lastname;
	public String address;
	public String home_phone;
	public String mobile_phone;
	public String work_phone;
	public String email1;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String group_name;
	public String address2;
	public String phone2;
	
	public GroupContactData() {
		}

	public GroupContactData(String firstname, String lastname, String address,
			String home_phone, String mobile_phone, String work_phone,
			String email1, String email2, String bday, String bmonth,
			String byear, String group_name, String address2, String phone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home_phone = home_phone;
		this.mobile_phone = mobile_phone;
		this.work_phone = work_phone;
		this.email1 = email1;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.group_name = group_name;
		this.address2 = address2;
		this.phone2 = phone2;
	}
}