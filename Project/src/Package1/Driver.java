package Package1;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Package2.*;


public class Driver extends JFrame{

// GUI
	
	// Initialize GUI Components
	
	// Panels
	private JPanel contentPane = new JPanel();
	private JPanel topPanel = new JPanel(new FlowLayout());
	private JPanel consolePanel = new JPanel(new BorderLayout(0, 0));
	private JPanel bottomPanel = new JPanel();
	
	
	// Labels
	private JLabel searchLbl = new JLabel("Search for an item: ");
	private JLabel removeLbl = new JLabel("Remove an item: ");
	
	// Buttons
	private JButton displayInv = new JButton("Display Inventory");
	private JButton searchForItem = new JButton("Search");
	private JButton addItem = new JButton("Add an item");
	private JButton refreshInv = new JButton("Refresh Inventory");
	private JButton removeBtn = new JButton("Remove item");
	
	
	// Text Area
	private JTextArea invConsole = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane();
	
	
	// Text Fields
	private JTextField searchTxtFld = new JTextField();
	private JTextField removeTxtFld = new JTextField();
	
	
	// Objects
	Inventory inv = new Inventory();
	BackOrder backOrderInfo = new BackOrder();
	InvReOrder reOrder = new InvReOrder();
	
	//Button Listeners 
	private class BtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String callingBtn = e.getActionCommand();
			
			if(callingBtn.equals("Add an item")) {
				AddItem addFrame = new AddItem("Add Item", inv, backOrderInfo, reOrder);
				addFrame.setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			
			else if(callingBtn.equals("Refresh Inventory")) {
				invConsole.setText(" ");
			}
			
			else if(callingBtn.equals("Search")) {
				String searchText = searchTxtFld.getText();
				String itemSearch = inv.searchByProductName(searchText);
				invConsole.append(itemSearch + "\n");
			}
			
			else if(callingBtn.equals("Remove item")) {
				String removeText = removeTxtFld.getText();
				String itemRemove = inv.removeProduct(removeText);
				invConsole.append(itemRemove + "\n");
			}
			
			else if(callingBtn.equals("Display Inventory")) {
				invConsole.append(inv.toString() + "\n");
			}
			
		}
		
	}
	
	
	
	public Driver(String title) {
		super(title);
		
		// Main GUI Settings
		
		//setSize(500, 500); SetBounds overrides this
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(600, 400, 1000, 600); // (x, y, width, height)
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// Create the panels used in the GUI
		createTopPanel();
		createConsolePanel();
		createBottomPanel();
		
		
		// Add the sub-panels to contentPane
		contentPane.add(topPanel, BorderLayout.NORTH);
		contentPane.add(consolePanel, BorderLayout.CENTER);
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		
		
		// Add the ActionListeners
		// Example: btn.addActionListener(new ButtonListener());
		addItem.addActionListener(new BtnListener());
		displayInv.addActionListener(new BtnListener());
		refreshInv.addActionListener(new BtnListener());
		searchForItem.addActionListener(new BtnListener());
		removeBtn.addActionListener(new BtnListener());
		
		
		
		
	}
	
		

	private void createTopPanel() {
		// Add components to the Top Panel
		topPanel.add(addItem);
		topPanel.add(displayInv);
		topPanel.add(refreshInv);
		
	}



	private void createConsolePanel() {
		// Add components to the Console Panel
		consolePanel.add(invConsole, BorderLayout.CENTER);
		invConsole.setEditable(false);
		consolePanel.add(scrollPane, BorderLayout.CENTER);
		
		// Add invConsole to scrollPane
		scrollPane.setViewportView(invConsole);
;		
	}



	private void createBottomPanel() {
		// Add components to the Bottom Panel
		bottomPanel.add(searchLbl);
		
		bottomPanel.add(searchTxtFld);
		searchTxtFld.setColumns(10);
		
		bottomPanel.add(searchForItem);
		
		bottomPanel.add(removeLbl);
		bottomPanel.add(removeTxtFld);
		removeTxtFld.setColumns(10);
		bottomPanel.add(removeBtn);
		
	}
	
	public static void main(String[] args) {
		
		Driver gui = new Driver("Inventory Manager");
		gui.setVisible(true);
	}
}