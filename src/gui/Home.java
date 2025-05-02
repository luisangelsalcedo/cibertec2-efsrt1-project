package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.AppData;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.Color;

public class Home extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmListar;
	private JMenuItem mntmVender;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmAcercaDeTienda;
	private JLabel lblBackground;
	private ImageIcon backgroundImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {		
		setTitle("Bembos App: Mantenimiento de Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 350);
		setLocationRelativeTo(null);
		setIconImage(
			Toolkit.getDefaultToolkit().getImage(getClass().getResource(AppData.sourcePath + AppData.favicon))
		);
		
		// set menu Items
		mntmSalir 					= new JMenuItem("Salir");
		mntmConsultar 				= new JMenuItem("Consultar producto");
		mntmModificar 				= new JMenuItem("Modificar producto");
		mntmListar 					= new JMenuItem("Listar productos");
		mntmVender 					= new JMenuItem("Vender");
		mntmConfigurarDescuentos 	= new JMenuItem("Configurar descuentos");
		mntmConfigurarObsequios 	= new JMenuItem("Configurar obsequios");
		mntmAcercaDeTienda 			= new JMenuItem("Acerca de Tienda");
		
		// set action events
		mntmSalir.addActionListener(this);
		mntmConsultar.addActionListener(this);
		mntmModificar.addActionListener(this);
		mntmListar.addActionListener(this);
		mntmVender.addActionListener(this);
		mntmConfigurarDescuentos.addActionListener(this);
		mntmConfigurarObsequios.addActionListener(this);
		mntmAcercaDeTienda.addActionListener(this);
		
		// set menus
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setForeground(AppData.$primaryColor);
		mnArchivo.add(mntmSalir);		
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setForeground(AppData.$primaryColor);
		mnMantenimiento.add(mntmConsultar);
		mnMantenimiento.add(mntmModificar);		
		mnMantenimiento.add(mntmListar);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setForeground(AppData.$primaryColor);
		mnVentas.add(mntmVender);
		
		mnConfiguracion = new JMenu("Configuracion");
		mnConfiguracion.setForeground(AppData.$primaryColor);
		mnConfiguracion.add(mntmConfigurarDescuentos);		
		mnConfiguracion.add(mntmConfigurarObsequios);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setForeground(AppData.$primaryColor);
		mnAyuda.add(mntmAcercaDeTienda);
		
		// set menu bar
		menuBar = new JMenuBar();
		menuBar.setBackground(AppData.$secondaryColor);
		menuBar.add(mnArchivo);
		menuBar.add(mnMantenimiento);
		menuBar.add(mnVentas);
		menuBar.add(mnConfiguracion);
		menuBar.add(mnAyuda);
		setJMenuBar(menuBar);
		
		// background		
		backgroundImage = new ImageIcon(getClass().getResource(AppData.sourcePath + "background.png"));
		lblBackground = new JLabel();
		lblBackground.setIcon(backgroundImage);		
		
		contentPane = new JPanel();
		contentPane.setBackground(AppData.$primaryColor);
		contentPane.add(lblBackground,BorderLayout.CENTER);
		setContentPane(contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub  
		Object source = e.getSource();
		
		MainDialog dialog = new MainDialog();
		dialog.setIconImage(
			Toolkit.getDefaultToolkit().getImage(getClass().getResource(AppData.sourcePath + AppData.favicon))
		);
		
		if(source == mntmSalir) {
			System.exit(0);
		}
		if(source == mntmConsultar) {
			ViewGetProduct getProductPanel = new ViewGetProduct(dialog);
			dialog.setTitle("Consultar");
			dialog.showView(getProductPanel);
		}
		if(source == mntmModificar) {
			ViewSetProduct setProductPanel = new ViewSetProduct(dialog);
			dialog.setTitle("Modificar");
			dialog.showView(setProductPanel);
		}
		if(source == mntmListar) {
			ViewGetAllProducts getAllProductsPanel = new ViewGetAllProducts(dialog);
			dialog.setTitle("Listar");
			dialog.showView(getAllProductsPanel);
		}
		if(source == mntmVender) {
			ViewSellProduct sellProductPanel = new ViewSellProduct(dialog);
			dialog.setTitle("Vender");
			dialog.showView(sellProductPanel);
		}
		if(source == mntmConfigurarDescuentos) {
			ViewDiscountsConfiguration discountsConfigurationPanel = new ViewDiscountsConfiguration();
			dialog.setTitle("Configurar Descuentos");
			dialog.showView(discountsConfigurationPanel);
		}
		if(source == mntmConfigurarObsequios) {			
			ViewGiftsConfiguration giftsConfigurationPanel = new ViewGiftsConfiguration();
			dialog.setTitle("Configurar Obsequios");
			dialog.showView(giftsConfigurationPanel);
		}
		if(source == mntmAcercaDeTienda) {
			ViewAboutApp aboutAppPanel = new ViewAboutApp();
			dialog.setTitle("Acerca de la Aplicacion");
			dialog.showView(aboutAppPanel);
		}
	
		dialog.setLocationRelativeTo(this);
	}
}

