package bembos.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import bembos.controllers.SalesController;
import bembos.models.Sale;
import bembos.utils.StyleTheme;

public class ViewTotalSalesProduct extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable salesTable;
    private DefaultTableModel tableModel;

    public ViewTotalSalesProduct() {
        setLayout(new BorderLayout());
        setBackground(StyleTheme.$primaryColor);

        String[] columns = {"ID Venta", "Nombre Combo", "Cantidad", "Precio Total", "Fecha"};
        tableModel = new DefaultTableModel(columns, 0);
        salesTable = new JTable(tableModel);

        salesTable.setRowHeight(30);
        salesTable.setBackground(Color.WHITE);
        salesTable.setForeground(Color.BLACK);
        salesTable.setGridColor(new Color(200, 200, 200));
        salesTable.setShowVerticalLines(true);
        salesTable.setIntercellSpacing(new Dimension(0, 1));
        
        for (Sale sale : SalesController.getAllsales()) {
            Object[] fila = {
                sale.getId(),
                sale.getCombo().getName(),
                sale.getCount(),
                String.format("%.2f", sale.getPaymentAmount()),
                sale.getSaleDate()
            };
            tableModel.addRow(fila);
        }

        JScrollPane scrollPane = new JScrollPane(salesTable);
        scrollPane.getViewport().setBackground(StyleTheme.$primaryColor);
        scrollPane.setBorder(null); 
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        ajustarAlturaScrollPane(scrollPane, salesTable, 30, 400);
        add(scrollPane, BorderLayout.CENTER);
    }


    private void ajustarAlturaScrollPane(JScrollPane scrollPane, JTable table, int rowHeight, int maxHeight) {
        int numRows = table.getModel().getRowCount();
        int headerHeight = table.getTableHeader().getPreferredSize().height;
        int totalHeight = numRows * rowHeight + headerHeight + 5;

        int finalHeight = Math.min(totalHeight, maxHeight);
        scrollPane.setPreferredSize(new Dimension(800, finalHeight));
        revalidate();
        repaint();
    }
}