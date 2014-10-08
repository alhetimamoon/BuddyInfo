/**
 *Lab 1 
 * @author mamoonabdulhameed
 *
 */
public class BuddyInfo {
	
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	private String address; 
	private String phoneNumber;
	
	public static void main(String args[])
	{
		BuddyInfo buddy = new BuddyInfo();
		buddy.name = "Homer";
		buddy.address = "Colonel By Drive";
		buddy.phoneNumber = "111-111-0000";
		
		System.out.print("Hello " + buddy.getName());
		
		AddressBook phoneBook = new AddressBook();
		phoneBook.addBuddy(buddy);
		phoneBook.removeBuddy(buddy);
		
		BuddyInfo mamoon = new BuddyInfo();
		mamoon.name = "Mamoon";
		mamoon.address = "54 drive";
		//dsjgas;bjv;aksbjdv
	}
}
