package gui;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import models.AppData;

import javax.swing.JTextPane;
import java.awt.Color;


public class ViewAboutApp extends JPanel {
	private JPanel topPanel;
	private JPanel centerPanel;
	private JPanel bottomPanel;
	private JPanel authorPanel;	
	private ImageIcon logo;
	private JLabel lblLogo;
	private ImageIcon avatar;
	private JLabel lblAvatar;
	private JTextPane textDescription;
	private JTextPane textAuthor;
	private JButton showDesignBtn;
	private JButton showCodeBtn;
	private JButton showDocumentsBtn;


	public ViewAboutApp() {
		
		String sourcePath = AppData.sourcePath;
		
//		logo image
		logo = new ImageIcon(sourcePath + "logo.png");
		Image smallLogo = logo.getImage().getScaledInstance(56, 83, Image.SCALE_SMOOTH);
		lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(smallLogo));
		
//		avatar image
		avatar = new ImageIcon(sourcePath + "avatar.png");
		lblAvatar = new JLabel();
		lblAvatar.setIcon(avatar);
		
//		text general description
		String description = "Esta aplicación ha sido desarrollada con fines de estudio del curso de\nIntroducción a la Algoritmia en el Instituto Cibertec. El objetivo de este\nproyecto es aplicar conceptos básicos de programación y algoritmos\nen la creación de una aplicación funcional.";
		textDescription = new JTextPane();
		textDescription.setEnabled(false);
		textDescription.setEditable(false);
		textDescription.setOpaque(false);
		textDescription.setText(description);	
		
//		text author description
		String authorDescription = "Creado por:\nLuis Angel Salcedo Gavidia\n2025";
		textAuthor = new JTextPane();
		textAuthor.setEnabled(false);
		textAuthor.setEditable(false);
		textAuthor.setOpaque(false);
		textAuthor.setForeground(new Color(255, 255, 255));
		textAuthor.setText(authorDescription);
		
//		set buttons
		showDesignBtn = new JButton();
		showDesignBtn.setBackground(AppData.$secondaryColor);
		showDesignBtn.setForeground(AppData.$primaryColor);
		showDesignBtn.setText("Ver diseno");
		
		showCodeBtn = new JButton();
		showCodeBtn.setBackground(AppData.$secondaryColor);
		showCodeBtn.setForeground(AppData.$primaryColor);
		showCodeBtn.setText("Ver Codigo");
		
		showDocumentsBtn = new JButton();
		showDocumentsBtn.setBackground(AppData.$secondaryColor);
		showDocumentsBtn.setForeground(AppData.$primaryColor);
		showDocumentsBtn.setText("Ver Informe");
		
//		set panels
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.setBorder(new EmptyBorder(10,10,10,10));
		topPanel.setOpaque(false);
		topPanel.add(lblLogo);	
		
		authorPanel = new JPanel();
		authorPanel.setLayout(new FlowLayout());
		authorPanel.setBorder(new EmptyBorder(15,15,15,15));
		authorPanel.setOpaque(false);
		authorPanel.add(lblAvatar);
		authorPanel.add(textAuthor);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setOpaque(false);
		centerPanel.add(textDescription, BorderLayout.CENTER);
		centerPanel.add(authorPanel, BorderLayout.SOUTH);
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.setOpaque(false);
		bottomPanel.add(showDesignBtn);
		bottomPanel.add(showCodeBtn);
		bottomPanel.add(showDocumentsBtn);
		
		setLayout(new BorderLayout(0, 10));
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}

}
