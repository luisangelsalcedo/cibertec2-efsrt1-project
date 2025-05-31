package bembos.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import bembos.models.BembosMenu;
import db.AppData;

public class BembosMenuController {
	private List<BembosMenu> bembosMenuList = new ArrayList<>(AppData.menusList);
	
	// methods
	public void addMenu(BembosMenu menu) {
		bembosMenuList.add(menu);
	}
	
	public List<BembosMenu> getAllMenus(){
		return new ArrayList<>(bembosMenuList);
	}
	
	public BembosMenu getMenuByName(String nameMenu){		
		for(BembosMenu menu:bembosMenuList) {
			if(menu.getName().equalsIgnoreCase(nameMenu)) {
				return menu;
			}
		}
		return null;
	}
	
	public boolean removeMenu(String nameMenu){
		Iterator<BembosMenu> iterator = bembosMenuList.iterator();
		
		while(iterator.hasNext()) {
			BembosMenu currentMenu = iterator.next();
			if(currentMenu.getName().equalsIgnoreCase(nameMenu)) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}
	
	public boolean updateMenu(String nameMenu, BembosMenu updatedMenu){
		for(int index = 0; bembosMenuList.size() > index; index++) {
			BembosMenu currentMenu = bembosMenuList.get(index);
			
			if(currentMenu.getName().equalsIgnoreCase(nameMenu)) {
				bembosMenuList.set(index, updatedMenu);
				return true;
			}
		}
		return false;
	}
}
