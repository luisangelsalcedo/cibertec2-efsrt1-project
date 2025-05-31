package bembos.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import bembos.controllers.BembosMenuController;
import bembos.models.BembosMenu;
import bembos.models.Burger;
import bembos.models.Potatoes;
import bembos.models.Soda;
import db.AppData;

public class ViewGetAllProducts extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea txtProductList;
	
	public ViewGetAllProducts(JDialog parent) {

		JLabel lblProductList = new JLabel("Listado de promociones");
		lblProductList.setForeground(AppData.$white);
		
		txtProductList = new JTextArea();
		txtProductList.setRows(20);
		txtProductList.setColumns(35); 
		txtProductList.setLineWrap(true);
		txtProductList.setWrapStyleWord(false);
        txtProductList.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(txtProductList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 

        JButton btnSave = new JButton("Listar");
		btnSave.setBackground(AppData.$secondaryColor);
		btnSave.setForeground(AppData.$primaryColor);
		btnSave.addActionListener(e -> onSubmit(e));
		
		JButton btnClose = new JButton("Cerrar");
		btnClose.setBackground(AppData.$primaryLightColor);
		btnClose.setForeground(AppData.$white);
		btnClose.addActionListener(e -> {
			parent.dispose();
		});

		// Button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2, 10, 0));
		buttonPanel.setOpaque(false);
		buttonPanel.add(btnSave);
		buttonPanel.add(btnClose);

		setLayout(new BorderLayout(0, 10));
		add(lblProductList, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	private void onSubmit(ActionEvent event) {
		
		BembosMenuController menuController = new BembosMenuController();
		
		txtProductList.append("LISTADO DE PROMOCIONES\n");
		
		for(BembosMenu menu:menuController.getAllMenus()) {
			txtProductList.append("\nPromo: " + menu.getName());
			
			if(menu.getAllBurgers().size() > 0) {
				txtProductList.append("\nHamburguesa");
				for(Burger burger:menu.getAllBurgers()) {
					txtProductList.append("\n	: 01 "  + burger.getName() + " " + burger.getSize());	
				}			
			}
			if(menu.getAllPotatoes().size() > 0) {				
				txtProductList.append("\nPapas");
				for(Potatoes potatoes:menu.getAllPotatoes()) {
					txtProductList.append("\n	: 01 "  + potatoes.getName() + " " + potatoes.getSize());	
				}
			}
			
			if(menu.getAllSodas().size() > 0) {
				txtProductList.append("\nBebida");
				for(Soda soda:menu.getAllSodas()) {
					txtProductList.append("\n	: 01 "  + soda.getName());	
				}
			}

			txtProductList.append("\nCantidad	: " + menu.getAllProducts().size() + " productos");
			txtProductList.append("\nPrecio Total	: S/. " + String.format("%,5.2f", menu.getPrice()));
			txtProductList.append("\n---------------------------------------------------------\n");
		}
	}		
}
