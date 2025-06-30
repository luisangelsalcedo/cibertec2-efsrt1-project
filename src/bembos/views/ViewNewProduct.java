package bembos.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bembos.controllers.ComboController;
import bembos.controllers.ProductController;
import bembos.enums.ProductSize;
import bembos.models.Combo;
import bembos.models.ComboItem;
import bembos.models.Product;
import bembos.utils.Utils;
import bembos.views.components.CustomAlert;
import bembos.views.components.MainDialog;
import bembos.views.components.ProductGraphic;
import db.StyleTheme;
import interfaces.AlertType;

public class ViewNewProduct extends JPanel {

	private static final long serialVersionUID = 1L;
	private ProductGraphic productPanel;
	private ProductController controller;
	private ComboController comboController;
	private JTextField txtComboName;
	private JTextField txtCount;
	private JComboBox<String> cmbProducts;
	private JComboBox<String> cmbSize;
	private JButton submitBtn;
	private Combo newcombo;
	private UUID comboID;
	private List<ComboItem> items;
	private JPanel buttonsPanel;

	public ViewNewProduct() {
		productPanel = new ProductGraphic();
		controller = new ProductController();
		comboController = new ComboController();
		newcombo = new Combo();
		comboID = newcombo.getId();
		items = new ArrayList<>();
		
		txtComboName = new JTextField();
		txtCount = new JTextField();
		
		String[] productComboList = Utils.createComboBoxArray(controller.getAllProducts(), "Selecciona un producto", product -> product.getName());
		cmbProducts = new JComboBox<String>(productComboList);
		
		String[] sizeComboList = Utils.createComboBoxArray(List.of(ProductSize.values()), "Selecciona el tamano", size -> size.toString());
		cmbSize = new JComboBox<String>(sizeComboList);
		
		String[] lables = {"Nombre del Combo:", "Agregar:", "Tamano", "Cantidad"};
		
		submitBtn = new JButton("Agregar");
		submitBtn.addActionListener(e -> addItemAction(e));
		submitBtn.setBackground(StyleTheme.$secondaryColor);
		submitBtn.setForeground(StyleTheme.$primaryColor);
		
		JPanel addBtnPanel = new JPanel();
		addBtnPanel.setOpaque(false);	
		addBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		addBtnPanel.add(submitBtn);
		
		JPanel formPanelLeft = new JPanel();
		formPanelLeft.setOpaque(false);	
		formPanelLeft.setLayout(new GridLayout(4,1,10,10));	
		for(String label:lables) {
			JLabel labelItem = new JLabel(label);
			labelItem.setForeground(Color.WHITE);
			formPanelLeft.add(labelItem);
		}
		
		JPanel formPanelRight = new JPanel();
		formPanelRight.setOpaque(false);
		formPanelRight.setLayout(new GridLayout(4,1,10,10));
		formPanelRight.add(txtComboName);
		formPanelRight.add(cmbProducts);
		formPanelRight.add(cmbSize);
		formPanelRight.add(txtCount);
		
		JPanel formPanel = new JPanel();
		formPanel.setOpaque(false);
		formPanel.setLayout(new BorderLayout(10,10));
		formPanel.add(formPanelLeft, BorderLayout.WEST);
		formPanel.add(formPanelRight, BorderLayout.CENTER);
		formPanel.add(addBtnPanel, BorderLayout.EAST);	
		
		JButton saveBtn = new JButton("Guardar");
		saveBtn.addActionListener(e -> saveAction(e));
		saveBtn.setBackground(StyleTheme.$secondaryColor);
		saveBtn.setForeground(StyleTheme.$primaryColor);
		
		JButton deleteBtn =new JButton("Borrar");
		deleteBtn.addActionListener(e -> deleteAction(e));
		deleteBtn.setBackground(StyleTheme.$primaryLightColor);
		deleteBtn.setForeground(Color.WHITE);
		
		buttonsPanel = new JPanel();
		buttonsPanel.setOpaque(false);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonsPanel.add(saveBtn);
		buttonsPanel.add(deleteBtn);
		buttonsPanel.setVisible(false);
		
		JPanel displayPanel = new JPanel();
		displayPanel.setOpaque(false);
		displayPanel.setLayout(new BorderLayout());
		displayPanel.add(productPanel, BorderLayout.NORTH);
		displayPanel.add(buttonsPanel, BorderLayout.CENTER);
		
		
		
		setLayout(new BorderLayout());
		add(formPanel, BorderLayout.CENTER);
		add(displayPanel, BorderLayout.SOUTH);
		setOpaque(false);
	}
	
	private Object deleteAction(ActionEvent e) {
		items.removeAll(items);
		productPanel.render(items);
		buttonsPanel.setVisible(false);
		clean();
		MainDialog.getInstance().pack();
		MainDialog.getInstance().setLocationRelativeTo(null);
		return null;
	}

	private Object saveAction(ActionEvent e) {
		String comboName = txtComboName.getText();
		
		if(comboName.trim().isEmpty()) {
			new CustomAlert("Define un nombre para el combo", AlertType.NOTICE);
			txtComboName.requestFocus();
			return null;
		}
		System.out.println(comboName);

		newcombo.setName(comboName);
		newcombo.setItems(items);
		comboController.insertCombo(newcombo);
		
		new CustomAlert("El combo "+ comboName + " ha sido agregado con exito", AlertType.SUCCESS);
		
		
		items.removeAll(items);
		productPanel.render(items);
		buttonsPanel.setVisible(false);
		clean();
		txtComboName.setText("");
		
		newcombo = new Combo();
		comboID = newcombo.getId();
		
		MainDialog.getInstance().pack();
		MainDialog.getInstance().setLocationRelativeTo(null);
		return null;
	}

	private Object addItemAction(ActionEvent e) {
		Product product;
		ProductSize size;
		int newCount;
		
		product = controller.getProductByName((String) cmbProducts.getSelectedItem());
		if (product == null) {
			new CustomAlert("Selecciona un producto valido", AlertType.NOTICE);
			cmbProducts.requestFocus();
			return null;
		}		
		
		try {
			size = ProductSize.fromTo((String) cmbSize.getSelectedItem());
		} catch (Exception e2) {
			new CustomAlert("Selecciona un tamano valido", AlertType.NOTICE);
			cmbSize.requestFocus();
			return null;
		}		
		
		try {
			newCount = Integer.parseInt(txtCount.getText());
		} catch (Exception e2) {
			new CustomAlert("Ingresa una cantidad validad", AlertType.NOTICE);
			txtCount.requestFocus();
			return null;
		}
		
		if(items.stream().anyMatch(current -> current.getProductID().equals(product.getId()) && current.getSize().equals(size))) {
			
			items.replaceAll(current -> current.getProductID().equals(product.getId()) && current.getSize().equals(size) 
				? new ComboItem(current.getComboID(), current.getProduct(), current.getCount() + newCount, current.getSize())
				: current);
			
		} else items.add(new ComboItem(comboID,product,newCount,size));
		
		productPanel.render(items);
		
		//show buttons
		buttonsPanel.setVisible(true);
		clean();
		
		MainDialog.getInstance().pack();
		MainDialog.getInstance().setLocationRelativeTo(null);
		return null;
	}
	
	private void clean() {
		// clean
		cmbProducts.setSelectedIndex(0);
		cmbSize.setSelectedIndex(0);
		txtCount.setText(null);
	}
	

}
