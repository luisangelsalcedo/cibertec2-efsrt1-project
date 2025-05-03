package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import models.AppData;

public class ViewSellProduct extends JPanel {
	
	JDialog parent;
	JPanel formPanel;
	JPanel buttonsPanel;
	JPanel formPanelLeft;
	JPanel formPanelRight;
	JPanel topPanel;
	ViewGraphics graphicPanel;
	ComboBoxPromo cmbPromoPanel;
	JLabel lblPrice;
	JLabel lblcount;
	JButton sellBtn;
	JButton closeBtn;
	JTextField txtPrice;
	JTextField txtCount;
	JTextArea txtResponse;
	JScrollPane scrollPane;
	String selectedItem;
	
	MainAlert alert;

	public ViewSellProduct(JDialog parent) {
		
		this.parent = parent;
		
		cmbPromoPanel = new ComboBoxPromo(item -> ComboBoxPromoAction(item));

		graphicPanel = new ViewGraphics();
		graphicPanel.setVisible(false);
		
		lblPrice = new JLabel("Precio (S/):");
		lblPrice.setForeground(AppData.$white);
		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		
		lblcount = new JLabel("Cantidad:");
		lblcount.setForeground(AppData.$white);
		txtCount = new JTextField();

		// panels
		formPanelLeft = new JPanel();
		formPanelLeft.setLayout(new GridLayout(2, 1, 0, 10));
		formPanelLeft.setOpaque(false);
		formPanelLeft.add(lblPrice);
		formPanelLeft.add(lblcount);
		
		formPanelRight = new JPanel();
		formPanelRight.setLayout(new GridLayout(2, 1, 0, 10));
		formPanelRight.setOpaque(false);
		formPanelRight.add(txtPrice);
		formPanelRight.add(txtCount);
		
		formPanel = new JPanel();
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

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(2, 1, 0, 15));
		buttonsPanel.setOpaque(false);
		buttonsPanel.add(sellBtn);
		buttonsPanel.add(closeBtn);

		topPanel = new JPanel();
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

		this.selectedItem = selectedItem;		
		graphicPanel.setPreferredSize(new Dimension(430, 200));
		sellBtn.setVisible(true);
		scrollPane.setVisible(true);
		
		if(selectedItem == "Selecciona un producto") {
			txtPrice.setText(null);
			graphicPanel.clean();
			graphicPanel.setVisible(false);
			graphicPanel.setPreferredSize(null);
			sellBtn.setVisible(false);
			scrollPane.setVisible(false);
		}
		
