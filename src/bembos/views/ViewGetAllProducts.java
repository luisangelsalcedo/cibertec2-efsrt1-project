package bembos.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import bembos.controllers.ComboController;
import bembos.models.Combo;
import bembos.models.ComboItem;
import bembos.views.components.MainDialog;
import db.StyleTheme;

public class ViewGetAllProducts extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea txtProductList;
	
	public ViewGetAllProducts() {

		JLabel lblProductList = new JLabel("Listado de promociones");
		lblProductList.setForeground(StyleTheme.$white);
		
		txtProductList = new JTextArea();
		txtProductList.setRows(20);
		txtProductList.setColumns(35); 
		txtProductList.setLineWrap(true);
		txtProductList.setWrapStyleWord(false);
        txtProductList.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(txtProductList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 

        JButton btnSave = new JButton("Listar");
		btnSave.setBackground(StyleTheme.$secondaryColor);
		btnSave.setForeground(StyleTheme.$primaryColor);
		btnSave.addActionListener(e -> onSubmit(e));
		
		JButton btnClose = new JButton("Cerrar");
		btnClose.setBackground(StyleTheme.$primaryLightColor);
		btnClose.setForeground(StyleTheme.$white);
		btnClose.addActionListener(e -> {
			MainDialog.getInstance().dispose();
		});

		// Button panel
		JPanel buttonPanel = new JPanel();
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
		
		ComboController controller = new ComboController();
		
		txtProductList.append("LISTADO DE PROMOCIONES\n");
		
		for(Combo combo : controller.getAllCombos()) {
			txtProductList.append("\nPromo: " + combo.getName());
			combo.setItems(controller.getAllItemsByComboID(combo.getId()));
			List<ComboItem> items = combo.getItems();
			for(ComboItem item : items) {
				txtProductList.append(
						"\n" + item.getCount() + " | " + item.getProduct().getType().toString() + ": " + item.getProduct().getName() + " | " + item.getSize().toString());
			}			

			txtProductList.append("\nCantidad: " + items.stream().mapToInt(item -> item.getCount()).sum() + " productos");
			txtProductList.append("\nPrecio Total: S/. " + String.format("%,5.2f", combo.getTotalPrice()));
			txtProductList.append("\n---------------------------------------------------------\n");
		}
	}		
}
