package bembos.models;

import interfaces.Permission;

public class User {
	private String userName;
	private String password;
	private Permission permission;
	
	private User(String userName, String password, Permission permission) {
		this.userName = userName;
		this.password = password;
		this.permission = permission;
	}
	
	public static User createAdmin(String userName, String password) {
		return new User(userName, password, Permission.ADMIN);
	}
	
	public static User createUser(String userName, String password) {
		return new User(userName, password, Permission.USER);
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public Permission getPermission() {
		return permission;
	}
}
