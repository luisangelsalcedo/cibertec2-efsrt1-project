package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import interfaces.AlertType;
import models.AppData;

public class ViewSetProduct extends JPanel {

	private static final long serialVersionUID = 1L;	
	private JDialog parent;
	private JComboBox<String> cmbBurgerName;
	private JComboBox<String> cmbBurgerSize;
	private JComboBox<String> cmbPotatoesSize;
	private JComboBox<String> cmbSodaName;
	private JTextField txtBurgerCount;
	private JTextField txtPotatoesCount;
	private JTextField txtSodaCount;
	private JTextField txtPrice;
	private JPanel panelCenter;
	private JPanel panelBottom;

	// values
	int burgerName;
	int burgerSize;
	int burgerCount;
	int potatoesSize;
	int potatoesCount;
	int sodaName;
	int sodaCount;
	double price;

	private String selectedItem;
	private Boolean error = false;
	private String errorMessage = "";	
	private MainAlert alert;

	public ViewSetProduct(JDialog parent) {
		
		this.parent = parent;
		// set
		resetAllValues();
		
		ComboBoxPromo cmbPromoPanel = new ComboBoxPromo(item -> ComboBoxPromoAction(item));
		cmbPromoPanel.setLayout(new GridLayout(1, 2, 0, 0));

		JLabel lblBurgerName = new JLabel("Hamburguesa");
		lblBurgerName.setForeground(AppData.$white);
		JLabel lblBurgerSize = new JLabel("Tamaño");
		lblBurgerSize.setForeground(AppData.$white);
		JLabel lblBurgerCount = new JLabel("Cantidad");
		lblBurgerCount.setForeground(AppData.$white);
		cmbBurgerName = new JComboBox<String>(AppData.burgers);
		cmbBurgerSize = new JComboBox<String>(AppData.sizeProducts);
		txtBurgerCount = new JTextField();

		JLabel lblPotatoesSize = new JLabel("Papas fritas");
		lblPotatoesSize.setForeground(AppData.$white);
		JLabel lblPotatoesCount = new JLabel("Cantidad");
		lblPotatoesCount.setForeground(AppData.$white);
		cmbPotatoesSize = new JComboBox<String>(AppData.sizeProducts);
		txtPotatoesCount = new JTextField();

		JLabel lblSodaName = new JLabel("Gaseosa");
		lblSodaName.setForeground(AppData.$white);
		JLabel lblSodaCount = new JLabel("Cantidad");
		lblSodaCount.setForeground(AppData.$white);
		cmbSodaName = new JComboBox<String>(AppData.sodas);
		txtSodaCount = new JTextField();

		JLabel lblPrice = new JLabel("Precio (S/.)");
		lblPrice.setForeground(AppData.$white);
		txtPrice = new JTextField();

		JButton btnSave = new JButton("Guardar");
		btnSave.setBackground(AppData.$secondaryColor);
		btnSave.setForeground(AppData.$primaryColor);
		btnSave.addActionListener(e -> onSubmit(e));
		
		JButton btnClose = new JButton("Cerrar");
		btnClose.setBackground(AppData.$primaryLightColor);
		btnClose.setForeground(AppData.$white);
		btnClose.addActionListener(e -> {
			parent.dispose();
		});

		// Burger panels
		JPanel burgerPanelLeft = new JPanel();
		burgerPanelLeft.setLayout(new GridLayout(3, 1, 0, 10));
		burgerPanelLeft.setOpaque(false);
		burgerPanelLeft.add(lblBurgerName);
		burgerPanelLeft.add(lblBurgerSize);
		burgerPanelLeft.add(lblBurgerCount);

		JPanel burgerPanelRight = new JPanel();
		burgerPanelRight.setLayout(new GridLayout(3, 1, 0, 10));
		burgerPanelRight.setOpaque(false);
		burgerPanelRight.add(cmbBurgerName);
		burgerPanelRight.add(cmbBurgerSize);
		burgerPanelRight.add(txtBurgerCount);

		JPanel burgerPanel = new JPanel();
		burgerPanel.setLayout(new BorderLayout(43, 0));
		burgerPanel.setOpaque(false);
		burgerPanel.add(burgerPanelLeft, BorderLayout.WEST);
		burgerPanel.add(burgerPanelRight, BorderLayout.CENTER);

		// Potatoes panels
		JPanel potatoesPanelLeft = new JPanel();
		potatoesPanelLeft.setLayout(new GridLayout(2, 1, 0, 10));
		potatoesPanelLeft.setOpaque(false);
		potatoesPanelLeft.add(lblPotatoesSize);
		potatoesPanelLeft.add(lblPotatoesCount);

		JPanel potatoesPanelRight = new JPanel();
		potatoesPanelRight.setLayout(new GridLayout(2, 1, 0, 10));
		potatoesPanelRight.setOpaque(false);
		potatoesPanelRight.add(cmbPotatoesSize);
		potatoesPanelRight.add(txtPotatoesCount);

		JPanel potatoesPanel = new JPanel();
		potatoesPanel.setLayout(new BorderLayout(55, 0));
		potatoesPanel.setOpaque(false);
		potatoesPanel.add(potatoesPanelLeft, BorderLayout.WEST);
		potatoesPanel.add(potatoesPanelRight, BorderLayout.CENTER);

		// Soda panels
		JPanel sodaPanelLeft = new JPanel();
		sodaPanelLeft.setLayout(new GridLayout(2, 1, 0, 10));
		sodaPanelLeft.setOpaque(false);
		sodaPanelLeft.add(lblSodaName);
		sodaPanelLeft.add(lblSodaCount);

		JPanel sodaPanelRight = new JPanel();
		sodaPanelRight.setLayout(new GridLayout(2, 1, 0, 10));
		sodaPanelRight.setOpaque(false);
		sodaPanelRight.add(cmbSodaName);
		sodaPanelRight.add(txtSodaCount);

		JPanel sodaPanel = new JPanel();
		sodaPanel.setLayout(new BorderLayout(72, 0));
		sodaPanel.setOpaque(false);
		sodaPanel.add(sodaPanelLeft, BorderLayout.WEST);
		sodaPanel.add(sodaPanelRight, BorderLayout.CENTER);

		// Price panel
		JPanel pricePanel = new JPanel();
		pricePanel.setLayout(new BorderLayout(61, 0));
		pricePanel.setOpaque(false);
		pricePanel.add(lblPrice, BorderLayout.WEST);
		pricePanel.add(txtPrice, BorderLayout.CENTER);

		// Button panel
		JPanel buttonPanel= new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2, 10, 0));
		buttonPanel.setOpaque(false);
		buttonPanel.add(btnSave);
		buttonPanel.add(btnClose);

		
		// Base panels
		JPanel panelTop = new JPanel();
		panelTop.setLayout(new BorderLayout(0, 0));
		panelTop.setOpaque(false);
		panelTop.add(cmbPromoPanel);

		panelCenter = new JPanel();
		panelCenter.setLayout(new BorderLayout(0, 10));
		panelCenter.setOpaque(false);
		panelCenter.add(burgerPanel, BorderLayout.NORTH);
		panelCenter.add(potatoesPanel, BorderLayout.CENTER);
		panelCenter.add(sodaPanel, BorderLayout.SOUTH);
		panelCenter.setVisible(false);

		panelBottom = new JPanel();
		panelBottom.setLayout(new GridLayout(2, 1, 10, 20));
		panelBottom.setOpaque(false);
		panelBottom.add(pricePanel);
		panelBottom.add(buttonPanel);
		panelBottom.setVisible(false);

		// this panel
		setLayout(new BorderLayout(0, 10));
		add(panelTop, BorderLayout.NORTH);
		add(panelCenter, BorderLayout.CENTER);
		add(panelBottom, BorderLayout.SOUTH);
	}

	public void ComboBoxPromoAction(String selectedItem) {
		panelCenter.setVisible(true);
		panelBottom.setVisible(true);

		this.selectedItem = selectedItem; 
		
		if(selectedItem == "Selecciona un producto") {
			
			resetAllValues();
			panelCenter.setVisible(false);
			panelBottom.setVisible(false);
			
		}
		if(selectedItem == AppData.productName1) {
			burgerName = AppData.burgerName1;
			burgerSize = AppData.burgerSize1;
			burgerCount = AppData.burgerCount1;
			potatoesSize = AppData.potatoesSize1;
			potatoesCount = AppData.potatoesCount1;
			sodaName = AppData.sodaName1;
			sodaCount = AppData.sodaCount1;
			price = AppData.price1;
		}
		if(selectedItem == AppData.productName2) {
			burgerName = AppData.burgerName2;
			burgerSize = AppData.burgerSize2;
			burgerCount = AppData.burgerCount2;
			potatoesSize = AppData.potatoesSize2;
			potatoesCount = AppData.potatoesCount2;
			sodaName = AppData.sodaName2;
			sodaCount = AppData.sodaCount2;
			price = AppData.price2;
		}
		if(selectedItem == AppData.productName3) {
			burgerName = AppData.burgerName3;
			burgerSize = AppData.burgerSize3;
			burgerCount = AppData.burgerCount3;
			potatoesSize = AppData.potatoesSize3;
			potatoesCount = AppData.potatoesCount3;
			sodaName = AppData.sodaName3;
			sodaCount = AppData.sodaCount3;
			price = AppData.price3;
		}
		if(selectedItem == AppData.productName4) {
			burgerName = AppData.burgerName4;
			burgerSize = AppData.burgerSize4;
			burgerCount = AppData.burgerCount4;
			potatoesSize = AppData.potatoesSize4;
			potatoesCount = AppData.potatoesCount4;
			sodaName = AppData.sodaName4;
			sodaCount = AppData.sodaCount4;
			price = AppData.price4;
		}
		if(selectedItem == AppData.productName5) {
			burgerName = AppData.burgerName5;
			burgerSize = AppData.burgerSize5;
			burgerCount = AppData.burgerCount5;
			potatoesSize = AppData.potatoesSize5;
			potatoesCount = AppData.potatoesCount5;
			sodaName = AppData.sodaName5;
			sodaCount = AppData.sodaCount5;
			price = AppData.price5;
		}
		if(selectedItem == AppData.productName6) {
			burgerName = AppData.burgerName6;
			burgerSize = AppData.burgerSize6;
			burgerCount = AppData.burgerCount6;
			potatoesSize = AppData.potatoesSize6;
			potatoesCount = AppData.potatoesCount6;
			sodaName = AppData.sodaName6;
			sodaCount = AppData.sodaCount6;
			price = AppData.price6;
		}
		
		// set values in components		
		loadNewValues();
		
		// resize jdialog
		this.parent.pack();
		this.parent.setLocationRelativeTo(null);
	}
	
	private void loadNewValues() {
		cmbBurgerName.setSelectedIndex(burgerName);
		cmbBurgerSize.setSelectedIndex(burgerSize);
		txtBurgerCount.setText(String.valueOf(burgerCount));
		cmbPotatoesSize.setSelectedIndex(potatoesSize);
		txtPotatoesCount.setText(String.valueOf(potatoesCount));
		cmbSodaName.setSelectedIndex(sodaName);
		txtSodaCount.setText(String.valueOf(sodaCount));
		txtPrice.setText(String.valueOf(price));
	}

	private void onSubmit(ActionEvent event) {	
		// get values		
		getAllNewValues();

		// save values
		if(!error) {
			saveAllValues();
			alert = new MainAlert("¡En hora buena! \nLos datos fueron guardados correctamente.", AlertType.SUCCESS);
			alert.setTitle("Mensaje");
			alert.setVisible(true);
			
//			System.out.print("\nHamburguesa: " + AppData.burgers[this.burgerName] + " - " + AppData.sizeProducts[this.burgerSize]);
//			System.out.print("\nCantidad: " + this.burgerCount);
//			System.out.print("\nPapitas: " + AppData.sizeProducts[this.potatoesSize]);
//			System.out.print("\nCantidad: " + this.potatoesCount);
//			System.out.print("\nGaseosa: " + AppData.sodas[this.sodaName]);
//			System.out.print("\nCantidad: " + this.sodaCount);
//			System.out.print("\nPrecio: " + this.price);
//			System.out.print("\n--------------\n\n");
		}
		else {
			alert = new MainAlert(errorMessage, AlertType.ERROR);
			alert.setTitle("Mensaje de error");
			alert.setVisible(true);
			
		}
		
	}
	
	private void getAllNewValues() {
		burgerName = cmbBurgerName.getSelectedIndex();
		burgerSize = cmbBurgerSize.getSelectedIndex();
		potatoesSize = cmbPotatoesSize.getSelectedIndex();
		sodaName = cmbSodaName.getSelectedIndex();
		
		// reset errors vars
		error = false;
		errorMessage = "";
		
		// valitation		
		try {
			burgerCount = Integer.parseInt(txtBurgerCount.getText());
		} catch (Exception e) {
			error = true;
			errorMessage += "La cantidad de hamburguesas no es válida.\n";
			txtBurgerCount.setText("");
			txtBurgerCount.requestFocus();
		}
		try {
			potatoesCount = Integer.parseInt(txtPotatoesCount.getText());
		} catch (Exception e) {
			error = true;
			errorMessage += "La cantidad de papas fritas no es válida.\n";
			txtPotatoesCount.setText("");
			txtPotatoesCount.requestFocus();
		}
		try {
			sodaCount = Integer.parseInt(txtSodaCount.getText());
		} catch (Exception e) {
			error = true;
			errorMessage += "La cantidad de gaseosa no es válida.\n";
			txtSodaCount.setText("");
			txtSodaCount.requestFocus();
		}
		try {
			price = Double.parseDouble(txtPrice.getText());
		} catch (Exception e) {
			error = true;
			errorMessage += "El precio que ingresaste no es válido.\n";
			txtPrice.setText("");
			txtPrice.requestFocus();
		}
	}
	
	private void saveAllValues() {
		String selectedItem = this.selectedItem;

		if(selectedItem == AppData.productName1) {
			AppData.burgerName1 = burgerName;
			AppData.burgerSize1 = burgerSize;
			AppData.burgerCount1 = burgerCount;
			AppData.potatoesSize1 = potatoesSize;
			AppData.potatoesCount1 = potatoesCount;
			AppData.sodaName1 = sodaName;
			AppData.sodaCount1 = sodaCount;
			AppData.price1 = price;
		}
		if(selectedItem == AppData.productName2) {
			AppData.burgerName2 = burgerName;
			AppData.burgerSize2 = burgerSize;
			AppData.burgerCount2 = burgerCount;
			AppData.potatoesSize2 = potatoesSize;
			AppData.potatoesCount2 = potatoesCount;
			AppData.sodaName2 = sodaName;
			AppData.sodaCount2 = sodaCount;
			AppData.price2 = price;
		}
		if(selectedItem == AppData.productName3) {
			AppData.burgerName3 = burgerName;
			AppData.burgerSize3 = burgerSize;
			AppData.burgerCount3 = burgerCount;
			AppData.potatoesSize3 = potatoesSize;
			AppData.potatoesCount3 = potatoesCount;
			AppData.sodaName3 = sodaName;
			AppData.sodaCount3 = sodaCount;
			AppData.price3 = price;
		}
		if(selectedItem == AppData.productName4) {
			AppData.burgerName4 = burgerName;
			AppData.burgerSize4 = burgerSize;
			AppData.burgerCount4 = burgerCount;
			AppData.potatoesSize4 = potatoesSize;
			AppData.potatoesCount4 = potatoesCount;
			AppData.sodaName4 = sodaName;
			AppData.sodaCount4 = sodaCount;
			AppData.price4 = price;
		}
		if(selectedItem == AppData.productName5) {
			AppData.burgerName5 = burgerName;
			AppData.burgerSize5 = burgerSize;
			AppData.burgerCount5 = burgerCount;
			AppData.potatoesSize5 = potatoesSize;
			AppData.potatoesCount5 = potatoesCount;
			AppData.sodaName5 = sodaName;
			AppData.sodaCount5 = sodaCount;
			AppData.price5 = price;
		}
		if(selectedItem == AppData.productName6) {
			AppData.burgerName6 = burgerName;
			AppData.burgerSize6 = burgerSize;
			AppData.burgerCount6 = burgerCount;
			AppData.potatoesSize6 = potatoesSize;
			AppData.potatoesCount6 = potatoesCount;
			AppData.sodaName6 = sodaName;
			AppData.sodaCount6 = sodaCount;
			AppData.price6 = price;
		}
	}
	
	private void resetAllValues() {		
		burgerName = 0;
		burgerSize = 0;
		burgerCount = 0;
		potatoesSize = 0;
		potatoesCount = 0;
		sodaName = 0;
		sodaCount = 0;
		price = 0.0;
	}
	
	
	
	
	
	
	
}
