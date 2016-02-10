package finalProject;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShopCartRepository extends MongoRepository<ShopCart, String> {

}
