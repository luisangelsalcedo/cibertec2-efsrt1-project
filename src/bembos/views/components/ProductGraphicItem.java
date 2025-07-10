package bembos.views.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import bembos.models.ComboItem;
import bembos.utils.StyleTheme;

public class ProductGraphicItem extends JPanel{

	private static final long serialVersionUID = 1L;
	private String sourcePath = StyleTheme.sourcePath;
	
	public ProductGraphicItem(ComboItem item) {
		ImageIcon ellipseSrc = new ImageIcon(getClass().getResource(sourcePath + "ellipse.png"));
		ImageIcon imageSrc = new ImageIcon(getClass().getResource(sourcePath + item.getProduct().getSlug() +".png"));
		
		JLabel lblImage = new JLabel();
		lblImage.setIcon(imageSrc);
		lblImage.setHorizontalAlignment(JLabel.CENTER);
		lblImage.setVerticalAlignment(JLabel.CENTER);
		
		JLabel lblCount = new JLabel();
		lblCount.setEnabled(false);
		lblCount.setForeground(Color.WHITE);
		lblCount.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCount.setText(String.valueOf(item.getCount()));
		
		JTextPane txtDescription = new JTextPane();
		txtDescription.setOpaque(false);
		txtDescription.setEnabled(false);
		txtDescription.setEditable(false);
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDescription.setText(item.getProduct().getName() + "\n" + item.getSize().toString());
		
		JPanel infoPanel = new JPanel();
		infoPanel.setOpaque(false);
		infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		infoPanel.add(lblCount);
		infoPanel.add(txtDescription);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setOpaque(false);
		imagePanel.setLayout(new GridBagLayout());
		imagePanel.add(lblImage);
		
		JLabel ellipseImage = new JLabel();
		ellipseImage.setPreferredSize(new Dimension(150, 130));
//		ellipseImage.setBorder(BorderFactory.createLineBorder(Color.RED));
		ellipseImage.setIcon(ellipseSrc);
		ellipseImage.setHorizontalAlignment(JLabel.CENTER);
		ellipseImage.setVerticalAlignment(JLabel.TOP);
		ellipseImage.setLayout(new GridLayout(1,1));
		ellipseImage.add(imagePanel);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setOpaque(false);
		contentPanel.setLayout(new BorderLayout());
		contentPanel.add(ellipseImage, BorderLayout.NORTH);
		contentPanel.add(infoPanel, BorderLayout.CENTER);		
		
		JPanel containerPanel = new JPanel();
		containerPanel.setOpaque(false);
		containerPanel.setLayout(new GridBagLayout());
		containerPanel.add(contentPanel);		
		
		setLayout(new GridLayout(1,1));
		setOpaque(false);
		add(containerPanel);
	}
}
