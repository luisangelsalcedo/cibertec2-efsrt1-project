package bembos.models;

import bembos.utils.Utils;
import interfaces.SizeProduct;

public class Burger implements Product{
	private String name;
	private String slug;
	private SizeProduct size;
	private double price;
	
	public Burger(String name, double price, SizeProduct size) {
		setName(name);
		setSize(size);
		setPrice(price);
	}
	public Burger(String name, double price){
		this(name, price, SizeProduct.REGULAR);
	}
	public Burger(Burger burger, SizeProduct sise){
		this(burger.getName(), burger.getPrice(), sise);
	}
	public Burger(Burger burger){
		this(burger.getName(), burger.getPrice(), burger.getSizeObject());
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