		if(selectedItem == AppData.productName1) {
			txtPrice.setText(String.valueOf(AppData.price1));
			// load Burger
			graphicPanel.setBurger(
				AppData.burgerCount1, 
				AppData.burgerSlugs[AppData.burgerName1] + ".png", 
				AppData.burgers[AppData.burgerName1], 
				AppData.sizeProducts[AppData.burgerSize1]
			);
			// load Potatoes
			graphicPanel.setPotatoe(
				AppData.potatoesCount1, 
				AppData.sizeProducts[AppData.potatoesSize1]
			);
			// load Soda
			graphicPanel.setSoda(
				AppData.sodaCount1, 
				AppData.sodasSlug[AppData.sodaName1] + ".png", 
				AppData.sodas[AppData.sodaName1]
			);
			graphicPanel.setVisible(true);
		}
		if(selectedItem == AppData.productName2) {
			txtPrice.setText(String.valueOf(AppData.price2));
			// load Burger
			graphicPanel.setBurger(
				AppData.burgerCount2, 
				AppData.burgerSlugs[AppData.burgerName2] + ".png", 
				AppData.burgers[AppData.burgerName2], 
				AppData.sizeProducts[AppData.burgerSize2]
			);
			// load Potatoes
			graphicPanel.setPotatoe(
				AppData.potatoesCount2, 
				AppData.sizeProducts[AppData.potatoesSize2]
			);
			// load Soda
			graphicPanel.setSoda(
				AppData.sodaCount2, 
				AppData.sodasSlug[AppData.sodaName2] + ".png", 
				AppData.sodas[AppData.sodaName2]
			);
			graphicPanel.setVisible(true);
			
		}
		if(selectedItem == AppData.productName3) {
			txtPrice.setText(String.valueOf(AppData.price3));
			// load Burger
			graphicPanel.setBurger(
				AppData.burgerCount3, 
				AppData.burgerSlugs[AppData.burgerName3] + ".png", 
				AppData.burgers[AppData.burgerName3], 
				AppData.sizeProducts[AppData.burgerSize3]
			);
			// load Potatoes
			graphicPanel.setPotatoe(
				AppData.potatoesCount3, 
				AppData.sizeProducts[AppData.potatoesSize3]
			);
			// load Soda
			graphicPanel.setSoda(
				AppData.sodaCount3, 
				AppData.sodasSlug[AppData.sodaName3] + ".png", 
				AppData.sodas[AppData.sodaName3]
			);
			graphicPanel.setVisible(true);
		}
		if(selectedItem == AppData.productName4) {
			txtPrice.setText(String.valueOf(AppData.price4));
			// load Burger
			graphicPanel.setBurger(
				AppData.burgerCount4, 
				AppData.burgerSlugs[AppData.burgerName4] + ".png", 
				AppData.burgers[AppData.burgerName4], 
				AppData.sizeProducts[AppData.burgerSize4]
			);
			// load Potatoes
			graphicPanel.setPotatoe(
				AppData.potatoesCount4, 
				AppData.sizeProducts[AppData.potatoesSize4]
			);
			// load Soda
			graphicPanel.setSoda(
				AppData.sodaCount4, 
				AppData.sodasSlug[AppData.sodaName4] + ".png", 
				AppData.sodas[AppData.sodaName4]
			);
			graphicPanel.setVisible(true);
		}
		if(selectedItem == AppData.productName5) {
			txtPrice.setText(String.valueOf(AppData.price5));
			// load Burger
			graphicPanel.setBurger(
				AppData.burgerCount5, 
				AppData.burgerSlugs[AppData.burgerName5] + ".png", 
				AppData.burgers[AppData.burgerName5], 
				AppData.sizeProducts[AppData.burgerSize5]
			);
			// load Potatoes
			graphicPanel.setPotatoe(
				AppData.potatoesCount5, 
				AppData.sizeProducts[AppData.potatoesSize5]
			);
			// load Soda
			graphicPanel.setSoda(
				AppData.sodaCount5, 
				AppData.sodasSlug[AppData.sodaName5] + ".png", 
				AppData.sodas[AppData.sodaName5]
			);
			graphicPanel.setVisible(true);
		}
		if(selectedItem == AppData.productName6) {
			txtPrice.setText(String.valueOf(AppData.price6));
			// load Burger
			graphicPanel.setBurger(
				AppData.burgerCount6, 
				AppData.burgerSlugs[AppData.burgerName6] + ".png", 
				AppData.burgers[AppData.burgerName6], 
				AppData.sizeProducts[AppData.burgerSize6]
			);
			// load Potatoes
			graphicPanel.setPotatoe(
				AppData.potatoesCount6, 
				AppData.sizeProducts[AppData.potatoesSize6]
			);
			// load Soda
			graphicPanel.setSoda(
				AppData.sodaCount6, 
				AppData.sodasSlug[AppData.sodaName6] + ".png", 
				AppData.sodas[AppData.sodaName6]
			);
			graphicPanel.setVisible(true);
		}
		// resize jdialog		
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
			
		} catch (Exception e) {
			alert = new MainAlert("Ingresa una cantidad valida", "error");
			alert.setTitle("Error");
			alert.setVisible(true);
			
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
			
			alert = new MainAlert(message, null);
			alert.setTitle("Avance de ventas");
			alert.setVisible(true);
		}
	}
}
