package finalProject;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Long>{
	
	public List<Product> findProductByName(String name);
	public List<Product> findProductByCategory(String category);
}
