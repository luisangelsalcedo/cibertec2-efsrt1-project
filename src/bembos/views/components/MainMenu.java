package bembos.views.components;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import bembos.controllers.AuthController;
import bembos.interfaces.AlertType;
import bembos.interfaces.Permission;
import bembos.utils.StyleTheme;
import bembos.views.Home;
import bembos.views.ViewAboutApp;
import bembos.views.ViewDiscountsConfiguration;
import bembos.views.ViewGetAllProducts;
import bembos.views.ViewGetProduct;
import bembos.views.ViewGiftsConfiguration;
import bembos.views.ViewNewProduct;
import bembos.views.ViewSellProduct;
import bembos.views.ViewTotalSalesProduct;

public class MainMenu extends JMenuBar implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private CustomMenuItem mntmSalir;
	private CustomMenuItem mntmNuevo;
	private CustomMenuItem mntmConsultar;
	private CustomMenuItem mntmModificar;
	private CustomMenuItem mntmListar;
	private CustomMenuItem mntmVender;
	private CustomMenuItem mntmVentasTotales;
	private CustomMenuItem mntmConfigurarDescuentos;
	private CustomMenuItem mntmConfigurarObsequios;
	private CustomMenuItem mntmAcercaDeTienda;	
	private CustomMenuItem mntmVerUsuario;	
	private CustomMenuItem mntmListarUsuarios;
	private CustomMenuItem mntmCerrarSesion;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenu mnUsuarios;
	private JMenu mnAyuda;
	private Home parent;
	
	public MainMenu(Home parent) {
		this.parent = parent;
		
		Font fontMenu = new Font("Dialog", Font.BOLD, 15);
		
		
		// set menu Items
		mntmSalir 					= new CustomMenuItem("Salir");
		mntmNuevo 					= new CustomMenuItem("Nueva combo", Permission.ADMIN);
		mntmConsultar 				= new CustomMenuItem("Consultar combos");
		mntmModificar 				= new CustomMenuItem("Modificar combos", Permission.ADMIN);
		mntmListar 					= new CustomMenuItem("Listar productos");
		mntmVender 					= new CustomMenuItem("Vender");
		mntmVentasTotales			= new CustomMenuItem("Reporte de Ventas", Permission.ADMIN);
		mntmConfigurarDescuentos 	= new CustomMenuItem("Configurar descuentos", Permission.ADMIN);
		mntmConfigurarObsequios 	= new CustomMenuItem("Configurar obsequios", Permission.ADMIN);
		mntmAcercaDeTienda 			= new CustomMenuItem("Acerca de la aplicación");
		mntmVerUsuario	 			= new CustomMenuItem("Ver Usuario");
		mntmListarUsuarios	 		= new CustomMenuItem("Listar Usuarios", Permission.ADMIN);
		mntmCerrarSesion	 		= new CustomMenuItem("Cerrar sesión");
		
		// set action events
		mntmSalir.addActionListener(this);
		mntmNuevo.addActionListener(this);
		mntmConsultar.addActionListener(this);
		mntmModificar.addActionListener(this);
		mntmListar.addActionListener(this);
		mntmVender.addActionListener(this);
		mntmVentasTotales.addActionListener(this);
		mntmConfigurarDescuentos.addActionListener(this);
		mntmConfigurarObsequios.addActionListener(this);
		mntmAcercaDeTienda.addActionListener(this);
		mntmVerUsuario.addActionListener(this);
		mntmListarUsuarios.addActionListener(this);
		mntmCerrarSesion.addActionListener(this);
		
		
		
		// set menus
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(fontMenu);
		mnArchivo.setForeground(StyleTheme.$primaryColor);
		for(CustomMenuItem item : new CustomMenuItem[] {mntmSalir}) {
			if(hasMenuPermission(item)) mnArchivo.add(item);			
		}	
		
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(fontMenu);
		mnMantenimiento.setForeground(StyleTheme.$primaryColor);		
		for(CustomMenuItem item : new CustomMenuItem[] {mntmNuevo, mntmConsultar, mntmListar}) { //mntmModificar,
			if(hasMenuPermission(item)) mnMantenimiento.add(item);
			
		}
		
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setFont(fontMenu);
		mnVentas.setForeground(StyleTheme.$primaryColor);
		for(CustomMenuItem item : new CustomMenuItem[] {mntmVender, mntmVentasTotales}) {
			if(hasMenuPermission(item)) mnVentas.add(item);
		}
		
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(fontMenu);
		mnAyuda.setForeground(StyleTheme.$primaryColor);
		for(CustomMenuItem item : new CustomMenuItem[] {mntmAcercaDeTienda}) {
			if(hasMenuPermission(item)) mnAyuda.add(item);
		}
		
		
		mnConfiguracion = new JMenu("Configuración");
		mnConfiguracion.setFont(fontMenu);
		mnConfiguracion.setForeground(StyleTheme.$primaryColor);
		for(CustomMenuItem item : new CustomMenuItem[] {mntmConfigurarDescuentos, mntmConfigurarObsequios}) {
			if(hasMenuPermission(item)) mnConfiguracion.add(item);
		}
		
		
		mnUsuarios = new JMenu("Usuarios");
		mnUsuarios.setFont(fontMenu);
		mnUsuarios.setForeground(StyleTheme.$primaryColor);
		for(CustomMenuItem item : new CustomMenuItem[] {mntmCerrarSesion}) { // mntmVerUsuario, mntmListarUsuarios, 
			if(hasMenuPermission(item)) mnUsuarios.add(item);
		}
		
		
		// set menu bar
		setBackground(StyleTheme.$secondaryColor);
		if(mnArchivo.getItemCount() > 0) add(mnArchivo);
		if(mnMantenimiento.getItemCount() > 0) add(mnMantenimiento);
		if(mnVentas.getItemCount() > 0) add(mnVentas);
		if(mnConfiguracion.getItemCount() > 0) add(mnConfiguracion);
		if(mnUsuarios.getItemCount() > 0) add(mnUsuarios);
		if(mnAyuda.getItemCount() > 0) add(mnAyuda);		
	}
	
	private boolean hasMenuPermission(CustomMenuItem item) {
		if(AuthController.getLoggedUser().getPermission().equals(Permission.ADMIN)) {
			return true;
		}
		if(AuthController.getLoggedUser().getPermission().equals(Permission.USER)) {
			if(item.getRole().equals(Permission.USER))return true;
		}
		return false;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		String sourceTitle = ((CustomMenuItem)source).getText();	
		
		if(source == mntmSalir) {
			System.exit(0);
		}
		if(source == mntmNuevo) {
			MainDialog.getInstance().showView(new ViewNewProduct());
		}
		if(source == mntmConsultar) {
			MainDialog.getInstance().showView(new ViewGetProduct());
		}
		if(source == mntmModificar) {
//			MainDialog.getInstance().showView(new ViewSetProduct());
		}
		if(source == mntmListar) {
			MainDialog.getInstance().showView(new ViewGetAllProducts());
		}
		if(source == mntmVender) {
			MainDialog.getInstance().showView(new ViewSellProduct());
		}
		if(source == mntmVentasTotales) {
			MainDialog.getInstance().showView(new ViewTotalSalesProduct());
		}
		if(source == mntmConfigurarDescuentos) {
			MainDialog.getInstance().showView(new ViewDiscountsConfiguration());
		}
		if(source == mntmConfigurarObsequios) {
			MainDialog.getInstance().showView(new ViewGiftsConfiguration());
		}
		if(source == mntmAcercaDeTienda) {
			MainDialog.getInstance().showView(new ViewAboutApp());
		}
		if(source == mntmVerUsuario) {
			JPanel testPanel = new JPanel();
			MainDialog.getInstance().showView(testPanel);
		}
		if(source == mntmListarUsuarios) {
			JPanel testPanel = new JPanel();			
			MainDialog.getInstance().showView(testPanel);
		}
		if(source == mntmCerrarSesion) {
			new CustomAlert("Nos vemos pronto " + AuthController.getLoggedUser().getName(), AlertType.DEFAULT);
			AuthController.logout();
			MainDialog.getInstance().dispose();
			parent.showLoginForm(true);
			parent.setJMenuBar(null);
		} else {
			MainDialog.getInstance().setTitle(sourceTitle);
		}
	
		MainDialog.getInstance().setLocationRelativeTo(this);
	}
}
