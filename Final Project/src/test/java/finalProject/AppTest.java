package finalProject;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import static org.junit.Assert.*;
import org.junit.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@EnableMongoRepositories
public class AppTest{ 
    
	@Autowired
	private ShopCartRepository shopCartRepo;
	
	@Autowired
	private ShopCartService shopCartService;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userService;
	
	@Before
	public void initialize(){
		shopCartRepo.deleteAll();
		productRepo.deleteAll();
		userRepo.deleteAll();
	}
	
	@Test
	public void testingApp(){
		//First we add some products
		String aux= productService.addProduct(1, "New Balance Xelima 3.0", "Calzados", 1260.99);
		aux=productService.addProduct(2, "New Balance Acuario", "Calzados", 1285.99);
		aux=productService.addProduct(3, "Sony DB-T40", "Minicomponentes", 3899.99);
		aux=productService.addProduct(4, "iPod Touch 5g 64 Gb", "Audio", 5100);
		aux=productService.addProduct(5, "Auricular Sony DX-75", "Audio", 799.99);
		aux=productService.addProduct(6, "Game Boy Color (Blue)", "Videojuegos", 500);
		
		Product pro1= productService.findOne(1);
		Product pro2= productService.findOne(2);
		Product pro3= productService.findOne(3);
		Product pro4= productService.findOne(4);
		Product pro5= productService.findOne(5);
		Product pro6= productService.findOne(6);
		
		//Now it's time to create a new user
		String userName= "xelimaSw";
		String newUser= userService.addUser(userName, "123456789", "Manuel", "Jimenez");
		Assert.assertTrue(userRepo.exists(userName));
		
		//We have to log in with our new user
		String auxLogIn= userService.setOnline(userName, "123456789");
		 Assert.assertTrue(userRepo.findOne(userName).getStatus());
		 
		//Creating a new shop cart..
		 String newShopCart= shopCartService.createShopCart(userName);
		 Assert.assertTrue(shopCartRepo.exists(userName));
		 
		 //Adding some products to the shop cart
		 aux= shopCartService.addProductToShopCart(userName, pro1);
		 aux= shopCartService.addProductToShopCart(userName, pro4);
		 aux= shopCartService.addProductToShopCart(userName, pro5);
		 aux= shopCartService.addProductToShopCart(userName, pro6);
		 Assert.assertEquals(4, shopCartService.showShopCartFromUser(userName).getProducts().size());
		 
		 //Now, we will remove 2 products from the shop cart
		 aux= shopCartService.removeProductFromShopCart(userName, pro6);
		 aux= shopCartService.removeProductFromShopCart(userName, pro1);
		 aux= shopCartService.removeProductFromShopCart(userName, pro5);
		 Assert.assertEquals(1, shopCartService.showShopCartFromUser(userName).getProducts().size());
		
		 //Purchasing the only product in our shop cart
		 aux= shopCartService.buyProductFromShopCart(userName);
		 System.out.println(aux);
		 
		 //Log out 
		 auxLogIn= userService.setOffline(userName);
		 Assert.assertTrue(!userRepo.findOne(userName).getStatus());
		 
		 //The end
		 newUser= userService.deleteUser(userName);
		 assertTrue(!userRepo.exists(userName));
		
		
	}
}
