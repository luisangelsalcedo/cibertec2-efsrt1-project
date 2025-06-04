package bembos.models;

import interfaces.Permission;

public class User {
	private String name;
	private String userName;
	private String password;
	private Permission permission;
	public int loginAttempt = 0;
	private boolean userLock = false;
	
	
	private User(String name, String userName, String password, Permission permission) {
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.permission = permission;
	}
	
	public static User createAdmin(String userName, String password) {
		return new User("administrador", userName, password, Permission.ADMIN);
	}
	
	public static User createUser(String userName, String password) {
		return new User("usuario", userName, password, Permission.USER);
	}

	// getters
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public Permission getPermission() {
		return permission;
	}

	public String getName() {
		return name;
	}
	
	public boolean isUserLock() {
		return userLock;
	}

	// setters
	public void setName(String name) {
		this.name = name;
	}	

	public void setUserLock(boolean userLock) {
		this.userLock = userLock;
	}
}
