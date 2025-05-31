package bembos.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import bembos.views.components.MainDialog;
import db.AppData;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Home extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;	
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmListar;
	private JMenuItem mntmVender;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmAcercaDeTienda;	
	private URL favicon = getClass().getResource(AppData.sourcePath + AppData.favicon);

	/**
	 * Create the frame.
	 */
	public Home() {		
		
		setTitle(AppData.AppTitle);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(500, 360);
		setLocationRelativeTo(null);
		setIconImage(
			Toolkit.getDefaultToolkit().getImage(favicon)
		);
		
		Font fontMenu = new Font("Dialog", Font.BOLD, 14);
		
		// set menu Items
		mntmSalir 					= new JMenuItem("Salir");
		mntmConsultar 				= new JMenuItem("Consultar producto");
		mntmModificar 				= new JMenuItem("Modificar producto");
		mntmListar 					= new JMenuItem("Listar productos");
		mntmVender 					= new JMenuItem("Vender");
		mntmConfigurarDescuentos 	= new JMenuItem("Configurar descuentos");
		mntmConfigurarObsequios 	= new JMenuItem("Configurar obsequios");
		mntmAcercaDeTienda 			= new JMenuItem("Acerca de la aplicación");
		
		// set submenu font
		mntmSalir.setFont(fontMenu);
		mntmConsultar.setFont(fontMenu);
		mntmModificar.setFont(fontMenu);
		mntmListar.setFont(fontMenu);
		mntmVender.setFont(fontMenu);
		mntmConfigurarDescuentos.setFont(fontMenu);
		mntmConfigurarObsequios.setFont(fontMenu);
		mntmAcercaDeTienda.setFont(fontMenu);
		
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
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(fontMenu);
		mnArchivo.setForeground(AppData.$primaryColor);
		mnArchivo.add(mntmSalir);		
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(fontMenu);
		mnMantenimiento.setForeground(AppData.$primaryColor);
		mnMantenimiento.add(mntmConsultar);
		mnMantenimiento.add(mntmModificar);		
		mnMantenimiento.add(mntmListar);
		
		JMenu mnVentas = new JMenu("Ventas");
		mnVentas.setFont(fontMenu);
		mnVentas.setForeground(AppData.$primaryColor);
		mnVentas.add(mntmVender);
		
		JMenu mnConfiguracion = new JMenu("Configuración");
		mnConfiguracion.setFont(fontMenu);
		mnConfiguracion.setForeground(AppData.$primaryColor);
		mnConfiguracion.add(mntmConfigurarDescuentos);		
		mnConfiguracion.add(mntmConfigurarObsequios);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(fontMenu);
		mnAyuda.setForeground(AppData.$primaryColor);
		mnAyuda.add(mntmAcercaDeTienda);
		
		// set menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(AppData.$secondaryColor);
		menuBar.add(mnArchivo);
		menuBar.add(mnMantenimiento);
		menuBar.add(mnVentas);
		menuBar.add(mnConfiguracion);
		menuBar.add(mnAyuda);
		setJMenuBar(menuBar);
		
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
		lblBackground.add(footerPanel, BorderLayout.SOUTH);
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(AppData.$primaryColor);
		contentPane.setLayout(new GridLayout(1, 1, 0, 0));
		contentPane.add(lblBackground);
		setContentPane(contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub  
		Object source = e.getSource();
		
		MainDialog dialog = new MainDialog();
		dialog.setIconImage(
			Toolkit.getDefaultToolkit().getImage(favicon)
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
			ViewDiscountsConfiguration discountsConfigurationPanel = new ViewDiscountsConfiguration(dialog);
			dialog.setTitle("Configurar Descuentos");
			dialog.showView(discountsConfigurationPanel);
		}
		if(source == mntmConfigurarObsequios) {			
			ViewGiftsConfiguration giftsConfigurationPanel = new ViewGiftsConfiguration(dialog);
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

