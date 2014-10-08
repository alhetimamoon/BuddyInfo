import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Interface extends JFrame implements ActionListener{
	
	BuddyInfo newBuddy = new BuddyInfo();
	JMenuItem newBuddyItem = new JMenuItem("New");
	JMenuItem save = new JMenuItem("Save");
	
	public Interface(){
			
		JFrame frame = new JFrame("Buddy Info");
		JMenuBar menuBar = new JMenuBar();
		JMenu mainMenu = new JMenu("file");
			
			
			
		newBuddyItem.addActionListener(this);
		save.addActionListener(this);
			
		mainMenu.add(newBuddyItem);			
		mainMenu.add(save);
			
		menuBar.add(mainMenu);
		frame.setJMenuBar(menuBar);
		frame.setSize(300, 400);
		frame.setVisible(true);
		}
	
	public void displayNewBuddyPanel()
	{
		String name =JOptionPane.showInputDialog(this, "Name");
		String address = JOptionPane.showInputDialog(this, "address");
		String phoneNumber = JOptionPane.showInputDialog(this, "Phone Number");
		
		newBuddy.setName(name);
		newBuddy.setAddress(address);
		newBuddy.setPhoneNumber(phoneNumber);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == newBuddyItem)
		{
			displayNewBuddyPanel();
			
		}
		System.out.println(newBuddy.getName() + " " + newBuddy.getAddress());
	}

	public static void main(String args[])
	{
		Interface ui = new Interface();
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
