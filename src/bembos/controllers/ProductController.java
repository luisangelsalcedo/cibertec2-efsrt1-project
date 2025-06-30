package bembos.controllers;
import java.util.List;
import bembos.dao.ProductDAO;
import bembos.models.Product;

public class ProductController {
	private static ProductDAO productDAO = new ProductDAO();
	
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}
	
	public Product getProductByName(String productName) {
		return productDAO.findProductByName(productName);
	}
}
