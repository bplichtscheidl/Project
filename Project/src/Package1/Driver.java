package Package1;
import Package2.*;

public class Driver {

	public static void main(String[] args) {
	
		Inventory inv = new Inventory();
		BackOrder bo = new BackOrder();
		InvReOrder re = new InvReOrder();
		Product product1 = new Product("Paper", 3, 59.99, 000000000);
		Product product2 = new Product("Pickles", 5, 3.99, 000000000);
		Product product3 = new Product("Nvidia 1080 TI Graphics Card", 3, 899.99, 000000000);
		
		
		inv.addProduct(product1);
		inv.addProduct(product2);
		inv.addProduct(product3);
		
		int item1 = inv.SearchForQty("Paper");
		int item2 = inv.SearchForQty("Pickles"); //putting fatal error on top of output and still iterating the code to output true when it should be nothing
		int item3 = inv.SearchForQty("Nvidia 1080 TI Graphics Card");
		boolean qty1 = bo.isBo(item1);
		boolean qty2 = bo.isBo(item2);
		boolean qty3 = bo.isBo(item3);
		int boQty1 = re.getOrdQty(qty1);
		int boQty2 = re.getOrdQty(qty2);
		int boQty3 = re.getOrdQty(qty3);
		product1.setBackOrder(boQty1);
		product2.setBackOrder(boQty2);
		product3.setBackOrder(boQty3);
		double price1 = inv.SearchForPrice("Paper");
		double price2 = inv.SearchForPrice("Pickles");
		double price3 = inv.SearchForPrice("Nvidia 1080 TI Graphics Card");
		double resupply1 = re.SetOrdTotal(price1);
		double resupply2 = re.SetOrdTotal(price2);
		double resupply3 = re.SetOrdTotal(price3);
		product1.setBackOrderTotal(resupply1);
		product2.setBackOrderTotal(resupply2);
		product3.setBackOrderTotal(resupply3);
		String item = inv.searchByProductName("Nvidia 1080 TI Graphics Card");
	
		System.out.print(inv.toString());
		System.out.println(item);
		System.out.println(qty1);
		System.out.println(qty2);
		System.out.println(qty3);
		//System.out.println(re.toString());
		

	}

}

