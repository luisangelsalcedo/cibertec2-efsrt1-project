package bembos.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bembos.controllers.BembosMenuController;
import bembos.models.BembosMenu;
import bembos.models.Burger;
import bembos.models.Potatoes;
import bembos.models.Soda;
import bembos.utils.Utils;
import bembos.views.components.ComboBoxPromo;
import bembos.views.components.MainAlert;

import javax.swing.JButton;
import interfaces.AlertType;
import interfaces.SizeProduct;
import db.AppData;

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
		
		String[] sizeArr = Utils.createComboBoxArray(Arrays.asList(SizeProduct.values()), "Selecciona una medida", size->size.toString());
		
		cmbBurgerName = new JComboBox<String>(Utils.createComboBoxArray(AppData.burgersList, "Selecciona una hamburguesa", burger->burger.getName()));
		cmbBurgerSize = new JComboBox<String>(sizeArr);
		txtBurgerCount = new JTextField();

		JLabel lblPotatoesSize = new JLabel("Papas fritas");
		lblPotatoesSize.setForeground(AppData.$white);
		JLabel lblPotatoesCount = new JLabel("Cantidad");
		lblPotatoesCount.setForeground(AppData.$white);
		cmbPotatoesSize = new JComboBox<String>(sizeArr);
		txtPotatoesCount = new JTextField();

		JLabel lblSodaName = new JLabel("Bebida");
		lblSodaName.setForeground(AppData.$white);
		JLabel lblSodaCount = new JLabel("Cantidad");
		lblSodaCount.setForeground(AppData.$white);
		cmbSodaName = new JComboBox<String>(Utils.createComboBoxArray(AppData.sodasList, "Selecciona una Bebida", soda->soda.getName()));
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

		panelBottom = new JPanel();
		panelBottom.setLayout(new GridLayout(2, 1, 10, 20));
		panelBottom.setOpaque(false);
		panelBottom.add(pricePanel);
		panelBottom.add(buttonPanel);
		
		// hidden form
		formVisible(false);
		

		// this panel
		setLayout(new BorderLayout(0, 10));
		add(panelTop, BorderLayout.NORTH);
		add(panelCenter, BorderLayout.CENTER);
		add(panelBottom, BorderLayout.SOUTH);
	}

	public void ComboBoxPromoAction(String selectedItem) {
		BembosMenuController menuController = new BembosMenuController();
		this.selectedItem = selectedItem; 
		formVisible(true);
		
		for(BembosMenu menu:menuController.getAllMenus()) {
			if(selectedItem == menu.getName()) {

				if(menu.getAllBurgers().size() > 0) {					
					Burger firtsBurger = menu.getAllBurgers().get(0);
					String firtsBurgerName = firtsBurger.getName();
					String firtsBurgerSize = firtsBurger.getSize();
					
					cmbBurgerName.setSelectedIndex(Utils.comboBoxIndexOf(cmbBurgerName, firtsBurgerName));
					cmbBurgerSize.setSelectedIndex(Utils.comboBoxIndexOf(cmbBurgerSize, firtsBurgerSize));
					txtBurgerCount.setText(String.valueOf(menu.getAllBurgers().size()));
				} else {
					cmbBurgerName.setSelectedIndex(0);
					cmbBurgerSize.setSelectedIndex(0);
					txtBurgerCount.setText(null);
				}
				

				if(menu.getAllPotatoes().size() > 0) {					
					Potatoes firtsPotatoe = menu.getAllPotatoes().get(0);
					String firtsPotatoeSize = firtsPotatoe.getSize();
					
					cmbPotatoesSize.setSelectedIndex(Utils.comboBoxIndexOf(cmbPotatoesSize, firtsPotatoeSize));
					txtPotatoesCount.setText(String.valueOf(menu.getAllPotatoes().size()));
				} else {
					cmbPotatoesSize.setSelectedIndex(0);
					txtPotatoesCount.setText(null);
				}
				
				
				if(menu.getAllSodas().size() > 0) {					
					Soda firtsSoda = menu.getAllSodas().get(0);
					String firtsSodaName = firtsSoda.getName();
					
					cmbSodaName.setSelectedIndex(Utils.comboBoxIndexOf(cmbSodaName, firtsSodaName));
					txtSodaCount.setText(String.valueOf(menu.getAllSodas().size()));
				} else {
					cmbSodaName.setSelectedIndex(0);
					txtSodaCount.setText(null);
				}
				
				txtPrice.setText(String.format("%,5.2f", menu.getPrice()));
			}
		}
		
		// resize jdialog
		this.parent.pack();
		this.parent.setLocationRelativeTo(null);
	}
	
	private void formVisible(boolean bool) {
		panelCenter.setVisible(bool);
		panelBottom.setVisible(bool);
	}
	

	private void onSubmit(ActionEvent event) {	
		// get values		
		getAllNewValues();

		// save values
		if(!error) {
			saveAllValues();
			new MainAlert("¡En hora buena! \nLos datos fueron guardados correctamente.", AlertType.SUCCESS);
			
		}
		else {
			new MainAlert(errorMessage, AlertType.ERROR);			
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

//		if(selectedItem == AppData.productName1) {
//			AppData.burgerName1 = burgerName;
//			AppData.burgerSize1 = burgerSize;
//			AppData.burgerCount1 = burgerCount;
//			AppData.potatoesSize1 = potatoesSize;
//			AppData.potatoesCount1 = potatoesCount;
//			AppData.sodaName1 = sodaName;
//			AppData.sodaCount1 = sodaCount;
//			AppData.price1 = price;
//		}
//		if(selectedItem == AppData.productName2) {
//			AppData.burgerName2 = burgerName;
//			AppData.burgerSize2 = burgerSize;
//			AppData.burgerCount2 = burgerCount;
//			AppData.potatoesSize2 = potatoesSize;
//			AppData.potatoesCount2 = potatoesCount;
//			AppData.sodaName2 = sodaName;
//			AppData.sodaCount2 = sodaCount;
//			AppData.price2 = price;
//		}
//		if(selectedItem == AppData.productName3) {
//			AppData.burgerName3 = burgerName;
//			AppData.burgerSize3 = burgerSize;
//			AppData.burgerCount3 = burgerCount;
//			AppData.potatoesSize3 = potatoesSize;
//			AppData.potatoesCount3 = potatoesCount;
//			AppData.sodaName3 = sodaName;
//			AppData.sodaCount3 = sodaCount;
//			AppData.price3 = price;
//		}
//		if(selectedItem == AppData.productName4) {
//			AppData.burgerName4 = burgerName;
//			AppData.burgerSize4 = burgerSize;
//			AppData.burgerCount4 = burgerCount;
//			AppData.potatoesSize4 = potatoesSize;
//			AppData.potatoesCount4 = potatoesCount;
//			AppData.sodaName4 = sodaName;
//			AppData.sodaCount4 = sodaCount;
//			AppData.price4 = price;
//		}
//		if(selectedItem == AppData.productName5) {
//			AppData.burgerName5 = burgerName;
//			AppData.burgerSize5 = burgerSize;
//			AppData.burgerCount5 = burgerCount;
//			AppData.potatoesSize5 = potatoesSize;
//			AppData.potatoesCount5 = potatoesCount;
//			AppData.sodaName5 = sodaName;
//			AppData.sodaCount5 = sodaCount;
//			AppData.price5 = price;
//		}
//		if(selectedItem == AppData.productName6) {
//			AppData.burgerName6 = burgerName;
//			AppData.burgerSize6 = burgerSize;
//			AppData.burgerCount6 = burgerCount;
//			AppData.potatoesSize6 = potatoesSize;
//			AppData.potatoesCount6 = potatoesCount;
//			AppData.sodaName6 = sodaName;
//			AppData.sodaCount6 = sodaCount;
//			AppData.price6 = price;
//		}
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
