package bembos.models;

import bembos.utils.Utils;

public class Soda implements Product{
	private String name;
	private String slug;
	private double price;
	
	public Soda(String name, double price) {
		setName(name);
		setPrice(price);
	}
	public Soda(Soda soda) {
		this(soda.getName(), soda.getPrice());
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
	
	//setters
	public void setName(String name) {
		this.name = name;
		slug = Utils.createSlug(name);
	}
	public void setPrice(double price){
		this.price = price;
	}	
}
