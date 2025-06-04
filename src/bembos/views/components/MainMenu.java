package bembos.views.components;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import bembos.controllers.UserController;
import bembos.views.Home;
import bembos.views.ViewAboutApp;
import bembos.views.ViewDiscountsConfiguration;
import bembos.views.ViewGetAllProducts;
import bembos.views.ViewGetProduct;
import bembos.views.ViewGiftsConfiguration;
import bembos.views.ViewSellProduct;
import bembos.views.ViewSetProduct;
import db.AppData;
import interfaces.AlertType;

public class MainMenu extends JMenuBar implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmListar;
	private JMenuItem mntmVender;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmAcercaDeTienda;	
	private JMenuItem mntmVerUsuario;	
	private JMenuItem mntmListarUsuarios;	
	private JMenuItem mntmAgregarUsuario;	
	private JMenuItem mntmCerrarSesion;
	private JMenu mnConfiguracion;
	private JMenu mnUsuarios;
	private JMenu mnAyuda;
	private JMenuBar menuBar;
	private Home parent;
	
	public MainMenu(Home parent){
		this.parent = parent;
		
		Font fontMenu = new Font("Dialog", Font.BOLD, 15);
		Font fontSubMenu = new Font("Dialog", Font.BOLD, 15);
		
		// set menu Items
		mntmSalir 					= new JMenuItem("Salir");
		mntmConsultar 				= new JMenuItem("Consultar producto");
		mntmModificar 				= new JMenuItem("Modificar producto");
		mntmListar 					= new JMenuItem("Listar productos");
		mntmVender 					= new JMenuItem("Vender");
		mntmConfigurarDescuentos 	= new JMenuItem("Configurar descuentos");
		mntmConfigurarObsequios 	= new JMenuItem("Configurar obsequios");
		mntmAcercaDeTienda 			= new JMenuItem("Acerca de la aplicación");
		mntmVerUsuario	 			= new JMenuItem("Ver Usuario");
		mntmListarUsuarios	 		= new JMenuItem("Listar Usuarios");
		mntmAgregarUsuario	 		= new JMenuItem("Agregar Usuarios");
		mntmCerrarSesion	 		= new JMenuItem("Cerrar sesión");
		
		// set submenu font
		mntmSalir.setFont(fontSubMenu);
		mntmConsultar.setFont(fontSubMenu);
		mntmModificar.setFont(fontSubMenu);
		mntmListar.setFont(fontSubMenu);
		mntmVender.setFont(fontSubMenu);
		mntmConfigurarDescuentos.setFont(fontSubMenu);
		mntmConfigurarObsequios.setFont(fontSubMenu);
		mntmAcercaDeTienda.setFont(fontSubMenu);
		mntmVerUsuario.setFont(fontSubMenu);
		mntmListarUsuarios.setFont(fontSubMenu);
		mntmAgregarUsuario.setFont(fontSubMenu);
		mntmCerrarSesion.setFont(fontSubMenu);
		
		// set action events
		mntmSalir.addActionListener(this);
		mntmConsultar.addActionListener(this);
		mntmModificar.addActionListener(this);
		mntmListar.addActionListener(this);
		mntmVender.addActionListener(this);
		mntmConfigurarDescuentos.addActionListener(this);
		mntmConfigurarObsequios.addActionListener(this);
		mntmAcercaDeTienda.addActionListener(this);
		mntmVerUsuario.addActionListener(this);
		mntmListarUsuarios.addActionListener(this);
		mntmAgregarUsuario.addActionListener(this);
		mntmCerrarSesion.addActionListener(this);
		
		
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
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(fontMenu);
		mnAyuda.setForeground(AppData.$primaryColor);
		mnAyuda.add(mntmAcercaDeTienda);
		
		mnConfiguracion = new JMenu("Configuración");
		mnConfiguracion.setFont(fontMenu);
		mnConfiguracion.setForeground(AppData.$primaryColor);
		mnConfiguracion.add(mntmConfigurarDescuentos);		
		mnConfiguracion.add(mntmConfigurarObsequios);
		
		mnUsuarios = new JMenu("Usuarios");
		mnUsuarios.setFont(fontMenu);
		mnUsuarios.setForeground(AppData.$primaryColor);
		mnUsuarios.add(mntmVerUsuario);
		mnUsuarios.add(mntmCerrarSesion);
		
		// set menu bar
		menuBar = new JMenuBar();
		menuBar.setBackground(AppData.$secondaryColor);
		menuBar.add(mnArchivo);
		menuBar.add(mnMantenimiento);
		menuBar.add(mnVentas);
		menuBar.add(mnUsuarios);
		menuBar.add(mnAyuda);		
	}
	
	public JMenuBar getComponent() {
		return menuBar;
	}
	
	public void setAdminMenu() {
		mnUsuarios.add(mntmListarUsuarios);
		mnUsuarios.add(mntmAgregarUsuario);
		mnUsuarios.add(mntmCerrarSesion);
		
		menuBar.add(mnConfiguracion);
		menuBar.add(mnUsuarios);
		menuBar.add(mnAyuda);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub  
		Object source = e.getSource();
		
		MainDialog dialog = new MainDialog();
		
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
		if(source == mntmVerUsuario) {
			JPanel testPanel = new JPanel();
			dialog.setTitle("Ver usuario");
			dialog.showView(testPanel);
		}
		if(source == mntmListarUsuarios) {
			JPanel testPanel = new JPanel();
			dialog.setTitle("Listar usuarios");
			dialog.showView(testPanel);
		}
		if(source == mntmAgregarUsuario) {
			JPanel testPanel = new JPanel();
			dialog.setTitle("Agregar usuario");
			dialog.showView(testPanel);
		}
		if(source == mntmCerrarSesion) {
			UserController userControl = new UserController();
			new MainAlert("Nos vemos pronto " + AppData.loggedUser.getName(), AlertType.DEFAULT);
			userControl.logout();
			parent.showLoginForm(true);
			parent.showMenu(false);
		}
	
		dialog.setLocationRelativeTo(this);
	}
}
