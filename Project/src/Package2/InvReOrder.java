package Package2;
import Package1.*;

public class InvReOrder {
	private int ordQty;
	private double tax;
	private double total;
	private BackOrder qty;
	
	public InvReOrder() {
		this.ordQty = 10;
		this.tax = 1.07125;
	}
	
	public void getBo(BackOrder qty) {
		getOrdQty(qty.getBo());
		}
	
	//Depending on what the boolean was from BackOrder
	//it will set either 10 or 0 for the back order quantity
	public int getOrdQty(boolean qty) {
		if(qty == true) {
			ordQty = 10;
		}
		else {
			ordQty = 0;
		}
		return ordQty;
	}
	
	//Takes the products price and finds the total 
	//amount the back order costs
	public double SetOrdTotal(double price) {
		double total = ordQty * price * tax;
		return this.total = total;
	}
	
	public BackOrder getQty() {
		return qty;
	}

	public void setQty(BackOrder qty) {
		this.qty = qty;
	}

	public double getOrdTotal() {
		return total;
	}
	
	public void setOrdQty(int ordQty) {
		this.ordQty = ordQty;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public String toString() {
		String resupply = " ";
		if(this.ordQty > 0) {
		resupply = "Backorder total: " + this.total + "\nBackorder quantity: "
				+ this.ordQty;
		}
	
		return resupply;
	}
}