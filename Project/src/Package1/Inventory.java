package Package1;
import Package2.*;

public class Inventory {
	private String name;
	private Product[] products;
	private int index;
	
	public Inventory(){
		this.name = "******************\n" 
					+ "Store Inventory\n"
					+ "******************\n";
		this.products = new Product[10];
		this.index = 0;
	}
	
	public Inventory(int size) {
		this.name = "Store Inventory";
		this.products = new Product[size];
		this.index = 0;
	}
	
	//Searches through the array by product name
	public String searchByProductName(String object) {
		String productsName = " ";
		Double productPrice = 0.0;
		int productQty = 0;
		//boolean boCheck = false;
		InvReOrder reOrder = new InvReOrder();
		BackOrder bo = new BackOrder();
		
		
		for(int i = 0; i < products.length; i++) {
			if(products[i] != null) {
				productsName = products[i].getProductName();
			}
			
			//transferring data to the other classes
			if(productsName.equalsIgnoreCase(object)) {
				
				productQty = products[i].getQty();
				bo.setBo(productQty);
				
				boolean boCheck = bo.getBo();
				reOrder.setOrdQty(boCheck);
				
				productPrice = products[i].getUnitCost();
				reOrder.SetOrdTotal(productPrice);
				
				productsName = products[i].toString();
				break;
			}
			else if(!(productsName.equalsIgnoreCase(object))) {
				productsName = "No such item";
			}
			
		}
		return "******************\n"
				+ "Search Engine\n" 
				+ "******************\n"
				+productsName;
	}
	
	
	//adds a new product to the array
	public void addProduct(Product product) {
		if(index == products.length)
			ensureCapacity();
		
		this.products[index] = product;
		index++;
	}
	
	//doubles the size of the array if it's full
	private void ensureCapacity() {
		int newSize = products.length * 2;
		Product[] newArray = new Product[newSize];
		
		for(int i = 0; i < products.length; i++) {
			newArray[i] = products[i];
		}
		products = newArray;
	}

	//displays the products in the array
	public String toString() {
		String storeInventory = this.name;
		for(int i = 0; i < index; i++) {
			storeInventory += products[i].toString() + "\n_________________________________________\n"
					+ "\n";
		}
		return storeInventory;
	}

}