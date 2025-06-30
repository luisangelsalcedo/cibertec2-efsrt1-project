package bembos.views.components;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import bembos.models.ComboItem;

public class ProductGraphic extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public ProductGraphic(){
		setOpaque(false);
		setLayout(new GridLayout(1, 10, 5, 5));
	}
	
	public void render(List<ComboItem> items) {
		clean();
		for(ComboItem item : items) {
			ComboItem cloneItem = new ComboItem(item);
			add(new ProductGraphicItem(cloneItem), BorderLayout.CENTER);
			setBorder(new EmptyBorder(10, 10, 10, 10));
		}
	}
	
	public void clean() {
		setBorder(null);
		removeAll();
		revalidate();
		repaint();
	}


}
