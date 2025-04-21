package gui;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import models.AppData;
import java.awt.Color;

public class ViewGraphics extends JPanel {
	
	JLabel burgerImage;
	JLabel potatoeImage;
	JLabel sodaImage;
	JLabel ellipseImage1;
	JLabel ellipseImage2;
	JLabel ellipseImage3;
	
	JLabel burgerCount;	
	JLabel potatoeCount;	
	JLabel sodaCount;
		
	JTextPane burgerDescription;
	JTextPane potatoeDescription;
	JTextPane sodaDescription;
	
	ImageIcon burgerSrc;
	ImageIcon potatoesSrc;
	ImageIcon sodaSrc;
	ImageIcon ellipseSrc;

	public ViewGraphics(
			String bImage,
			String bName,
			String bSize,
			int bCount,			
			String pSize,
			int pCount,
			String sImage,
			String sName,
			int sCount			
		) {
		setBackground(new Color(255, 0, 0));
		
		String sourcePath = AppData.sourcePath;
		
		String bbCount = bCount == 0 ? "" : "" + bCount;
		String ppCount = pCount == 0 ? "" : "" + pCount;
		String ssCount = sCount == 0 ? "" : "" + sCount;
		

		burgerSrc = bImage == null ? null : new ImageIcon(sourcePath + bImage);
		sodaSrc = sImage == null ? null : new ImageIcon(sourcePath + sImage);
		potatoesSrc = new ImageIcon(sourcePath + "papitas.png");
		ellipseSrc = new ImageIcon(sourcePath + "ellipse.png");

		
		burgerImage = new JLabel();
		burgerImage.setBounds(22, 27, 150, 150);
		burgerImage.setIcon(burgerSrc);
		burgerDescription = new JTextPane();
		burgerDescription.setForeground(new Color(255, 255, 255));
		burgerDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		burgerDescription.setEnabled(false);
		burgerDescription.setEditable(false);
		burgerDescription.setOpaque(false);
		burgerDescription.setBounds(58, 159, 113, 36);
		burgerDescription.setText(bName + "\n" + bSize);
		burgerCount = new JLabel();
		burgerCount.setText(bbCount);
		burgerCount.setForeground(new Color(255, 255, 255));
		burgerCount.setBounds(33, 160, 35, 35);
		burgerCount.setFont(new Font("Tahoma", Font.BOLD, 20));

		
		potatoeImage = new JLabel();
		potatoeImage.setBounds(150, 17, 150, 150);
		potatoeImage.setIcon(potatoesSrc);
		potatoeDescription = new JTextPane();
		potatoeDescription.setForeground(new Color(255, 255, 255));
		potatoeDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		potatoeDescription.setEnabled(false);
		potatoeDescription.setEditable(false);
		potatoeDescription.setOpaque(false);
		potatoeDescription.setBounds(215, 166, 74, 23);
		potatoeDescription.setText(pSize);
		potatoeCount = new JLabel();
		potatoeCount.setText(ppCount);
		potatoeCount.setForeground(new Color(255, 255, 255));
		potatoeCount.setBounds(191, 160, 35, 35);
		potatoeCount.setFont(new Font("Tahoma", Font.BOLD, 20));

		
		sodaImage = new JLabel();
		sodaImage.setBounds(276, 27, 150, 150);
		sodaImage.setIcon(sodaSrc);
		sodaDescription = new JTextPane();
		sodaDescription.setForeground(new Color(255, 255, 255));
		sodaDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sodaDescription.setEnabled(false);
		sodaDescription.setEditable(false);
		sodaDescription.setOpaque(false);
		sodaDescription.setBounds(328, 166, 69, 23);
		sodaDescription.setText(sName);
		sodaCount = new JLabel();
		sodaCount.setText(ssCount);
		sodaCount.setForeground(new Color(255, 255, 255));
		sodaCount.setBounds(306, 160, 35, 35);
		sodaCount.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		ellipseImage1 = new JLabel();
		ellipseImage1.setBounds(44, 37, 112, 112);
		ellipseImage1.setIcon(ellipseSrc);
		
		ellipseImage2 = new JLabel();
		ellipseImage2.setBounds(170, 37, 112, 112);
		ellipseImage2.setIcon(ellipseSrc);
		
		ellipseImage3 = new JLabel();
		ellipseImage3.setBounds(294, 37, 112, 112);
		ellipseImage3.setIcon(ellipseSrc);
		
		setLayout(null);
		setBackground(new Color(2, 22, 137));
		add(burgerCount);		
		add(potatoeCount);
		add(sodaCount);
		add(burgerDescription);
		add(potatoeDescription);
		add(sodaDescription);
		add(potatoeImage);
		add(sodaImage);
		add(burgerImage);
		add(ellipseImage1);
		add(ellipseImage2);
		add(ellipseImage3);
	}

}
