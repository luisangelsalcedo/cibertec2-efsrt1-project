package bembos.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import bembos.controllers.SalesController;
import bembos.views.components.CustomAlert;
import bembos.views.components.MainDialog;
import interfaces.AlertType;
import db.StyleTheme;

public class ViewGiftsConfiguration extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtGift1;
	private JTextField txtGift2;
	private JTextField txtGift3;
	private String[] labels;
	private String gift1, gift2, gift3;
	
	public ViewGiftsConfiguration() {
		JPanel formPanelLeft = new JPanel();
		formPanelLeft.setLayout(new GridLayout(4, 1, 0, 10));
		formPanelLeft.setOpaque(false);
		
		JPanel formPanelCenter = new JPanel();
		formPanelCenter.setLayout(new GridLayout(4, 1, 0, 10));
		formPanelCenter.setOpaque(false);
		formPanelCenter.setPreferredSize(new Dimension(250, 100));
		
		JPanel formPanelRight = new JPanel();
		formPanelRight.setLayout(new GridLayout(4, 1, 0, 10));
		formPanelRight.setOpaque(false);
		
		labels = new String[] {"1", "2 a 5", "6 a más"};
		
		for (String label : labels) {
			boolean condition = label == labels[0];
			JLabel lblLabel = new JLabel(label + (condition ? " unidad" : " unidades"));
			lblLabel.setForeground(StyleTheme.$white);
			
			JLabel txtSign = new JLabel("");
			txtSign.setForeground(StyleTheme.$white);
			
			formPanelLeft.add(lblLabel);
			formPanelRight.add(txtSign);
		}
		
		txtGift1 = new JTextField(SalesController.gift1);
		txtGift2 = new JTextField(SalesController.gift2);
		txtGift3 = new JTextField(SalesController.gift3);
		
		formPanelCenter.add(txtGift1);
		formPanelCenter.add(txtGift2);
		formPanelCenter.add(txtGift3);
		
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new BorderLayout(10,0));
		formPanel.setOpaque(false);
		formPanel.add(formPanelLeft, BorderLayout.WEST);
		formPanel.add(formPanelCenter, BorderLayout.CENTER);
		formPanel.add(formPanelRight, BorderLayout.EAST);

		JButton submitBtn = new JButton("Aceptar");
		submitBtn.setBackground(StyleTheme.$secondaryColor);
		submitBtn.setForeground(StyleTheme.$primaryColor);
		submitBtn.addActionListener(e -> submitAction(e));
		
		JButton closeBtn = new JButton("Cancelar");
		closeBtn.setBackground(StyleTheme.$secondaryColor);
		closeBtn.setForeground(StyleTheme.$primaryColor);
		closeBtn.addActionListener(e -> {
			MainDialog.getInstance().dispose();
		});
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(2, 1, 0, 30));
		buttonsPanel.setOpaque(false);
		buttonsPanel.add(submitBtn);
		buttonsPanel.add(closeBtn);
		
		setLayout(new BorderLayout(40,0));
		add(formPanel ,BorderLayout.CENTER);
		add(buttonsPanel ,BorderLayout.EAST);
	}

	private void submitAction(ActionEvent event) {
		boolean error = false;
		String errorMessage = "";
		
		// validation		
		gift1 = txtGift1.getText(); 
		gift2 = txtGift2.getText();
		gift3 = txtGift3.getText();
		
		gift1 = gift1.trim();
		gift2 = gift2.trim();
		gift3 = gift3.trim();
	
		
		if (gift1.length() <= 2) {
			error = true;
			errorMessage += "Regalo para " + labels[0] + " unidad, debe tener más de 2 caracteres.\n";
			txtGift1.setText("");
			txtGift1.requestFocus();
		}
		if (gift2.length() <= 2) {
			error = true;
			errorMessage += "Regalo para " + labels[1] + " unidades, debe tener más de 2 caracteres.\n";
			txtGift2.setText("");
			txtGift2.requestFocus();

		} 
		if (gift3.length() <= 2) {
			error = true;
			errorMessage += "Regalo para " + labels[2] + " unidades, debe tener más de 2 caracteres.\n";
			txtGift3.setText("");
			txtGift3.requestFocus();
		}
		
		
		if(error) {
			new CustomAlert(errorMessage, AlertType.ERROR);
		} else {
			SalesController.gift1 = gift1;
			SalesController.gift2 = gift2;
			SalesController.gift3 = gift3;

			String successMessage = "¡En hora buena! \nLos Regalos fueron guardados correctamente.";
			new CustomAlert(successMessage, AlertType.SUCCESS);
		}
		
	}

}
