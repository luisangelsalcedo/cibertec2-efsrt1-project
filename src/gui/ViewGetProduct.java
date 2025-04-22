package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import models.AppData;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;



public class ViewGetProduct extends JPanel {
	
	private JLabel lblPromo;
	private JComboBox<String> cmbPromo;
	private JLabel lblPrice;
	private JTextField txtPrice;
	private ViewGraphics graphicPanel;

	/**
	 * Create the panel.
	 */
	public ViewGetProduct(JDialog parent) {
		
		graphicPanel = new ViewGraphics();
		graphicPanel.setVisible(false);
		
		String[] promosList = new String[] {
			"Selecciona un producto",
			AppData.productName1,
			AppData.productName2,
			AppData.productName3,
			AppData.productName4,
			AppData.productName5,
			AppData.productName6
		};
		lblPromo = new JLabel("Promos exclusivas:");
		lblPromo.setForeground(AppData.$white);
		cmbPromo = new JComboBox(promosList);

		
		// ActionListener
		cmbPromo.addActionListener(e->{
			String selected = (String) cmbPromo.getSelectedItem();
			graphicPanel.setPreferredSize(new Dimension(430, 200));
			
			if(selected == "Selecciona un producto") {
				txtPrice.setText(null);
				graphicPanel.clean();
				graphicPanel.setVisible(false);
				graphicPanel.setPreferredSize(null);
			}
			
			if(selected == AppData.productName1) {
				txtPrice.setText("S/. " + String.valueOf(AppData.price1));
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
			if(selected == AppData.productName2) {
				txtPrice.setText("S/. " + String.valueOf(AppData.price2));
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
			if(selected == AppData.productName3) {
				txtPrice.setText("S/. " + String.valueOf(AppData.price3));
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
			if(selected == AppData.productName4) {
				txtPrice.setText("S/. " + String.valueOf(AppData.price4));
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
			if(selected == AppData.productName5) {
				txtPrice.setText("S/. " + String.valueOf(AppData.price5));
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
			if(selected == AppData.productName6) {
				txtPrice.setText("S/. " + String.valueOf(AppData.price6));
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
			parent.pack();
		});
		
		lblPrice = new JLabel("Precio:");
		lblPrice.setForeground(AppData.$white);
		txtPrice = new JTextField();
		txtPrice.setEditable(false);

		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout(10, 10));
		topPanel.setOpaque(false);
		topPanel.add(lblPromo, BorderLayout.WEST);
		topPanel.add(cmbPromo, BorderLayout.CENTER);
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout(82, 10));
		centerPanel.setOpaque(false);
		centerPanel.add(lblPrice, BorderLayout.WEST);
		centerPanel.add(txtPrice, BorderLayout.CENTER);
		centerPanel.add(graphicPanel, BorderLayout.SOUTH);
		
		
		JButton closeBtn = new JButton("Cerrar");
		closeBtn.setBackground(AppData.$secondaryColor);
		closeBtn.setForeground(AppData.$primaryColor);
		closeBtn.addActionListener(e->{
			parent.dispose();
		});		
		
		
		setLayout(new BorderLayout(10, 10));
		setBorder(new EmptyBorder(15,15,15,15));
		setOpaque(false);
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(closeBtn, BorderLayout.SOUTH);
	}
}
