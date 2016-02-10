package finalProject;

import org.springframework.data.annotation.Id;

public class Product {
	@Id
	private long id;
	private String name, category;
	private double price;
	
	protected Product(){}
	
	public Product(long id, String name, String category, double price) {
        this.setId(id);
        this.setName(name);
        this.setCategory(category);
        this.setPrice(price);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString(){
		return String.format(
                "Product[id=%d, name=%s, category='%s', price='%f']",
                id, name, category, price);
	}
	
}
