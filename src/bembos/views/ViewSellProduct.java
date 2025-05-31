package bembos.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import bembos.controllers.BembosMenuController;
import bembos.models.BembosMenu;
import bembos.models.Burger;
import bembos.models.Potatoes;
import bembos.models.Product;
import bembos.models.Soda;
import bembos.views.components.ComboBoxPromo;
import bembos.views.components.MainAlert;
import bembos.views.components.ViewGraphics;
import interfaces.AlertType;
import db.AppData;

public class ViewSellProduct extends JPanel {
	
	private static final long serialVersionUID = 1L;	
	private JDialog parent;
	private ViewGraphics graphicPanel;
	private JButton sellBtn;
	private JButton closeBtn;	
	private JTextField txtPrice;
	private JTextField txtCount;
	private JTextArea txtResponse;
	private JScrollPane scrollPane;	
	private String selectedItem;	

	public ViewSellProduct(JDialog parent) {
		
		this.parent = parent;
		
		ComboBoxPromo cmbPromoPanel = new ComboBoxPromo(item -> ComboBoxPromoAction(item));

		graphicPanel = new ViewGraphics();
		
		JLabel lblPrice = new JLabel("Precio (S/):");
		lblPrice.setForeground(AppData.$white);
		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		
		JLabel lblcount = new JLabel("Cantidad:");
		lblcount.setForeground(AppData.$white);
		txtCount = new JTextField();

		// panels
		JPanel formPanelLeft = new JPanel();
		formPanelLeft.setLayout(new GridLayout(2, 1, 0, 10));
		formPanelLeft.setOpaque(false);
		formPanelLeft.add(lblPrice);
		formPanelLeft.add(lblcount);
		
		JPanel formPanelRight = new JPanel();
		formPanelRight.setLayout(new GridLayout(2, 1, 0, 10));
		formPanelRight.setOpaque(false);
		formPanelRight.add(txtPrice);
		formPanelRight.add(txtCount);
		
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new BorderLayout(60, 10));
		formPanel.setOpaque(false);
		formPanel.add(cmbPromoPanel, BorderLayout.NORTH);
		formPanel.add(formPanelLeft, BorderLayout.WEST);
		formPanel.add(formPanelRight, BorderLayout.CENTER);
		
