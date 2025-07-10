package bembos.controllers;

import java.util.ArrayList;
import java.util.List;
import bembos.dao.UserDao;
import bembos.interfaces.Permission;
import bembos.models.User;
import bembos.utils.StyleTheme;

public class AuthController {
//	private List<User> userList = new ArrayList<>(AppData.usersList);
	private static int maxAttempts;
	private static User loggedUser;
	private UserDao userDao = new UserDao();
	
	static {
		maxAttempts = 5;
		setLoggedUser(null);
	}
	
	//methods
	public List<User> getAllUsers(){
		return new ArrayList<>(userDao.getAllUsers());
	}
	
	public void login(String userName, String password) {
		User userFound = findUserByUserName(userName);
		
		if(userFound == null) {
			throw new IllegalArgumentException("El usuario " + userName + " no existe");
		}
		if(hasTooManyAttempts(userFound)) {
			throw new IllegalArgumentException("Su usuario " + userName + " ha sido bloqueado\nComunicate con el administrador para activarlo");
		}
		if(!verifyPassword(userFound, password)) {
			throw new IllegalArgumentException("El usuario y la contraseña no coinciden");
		}
		
		userFound.loginAttempt = 0; //reset attempt
		setLoggedUser(userFound);
		userDao.updateUser(userFound);
	}
	
	public static void logout() {
		setLoggedUser(null);
	}
	
	private boolean verifyPassword(User user, String password) {
		if(user.getPassword().equals(password)) return true;
		return false;
	}
	
	public User findUserByUserName(String userName) {
		return getAllUsers().stream().filter(user -> user.getUserName().equals(userName)).findFirst().orElse(null);
	}
	
	private boolean hasTooManyAttempts(User user) {
		if(user.getPermission() == Permission.ADMIN) return false;
		
		user.loginAttempt++;
		userDao.updateUser(user);
		
		if(user.loginAttempt < maxAttempts) return false;
		
		user.setUserLock(true); //user lock
		userDao.updateUser(user);
		return true;	
	}
	
	// getters
	public static User getLoggedUser() {
		return loggedUser;
	}

	// setters
	private static void setLoggedUser(User loggedUser) {
		AuthController.loggedUser = loggedUser;
	}

}
