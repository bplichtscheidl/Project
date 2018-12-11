package Package1;
import Package2.*;

import java.text.NumberFormat;
import java.util.Random;


public class Product {
	private String productName;
	private int qty;
	private double unitCost;
	private long productId;
	private InvReOrder reOrder;
	NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
	
	//Creating an object
	public Product(String productName, int qty, double unitCost, InvReOrder reOrder) {
		this.reOrder = reOrder;
		this.productName = productName;
		this.qty = qty;
		this.unitCost = unitCost * 1.2 * reOrder.getTax();
		this.productId = getID();
	}

	//Generates random item number
	public long getID() {
		Random rand = new Random();
		long num = (long)(rand.nextInt(900000000)+ 100000000);
		productId = num;
		return productId;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public long getProductId() {
		return productId;
	}
	
	public InvReOrder getReOrder() {
		return reOrder;
	}

	public void setReOrder(InvReOrder reOrder) {
		this.reOrder = reOrder;
	}

	//Displays product information
	public String toString() {
		return ("Product: " + this.productName + "\n" + "Quantity: " + this.qty + 
				"\n" + "Retail Cost: " + moneyFormatter.format(this.unitCost) +"\n" + "Product Id: " 
				+ this.productId +"\n" + this.reOrder.toString());
	}

}