		sellBtn = new JButton("Vender");
		sellBtn.addActionListener(e -> sellAction(e));
		sellBtn.setVisible(false);
		sellBtn.setBackground(AppData.$secondaryColor);
		sellBtn.setForeground(AppData.$primaryColor);
		closeBtn = new JButton("Cerrar");
		closeBtn.addActionListener(e -> closeAction(e));
		closeBtn.setBackground(AppData.$secondaryColor);
		closeBtn.setForeground(AppData.$primaryColor);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(2, 1, 0, 15));
		buttonsPanel.setOpaque(false);
		buttonsPanel.add(sellBtn);
		buttonsPanel.add(closeBtn);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout(10, 20));
		topPanel.setOpaque(false);
		topPanel.add(formPanel, BorderLayout.CENTER);
		topPanel.add(buttonsPanel, BorderLayout.EAST);
		
		txtResponse = new JTextArea();
		txtResponse.setLineWrap(true);
		txtResponse.setWrapStyleWord(false);
		txtResponse.setRows(10);
		txtResponse.setColumns(35);
		txtResponse.setEditable(false);
		scrollPane = new JScrollPane(txtResponse);
		scrollPane.setVisible(false);

		setLayout(new BorderLayout());
		add(topPanel, BorderLayout.NORTH);
		add(graphicPanel, BorderLayout.CENTER);
		add(scrollPane, BorderLayout.SOUTH);
	}
	
	public void ComboBoxPromoAction(String selectedItem) {
		BembosMenuController menuController = new BembosMenuController();
		this.selectedItem = selectedItem;
		// default
		clean();
		sellBtn.setVisible(false);
		scrollPane.setVisible(false);
	
		for(BembosMenu menu:menuController.getAllMenus()) {
			if(selectedItem == menu.getName()) {
				txtPrice.setText(String.format("%,5.2f", menu.getPrice()));
				sellBtn.setVisible(true);
				scrollPane.setVisible(true);
				
				//split products
				for(Product product:menu.getAllProducts()) {
					
					// is burger
					if(product instanceof Burger) {
						graphicPanel.setBurger(
							menu.getAllBurgers().size(),
							product.getSlug() + ".png", 
							product.getName(), 
							((Burger) product).getSize()
						);
					}
					
					// is potatoes
					if(product instanceof Potatoes) {
						graphicPanel.setPotatoe(
							menu.getAllPotatoes().size(),
							((Potatoes) product).getSize()
						);
					}
					
					// is soda
					if(product instanceof Soda) {
						graphicPanel.setSoda(
							menu.getAllSodas().size(),
							product.getSlug() + ".png", 
							product.getName()
						);
					}
				}
			}
		}
		this.parent.pack();
		this.parent.setLocationRelativeTo(null);
	}
	
	private void sellAction(ActionEvent event) {
		try {
			double productPrice, buyAmount, discountAmount, paymentAmount;
			int productCount;
			String productName, gifts;
			
			productName = this.selectedItem;
			productPrice = Double.parseDouble(txtPrice.getText());
			productCount = Integer.parseInt(txtCount.getText());
			
			if(productCount > 0) {
				buyAmount = productPrice * productCount;
				discountAmount = calculateDiscount(productCount, buyAmount);
				paymentAmount = buyAmount - discountAmount;
				gifts = calculateGifts(productCount);
				
				txtResponse.setText("BOLETA DE VENTA\n----------------------------");
				txtResponse.append("\nPromocion: " + productName);
				txtResponse.append("\nPrecio: " + productPrice);
				txtResponse.append("\nCantidad: " + productCount);
				txtResponse.append("\nImporte Compra: " + String.format("%,5.2f", buyAmount));
				txtResponse.append("\nImporte Descuento: " + String.format("%,5.2f", discountAmount));
				txtResponse.append("\nImporte a Pagar: " + String.format("%,5.2f", paymentAmount));
				txtResponse.append("\nObsequio: 1 " + gifts);
				
				
				
				// add sale
				calculateSales(paymentAmount);
			} else {
				new MainAlert("Ingresa al menos 1 producto", AlertType.NOTICE);
				txtCount.setText("");
				txtCount.requestFocus();
			}
			
		} catch (Exception e) {
			new MainAlert("Ingresa una cantidad valida", AlertType.ERROR);
			txtCount.setText("");
			txtCount.requestFocus();
		}		
	}
	
	private void closeAction(ActionEvent event) {
		parent.dispose();
	}
	
	private double calculateDiscount(int count, double cost) {
		if(count == 0)
			return 0.0;
		
		else if(count <= 5)
			return cost * (AppData.discount1 / 100);
		
		else if(count <= 10)
			return cost * (AppData.discount2 / 100);
		
		else if(count <=15)
			return cost * (AppData.discount3 / 100);
		
		else 
			return cost * (AppData.discount4 / 100);
	}
	
	private String calculateGifts(int count) {
		if(count == 1)
			return AppData.gift1;
		
		else if(count <= 5)
			return AppData.gift2;
		
		else 
			return AppData.gift3;
	}
	
	private void calculateSales(double paymentAmount) {
		AppData.generalSalesCount++;
		AppData.generalSalesAmount += paymentAmount;
		
		if(AppData.generalSalesCount % 5 == 0) {
			String message = "Venta Nro " + AppData.generalSalesCount;
			message += "\nImporte total general acomulado: S/." + String.format("%,5.2f", AppData.generalSalesAmount);
			message += "\nPorcentaje de la cuota diaria: " + String.format("%,5.2f", AppData.calculatePercentageDailyQuota()) + "%";
			
			new MainAlert(message, AlertType.DEFAULT, "Avance de ventas");
		}
	}
	
	private void clean() {
		txtPrice.setText(null);
		txtCount.setText(null);
		txtResponse.setText(null);
		graphicPanel.clean();
	}

}
