package bembos.views;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import bembos.controllers.ComboController;
import bembos.models.Combo;
import bembos.utils.StyleTheme;
import bembos.views.components.ComboBoxPromo;
import bembos.views.components.MainDialog;
import bembos.views.components.ProductGraphic;
import javax.swing.JLabel;

public class ViewGetProduct extends JPanel {

	private static final long serialVersionUID = 1L;	
	private ProductGraphic productPanel;
	private ComboController control = new ComboController();
	private JTextField txtPrice;

	public ViewGetProduct() {		

		productPanel = new ProductGraphic();
		ComboBoxPromo cmbPromoPanel = new ComboBoxPromo(item -> ComboBoxPromoAction(item));
		
		JLabel lblPrice = new JLabel("Precio:");
		lblPrice.setForeground(StyleTheme.$white);
		txtPrice = new JTextField();
		txtPrice.setEditable(false);		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout(82, 10));
		centerPanel.setOpaque(false);
		centerPanel.add(lblPrice, BorderLayout.WEST);
		centerPanel.add(txtPrice, BorderLayout.CENTER);
		centerPanel.add(productPanel, BorderLayout.SOUTH);		
		
		JButton closeBtn = new JButton("Cerrar");
		closeBtn.setBackground(StyleTheme.$secondaryColor);
		closeBtn.setForeground(StyleTheme.$primaryColor);
		closeBtn.addActionListener(e->{
			MainDialog.getInstance().dispose();
		});		
		
		setLayout(new BorderLayout(10, 10));
		add(cmbPromoPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(closeBtn, BorderLayout.SOUTH);
	}
	
	private void ComboBoxPromoAction(String selectedItem){
		
		productPanel.clean();
		for(Combo combo : control.getAllCombos()) {
			if(selectedItem == combo.getName()) {
				combo.setItems(control.getAllItemsByComboID(combo.getId()));
				productPanel.render(combo.getItems());
				txtPrice.setText(String.format("%,5.2f", combo.getTotalPrice()));
			} else if(selectedItem == "Selecciona un menu") {
				txtPrice.setText("");
			}
		}		
		// resize jdialog		
		MainDialog.getInstance().pack();
		MainDialog.getInstance().setLocationRelativeTo(null);
	}
}
