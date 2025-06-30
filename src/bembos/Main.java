package bembos;

import java.awt.EventQueue;
//import java.util.UUID;
//import bembos.controllers.ComboController;
//import bembos.dao.ComboDAO;
//import bembos.dao.ComboItemDAO;
//import bembos.dao.ProductDAO;
//import bembos.enums.ProductSize;
//import bembos.enums.ProductType;
//import bembos.models.Combo;
//import bembos.models.ComboItem;
//import bembos.models.Product;
import bembos.views.Home;

public class Main {

	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
