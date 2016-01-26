package services;

public interface ShopCart {

	public void addProductToCart(Product p);
	
	public void removeProductFromCart(Product p);
	
	public String clearCart();
	
	public double calculateSubTotalOfProducts();
	
	public int getAmountProductsInCart();
	
	public boolean existProductInCart(Product p);	
	
}
