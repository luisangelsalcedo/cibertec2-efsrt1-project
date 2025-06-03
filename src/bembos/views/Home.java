package bembos.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;

import bembos.views.components.LoginForm;
import bembos.views.components.MainMenu;
import db.AppData;


public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private MainMenu menuBar;
	private LoginForm loginForm;
	/**
	 * Create the frame.
	 */
	public Home() {		
		
		setTitle(AppData.AppTitle);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 450);
		setLocationRelativeTo(null);
		setIconImage(
			Toolkit.getDefaultToolkit().getImage(AppData.favicon)
		);
		
		// menu
		menuBar = new MainMenu(this);
		// login
		loginForm = new LoginForm(this);
		
		
		// disclaimer
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(getClass().getResource(AppData.sourcePath + "cibertec.png")));
		
		JLabel lblDisclaimer = new JLabel("-  Proyecto realizado con fines educativos");
		lblDisclaimer.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblDisclaimer.setForeground(AppData.$white);
		
		JPanel disclaimerPanel = new JPanel();
		disclaimerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		disclaimerPanel.setOpaque(false);
		disclaimerPanel.add(lblLogo);
		disclaimerPanel.add(lblDisclaimer);
		
		// version
		JLabel lblVersion = new JLabel();
		lblVersion.setText(AppData.version == null ? "" : "Versión " + AppData.version);
		lblVersion.setForeground(AppData.$white);
		
		JPanel versionPanel = new JPanel();
		versionPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		versionPanel.setOpaque(false);
		versionPanel.add(lblVersion);
		
		JPanel footerPanel = new JPanel();
		footerPanel.setLayout(new BorderLayout());
		footerPanel.setBorder(new EmptyBorder(0, 15, 15, 20));
		footerPanel.setOpaque(false);
		footerPanel.add(disclaimerPanel, BorderLayout.CENTER);
		footerPanel.add(versionPanel, BorderLayout.EAST);
		
		// background		
		ImageIcon backgroundImage = new ImageIcon(getClass().getResource(AppData.sourcePath + "background.png"));
		JLabel lblBackground = new JLabel();
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground.setIcon(backgroundImage);	
		lblBackground.setLayout(new BorderLayout());
		lblBackground.add(loginForm, BorderLayout.NORTH);
		lblBackground.add(footerPanel, BorderLayout.SOUTH);
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(AppData.$primaryColor);
		contentPane.setLayout(new GridLayout(1, 1, 0, 0));
		contentPane.add(lblBackground);
		setContentPane(contentPane);
	}
	
	public void showMenu(boolean bool) {
		if(bool) setJMenuBar(menuBar.getComponent());
		else setJMenuBar(null);
	}
	
	public void showLoginForm(boolean bool) {
		if(bool) loginForm.setVisible(true);
		else loginForm.setVisible(false);
	}

	
}

