package bembos.views.components;

import java.awt.Font;
import javax.swing.JMenuItem;
import interfaces.Permission;

public class CustomMenuItem extends JMenuItem {

	private static final long serialVersionUID = 1L;
	private Permission role;
	
	
	public CustomMenuItem(String label, Permission role){
		super(label);
		this.setRole(role); 
		render();
	}	
	public CustomMenuItem(String label){
		this(label, Permission.USER);
	}
	public CustomMenuItem(){
		this("", Permission.USER);
	}
	
	
	//methods
	public boolean isAdmin() {
		return role.equals(Permission.ADMIN) ? true : false;
	}	
	private void render() {
		Font fontSubMenu = new Font("Dialog", Font.BOLD, 15);
		setFont(fontSubMenu);		
	}
	
	
	//getters
	public Permission getRole() {
		return role;
	}	
	//setters
	public void setRole(Permission role) {
		this.role = role;
	}
}
