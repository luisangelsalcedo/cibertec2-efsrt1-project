package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Home extends JFrame {


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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// set menu Items
		mntmSalir = new JMenuItem("Salir");
		mntmConsultar = new JMenuItem("Consultar");
		mntmModificar = new JMenuItem("Modificar");
		mntmListar = new JMenuItem("Listar");
		mntmVender = new JMenuItem("Vender");
		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		
		// set menus
		mnArchivo = new JMenu("Archivo");
		mnArchivo.add(mntmSalir);		
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.add(mntmConsultar);
		mnMantenimiento.add(mntmModificar);		
		mnMantenimiento.add(mntmListar);
		
		mnVentas = new JMenu("Ventas");		
		mnVentas.add(mntmVender);
		
		mnConfiguracion = new JMenu("Configuracion");		
		mnConfiguracion.add(mntmConfigurarDescuentos);		
		mnConfiguracion.add(mntmConfigurarObsequios);
		
		mnAyuda = new JMenu("Ayuda");		
		mnAyuda.add(mntmAcercaDeTienda);
		
		// set menu bar
		menuBar = new JMenuBar();
		menuBar.add(mnArchivo);
		menuBar.add(mnMantenimiento);
		menuBar.add(mnVentas);
		menuBar.add(mnConfiguracion);
		menuBar.add(mnAyuda);
		setJMenuBar(menuBar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		setContentPane(contentPane);
	}

}
