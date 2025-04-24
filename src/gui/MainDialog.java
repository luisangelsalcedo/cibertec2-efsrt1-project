package gui;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.AppData;
import java.awt.Color;

public class MainDialog extends JDialog {
	
	JPanel panel;
	
	public MainDialog() {
		setSize(500, 245);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().setBackground(AppData.$primaryColor);
	}
	
	public void showView(JPanel panel) {
		// general panel settings
		this.panel = panel;
		this.panel.setBorder(new EmptyBorder(15, 15, 15, 15));
		this.panel.setOpaque(false);
		
		getContentPane().removeAll();
		getContentPane().add(this.panel);
		pack();
		setVisible(true);
	}
}
