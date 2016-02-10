package finalProject;

import java.util.*;

public interface ProductService {
	
	String addProduct(long id, String name, String category, double price);
	
	List<Product> showProducts();
	
	List<Product> findProductByName(String name);
	
	List<Product> findProductByCategory(String category);
	
	Product findOne(long id);
}
