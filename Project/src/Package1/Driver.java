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
	
	// Buttons
	private JButton createOrder = new JButton("Create an order");
	private JButton searchForItem = new JButton("Search");
	private JButton addItem = new JButton("Add an item");
	private JButton refreshInv = new JButton("Refresh Inventory");
	
	
	// Text Area
	private JTextArea invConsole = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane();
	
	
	// Text Fields
	private JTextField searchTxtFld = new JTextField();
	
	
	
	public Driver(String title) {
		super(title);
		
		// Main GUI Settings
		setSize(500, 500); // Change this later
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
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
	}
	
		

	private void createTopPanel() {
		// Add components to the Top Panel
		topPanel.add(addItem);
		topPanel.add(createOrder);
		topPanel.add(refreshInv);
		
	}



	private void createConsolePanel() {
		// Add components to the Console Panel
		consolePanel.add(invConsole, BorderLayout.CENTER);
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
	}



	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
						
		}
		
	}
	
	public static void main(String[] args) {
		
		Driver gui = new Driver("Inventory Manager");
		gui.setVisible(true);
	
		/*Inventory inv = new Inventory();
		BackOrder bo = new BackOrder();
		InvReOrder re = new InvReOrder();
		Product product1 = new Product("Paper", 3, 59.99, 000000000);
		Product product2 = new Product("Pickles", 5, 3.99, 000000000);
		Product product3 = new Product("Nvidia 1080 TI Graphics Card", 3, 899.99, 000000000);
		
		
		inv.addProduct(product1);
		inv.addProduct(product2);
		inv.addProduct(product3);
		
		int item1 = inv.SearchForQty("Paper");
		int item2 = inv.SearchForQty("Pickles"); //putting fatal error on top of output and still iterating the code to output true when it should be nothing
		int item3 = inv.SearchForQty("Nvidia 1080 TI Graphics Card");
		boolean qty1 = bo.isBo(item1);
		boolean qty2 = bo.isBo(item2);
		boolean qty3 = bo.isBo(item3);
		int boQty1 = re.getOrdQty(qty1);
		int boQty2 = re.getOrdQty(qty2);
		int boQty3 = re.getOrdQty(qty3);
	
		double price1 = inv.SearchForPrice("Paper");
		double price2 = inv.SearchForPrice("Pickles");
		double price3 = inv.SearchForPrice("Nvidia 1080 TI Graphics Card");
		double resupply1 = re.SetOrdTotal(price1);
		double resupply2 = re.SetOrdTotal(price2);
		double resupply3 = re.SetOrdTotal(price3);
	
		String item = inv.searchByProductName("Nvidia 1080 TI Graphics Card");
	
		System.out.print(inv.toString());
		System.out.println(item);
		System.out.println(qty1);
		System.out.println(qty2);
		System.out.println(qty3);*/
		

	}

}

