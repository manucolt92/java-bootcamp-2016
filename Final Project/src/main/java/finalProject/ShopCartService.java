package finalProject;

public interface ShopCartService {
	
	String createShopCart(String user_name);
	
	String addProductToShopCart(String user_name, Product pro);
	
	ShopCart showShopCartFromUser(String user_name);
	
	String removeProductFromShopCart(String user_name, Product pro);
	
	String deleteShopCart(String user_name);
	
	String buyProductFromShopCart(String user_name);
}
