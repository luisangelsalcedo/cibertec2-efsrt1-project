package bembos.models;

import java.util.UUID;

import bembos.enums.ProductSize;

public class ComboItem {
	private Product product;
	private UUID productID;
	private UUID comboID;	
    private int count;
    private ProductSize size;

    public ComboItem(UUID comboID, Product product, int count, ProductSize size) {
    	setComboID(comboID);
        setProduct(product);
        setCount(count);
        setSize(size);
    }
    public ComboItem(ComboItem item) {
    	this(item.getComboID(),item.getProduct(), item.getCount(), item.getSize());
    }
    public ComboItem() {}

    //getters
	public Product getProduct() {
		return product;
	}
	public int getCount() {
		return count;
	}
	public ProductSize getSize() {
		return size;
	}
	public UUID getComboID() {
		return comboID;
	}
	public UUID getProductID() {
		return productID;
	}

	//setters
	public void setProduct(Product product) {
		this.product = product;
		setProductID(product.getId());
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setSize(ProductSize size) {
		this.size = size;
	}
	public void setComboID(UUID comboID) {
		this.comboID = comboID;
	}
	public void setProductID(UUID productID) {
		this.productID = productID;
	}
	
	
	//methods
	public double getTotalPrice() {
        return product.getPrice() * size.getFactor() * count;
    }
	
	@Override
	public String toString() {
		return String.valueOf(comboID + "," + productID + "," + count + "," + size.toString());
	}

	

	
	
}
