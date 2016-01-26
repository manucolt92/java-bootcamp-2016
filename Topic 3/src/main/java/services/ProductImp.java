package services;

public class ProductImp implements Product{
	
	
	private double price;
	private String name, description;
	
	public ProductImp(){
		price= 0.0d;
		name= "The name has not been specificated";
		description= "The description has not been specificated";		
	}
	
	public ProductImp(double p, String n, String d){
		if(p>0.0d){
			price=p;
			name= n;
			description= d;
		}
		else {
			System.out.println("\nThe price must be positive.\n");
		}
	}
	
	
	public double getPrice(){
		return price;
	}
	
	
	public void setPrice(double price){
		this.price= price;
	}
	
	
	public String getName(){
		return name;
	}
	
	
	public void setName(String name){
		this.name= name;
	}
	
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description= description;
	}
}



