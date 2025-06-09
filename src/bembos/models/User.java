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
		setUserName(userName);
		setName(name);
		setPassword(password);
		setPermission(permission);
	}
	
	public User() {}
	
	public static User createAdmin(String userName, String password) {
		return new User(Permission.ADMIN.toString(), userName, password, Permission.ADMIN);
	}
	
	public static User createUser(String userName, String password) {
		return new User(Permission.USER.toString(), userName, password, Permission.USER);
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

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public void setUserLock(boolean userLock) {
		this.userLock = userLock;
	}
}
