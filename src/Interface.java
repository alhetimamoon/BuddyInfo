import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Interface extends JFrame implements ActionListener{
	
	BuddyInfo newBuddy;
	AddressBook addressBook = new AddressBook();
	
	//menu items
	JMenuItem newAddressBook = new JMenuItem("New Address Book");
	JMenuItem newBuddyItem = new JMenuItem("New Contact");
	JMenuItem save = new JMenuItem("Save Address Book");
	
	
	//text fields
	JTextField name = new JTextField();
	JTextField address = new JTextField();
	JTextField phoneNumber = new JTextField();
	
	//text areas
	JTextArea addressBookView = new JTextArea("No Addressbook");
	
	public Interface(){

		addressBookView.setEditable(false);
		
		//new frame
		JFrame frame = new JFrame("Buddy Info");
		
		//new menu bar
		JMenuBar menuBar = new JMenuBar();
		
		//new menu
		JMenu mainMenu = new JMenu("file");
		
		//adding action listeners
		newAddressBook.addActionListener(this);
		newBuddyItem.addActionListener(this);
		save.addActionListener(this);
			
		//adding menu items
		mainMenu.add(newAddressBook);
		mainMenu.add(newBuddyItem);			
		mainMenu.add(save);
		
		//adding the menu to the menu bar
		menuBar.add(mainMenu);
		
		//setting frame properties
		frame.setJMenuBar(menuBar);
		frame.add(addressBookView);
		frame.setSize(300, 400);
		frame.setVisible(true);
		
		}
	public void createAddressBook()
	{
		addressBook = new AddressBook();
		addressBookView.setText("Addressbook created, add new contacts");
		
	}
	/**
	 * This method is responsible for displaying the popup when adding a new buddy
	 */
	public void displayNewBuddyPanel()
	{
		newBuddy = new BuddyInfo();
		Object[] addressBookEntry = {
			    "Name:", name,
			    "Address", address,
			    "Phone Number:", phoneNumber,
			};
		int option = JOptionPane.showConfirmDialog(this, addressBookEntry, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION)
		{			    	
			newBuddy.setName(name.getText());
			newBuddy.setAddress(address.getText());
			newBuddy.setPhoneNumber(phoneNumber.getText());
			    
		}
		addressBook.addBuddy(newBuddy);

	}
	/**
	 * This method updates the view of the addressbook on the main panel
	 */
	public void updateAddressbookView()
	{
		addressBookView.setText(" ");
		BuddyInfo temp = new BuddyInfo();
		for(int i=0; i<addressBook.getBuddies().size(); i++)
		{
			temp = addressBook.getBuddies().get(i);
			addressBookView.insert(" - " + temp.getName() 
					+ " " + temp.getAddress() 
					+ " " + temp.getPhoneNumber()  + "\n", 0);	
		}	
			
	}
	public void saveAddressbook()
	{
		
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("addressbook.txt"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(BuddyInfo buddy: addressBook.getBuddies())
		{
			try {
				out.write("Name: " + buddy.getName() + " Address: " + buddy.getAddress() + " Phone Number: " + buddy.getPhoneNumber() + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == newBuddyItem)
			displayNewBuddyPanel();
		updateAddressbookView();
		if (e.getSource() == newAddressBook)
			createAddressBook();
		
		if (e.getSource() == save)
			saveAddressbook();
		
	}

	public static void main(String args[])
	{
		Interface ui = new Interface();
		
	}
}
