package Package2;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Date;

import Package1.*;

public class InvReOrder {
	private int ordQty;
	private double tax;
	private BigDecimal total;
	private double cost;
	private Date ordDate;
	private Date arrivalDate;
	
	
	public InvReOrder() {
		this.tax = 1.07125;
		
	}
	
	//Depending on what the boolean was from BackOrder
	//it will set either 10 or 0 for the back order quantity
	public int setOrdQty(boolean bo) {
		if(bo == true) {
			ordQty = 10;
		}
		else {
			ordQty = 0;
		}
		return ordQty;
	}
	
	//Takes the products price and finds the total 
	//amount the back order costs
	public void setOrdTotal(double price, int ordQty) {
		this.ordQty = ordQty;
		this.cost = price;
		
		BigDecimal newOrdQty = BigDecimal.valueOf(ordQty);
		BigDecimal newPrice = BigDecimal.valueOf(price);
		
		BigDecimal newTotal = newOrdQty.multiply(newPrice);
		
		this.total = newTotal;
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
		resupply = "Backorder quantity: " + this.ordQty + "\nWholesale Cost: $" + this.cost +
					"\nBackorder total: $" + this.total;

		
		return resupply;
	}
}