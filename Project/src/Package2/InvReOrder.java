package Package2;
import java.text.NumberFormat;

import Package1.*;

public class InvReOrder {
	private int ordQty;
	private double tax;
	private double total;
	private double cost;
	NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
	
	public InvReOrder() {
		this.tax = 1.07125;
		
	}
	
	
	/* Depending on what the boolean was from BackOrder
	it will set either 10 or 0 for the back order quantity */
	public int setOrdQty(boolean bo) {
		if(bo == true) {
			ordQty = 10;
		}
		else {
			ordQty = 0;
		}
		return ordQty;
	}
	
	
	/* Takes the products price and finds the total 
	 amount the back order costs*/
	public void setOrdTotal(double price, int ordQty) {
		this.ordQty = ordQty;
		this.cost = price;
		total = this.ordQty * this.cost * this.tax;
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
		if(this.ordQty == 0) {
			resupply = "";
		}
		else {
		resupply = "Backorder quantity: " + this.ordQty + "\nWholesale Cost: " + moneyFormatter.format(this.cost) +
					"\nBackorder total: " + moneyFormatter.format(this.total);

		}
		return resupply;
	}
}
