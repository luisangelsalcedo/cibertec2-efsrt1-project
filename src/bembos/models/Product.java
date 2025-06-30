package bembos.models;

import java.io.Serializable;
import java.util.UUID;
import bembos.enums.ProductType;
import bembos.utils.Utils;

public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	private UUID id;
    private String name;
    private String slug;
    private double price;
    private ProductType type; 
    
    public Product(ProductType type, String name, double price){
    	id = UUID.randomUUID();
        setName(name);
        setPrice(price);
        setType(type);
    }
    public Product(Product product) {
    	this(product.getType(), product.getName(), product.getPrice());
    	setId(product.getId());
    }
    public Product() {
    	this(null, "new product", 0.0);
    }

    
    // getters
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSlug(){
		return slug;
	}
	public double getPrice(){
		return price;
	}
	public ProductType getType() {
		return type;
	}


	
    //setters
	public void setId(UUID id){
		this.id = id;
	}
	public void setName(String name) {
		if(name.trim().isEmpty() || name.length() <= 2) 
			throw new IllegalArgumentException("el name: " + name + " debe tener mas de 2 caracteres");
		
		this.name = name;
		slug = Utils.createSlug(name);
	}
	public void setPrice(double price){
		this.price = price;
	}
	public void setType(ProductType type) {
		this.type = type;
	}

	
	//methods
	@Override
	public String toString() {
		return String.valueOf(id + "," + 
							name + "," + 
							price + "," + 
							type.toString());
	}
}

