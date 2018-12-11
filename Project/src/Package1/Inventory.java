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
	
	public boolean searchForDuplicate(String object) {
		String productsName = " ";
		boolean duplicate = false;
		
		for(int i = 0; i < products.length; i++) {
			if(products[i] != null) {
				productsName = products[i].getProductName();
			}
			
			if(productsName.equalsIgnoreCase(object)) {
				duplicate = true;
				productsName = "Item already exists";
				break;
			}
		}
		return duplicate;
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
	
	public String removeProduct(String object) {
		String productName = " ";
		
		for(int i = 0; i < products.length; i++) {
			if(products[i] != null) {
				productName = products[i].getProductName();
			}
			
			if(productName.equalsIgnoreCase(object)) {
				products[i] = null;
				
				for(int count = i; count < products.length - 1; count++) {
						products[count] = products[count + 1];
				}
				productName = object + " has been removed.";
				break;
			}
			if(!(productName.equalsIgnoreCase(object))) {
				productName = "No such item";
			}
		}
		return productName;
		
	}
	
	public void addProduct(String productName, int qty, double unitCost, InvReOrder reOrder) {
		Product product = new Product(productName, qty, unitCost, reOrder);
		addProduct(product);
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
			if(products[i] == null)
			products[i] = products[i+1];
			
			else{
			storeInventory += products[i].toString() + "\n_________________________________________\n"
					+ "\n";
			}
		}
		return storeInventory;
	}

}
