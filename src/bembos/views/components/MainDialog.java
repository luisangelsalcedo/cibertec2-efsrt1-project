package bembos.views.components;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bembos.utils.StyleTheme;

public class MainDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private static MainDialog instance;

	private MainDialog() {
		InitDialog();
	}
	
	private void InitDialog() {
		setSize(500, 245);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().setBackground(StyleTheme.$primaryColor);
		setIconImage(
			Toolkit.getDefaultToolkit().getImage(StyleTheme.favicon)
		);
	}
	
	public static MainDialog getInstance() {
		if(instance == null || !instance.isDisplayable()) {
			instance = new MainDialog();
		} 
		return instance;
	}
	
	public void showView(JPanel view) {
		// general panel settings
		view.setBorder(new EmptyBorder(15, 15, 15, 15));
		view.setOpaque(false);
		
		getContentPane().removeAll();
		getContentPane().add(view);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
