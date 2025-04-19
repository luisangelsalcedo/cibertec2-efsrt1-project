package gui;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class MainDialog extends JDialog {
	
	public MainDialog() {
		setSize(450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
	}
	
	public void showView(JPanel panel) {
		getContentPane().removeAll();
		add(panel);
		pack();
		setVisible(true);
	}
}
