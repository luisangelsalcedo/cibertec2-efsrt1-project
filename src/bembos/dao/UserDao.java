package bembos.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bembos.interfaces.Permission;
import bembos.models.User;

public class UserDao {
	private String jdbcURL = "jdbc:sqlite:./bembos.db";


    private Connection connect() throws SQLException {
        return DriverManager.getConnection(jdbcURL);
    }
    
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "userName TEXT UNIQUE NOT NULL, "
                + "password TEXT NOT NULL, "
                + "permission TEXT NOT NULL, "
                + "loginAttempt INTEGER NOT NULL DEFAULT 0,"
                + "userLock INTEGER NOT NULL DEFAULT 0"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla creada o ya existente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertUser(User user) {
        String sql = "INSERT INTO users(name, userName, password, permission) VALUES(?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getUserName());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getPermission().toString());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
        }
    }
    
    public List<User> getAllUsers() {
    	List<User> userList = new ArrayList<>();
    	
        String sql = "SELECT * FROM users";        

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String name = rs.getString("name");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String permStr = rs.getString("permission");
                int loginAttempt = rs.getInt("loginAttempt");
                boolean lock = rs.getInt("userLock") == 1;

                User user = new User();
                user.setName(name);
                user.setUserName(userName);
                user.setPassword(password);
                user.setPermission(Permission.fromName(permStr));
                user.setUserLock(lock);
                user.loginAttempt = loginAttempt;
                userList.add(user);
            } 
            
        } catch (SQLException e) {
            System.out.println("Error al obtener usuarios: " + e.getMessage());
        }
        
        return userList;
    }
    
    public void updateUser(User user) {
        String sql = "UPDATE users SET name = ?, password = ?, permission = ?, loginAttempt = ?, userLock = ? WHERE userName = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getPermission().toString());
            pstmt.setInt(4, user.loginAttempt);
            pstmt.setInt(5, user.isUserLock() ? 1 : 0);
            pstmt.setString(6, user.getUserName());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }
}
