package bembos.controllers;

import java.util.List;
import java.util.UUID;
import bembos.dao.ComboDAO;
import bembos.dao.ComboItemDAO;
import bembos.models.Combo;
import bembos.models.ComboItem;

public class ComboController {
	private static ComboDAO comboDAO = new ComboDAO();
	private static ComboItemDAO itemDAO = new ComboItemDAO();
	
	
	public List<Combo> getAllCombos() {
		return comboDAO.getAllCombos();
	}
	
	public List<ComboItem> getAllItemsByComboID(UUID comboID) {
		return itemDAO.getAllItemsByComboID(comboID);
	}
	
	public Combo getCompleteComboByID(UUID comboID) {
		Combo found = comboDAO.findComboById(comboID);
		found.setItems(getAllItemsByComboID(comboID));
		
		return found;
	}
	
	public void insertCombo(Combo combo) {
		comboDAO.insertCombo(combo);
		itemDAO.insertItems(combo.getItems());
	}
	
	
	
	
	
//	
//	ProductDAO daop = new ProductDAO();
//	ComboDAO daoc = new ComboDAO();
//	ComboItemDAO daoi = new ComboItemDAO();
//	
//	Combo combo1 = new Combo();
//	combo1.addProduct(daop.findProductById(UUID.fromString("10d64f67-5cc5-4ca1-b73c-55775ad20236")), 2, ProductSize.MEDIUM);
//	combo1.addProduct(daop.findProductById(UUID.fromString("1a264d92-2e36-41c7-8837-157bb7dd560e")), 2, ProductSize.MEDIUM);
//	
//	System.out.println(combo1.getId());		
//	System.out.println(combo1.getTotalPrice());		
//	System.out.println(combo1.toString());
//	
//	daoc.insertCombo(combo1);
//	daoi.insertItems(combo1.getItems());
//	Product burger1 = daop.findProductById(UUID.fromString("10d64f67-5cc5-4ca1-b73c-55775ad20236"));
//	Product burger2 = daop.findProductById(UUID.fromString("62568e90-0395-47e3-aed4-00583e1cf93d"));
//	Product burger3 = daop.findProductById(UUID.fromString("2aeb1af9-75d4-42ae-a4c5-1e6772e9037e"));
//	UUID comboID = UUID.fromString("f5658de2-d999-4328-ad2a-59b5f3ea9130");
//	Combo combo2 = daoc.findComboById(comboID);
//	combo2.setItems(daoi.getAllItemsByComboID(comboID));
//	System.out.println(combo2.toString());		
//	System.out.println(combo2.getItems().size());
//	for(ComboItem item:combo2.getItems()) {
//		
//		System.out.println(item.getProduct().toString());		
//	}
//	
//	daoi.updateItem(comboID, burger3.getId(), burger2, 20, ProductSize.REGULAR);
//	combo2.setItems(daoi.getAllItemsByComboID(comboID));
//	
//	for(ComboItem item:combo2.getItems()) {
//		
//		System.out.println(item.getProduct().toString());		
//	}
	
//	ComboController control = new ComboController();
//	for(ComboItem items : control.getAllItemsByComboID(comboID)) {
//		System.out.println(items.getProduct().toString());		
//	}
//		System.out.println(control.getCompleteComboByID(comboID).toString());		
//		System.out.println(control.getCompleteComboByID(comboID).getItems().get(0).getProduct().getName());		

}
