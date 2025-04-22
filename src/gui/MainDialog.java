package gui;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;

import models.AppData;
import java.awt.Color;

public class MainDialog extends JDialog {
	
	public MainDialog() {
		setSize(450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().setBackground(AppData.$primaryColor);
		setBackground(AppData.$primaryColor);
	}
	
	public void showView(JPanel panel) {
		getContentPane().removeAll();
		getContentPane().add(panel);
		pack();
		setVisible(true);
	}
}
