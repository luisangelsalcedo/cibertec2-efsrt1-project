package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import interfaces.AlertType;
import models.AppData;

public class ViewDiscountsConfiguration extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtDiscount1;
	private JTextField txtDiscount2;
	private JTextField txtDiscount3;
	private JTextField txtDiscount4;
	private MainAlert alert;
	private String[] labels;
	private double dsct1, dsct2, dsct3, dsct4;
	
	public ViewDiscountsConfiguration(JDialog parent) {
		JPanel formPanelLeft = new JPanel();
		formPanelLeft.setLayout(new GridLayout(4, 1, 0, 10));
		formPanelLeft.setOpaque(false);
		
		JPanel formPanelCenter = new JPanel();
		formPanelCenter.setLayout(new GridLayout(4, 1, 0, 10));
		formPanelCenter.setOpaque(false);
		formPanelCenter.setPreferredSize(new Dimension(100, 100));
		
		JPanel formPanelRight = new JPanel();
		formPanelRight.setLayout(new GridLayout(4, 1, 0, 10));
		formPanelRight.setOpaque(false);
		
		labels = new String[] {"1 a 5", "6 a 10", "11 a 15", "Más de 15"};
		
		for (String label : labels) {
			JLabel lblLabel = new JLabel(label + " unidades");
			lblLabel.setForeground(AppData.$white);
			
			JLabel txtSign = new JLabel("%");
			txtSign.setForeground(AppData.$white);
			
			formPanelLeft.add(lblLabel);
			formPanelRight.add(txtSign);
		}
		
		txtDiscount1 = new JTextField(String.valueOf(AppData.discount1));
		txtDiscount2 = new JTextField(String.valueOf(AppData.discount2));
		txtDiscount3 = new JTextField(String.valueOf(AppData.discount3));
		txtDiscount4 = new JTextField(String.valueOf(AppData.discount4));
		
		formPanelCenter.add(txtDiscount1);
		formPanelCenter.add(txtDiscount2);
		formPanelCenter.add(txtDiscount3);
		formPanelCenter.add(txtDiscount4);
		
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new BorderLayout(10,0));
		formPanel.setOpaque(false);
		formPanel.add(formPanelLeft, BorderLayout.WEST);
		formPanel.add(formPanelCenter, BorderLayout.CENTER);
		formPanel.add(formPanelRight, BorderLayout.EAST);

		JButton submitBtn = new JButton("Aceptar");
		submitBtn.setBackground(AppData.$secondaryColor);
		submitBtn.setForeground(AppData.$primaryColor);
		submitBtn.addActionListener(e -> submitAction(e));
		
		JButton closeBtn = new JButton("Cancelar");
		closeBtn.setBackground(AppData.$secondaryColor);
		closeBtn.setForeground(AppData.$primaryColor);
		closeBtn.addActionListener(e -> {
			parent.dispose();
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
		try {
			dsct1 = Double.parseDouble(txtDiscount1.getText()); 
		} catch (Exception e) {
			error = true;
			errorMessage += "Descuento de " + labels[0] + " unidades, no es válida.\n";
			txtDiscount1.setText("");
			txtDiscount1.requestFocus();
		}
		try {
			dsct2 = Double.parseDouble(txtDiscount2.getText());
		} catch (Exception e) {
			error = true;
			errorMessage += "Descuento de " + labels[1] + " unidades, no es válida.\n";
			txtDiscount2.setText("");
			txtDiscount2.requestFocus();

		} 
		try {
			dsct3 = Double.parseDouble(txtDiscount3.getText()); 
		} catch (Exception e) {
			error = true;
			errorMessage += "Descuento de " + labels[2] + " unidades, no es válida.\n";
			txtDiscount3.setText("");
			txtDiscount3.requestFocus();
		}
		try {
			dsct4 = Double.parseDouble(txtDiscount4.getText()); 
		} catch (Exception e) {
			error = true;
			errorMessage += "Descuento de " + labels[3] + " unidades, no es válida.\n";
			txtDiscount4.setText("");
			txtDiscount4.requestFocus();
		}
		
		
		if(error) {
			alert = new MainAlert(errorMessage, AlertType.ERROR);
			alert.setVisible(true);
		} else {
			AppData.discount1 = dsct1;
			AppData.discount2 = dsct2;
			AppData.discount3 = dsct3;
			AppData.discount4 = dsct4;

			alert = new MainAlert("¡En hora buena! \nLos Descuentos fueron guardados correctamente.", AlertType.SUCCESS);
			alert.setVisible(true);
		}
		
	}

}
