package bembos.views.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bembos.controllers.UserController;
import bembos.views.Home;
import db.AppData;
import interfaces.AlertType;

public class LoginForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private Home parent;
	
	public LoginForm(Home parent) {
		this.parent = parent;
		Font fontLogin = new Font("Dialog", Font.BOLD, 14);
		
		JLabel lblUserName = new JLabel("Usuario:");
		lblUserName.setFont(fontLogin);
		JLabel lblPassword = new JLabel("Contrasena:");
		lblPassword.setFont(fontLogin);
		
		txtUserName = new JTextField();
		txtUserName.setBorder(null);
		txtUserName.addActionListener(e->submitAction());
		txtUserName.requestFocus();
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(null);
		txtPassword.addActionListener(e->submitAction());
			

		
		JPanel userPanel = new JPanel();
		userPanel.setOpaque(false);
		userPanel.setLayout(new BorderLayout(10,0));
		userPanel.add(lblUserName, BorderLayout.WEST);
		userPanel.add(txtUserName, BorderLayout.CENTER);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.setOpaque(false);
		passwordPanel.setLayout(new BorderLayout(10,0));
		passwordPanel.add(lblPassword, BorderLayout.WEST);
		passwordPanel.add(txtPassword, BorderLayout.CENTER);
		
		JPanel loginFormPanel = new JPanel();
		loginFormPanel.setOpaque(false);
		loginFormPanel.setPreferredSize(new Dimension(0,25));
		loginFormPanel.setLayout(new GridLayout(1,2,10,0));
		loginFormPanel.add(userPanel);
		loginFormPanel.add(passwordPanel);
		
		JButton btnSubmit = new JButton("Ingresar");
		btnSubmit.setFont(fontLogin);
		btnSubmit.setBackground(AppData.$primaryColor);
		btnSubmit.setForeground(AppData.$white);
		btnSubmit.addActionListener(e->submitAction());
		
		JLabel lblIcon = new JLabel();
		lblIcon.setIcon(new ImageIcon(getClass().getResource(AppData.sourcePath + "icon-lock.png")));
		
		
		setBackground(AppData.$secondaryColor);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(15,0));
		add(lblIcon, BorderLayout.WEST);
		add(loginFormPanel, BorderLayout.CENTER);
		add(btnSubmit, BorderLayout.EAST);
		setVisible(true);
	}

	private Object submitAction() {
		String userName = txtUserName.getText(); 
		char[] password = txtPassword.getPassword();			
		
		if(userName.length() < 2) {
			new MainAlert("El Usuario debe tener min 2 caracteres", AlertType.NOTICE);
			txtUserName.requestFocus();
			return null;
		}
		if(password.length < 8) {
			new MainAlert("La Contrasena debe tener min 8 caracteres", AlertType.NOTICE);
			txtPassword.requestFocus();
			return null;
		}
		
		UserController userControl = new UserController();
		if(userControl.login(userName, new String(password))) {
			parent.showLoginForm(false);
			parent.showMenu(true);
		} else {
			new MainAlert("El usuario y la contrasena no coinciden", AlertType.ERROR);
		}
		
		cleanTextFields();
		return null;
	}
	
	private void cleanTextFields() {
		txtUserName.setText(""); 
		txtPassword.setText("");
	}

}
