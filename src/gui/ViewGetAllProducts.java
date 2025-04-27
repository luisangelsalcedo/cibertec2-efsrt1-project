package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import models.AppData;
import javax.swing.JScrollBar;

public class ViewGetAllProducts extends JPanel {

	JLabel lblProductList;
	JTextArea txtProductList;
	JScrollPane scrollPane;
	JButton btnSave;
	JButton btnClose;
	JPanel buttonPanel;
	
	public ViewGetAllProducts(JDialog parent) {

		lblProductList = new JLabel("Listado de promociones");
		lblProductList.setForeground(AppData.$white);
		
		txtProductList = new JTextArea();
		txtProductList.setRows(20);
		txtProductList.setColumns(35); 
		txtProductList.setLineWrap(true);
		txtProductList.setWrapStyleWord(false);
        txtProductList.setEditable(false);

        scrollPane = new JScrollPane(txtProductList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 

		btnSave = new JButton("Listar");
		btnSave.setBackground(AppData.$secondaryColor);
		btnSave.setForeground(AppData.$primaryColor);
		btnSave.addActionListener(e -> onSubmit(e));
		
		btnClose = new JButton("Cerrar");
		btnClose.setBackground(AppData.$primaryLightColor);
		btnClose.setForeground(AppData.$white);
		btnClose.addActionListener(e -> {
			parent.dispose();
		});

		// Button panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2, 10, 0));
		buttonPanel.setOpaque(false);
		buttonPanel.add(btnSave);
		buttonPanel.add(btnClose);

		setLayout(new BorderLayout(0, 10));
		add(lblProductList, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	private void onSubmit(ActionEvent event) {
		
		txtProductList.append("LISTADO DE PROMOCIONES\n");

		//	product 1
		txtProductList.append("\nPromo 1	: " + AppData.productName1);
		txtProductList.append("\nHamburguesa	: " + AppData.burgers[AppData.burgerName1] + " " + AppData.sizeProducts[AppData.burgerSize1]);
		txtProductList.append("\nCantidad	: " + AppData.burgerCount1);
		txtProductList.append("\nPapas	: " + AppData.sizeProducts[AppData.potatoesSize1]);
		txtProductList.append("\nCantidad	: " + AppData.potatoesCount1);
		txtProductList.append("\nBebida	: " + AppData.sodas[AppData.sodaName1]);
		txtProductList.append("\nCantidad	: " + AppData.sodaCount1);
		txtProductList.append("\nPrecio Total	: S/. " + AppData.price1);
		txtProductList.append("\n\n");

		//	product 2
		txtProductList.append("\nPromo 2	: " + AppData.productName2);
		txtProductList.append("\nHamburguesa	: " + AppData.burgers[AppData.burgerName2] + " " + AppData.sizeProducts[AppData.burgerSize2]);
		txtProductList.append("\nCantidad	: " + AppData.burgerCount2);
		txtProductList.append("\nPapas	: " + AppData.sizeProducts[AppData.potatoesSize2]);
		txtProductList.append("\nCantidad	: " + AppData.potatoesCount2);
		txtProductList.append("\nBebida	: " + AppData.sodas[AppData.sodaName2]);
		txtProductList.append("\nCantidad	: " + AppData.sodaCount2);
		txtProductList.append("\nPrecio Total	: S/. " + AppData.price2);
		txtProductList.append("\n\n");

		//	product 3
		txtProductList.append("\nPromo 3	: " + AppData.productName3);
		txtProductList.append("\nHamburguesa	: " + AppData.burgers[AppData.burgerName3] + " " + AppData.sizeProducts[AppData.burgerSize3]);
		txtProductList.append("\nCantidad	: " + AppData.burgerCount3);
		txtProductList.append("\nPapas	: " + AppData.sizeProducts[AppData.potatoesSize3]);
		txtProductList.append("\nCantidad	: " + AppData.potatoesCount3);
		txtProductList.append("\nBebida	: " + AppData.sodas[AppData.sodaName3]);
		txtProductList.append("\nCantidad	: " + AppData.sodaCount3);
		txtProductList.append("\nPrecio Total	: S/. " + AppData.price3);
		txtProductList.append("\n\n");

		//	product 4
		txtProductList.append("\nPromo 4	: " + AppData.productName4);
		txtProductList.append("\nHamburguesa	: " + AppData.burgers[AppData.burgerName4] + " " + AppData.sizeProducts[AppData.burgerSize4]);
		txtProductList.append("\nCantidad	: " + AppData.burgerCount4);
		txtProductList.append("\nPapas	: " + AppData.sizeProducts[AppData.potatoesSize4]);
		txtProductList.append("\nCantidad	: " + AppData.potatoesCount4);
		txtProductList.append("\nBebida	: " + AppData.sodas[AppData.sodaName4]);
		txtProductList.append("\nCantidad	: " + AppData.sodaCount4);
		txtProductList.append("\nPrecio Total	: S/. " + AppData.price4);
		txtProductList.append("\n\n");

		//	product 5
		txtProductList.append("\nPromo 5	: " + AppData.productName5);
		txtProductList.append("\nHamburguesa	: " + AppData.burgers[AppData.burgerName5] + " " + AppData.sizeProducts[AppData.burgerSize5]);
		txtProductList.append("\nCantidad	: " + AppData.burgerCount5);
		txtProductList.append("\nPapas	: " + AppData.sizeProducts[AppData.potatoesSize5]);
		txtProductList.append("\nCantidad	: " + AppData.potatoesCount5);
		txtProductList.append("\nBebida	: " + AppData.sodas[AppData.sodaName5]);
		txtProductList.append("\nCantidad	: " + AppData.sodaCount5);
		txtProductList.append("\nPrecio Total	: S/. " + AppData.price5);
		txtProductList.append("\n\n");

		//	product 6
		txtProductList.append("\nPromo 6	: " + AppData.productName6);
		txtProductList.append("\nHamburguesa	: " + AppData.burgers[AppData.burgerName6] + " " + AppData.sizeProducts[AppData.burgerSize6]);
		txtProductList.append("\nCantidad	: " + AppData.burgerCount6);
		txtProductList.append("\nPapas	: " + AppData.sizeProducts[AppData.potatoesSize6]);
		txtProductList.append("\nCantidad	: " + AppData.potatoesCount6);
		txtProductList.append("\nBebida	: " + AppData.sodas[AppData.sodaName6]);
		txtProductList.append("\nCantidad	: " + AppData.sodaCount6);
		txtProductList.append("\nPrecio Total	: S/. " + AppData.price6);
		txtProductList.append("\n\n");
	}		


}
