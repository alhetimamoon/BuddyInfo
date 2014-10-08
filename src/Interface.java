
public class Interface {
	
	public static void main(String args[])
	{
		BuddyInfo buddy = new BuddyInfo();
		buddy.setName("Homer");
		buddy.setAddress("Colonel By Drive");
		buddy.setPhoneNumber("111-111-0000");
		
		System.out.print("Hello " + buddy.getName());
		
		AddressBook phoneBook = new AddressBook();
		phoneBook.addBuddy(buddy);
		phoneBook.removeBuddy(buddy);
		
		BuddyInfo mamoon = new BuddyInfo();
		mamoon.setName("Mamoon");
		mamoon.setAddress("11 Drive");
		
	}

}
