package finalProject;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Long>{
	
	public List<Product> findByProductName(String name);
	public List<Product> findByProductCategory(String category);
}
