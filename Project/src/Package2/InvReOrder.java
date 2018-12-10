package Package2;
import java.util.Date;

import Package1.*;

public class InvReOrder {
	private int ordQty;
	private double tax;
	private double total;
	private double cost;
	private Date ordDate;
	private Date arrivalDate;
	
	public InvReOrder() {
		tax = 1.07125;
	}
	
	//Depending on what the boolean was from BackOrder
	//it will set either 10 or 0 for the back order quantity
	public void setOrdQty(boolean bo) {
		if(bo == true) {
			this.ordQty = 10;
		}
		else {
			this.ordQty = 0;
		}
	}
	
	//Takes the products price and finds the total 
	//amount the back order costs
	public void setOrdTotal(double price) {
		this.cost = price;
		this.total = this.ordQty * this.cost * tax;
	}
	
	public int getOrdQty() {
		return ordQty;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public String toString() {
		String resupply = " ";
		resupply = "Backorder quantity: " + this.ordQty + "\nWholesale Cost: " + this.cost +
					"\nBackorder total: " + this.total;

		
		return resupply;
	}
}