package finalProject;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("productService")
@Transactional
public class ProductServiceImp implements ProductService {
	
	private final ProductRepository productRepo;
	
	@Autowired
	public ProductServiceImp(ProductRepository productRepo){
		this.productRepo= productRepo;
	}
	
	public String addProduct(long id, String name, String category, double price){
		Product pro= new Product(id, name, category, price);
		this.productRepo.save(pro);
		return "The product has been added.";
	}
	
	public List<Product> showProducts(){
		List<Product> products= new ArrayList<Product>();
		products= productRepo.findAll();
		return products;
	}
	
	public List<Product> findProductByName(String name){
		List<Product> products= new ArrayList<Product>();
		products= productRepo.findByProductName(name);
		return products;
	}
	
	public List<Product> findProductByCategory(String category){
		List<Product> products= new ArrayList<Product>();
		products= productRepo.findByProductName(category);
		return products;
	}
	
	public Product findOne(long id){
		return this.productRepo.findOne(id);
	}
}
