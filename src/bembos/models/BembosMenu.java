package bembos.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import bembos.utils.Utils;

public class BembosMenu implements Product{
	private String name;	
	private String slug;
	private List<Product> products;
	private double price;
	
	public BembosMenu(String name) {
		setName(name);
		products = new ArrayList<>();
		price = 0.0;
	}
	
	// getters
	@Override
	public String getName() {
		return name;
	}
	@Override
	public String getSlug() {
		return slug;
	}
	@Override
	public double getPrice() {
		return price;
	}
	
	// setters
	public void setName(String name) {
		this.name = name;
		slug = Utils.createSlug(name);
	}
	
	// methods
	private void calculatePrice() {
		price = products.stream().mapToDouble(Product::getPrice).sum();		
	}
	
	public void addProduct(Product product) {
		products.add(product);
		calculatePrice();
	}
	
	public List<Product> getAllProducts() {
		return new ArrayList<>(products);
	}
	
	public Product getProductByName(String name){		
		for(Product product:products) {
			if(product.getName().equalsIgnoreCase(name)) {
				return product;
			}
		}
		return null;
	}
	
	public boolean removeProduct(String name){
		Iterator<Product> iterator = products.iterator();
		
		while(iterator.hasNext()) {
			Product currentProduct = iterator.next();
			if(currentProduct.getName().equalsIgnoreCase(name)) {
				iterator.remove();
				calculatePrice();
				return true;
			}
		}
		return false;
	}
	
	public boolean updateProduct(String name, Product updatedProduct){
		for(int index = 0; products.size() > index; index++) {
			Product currentProduct = products.get(index);
			
			if(currentProduct.getName().equalsIgnoreCase(name)) {
				products.set(index, updatedProduct);
				calculatePrice();
				return true;
			}
		}
		return false;
	}
	
	public List<Burger> getAllBurgers(){		
		List<Burger> burgers = new ArrayList<>();		
		for(Product product:getAllProducts()) {
			if(product instanceof Burger) 
				burgers.add((Burger) product);			
		}
		return burgers;		
	}
	
	public List<Potatoes> getAllPotatoes(){
		List<Potatoes> potatoes = new ArrayList<>();
		for(Product product:getAllProducts()) {
			if(product instanceof Potatoes) {
				potatoes.add((Potatoes) product);
			}
		}
		return potatoes;
	}
	
	public List<Soda> getAllSodas(){
		List<Soda> sodas = new ArrayList<>();
		for(Product product:getAllProducts()) {			
			if(product instanceof Soda) {
				sodas.add((Soda) product);
			}
		}
		return sodas;
	}
	
}
