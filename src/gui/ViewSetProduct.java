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
import javax.swing.border.EmptyBorder;
import models.AppData;

public class ViewSetProduct extends JPanel {
	
	private JDialog parent;
	private ComboBoxPromo cmbPromoPanel;

	private JLabel lblBurgerName;
	private JComboBox<String> cmbBurgerName;
	private JLabel lblBurgerSize;
	private JComboBox<String> cmbBurgerSize;
	private JLabel lblBurgerCount;
	private JTextField txtBurgerCount;

	private JLabel lblPotatoesSize;
	private JComboBox<String> cmbPotatoesSize;
	private JLabel lblPotatoesCount;
	private JTextField txtPotatoesCount;

	private JLabel lblSodaName;
	private JComboBox<String> cmbSodaName;
	private JLabel lblSodaCount;
	private JTextField txtSodaCount;

	private JLabel lblPrice;
	private JTextField txtPrice;

	private JButton btnSave;
	private JButton btnClose;

	private JPanel panelTop;
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

	String selectedItem;

	public ViewSetProduct(JDialog parent) {
		
		this.parent = parent;
		// set
		setAllToDefaultValues();

		cmbPromoPanel = new ComboBoxPromo(item -> ComboBoxPromoAction(item));
		cmbPromoPanel.setLayout(new GridLayout(1, 2, 0, 0));

		lblBurgerName = new JLabel("Hamburguesa");
		lblBurgerName.setForeground(AppData.$white);
		lblBurgerSize = new JLabel("Tamaño");
		lblBurgerSize.setForeground(AppData.$white);
		lblBurgerCount = new JLabel("Cantidad");
		lblBurgerCount.setForeground(AppData.$white);
		cmbBurgerName = new JComboBox(AppData.burgers);
		cmbBurgerSize = new JComboBox(AppData.sizeProducts);
		txtBurgerCount = new JTextField();

		lblPotatoesSize = new JLabel("Papas fritas");
		lblPotatoesSize.setForeground(AppData.$white);
		lblPotatoesCount = new JLabel("Cantidad");
		lblPotatoesCount.setForeground(AppData.$white);
		cmbPotatoesSize = new JComboBox(AppData.sizeProducts);
		txtPotatoesCount = new JTextField();

		lblSodaName = new JLabel("Gaseosa");
		lblSodaName.setForeground(AppData.$white);
		lblSodaCount = new JLabel("Cantidad");
		lblSodaCount.setForeground(AppData.$white);
		cmbSodaName = new JComboBox(AppData.sodas);
		txtSodaCount = new JTextField();

		lblPrice = new JLabel("Precio (S/.)");
		lblPrice.setForeground(AppData.$white);
		txtPrice = new JTextField();

		btnSave = new JButton("Guardar");
		btnSave.setBackground(AppData.$secondaryColor);
		btnSave.setForeground(AppData.$primaryColor);
		btnSave.addActionListener(e -> onSubmit(e));
		
		btnClose = new JButton("Cerrar");
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
		panelTop = new JPanel();
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
			
			setAllToDefaultValues();
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
		setAllNewValues();
		
		// resize jdialog
		this.parent.pack();
	}

	private void onSubmit(ActionEvent event) {	
		JButton action = (JButton) event.getSource();
		
		// get values		
		getAllNewValues();

		// save values
		saveAllValues();
		
		System.out.print("\nHamburguesa: " + AppData.burgers[this.burgerName] + " - " + AppData.sizeProducts[this.burgerSize]);
		System.out.print("\nCantidad: " + this.burgerCount);
		System.out.print("\nPapitas: " + AppData.sizeProducts[this.potatoesSize]);
		System.out.print("\nCantidad: " + this.potatoesCount);
		System.out.print("\nGaseosa: " + AppData.sodas[this.sodaName]);
		System.out.print("\nCantidad: " + this.sodaCount);
		System.out.print("\nPrecio: " + this.price);
		System.out.print("\n--------------\n\n");
	}
	
	private void setAllToDefaultValues() {		
		burgerName = 0;
		burgerSize = 0;
		burgerCount = 0;
		potatoesSize = 0;
		potatoesCount = 0;
		sodaName = 0;
		sodaCount = 0;
		price = 0.0;
	}
	
	private void setAllNewValues() {
		cmbBurgerName.setSelectedIndex(burgerName);
		cmbBurgerSize.setSelectedIndex(burgerSize);
		txtBurgerCount.setText(String.valueOf(burgerCount));
		cmbPotatoesSize.setSelectedIndex(potatoesSize);
		txtPotatoesCount.setText(String.valueOf(potatoesCount));
		cmbSodaName.setSelectedIndex(sodaName);
		txtSodaCount.setText(String.valueOf(sodaCount));
		txtPrice.setText(String.valueOf(price));
	}
	
	private void getAllNewValues() {
		burgerName = cmbBurgerName.getSelectedIndex();
		burgerSize = cmbBurgerSize.getSelectedIndex();
		burgerCount = Integer.parseInt(txtBurgerCount.getText());
		potatoesSize = cmbPotatoesSize.getSelectedIndex();
		potatoesCount = Integer.parseInt(txtPotatoesCount.getText());
		sodaName = cmbSodaName.getSelectedIndex();
		sodaCount = Integer.parseInt(txtSodaCount.getText());
		price = Double.parseDouble(txtPrice.getText());
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
	
}
