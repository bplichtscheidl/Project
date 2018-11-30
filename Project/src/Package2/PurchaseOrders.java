package Package2;
import java.util.*;

import Package1.*;

public class PurchaseOrders {
	private Date date;
	private String estArrivalTime;
	private int ordSize;
	
	public PurchaseOrders() {
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEstArrivalTime() {
		return estArrivalTime;
	}

	public void setEstArrivalTime(String estArrivalTime) {
		this.estArrivalTime = estArrivalTime;
	}

	public int getOrdSize() {
		return ordSize;
	}

	public void setOrdSize(int ordSize) {
		this.ordSize = ordSize;
	}
	
	public String toString() {
		String purchaseOrder = "Purchase Order \n" + "Order Size: " + ordSize + "Date: " + this.date +
				"Estimated Arrival Time: " + this.estArrivalTime;
		return purchaseOrder;
	}

}
