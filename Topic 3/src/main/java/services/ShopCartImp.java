package services;

import java.util.*;

public class ShopCartImp implements ShopCart {

	
	private int amountOfPro;
	private double subTotal;
	private List<Product> cart;
	
	public ShopCartImp(){
		amountOfPro=0;
		subTotal=0.0d;
		cart= new LinkedList<Product>();
	}
	
	/*This method accepts product duplicates in chart*/
	public void addProductToCart(Product p){
		if(p!=null){
			amountOfPro++;
			subTotal+= p.getPrice();
			cart.add(0, p);
		}
	}
	
	/*This method not accepts product duplicates in chart*/
	public void addProductToCartWithOutDuplicate(Product p){
		if(!cart.contains(p) && p!=null){
			amountOfPro++;
			subTotal+= p.getPrice();
			cart.add(0, p);
		}
	}
	
	public void removeProductFromCart(Product p){
		if(cart.contains(p) && p!=null){
			amountOfPro--;
			subTotal-= p.getPrice();
			cart.remove(p);
		}
	}
	
	public String clearCart(){		
		cart.clear();
		amountOfPro=0;
		subTotal=0.0d;
		return "The cart has been cleaned";
	}
	
	public double calculateSubTotalOfProducts(){
		return subTotal;
	}
	
	public int getAmountProductsInCart(){
		return amountOfPro;
	}
	
	/*This method is use to verify if one product is in cart and also we can use to verify if the product is duplicated, triplicated, ..., in cart*/
	public boolean existProductInCart(Product p){
		if(p!=null){
			cart.contains(p);
			return true;
		}
		else return false;
	}
	

	
	
}
