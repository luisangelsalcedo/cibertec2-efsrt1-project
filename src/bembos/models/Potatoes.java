package bembos.models;

import bembos.utils.Utils;
import interfaces.SizeProduct;

public class Potatoes implements Product{
	private String name;
	private String slug;
	private SizeProduct size;
	private double price;
	
	public Potatoes(String name, double price, SizeProduct size) {
		setName(name);
		setSize(size);
		setPrice(price);
	}
	public Potatoes(double price, SizeProduct size) {
		this("Papas fritas", price, size);
	}
	public Potatoes(double price) {
		this(price, SizeProduct.REGULAR);
	}
	public Potatoes(Potatoes potatoes, SizeProduct size){
		this(potatoes.getName(), potatoes.getPrice(), size);
	}
	public Potatoes(Potatoes potatoes){
		this(potatoes.getName(), potatoes.getPrice(), potatoes.getSizeObject());
	}
	
	
	// getters
	@Override
	public String getName() {
		return name;
	}
	@Override
	public String getSlug(){
		return slug;
	}
	@Override
	public double getPrice(){
		return price;
	}	
	public String getSize(){
		return size.toString();
	}	
	public SizeProduct getSizeObject(){
		return size;
	}
	
	
	//setters
	public void setName(String name) {
		this.name = name;
		slug = Utils.createSlug(name);
	}
	public void setPrice(double price){
		this.price = price * size.getFactor();
	}	
	public void setSize(SizeProduct size){
		this.size = size;
	}

}
