package bembos.controllers;

import java.util.ArrayList;
import java.util.List;
import bembos.models.User;
import db.AppData;

public class UserController {
	private List<User> userList = new ArrayList<>(AppData.usersList);
	
	public List<User> getAllUsers(){
		return userList;
	}
	
	public boolean login(String userName, String password) {
		System.out.print("\nuser " + userName);
		System.out.print("\npass " + password);
		for(User user:userList) {
			if(
				user.getUserName().trim().equals(userName) && 
				user.getPassword().trim().equals(password)
			){
				AppData.loggedUser = user;
				return true;
			} 		
		}
		return false;
	}
	public boolean logout() {
		AppData.loggedUser = null;
		return false;
	}
}
