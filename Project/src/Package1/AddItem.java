package Package1;

import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Package2.*;

public class AddItem extends JFrame {
	
	//JPanels
	private JPanel topPanel = new JPanel (new GridLayout(3,1));
	private JPanel btnPanel = new JPanel (new FlowLayout());
	private JPanel bottomPanel = new JPanel (new BorderLayout());
	
	
	//Labels
	private JLabel itemName = new JLabel("Item Description: ", SwingConstants.RIGHT);
	private JLabel qty = new JLabel("Quantity: ", SwingConstants.RIGHT);
	private JLabel price = new JLabel("Price: ", SwingConstants.RIGHT);
	
	
	//Buttons
	private JButton add = new JButton("Add");
	
	
	//TextArea
	private JTextArea consoleTxt = new JTextArea();
	
	
	//TextField
	private JTextField itemNameTxt = new JTextField();
	private JTextField qtyTxt = new JTextField();
	private JTextField priceTxt = new JTextField();
	
	
	private Inventory inv;
	private BackOrder backOrderInfo;
	private InvReOrder reOrder;
	
	//Button Listeners 
		private class BtnListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				String callingBtn = e.getActionCommand();
				
				if(callingBtn.equals("Add")) {
					String itemTxt = itemNameTxt.getText();
					
					String qtyText = qtyTxt.getText();
					int qty = Integer.parseInt(qtyText);
					
					String priceText = priceTxt.getText();
					double price = Double.parseDouble(priceText);
	
					boolean backOrderBool = backOrderInfo.setBo(qty);
					int backOrderQty = reOrder.setOrdQty(backOrderBool);
					reOrder.setOrdTotal(price, backOrderQty);
					
					inv.addProduct(itemTxt, qty, price, reOrder);
					consoleTxt.append(itemTxt + " has been added\n");
				}
			}
		}
	
	
	
	public AddItem(String title, Inventory inv, BackOrder backOrderInfo, InvReOrder reOrder) {
		super(title);
		this.inv = inv;
		this.backOrderInfo = backOrderInfo;
		this.reOrder = reOrder;
		
		//setSize(500, 300);
		setBounds(850, 550, 500, 300);
		setLayout(new GridLayout(3,1,100,50));
		
		createTopPanel();
		createBtnPanel();
		createBottomPanel();
		add(topPanel);
		add(btnPanel);
		add(bottomPanel);
		
		add.addActionListener(new BtnListener());
			
		}
			
	private void createBottomPanel() {
		bottomPanel.add(consoleTxt, BorderLayout.NORTH);
		JScrollPane consoleArea = new JScrollPane(consoleTxt);
		bottomPanel.add(consoleArea, BorderLayout.CENTER);
		consoleTxt.setEditable(false);
	}

	private void createBtnPanel() {
		btnPanel.add(add);
	}

	private void createTopPanel() {
		topPanel.add(itemName);
		topPanel.add(itemNameTxt);
		topPanel.add(qty);
		topPanel.add(qtyTxt);
		topPanel.add(price);
		topPanel.add(priceTxt);
	}
	

}
