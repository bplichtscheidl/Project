package Package1;

import java.util.Random;

public class Product {
	private String productName;
	private int qty;
	private double unitCost;
	private long productId;
	private int backOrder;
	private double backOrderTotal;
	
	public Product() {
		this.productName = "No name";
		this.qty = 0;
		this.unitCost = 0;
	}
	
	//Creating an object
	public Product(String productName, int qty, double unitCost, long productId) {
		this.productName = productName;
		this.qty = qty;
		this.unitCost = unitCost;
		Random rand = new Random();
		long num = (long)(rand.nextInt(900000000)+ 100000000);
		productId = num;
		this.productId = productId;
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
	
	public void setBackOrder(int backOrder) {
		this.backOrder = backOrder;
	}
	
	public int getBackOrder(int qty) {
		return backOrder;
	}
	
	public double getBackOrderTotal() {
		return backOrderTotal;
	}
	
	public void setBackOrderTotal(double backOrderTotal) {
		this.backOrderTotal = backOrderTotal;
	}
	
	//Displays product information
	public String toString() {
		return ("Product: " + this.productName + "\n" + "Quantity: " + this.qty + "\n" + "Unit Cost: $" + this.unitCost +
				 "\n" + "Product Id: "+ this.productId + "\n" + "Backorder Quantity: " + this.backOrder + "\n"
				 +"Backorder total: $" + this.backOrderTotal + "\n");
	}

}
