package Package2;
import Package1.*;

public class BackOrder {
	private boolean bo;
	private int minQty;

	public BackOrder() {
		this.minQty = 5;
	}

	//Testing if the quantity of the item is above or below the minimum
	public boolean isBo(int foundQty) {
		if(foundQty == 0) {
			System.out.println("Fatal error");
		}
		if(foundQty < this.minQty) {
			this.bo = true;
		}
		else {
			this.bo = false;
		}
		return this.bo;
	}

	public void setBo(boolean bo) {
		this.bo = bo;
	}
	
	public boolean getBo() {
		return bo;
	}
	
	//possible switch statement instead of if?

}
