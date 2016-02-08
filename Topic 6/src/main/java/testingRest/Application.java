package testingRest;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	
	@Bean
	CommandLineRunner init(UserRepository userRepo){
		return evt -> {
			User user1= userRepo.save(new User("carlosI", "Carlos", "Primero"));
			User user2= userRepo.save(new User("carlosII", "Carlos", "Segundo"));
			User user3= userRepo.save(new User("carlosIII", "Carlos", "Tercero"));
			User user4= userRepo.save(new User("carlosIV", "Carlos", "Cuarto"));
			User user5= userRepo.save(new User("carlosV", "Carlos", "Quinto"));
			User user6= userRepo.save(new User("carlosVI", "Carlos", "Sexto"));
		};
	}
	
	public static void main(String args[]){
		SpringApplication.run(Application.class, args);
	}
	
	
	
}	
