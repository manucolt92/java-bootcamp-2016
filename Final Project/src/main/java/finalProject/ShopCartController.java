package finalProject;

import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
@RequestMapping("/shopCart")
@ComponentScan("finalProject")
@Api(value = "shopCart", description = "")

public class ShopCartController {
	
	@Autowired
	private ShopCartService shopCartService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="{userName}/createShopCart", method = RequestMethod.POST)
    String createShopCart(@PathVariable String userName) {
        return shopCartService.createShopCart(userName);
    }	
	
    @RequestMapping(value = "/{userName}/addToShopCart", method = RequestMethod.POST)    
    String addProductToShopCart(@PathVariable String userName,
    		@RequestParam(value= "productId")long productId){
		Product product= productService.findOne(productId);
		return shopCartService.addProductToShopCart(userName, product);
	}
    
    @RequestMapping(value="{userName}/removeProductFromShopCart", method = RequestMethod.DELETE)
    String removeProductFromShopCart(@PathVariable String userName,
                            @RequestParam(value="productId") long productId) {
        Product product = productService.findOne(productId);
        return shopCartService.removeProductFromShopCart(userName, product);
    }

    @RequestMapping(value="{userName}/deleteShopCart", method = RequestMethod.DELETE)
    String deletecart(@PathVariable String userName) {
        return shopCartService.deleteShopCart(userName);
    }

    @RequestMapping(value="{userName}/showShopCartFromUser", method = RequestMethod.GET)
    public ShopCart showShopCart(@PathVariable String userName) {
        return shopCartService.showShopCartFromUser(userName);
    }

    @RequestMapping(value="{userName}/buyProductFromShopCart")
    public String buyProductFromShopCart(@PathVariable String userName) {
        return shopCartService.buyProductFromShopCart(userName);
    }
    
    
}
