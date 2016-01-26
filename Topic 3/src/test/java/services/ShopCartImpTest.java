package services;

import org.junit.*;

public class ShopCartImpTest{ 
    
	@Test
	public void cartEmptyBeforeCreation(){
		ShopCart cartTest1= new ShopCartImp();
		Assert.assertTrue(cartTest1.getAmountProductsInCart()==0);
		
 	}
	
	@Test
	public void subTotalIsZeroBeforeCreation(){
		ShopCart cartTest2= new ShopCartImp();
		Assert.assertTrue(cartTest2.calculateSubTotalOfProducts()==0);
	}
	
	@Test
	public void incrementAmountOfProductsBeforeAdding(){
		ShopCart cartTest3= new ShopCartImp();
		Product pTest1= new ProductImp(350.99, null, null);
		Product pTest2= new ProductImp(200.5, null, null);
		cartTest3.addProductToCart(pTest1);
		Assert.assertTrue(cartTest3.getAmountProductsInCart()==1);
		cartTest3.addProductToCart(pTest2);
		Assert.assertTrue(cartTest3.getAmountProductsInCart()==2);
	}
	
	@Test
	public void incrementSubTotalOfProductsBeforeAdding(){
		double p1=350.99, p2=65.99, p3= 1047.5;
		ShopCart cartTest4= new ShopCartImp();
		Product pTest3= new ProductImp(p1, null, null);
		Product pTest4= new ProductImp(p2, null, null);
		Product pTest5= new ProductImp(p3, null, null);
		cartTest4.addProductToCart(pTest3);
		Assert.assertTrue(cartTest4.calculateSubTotalOfProducts()==p1);
		cartTest4.addProductToCart(pTest4);
		Assert.assertTrue(cartTest4.calculateSubTotalOfProducts()==p1+p2);
		cartTest4.addProductToCart(pTest5);
		Assert.assertTrue(cartTest4.calculateSubTotalOfProducts()==p1+p2+p3);		
		
	}

	@Test
	public void clearCartSetAmountProductsInZero(){
		ShopCart cartTest5= new ShopCartImp();
		Product pTest6= new ProductImp(558, null, null);
		Product pTest7= new ProductImp(21, null, null);
		Product pTest8= new ProductImp(99.75, null, null);
		cartTest5.addProductToCart(pTest6);
		cartTest5.addProductToCart(pTest7);
		cartTest5.addProductToCart(pTest8);
		cartTest5.clearCart();
		Assert.assertTrue(cartTest5.getAmountProductsInCart()==0);
		
	}
	
	@Test
	public void clearCartSetSubTotalOfProducsInZero(){
		ShopCart cartTest6= new ShopCartImp();
		Product pTest9= new ProductImp(558, null, null);
		Product pTest10= new ProductImp(21, null, null);
		Product pTest11= new ProductImp(99.75, null, null);
		cartTest6.addProductToCart(pTest9);
		cartTest6.addProductToCart(pTest10);
		cartTest6.addProductToCart(pTest11);
		cartTest6.clearCart();
		Assert.assertTrue(cartTest6.calculateSubTotalOfProducts()==0);
	}
    
    
}
