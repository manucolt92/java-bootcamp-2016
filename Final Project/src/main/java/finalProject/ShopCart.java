package finalProject;

import org.springframework.data.annotation.Id;
import java.util.*;

public class ShopCart {
	@Id
	private String user_name;
	private List<Product> listproducts;
	private double subTotal;
	
	protected ShopCart(){}
	
	public ShopCart(String user_name){
		this.user_name= user_name;
		setProducts(new ArrayList<Product>());
		setSubTotal(0);
	}
	
	public ShopCart(String user_name, List<Product> listproducts, double subTotal){
		this.user_name= user_name;
		this.listproducts= listproducts;
		this.subTotal= subTotal;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public List<Product> getProducts() {
		return listproducts;
	}

	public void setProducts(List<Product> listproducts) {
		this.listproducts = listproducts;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	public void addProductToShopCart(Product pro){
		this.listproducts.add(0, pro);
		this.subTotal+=pro.getPrice();
	}
	
	public void removeProductFromShopCart(Product pro){
		if(listproducts.contains(pro) && pro!=null ){
			this.listproducts.remove(pro);
			this.subTotal-= pro.getPrice();
		}
	}
	
	public String buyAProduct(){
		String aux= "You just buy this product: ";
		for(int i=0; i<listproducts.size(); i++){
			aux+= listproducts.get(i).getName();
		}
		aux+=", for $"+ subTotal;
		return aux;
	}
	
	public String clearShopCart(){
		this.listproducts.clear();
		this.subTotal=0.0d;
		return "The Shop Cart has been cleaned";
	}
	
	public double calculateSubTotalOfProductsInShopCart(){
		return this.subTotal;
	}
	
	public String toString() {
        String aux = "";
        for (int i = 0; i < listproducts.size(); i++) {
            aux += listproducts.get(i).toString();
        }
        return String.format(
                "ShopCart[username=%s, subtotal='%f', amount=%d, products=%s]",
                user_name, subTotal, listproducts.size(), aux);
    }
	
	
	
}
