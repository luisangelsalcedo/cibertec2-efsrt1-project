package bembos.views.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import interfaces.AlertType;
import db.AppData;

public class MainAlert extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private String alertMessage;
	private AlertType type;
	private String title;
	
	public MainAlert(String alertMessage, AlertType type) {
		this.alertMessage = alertMessage;
		this.type = type;
		renderComponents();
	}

	public MainAlert(String alertMessage, AlertType type, String title) {
		this.alertMessage = alertMessage;
		this.type = type;
		this.title = title;
		renderComponents();
	}
	
	private void renderComponents() {
		URL burgerIcon = getClass().getResource(AppData.sourcePath + "burgerIcon.png");
		URL successIcon = getClass().getResource(AppData.sourcePath + "successIcon.png");
		URL errorIcon = getClass().getResource(AppData.sourcePath + "errorIcon.png");
		URL noticeIcon = getClass().getResource(AppData.sourcePath + "infoIcon.png");
		
		JLabel lblIcon = new JLabel();
		
		switch (type) {
	        case SUCCESS:
	            lblIcon.setIcon(new ImageIcon(successIcon));
	            break;
	        case ERROR:
	            lblIcon.setIcon(new ImageIcon(errorIcon));
	            break;
	        case NOTICE:
	            lblIcon.setIcon(new ImageIcon(noticeIcon));
	            break;
	        default:
	            lblIcon.setIcon(new ImageIcon(burgerIcon));
	    }
		
		JTextPane txtContent = new JTextPane();
		txtContent.setEditable(false);
		txtContent.setOpaque(false);
		txtContent.setForeground(AppData.$primaryColor);
		txtContent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContent.setText(alertMessage);
		
		JButton okBtn = new JButton("Aceptar");
		okBtn.setBackground(AppData.$secondaryColor);
		okBtn.setForeground(AppData.$primaryColor);
		okBtn.addActionListener(e -> {
			dispose();
		});
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		centerPanel.setOpaque(false);
		centerPanel.add(lblIcon);
		centerPanel.add(txtContent);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		bottomPanel.setOpaque(false);
		bottomPanel.add(okBtn);		
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.setBackground(AppData.$white);
		contentPanel.add(centerPanel, BorderLayout.CENTER);
		contentPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		getContentPane().setLayout(new GridLayout(1,1));
		getContentPane().add(contentPanel);
		setIconImage(
			Toolkit.getDefaultToolkit().getImage(AppData.favicon)
		);
		pack();
		setLocationRelativeTo(null);
		setModal(true);
		setTitle(title == null ? "Mensaje" : title);
		setVisible(true);
	}

}
