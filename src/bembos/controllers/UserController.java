package bembos.controllers;

import java.util.ArrayList;
import java.util.List;
import bembos.models.User;
import db.AppData;
import interfaces.Permission;

public class UserController {
	private List<User> userList = new ArrayList<>(AppData.usersList);	
	
	//methods
	public List<User> getAllUsers(){
		return userList;
	}
	
	public boolean login(String userName, String password) {
		User userFound = findUserByUserName(userName);
		
		if(userFound == null) return false;						
		if(verifyAttempts(userFound)) return false;		
		if(userFound.getPassword().trim().equals(password)) {
			//validated password
			userFound.loginAttempt = 0; //reset attempt
			AppData.loggedUser = userFound;
			return true;
		}		
		return false;
	}
	
	public boolean logout() {
		AppData.loggedUser = null;
		return false;
	}
	
	public User findUserByUserName(String userName) {
		for(User user:userList) {
			if(user.getUserName().trim().equals(userName.trim())) 
				return user;
		}
		return null;
	}
	
	private boolean verifyAttempts(User user) {
		if(user.getPermission().toString() != Permission.ADMIN.toString()) 
			user.loginAttempt++;
		
		debugAttempts(user);
		if(user.loginAttempt >= 5) {
			//user lock
			user.setUserLock(true);
			return true;
		}
		return false;
	}
	private void debugAttempts(User user) {
		System.out.print("\n"+user.getUserName()+" Attempt: " + user.loginAttempt);
	}
}
