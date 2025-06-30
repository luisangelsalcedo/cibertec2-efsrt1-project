package bembos.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import bembos.enums.ProductSize;
import bembos.models.ComboItem;
import bembos.models.Product;
import bembos.utils.FileUtil;

public class ComboItemDAO {
	private static final String filePath = "data/itemscombo.txt";
	
	private List<ComboItem> comboItems;
	private ProductDAO productDAO;
	
	public ComboItemDAO() {
		productDAO = new ProductDAO();
		comboItems = new ArrayList<>();
		loadDataFromFile();
	}
	
	public List<ComboItem> getAllItems(){
		return new ArrayList<>(comboItems);
	}
	
	public List<ComboItem> getAllItemsByComboID(UUID comboId){
		return comboItems.stream().filter(item -> item.getComboID().equals(comboId)).collect(Collectors.toList());
	}
	
	public ComboItem findItem(UUID comboID, UUID productID) {
		return comboItems.stream().filter(item -> item.getComboID().equals(comboID) && item.getProductID().equals(productID))
								  .findFirst()
								  .orElse(null);
	}
	
	public void insertItem(ComboItem item) {					
		comboItems.add(item);
		writeDataToFile();
	}
	
	public void insertItems(List<ComboItem> items) {					
		for(ComboItem item : items) {
			comboItems.add(item);
		}
		writeDataToFile();
	}

	public void updateItem(UUID comboID, UUID productID, Product updated, int count, ProductSize size) {
		comboItems.replaceAll(current -> current.getComboID().equals(comboID) && current.getProductID().equals(productID) 
				? new ComboItem(comboID, updated, count, size) 
			    : current);
		writeDataToFile();
	}

	private void loadDataFromFile() {
		try {
			for(String line : FileUtil.readFile(filePath)) {
				String[] fields = line.split(",");
				
				ComboItem item = new ComboItem();
				item.setComboID(UUID.fromString(fields[0]));
				item.setProductID(UUID.fromString(fields[1]));
				item.setCount(Integer.parseInt(fields[2]));
				item.setSize(ProductSize.fromTo(fields[3]));
				item.setProduct(productDAO.findProductById(item.getProductID()));
				
				comboItems.add(item);
			}
		} catch (Exception e) {
			System.out.println("Error leyendo el archivo " + filePath + ": " + e.getMessage());
		}
	}
	
	private void writeDataToFile() {
		try {
			List<String> lines = new ArrayList<>();
			
			for(ComboItem item : comboItems)
				lines.add(item.toString());

			FileUtil.writeFile(filePath, lines);
			
		} catch (Exception e) {
			System.out.println("Error escribiendo el archivo " + filePath + ": " + e.getMessage());
		}
	}
}
