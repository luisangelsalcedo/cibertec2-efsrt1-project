package bembos.views;

import java.awt.BorderLayout;
import db.AppData;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import bembos.controllers.BembosMenuController;
import bembos.models.BembosMenu;
import bembos.models.Burger;
import bembos.models.Potatoes;
import bembos.models.Product;
import bembos.models.Soda;
import bembos.views.components.ComboBoxPromo;
import bembos.views.components.ViewGraphics;

import javax.swing.JLabel;

public class ViewGetProduct extends JPanel {

	private static final long serialVersionUID = 1L;	
	private JDialog parent;
	private ViewGraphics graphicPanel;
	private JTextField txtPrice;

	public ViewGetProduct(JDialog parent) {
		
		this.parent = parent;
		
		graphicPanel = new ViewGraphics();		
		ComboBoxPromo cmbPromoPanel = new ComboBoxPromo(item -> ComboBoxPromoAction(item));
		
		JLabel lblPrice = new JLabel("Precio:");
		lblPrice.setForeground(AppData.$white);
		txtPrice = new JTextField();
		txtPrice.setEditable(false);		
		
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
		add(cmbPromoPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(closeBtn, BorderLayout.SOUTH);
	}
	
	private void ComboBoxPromoAction(String selectedItem){
		BembosMenuController menuController = new BembosMenuController();
		// default
		graphicPanel.clean();
		txtPrice.setText(null);
		
		//select item
		for(BembosMenu menu:menuController.getAllMenus()) {
			if(selectedItem == menu.getName()) {
				txtPrice.setText("S/. " + String.format("%,5.2f", menu.getPrice()));
				
				
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
		
		// resize jdialog		
		this.parent.pack();
		this.parent.setLocationRelativeTo(null);
	}
}
