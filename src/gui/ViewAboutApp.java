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
import java.awt.Desktop;
import java.awt.Dimension;
import java.net.URI;


public class ViewAboutApp extends JPanel {

	private static final long serialVersionUID = 1L;

	public ViewAboutApp() {
		
		String sourcePath = AppData.sourcePath;
		
//		logo image
		ImageIcon logo = new ImageIcon(getClass().getResource(sourcePath + "logo.png"));
		Image smallLogo = logo.getImage().getScaledInstance(56, 83, Image.SCALE_SMOOTH);
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(smallLogo));
		
//		avatar image
		ImageIcon avatar = new ImageIcon(getClass().getResource(sourcePath + "avatar.png"));
		JLabel lblAvatar = new JLabel();
		lblAvatar.setIcon(avatar);
		
//		text general description
		String description = "Esta aplicación ha sido desarrollada con fines educativos como parte del curso \"Introducción a la Algoritmia\", dictado por el docente Yan Carlos Bocanegra Pinchi en el Instituto Cibertec. El objetivo de este proyecto es aplicar conceptos básicos de programación y algoritmos en la creación de una aplicación funcional.";
		JTextPane textDescription = new JTextPane();
		textDescription.setEnabled(false);
		textDescription.setEditable(false);
		textDescription.setOpaque(false);
		textDescription.setText(description);
		textDescription.setPreferredSize(new Dimension(430, 100));
		
//		text author description
		String authorDescription = "Creado por:\nLuis Angel Salcedo Gavidia\n2025";
		JTextPane textAuthor = new JTextPane();
		textAuthor.setEnabled(false);
		textAuthor.setEditable(false);
		textAuthor.setOpaque(false);
		textAuthor.setForeground(new Color(255, 255, 255));
		textAuthor.setText(authorDescription);
		
//		set buttons
		JButton showDesignBtn = new JButton();
		showDesignBtn.setBackground(AppData.$secondaryColor);
		showDesignBtn.setForeground(AppData.$primaryColor);
		showDesignBtn.setText("Ver diseño");
		showDesignBtn.addActionListener(e->{
			try {
				Desktop.getDesktop().browse(new URI("https://www.figma.com/design/og3bf3oQxkjahuaH1yghme/cibertec1-iaa-project?node-id=0-1&t=OKpfs7KpUQedbDS4-1"));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});
		
		JButton showCodeBtn = new JButton();
		showCodeBtn.setBackground(AppData.$secondaryColor);
		showCodeBtn.setForeground(AppData.$primaryColor);
		showCodeBtn.setText("Ver Código");
		showCodeBtn.addActionListener(e->{
			try {
				Desktop.getDesktop().browse(new URI("https://github.com/luisangelsalcedo/cibertec1-iaa-project"));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});
		
//		JButton showDocumentsBtn = new JButton();
//		showDocumentsBtn.setBackground(AppData.$secondaryColor);
//		showDocumentsBtn.setForeground(AppData.$primaryColor);
//		showDocumentsBtn.setText("Ver Informe");
		
//		set panels
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
		topPanel.setOpaque(false);
		topPanel.add(lblLogo);	
		
		JPanel authorPanel = new JPanel();
		authorPanel.setLayout(new FlowLayout());
		authorPanel.setBorder(new EmptyBorder(15,15,15,15));
		authorPanel.setOpaque(false);
		authorPanel.add(lblAvatar);
		authorPanel.add(textAuthor);
		
		JLabel txtVersion = new JLabel();
		txtVersion.setText(AppData.version == null ? "" : "Versión " + AppData.version);
		txtVersion.setForeground(AppData.$white);
		JPanel versionPanel = new JPanel();
		versionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		versionPanel.setBorder(new EmptyBorder(0, 0, 15, 0));
		versionPanel.setOpaque(false);
		versionPanel.add(txtVersion);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setOpaque(false);
		centerPanel.add(versionPanel, BorderLayout.NORTH);
		centerPanel.add(textDescription, BorderLayout.CENTER);
		centerPanel.add(authorPanel, BorderLayout.SOUTH);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.setOpaque(false);
		bottomPanel.add(showDesignBtn);
		bottomPanel.add(showCodeBtn);
//		bottomPanel.add(showDocumentsBtn);
		
		setLayout(new BorderLayout(0, 10));
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}

}
