package bembos.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import bembos.enums.ProductSize;
import bembos.enums.ProductType;

public class Combo {
	private UUID id;
	private String name;
	private List<ComboItem> items;

    public Combo(String name) {
    	id = UUID.randomUUID();
        setName(name);
        items = new ArrayList<>();
    }
    public Combo() {
    	this("new combo");
    }
    
    //methods    
    public void addProduct(Product product, int count, ProductSize size) {
        items.add(new ComboItem(id, product, count, size));
    }
    
    public void addProduct(Product product, int count) {
        items.add(new ComboItem(id, product, count, ProductSize.REGULAR));
    }
    
    public ComboItem getItemByProductId(UUID productId){
    	return items.stream()
    			.filter(item -> item.getProduct().getId().equals(productId))
    			.findFirst()
    			.orElse(null);
    }
    
    public List<ComboItem> getItemsByType(ProductType type){
    	return items.stream()
    			.filter(item -> item.getProduct().getType().equals(type))
    			.collect(Collectors.toList());
    }
    
    public void updateItemByProductId(UUID productId, ComboItem updated) {
    	items.replaceAll(item -> item.getProduct().getId().equals(productId) ? updated : item);
    }
    
    public boolean deleteItemByProductId(UUID productId) {
    	return items.removeIf(item -> item.getProduct().getId().equals(productId));
    }  
    
    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(ComboItem::getTotalPrice)
                .sum();
    }
    
    @Override
    public String toString() {
    	return String.valueOf(id + "," + name);
    }
    
    
    //getters
    public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}	
	public List<ComboItem> getItems(){
		return new ArrayList<>(items);
	}
	

	//setters
	public void setId(UUID id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setItems(List<ComboItem> items){
		this.items = new ArrayList<>(items);
	}
}
