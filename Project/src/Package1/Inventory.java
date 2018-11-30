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
		
		for(int i = 0; i < products.length; i++) {
			if(products[i] != null) {
				productsName = products[i].getProductName();
			}
			
			if(productsName.equalsIgnoreCase(object)) {
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
	
	//Searches the array by product name and gets the quantity of the product
	public int SearchForQty(String object) {
		String productsName = " ";
		int productQty = 0;
		
		for(int i = 0; i < products.length; i++) {
			if(products[i] != null) {
				productsName = products[i].getProductName();
			}
	
			if(productsName.equalsIgnoreCase(object)) {
				productQty = products[i].getQty();
				break;
			}
			else if(!(productsName.equalsIgnoreCase(object))) {
				productQty = 0;
			}
			
		}
		return productQty;
	}
	
	//Searches the array by product name and gets the price of the product
	public double SearchForPrice(String object) {
		String productsName = " ";
		double productPrice = 0;
	
		for(int i = 0; i < products.length; i++) {
			if(products[i] != null) {
				productsName = products[i].getProductName();
			}
	
			if(productsName.equalsIgnoreCase(object)) {
				productPrice = products[i].getUnitCost();
				break;
			}
			else if(!(productsName.equalsIgnoreCase(object))) {
				productPrice = 1000000.00;
			}
			
		}
		return productPrice;
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
			storeInventory += products[i].toString() + "_______________" 
					+ "__________________________\n"
					+ "\n";
		}
		return storeInventory;
	}

}
