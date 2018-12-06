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

public class AddItem extends JFrame {
	//JPanels
	private JPanel topPanel = new JPanel (new GridLayout(3,1));
	private JPanel btnPanel = new JPanel (new FlowLayout());
	private JPanel bottomPanel = new JPanel (new BorderLayout());
	
	//Labels
	private JLabel itemName = new JLabel("Item Description: ", SwingConstants.CENTER);
	private JLabel qty = new JLabel("Quantity: ", SwingConstants.CENTER);
	private JLabel price = new JLabel("Price: ", SwingConstants.CENTER);
	
	//Buttons
	private JButton add = new JButton("Add");
	
	//TextArea
	private JTextArea consoleTxt = new JTextArea();
	
	//TextField
	private JTextField itemNameTxt = new JTextField(SwingConstants.CENTER);
	private JTextField qtyTxt = new JTextField(SwingConstants.CENTER);
	private JTextField priceTxt = new JTextField(SwingConstants.CENTER);
	
	Inventory inv = new Inventory();
	
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
					
					Product productInfo = new Product(itemTxt, qty, price);
					inv.addProduct(productInfo);
				}
			}
		}
	
	
	
	public AddItem(String title) {
		super(title);
		
		setSize(1000, 600);
		setLayout(new GridLayout(3,1,100,50));
		
		createTopPanel();
		createBtnPanel();
		createBottomPanel();
		add(topPanel);
		add(btnPanel);
		add(bottomPanel);
			
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
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
						
		}
		
	}
	
	public static void main(String[] args) {
		
	}

}
