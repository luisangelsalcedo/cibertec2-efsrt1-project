package gui;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import models.AppData;

public class MainDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public MainDialog() {
		setSize(500, 245);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().setBackground(AppData.$primaryColor);
	}
	
	public void showView(JPanel panel) {
		// general panel settings

		panel.setBorder(new EmptyBorder(15, 15, 15, 15));
		panel.setOpaque(false);
		
		getContentPane().removeAll();
		getContentPane().add(panel);
		pack();
		setVisible(true);
	}
}
