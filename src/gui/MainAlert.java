package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import models.AppData;
import java.awt.Color;

public class MainAlert extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel centerPanel;
	private JPanel bottomPanel;
	private JButton okBtn;
	private JLabel lblIcon;
	private JTextPane txtContent;
	
	public MainAlert(String alertMessage) {		
		
		lblIcon = new JLabel();
		lblIcon.setIcon(new ImageIcon(getClass().getResource(AppData.sourcePath + "burgerIcon.png")));
		
		txtContent = new JTextPane();
		txtContent.setEditable(false);
		txtContent.setOpaque(false);
		txtContent.setForeground(AppData.$primaryColor);
		txtContent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContent.setText(alertMessage);
		
		okBtn = new JButton("Aceptar");
		okBtn.setBackground(AppData.$secondaryColor);
		okBtn.setForeground(AppData.$primaryColor);
		okBtn.addActionListener(e -> {
			dispose();
		});
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		centerPanel.setOpaque(false);
		centerPanel.add(lblIcon);
		centerPanel.add(txtContent);
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		bottomPanel.setOpaque(false);
		bottomPanel.add(okBtn);		
		
		contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.setBackground(AppData.$white);
		contentPanel.add(centerPanel, BorderLayout.CENTER);
		contentPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		getContentPane().setLayout(new GridLayout(1,1));
		getContentPane().add(contentPanel);
		setIconImage(
			Toolkit.getDefaultToolkit().getImage(getClass().getResource(AppData.sourcePath + AppData.favicon))
		);
		pack();
		setLocationRelativeTo(null);
	}

}
