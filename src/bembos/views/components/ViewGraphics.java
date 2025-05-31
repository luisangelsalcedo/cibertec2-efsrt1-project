package bembos.views.components;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import db.AppData;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ViewGraphics extends JPanel {

	private static final long serialVersionUID = 1L;	
	private JLabel burgerImage;
	private JLabel potatoeImage;
	private JLabel sodaImage;
	private JLabel burgerCount;
	private JLabel potatoeCount;
	private JLabel sodaCount;
	private JTextPane burgerDescription;
	private JTextPane potatoeDescription;
	private JTextPane sodaDescription;
	private ImageIcon burgerImagePath;
	private ImageIcon potatoesImagePath;
	private ImageIcon sodaImagePath;	
	private String sourcePath = AppData.sourcePath;
	private ImageIcon defaultBurgerImagePath = new ImageIcon(getClass().getResource(sourcePath + "default-burger.png"));
	private ImageIcon defaultPotatoesImagePath = new ImageIcon(getClass().getResource(sourcePath + "default-papitas.png"));
	private ImageIcon defaultSodaImagePath = new ImageIcon(getClass().getResource(sourcePath + "default-soda.png"));


	public ViewGraphics() {
		setBackground(new Color(255, 0, 0));

		burgerImage = new JLabel();
		burgerImage.setBounds(22, 27, 150, 150);
		burgerImage.setIcon(defaultBurgerImagePath);
		burgerDescription = new JTextPane();
		burgerDescription.setForeground(AppData.$white);
		burgerDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		burgerDescription.setEnabled(false);
		burgerDescription.setEditable(false);
		burgerDescription.setOpaque(false);
		burgerDescription.setBounds(58, 159, 113, 36);		
		burgerCount = new JLabel();
		burgerCount.setForeground(AppData.$white);
		burgerCount.setBounds(33, 160, 35, 35);
		burgerCount.setFont(new Font("Tahoma", Font.BOLD, 20));

		potatoeImage = new JLabel();
		potatoeImage.setBounds(150, 17, 150, 150);
		potatoeImage.setIcon(defaultPotatoesImagePath);
		potatoeDescription = new JTextPane();
		potatoeDescription.setForeground(AppData.$white);
		potatoeDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		potatoeDescription.setEnabled(false);
		potatoeDescription.setEditable(false);
		potatoeDescription.setOpaque(false);
		potatoeDescription.setBounds(215, 166, 74, 23);
		potatoeCount = new JLabel();
		potatoeCount.setForeground(AppData.$white);
		potatoeCount.setBounds(191, 160, 35, 35);
		potatoeCount.setFont(new Font("Tahoma", Font.BOLD, 20));

		sodaImage = new JLabel();
		sodaImage.setBounds(276, 27, 150, 150);
		sodaImage.setIcon(defaultSodaImagePath);
		sodaDescription = new JTextPane();
		sodaDescription.setForeground(AppData.$white);
		sodaDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sodaDescription.setEnabled(false);
		sodaDescription.setEditable(false);
		sodaDescription.setOpaque(false);
		sodaDescription.setBounds(328, 166, 69, 23);
		sodaCount = new JLabel();
		sodaCount.setForeground(AppData.$white);
		sodaCount.setBounds(306, 160, 35, 35);
		sodaCount.setFont(new Font("Tahoma", Font.BOLD, 20));

		ImageIcon ellipseSrc = new ImageIcon(getClass().getResource(sourcePath + "ellipse.png"));
		
		JLabel ellipseImage1 = new JLabel();
		ellipseImage1.setBounds(44, 37, 112, 112);
		ellipseImage1.setIcon(ellipseSrc);

		JLabel ellipseImage2 = new JLabel();
		ellipseImage2.setBounds(170, 37, 112, 112);
		ellipseImage2.setIcon(ellipseSrc);
		
		JLabel ellipseImage3 = new JLabel();
		ellipseImage3.setBounds(294, 37, 112, 112);
		ellipseImage3.setIcon(ellipseSrc);

		setLayout(null); // absolute
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
		
		setPreferredSize(new Dimension(430, 200));
		setVisible(true);
	}

	public void setBurger(int count, String image, String name, String size) {
		burgerImagePath = new ImageIcon(getClass().getResource(sourcePath + image));
		burgerCount.setText(String.valueOf(count));		
		burgerDescription.setText(name + "\n" + size);
		burgerImage.setIcon(burgerImagePath);
	}

	public void setPotatoe(int count, String size) {
		potatoesImagePath = new ImageIcon(getClass().getResource(sourcePath + "papitas.png"));
		potatoeDescription.setText(size);
		potatoeCount.setText(String.valueOf(count));
		potatoeImage.setIcon(potatoesImagePath);
	}

	public void setSoda(int count, String image, String name) {
		sodaImagePath = new ImageIcon(getClass().getResource(sourcePath + image));			
		sodaCount.setText(String.valueOf(count));
		sodaDescription.setText(name);
		sodaImage.setIcon(sodaImagePath);
	}
	
	public void clean() {
		this.cleanBurger();
		this.cleanPotatoes();
		this.cleanSoda();
	}
	
	public void cleanBurger() {
		burgerCount.setText(null);
		burgerImage.setIcon(defaultBurgerImagePath);
		burgerDescription.setText(null);		
	}
	public void cleanPotatoes() {		
		potatoeDescription.setText(null);
		potatoeImage.setIcon(defaultPotatoesImagePath);
		potatoeCount.setText(null);

	}
	public void cleanSoda() {
		sodaCount.setText(null);
		sodaImage.setIcon(defaultSodaImagePath);
		sodaDescription.setText(null);
	}

}
