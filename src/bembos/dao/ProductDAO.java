package bembos.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import bembos.enums.ProductSize;
import bembos.enums.ProductType;
import bembos.models.Product;
import bembos.utils.FileUtil;

public class ProductDAO {
	
	private final String filePath =  "data/productos.txt";
	private List<Product> products;
	
	public ProductDAO() {
		products = new ArrayList<>();
		loadDataFromFile();
	}
	
	public List<Product> getAllProducts(){
		return new ArrayList<>(products);
	}
	
	public List<Product> getAllProductsByType(ProductType type){
		return products.stream().filter(product -> product.getType().equals(type)).collect(Collectors.toList());
	}
	
	public Product findProductById(UUID id) {
		return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
	}
	
	public Product findProductByName(String name) {
		return products.stream().filter(product -> product.getName().equals(name)).findFirst().orElse(null);
	}
	
	public void insertProduct(Product product) {					
		products.add(product);
		writeDataToFile();
		
	}

	public void updateProduct(Product product) {
		products.replaceAll(current -> current.getId().equals(product.getId()) ? product : current);
		writeDataToFile();
	}

	private void loadDataFromFile() {
		try {
			for(String line : FileUtil.readFile(filePath)) {
				String[] fields = line.split(",");
				
				Product product = new Product();
				product.setId(UUID.fromString(fields[0]));
				product.setName(fields[1]);
				product.setPrice(Double.parseDouble(fields[2]));
				product.setType(ProductType.fromTo(fields[3]));
				
				products.add(product);
			}
		} catch (Exception e) {
			System.out.println("Error leyendo el archivo " + filePath + ": " + e.getMessage());
		}
	}
	
	private void writeDataToFile() {
		try {
			List<String> lines = new ArrayList<>();
			
			for(Product product : products)
				lines.add(product.toString());

			FileUtil.writeFile(filePath, lines);
			
		} catch (Exception e) {
			System.out.println("Error escribiendo el archivo " + filePath + ": " + e.getMessage());
		}
	}
}
