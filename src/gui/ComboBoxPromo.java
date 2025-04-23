package gui;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import interfaces.ComboBoxAction;
import models.AppData;

public class ComboBoxPromo extends JPanel {

	private JLabel lblPromo;
	private JComboBox<String> cmbPromo;
	
	
	public ComboBoxPromo(ComboBoxAction callback) {		
		lblPromo = new JLabel("Promos exclusivas:");
		lblPromo.setForeground(AppData.$white);
		
		String[] promosList = new String[] {
			"Selecciona un producto",
			AppData.productName1,
			AppData.productName2,
			AppData.productName3,
			AppData.productName4,
			AppData.productName5,
			AppData.productName6
		};		
		cmbPromo = new JComboBox(promosList);
		cmbPromo.addActionListener(e->{
			String selectedItem = (String) cmbPromo.getSelectedItem();
			if (callback != null && selectedItem != null) {
                callback.onItemSelected(selectedItem); 
            }
		});
		
		JPanel comboPanel = new JPanel();
		comboPanel.setLayout(new BorderLayout(10, 10));
		comboPanel.setOpaque(false);
		comboPanel.add(lblPromo, BorderLayout.WEST);
		comboPanel.add(cmbPromo, BorderLayout.CENTER);
		
		setLayout(new BorderLayout(10, 10));
		setOpaque(false);
		add(comboPanel, BorderLayout.CENTER);
	}



}
