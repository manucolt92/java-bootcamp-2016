package finalProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component("shopCartService")
@Transactional
public class ShopCartServiceImp implements ShopCartService {
	
	private final ShopCartRepository shopCartRepo;
	
	@Autowired
	public ShopCartServiceImp(ShopCartRepository shopCartRepo){
		this.shopCartRepo= shopCartRepo;
	}
	
	public String createShopCart(String user_name){
		ShopCart shopCart= new ShopCart(user_name);
		this.shopCartRepo.save(shopCart);
		return "The Shop Cart was created";
	}
	
	public String deleteShopCart(String user_name){
		this.shopCartRepo.delete(user_name);
		return "The Shop Cart was deleted";
	}
	
	public String addProductToShopCart(String user_name, Product pro){
		ShopCart shopCart= this.shopCartRepo.findOne(user_name);
		shopCart.addProductToShopCart(pro);
		this.shopCartRepo.save(shopCart);
		return shopCart.toString();
	}
	
	public String removeProductFromShopCart(String user_name, Product pro){
		ShopCart shopCart= this.shopCartRepo.findOne(user_name);
		shopCart.removeProductFromShopCart(pro);
		this.shopCartRepo.save(shopCart);
		return shopCart.toString();
	}
	
	public ShopCart showShopCartFromUser(String user_name){
		ShopCart shopCart= this.shopCartRepo.findOne(user_name);
		return shopCart;
	}
	
	public String buyProductFromShopCart(String user_name){
		ShopCart shopCart= this.shopCartRepo.findOne(user_name);
		String aux= shopCart.buyAProduct();
		this.shopCartRepo.delete(user_name);
		return aux;
	}
}
