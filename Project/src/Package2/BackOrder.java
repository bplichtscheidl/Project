package Package2;
import Package1.*;

public class BackOrder {
	private boolean bo;
	private int minQty;

	public BackOrder() {
		this.minQty = 5;
	}

	//Testing if the quantity of the item is above or below the minimum
	public boolean setBo(int qty) {
		
		if(qty < this.minQty) {
			this.bo = true;
		}
		else {
			this.bo = false;
		}
		return this.bo;
	}
	
	public boolean getBo() {
		return bo;
	}

	public int getMinQty() {
		return minQty;
	}

	public void setMinQty(int minQty) {
		this.minQty = minQty;
	}

}
