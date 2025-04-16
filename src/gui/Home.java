package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
		mntmConsultar = new JMenuItem("Consultar producto");
		mntmModificar = new JMenuItem("Modificar producto");
		mntmListar = new JMenuItem("Listar productos");
		mntmVender = new JMenuItem("Vender");
		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if(source == mntmSalir) {
			System.exit(0);
		}
		if(source == mntmConsultar) {
			this.alertMessage("Consultar producto");
		}
		if(source == mntmModificar) {
			this.alertMessage("Modificar producto");
		}
		if(source == mntmListar) {
			this.alertMessage("Listar productos");
		}
		if(source == mntmVender) {
			this.alertMessage("Vender");		
		}
		if(source == mntmConfigurarDescuentos) {
			this.alertMessage("configurar descuentos");
		}
		if(source == mntmAcercaDeTienda) {
			this.alertMessage("Acerca de Tienda");
		}
	}
	
	private void alertMessage(String name) {
		JOptionPane.showMessageDialog(
            null,
            "Has seleccionado: " + name,
            name,
            JOptionPane.INFORMATION_MESSAGE
        );
	}

}

