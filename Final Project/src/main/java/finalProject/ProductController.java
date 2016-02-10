package finalProject;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	private final AtomicLong counter = new AtomicLong();
	
	
	@RequestMapping(value= "/addProduct", method= RequestMethod.POST)		
	String addProduct(@RequestParam(value= "name")String name,
			@RequestParam(value= "category")String category, 
			@RequestParam(value= "price")double price){
		return productService.addProduct(counter.incrementAndGet(), name, category, price);
	}	
	
    @RequestMapping(value= "/showAllProducts", method = RequestMethod.GET)   
    List<Product> getAllProducts() {
        return productService.showProducts();
    }	
	
    @RequestMapping(value = "/findProductByName", method = RequestMethod.GET)    
	public List<Product> findProductByName(@RequestParam(value="name") String name) {
        return productService.findProductByName(name);
    }	
	
    @RequestMapping(value = "/findProductByCategory", method = RequestMethod.GET)    
	public List<Product> findproductbycategory(@RequestParam(value="category") String category) {
        return productService.findProductByCategory(category);
    }
}
