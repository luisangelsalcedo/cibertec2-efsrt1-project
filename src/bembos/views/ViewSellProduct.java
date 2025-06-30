package bembos.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import bembos.controllers.ComboController;
import bembos.controllers.SalesController;
import bembos.models.Combo;
import bembos.models.Sale;
import bembos.views.components.ComboBoxPromo;
import bembos.views.components.CustomAlert;
import bembos.views.components.MainDialog;
import bembos.views.components.ProductGraphic;
import interfaces.AlertType;
import db.StyleTheme;

public class ViewSellProduct extends JPanel {
	
	private static final long serialVersionUID = 1L;	

	private ProductGraphic productPanel;
	private ComboController control = new ComboController();
	private JButton sellBtn;
	private JButton closeBtn;	
	private JTextField txtPrice;
	private JTextField txtCount;
	private JTextArea txtResponse;
	private JScrollPane scrollPane;	
	private String selectedItem;
	private Combo SelectedItemObject;

	public ViewSellProduct() {	

		productPanel = new ProductGraphic();
		ComboBoxPromo cmbPromoPanel = new ComboBoxPromo(item -> ComboBoxPromoAction(item));
		
		JLabel lblPrice = new JLabel("Precio (S/):");
		lblPrice.setForeground(Color.WHITE);
		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		
		JLabel lblcount = new JLabel("Cantidad:");
		lblcount.setForeground(Color.WHITE);
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
		sellBtn.setBackground(StyleTheme.$secondaryColor);
		sellBtn.setForeground(StyleTheme.$primaryColor);
		closeBtn = new JButton("Cerrar");
		closeBtn.addActionListener(e -> closeAction(e));
		closeBtn.setBackground(StyleTheme.$secondaryColor);
		closeBtn.setForeground(StyleTheme.$primaryColor);

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
		add(productPanel, BorderLayout.CENTER);
		add(scrollPane, BorderLayout.SOUTH);
	}
	
	private void ComboBoxPromoAction(String selectedItem){
		showSellControls(false);
		this.selectedItem = selectedItem;

		productPanel.clean();
		for(Combo combo : control.getAllCombos()) {
			if(selectedItem == combo.getName()) {
				SelectedItemObject = combo;
				showSellControls(true);

				combo.setItems(control.getAllItemsByComboID(combo.getId()));
				productPanel.render(combo.getItems());
				txtPrice.setText(String.format("%,5.2f", combo.getTotalPrice()));
			}else if(selectedItem == "Selecciona un menu") {
				txtPrice.setText("");
			}
		}		
		// resize jdialog		
		MainDialog.getInstance().pack();
		MainDialog.getInstance().setLocationRelativeTo(null);
	}
	
	private void sellAction(ActionEvent event) {
		try {
			double comboPrice, buyAmount, discountAmount, paymentAmount;
			int comboCount;
			String comboName, gifts;
			
			comboName = this.selectedItem;
			comboPrice = Double.parseDouble(txtPrice.getText());
			comboCount = Integer.parseInt(txtCount.getText());
			
			if(comboCount > 0) {
				buyAmount = comboPrice * comboCount;
				discountAmount = SalesController.calculateDiscount(comboCount, buyAmount);
				paymentAmount = buyAmount - discountAmount;
				gifts = SalesController.calculateGifts(comboCount);
				
				txtResponse.setText("BOLETA DE VENTA\n----------------------------");
				txtResponse.append("\nPromocion: " + comboName);
				txtResponse.append("\nPrecio: " + comboPrice);
				txtResponse.append("\nCantidad: " + comboCount);
				txtResponse.append("\nImporte Compra: " + String.format("%,5.2f", buyAmount));
				txtResponse.append("\nImporte Descuento: " + String.format("%,5.2f", discountAmount));
				txtResponse.append("\nImporte a Pagar: " + String.format("%,5.2f", paymentAmount));
				txtResponse.append("\nObsequio: 1 " + gifts);

				// add sale
				Sale sale = new Sale(SelectedItemObject, comboCount, paymentAmount);
				SalesController.addSale(sale);
				
				// view message
				if(SalesController.generalSalesCount % 5 == 0) {
					new CustomAlert(SalesController.SalesMessages, AlertType.DEFAULT, "Avance de ventas");
				}
				
				System.out.println(SalesController.getAllsales().size());
			} else {
				new CustomAlert("Ingresa la cantidad de tu pedido", AlertType.NOTICE);
				txtCount.setText("");
				txtCount.requestFocus();
			}
			
		} catch (Exception e) {
			new CustomAlert("Ingresa una cantidad valida", AlertType.ERROR);
			txtCount.setText("");
			txtCount.requestFocus();
		}		
	}
	
	private void closeAction(ActionEvent event) {
		MainDialog.getInstance().dispose();
	}

	private void showSellControls(boolean bool){
		sellBtn.setVisible(bool);
		scrollPane.setVisible(bool);
	}

}
