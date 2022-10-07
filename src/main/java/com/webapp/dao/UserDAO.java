package com.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.webapp.connector.ConnectionManager;
import com.webapp.model.User;
import com.webapp.repository.UserRepository;

public class UserDAO implements UserRepository {

	private Connection con;
	private User user;
	
	public int insert(User u) {
		try {
			ConnectionManager.getInstance();
			con = ConnectionManager.getConnection();
			java.sql.Date date = new java.sql.Date(u.getBirthUser().getTimeInMillis());
			PreparedStatement stmt = con.prepareStatement("INSERT INTO tbl_user (nickname_user, password_user, birth_user) VALUES (?, ?, ?)");
			stmt.setString(1, u.getNicknameUser());
			stmt.setString(2,u.getPassword());
			stmt.setDate(3, date);
			return stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int update(User u) {
		try {
			ConnectionManager.getInstance();
			con = ConnectionManager.getConnection();
			java.sql.Date date = new java.sql.Date(u.getBirthUser().getTimeInMillis());
			PreparedStatement stmt = con.prepareStatement("UPDATE tbl_user SET "
					+ "nickname_user = ?, "
					+ "password_user = ?, "
					+ "birth_user = ? "
					+ "WHERE id_user = ?");
			stmt.setString(1, u.getNicknameUser());
			stmt.setString(2, u.getPassword());
			stmt.setDate(3, date);
			stmt.setLong(4, u.getIdUser());
			return stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int delete(User u) {
		try {
			ConnectionManager.getInstance();
			con = ConnectionManager.getConnection();
			PreparedStatement stmt = con.prepareStatement("DELETE FROM tbl_user WHERE id_user = ?");
			stmt.setLong(1, u.getIdUser());
			return stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<User> getAll() {
		List<User> lst = new ArrayList<>();		
		try {
			ConnectionManager.getInstance();
			con = ConnectionManager.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbl_user");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				User u = new User();
				java.sql.Date birth = rs.getDate("birth_user");
				Calendar date = Calendar.getInstance();
				date.setTimeInMillis(birth.getTime());
				u.setIdUser(rs.getLong("id_user"));
				u.setNicknameUser(rs.getString("nickname_user"));
				u.setBirthUser(date);
				lst.add(u);
			}
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	public User getById(int id) {
		try {
			ConnectionManager.getInstance();
			con = ConnectionManager.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbl_user WHERE id_user = ?");
			
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				java.sql.Date birth = rs.getDate("birth_user");
				Calendar date = Calendar.getInstance();
				date.setTimeInMillis(birth.getTime());
				long idUser = rs.getLong("id_user");
				String nicknameUser = rs.getString("nickname_user");
				String password = rs.getString("password_user");
				
				user = new User(idUser, nicknameUser, date, password);
			}
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User getByNick(String nickname) {
		try {
			ConnectionManager.getInstance();
			con = ConnectionManager.getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbl_user WHERE nickname_user LIKE ?");
			stmt.setString(1, nickname);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				java.sql.Date birth = rs.getDate("birth_user");
				Calendar birthUser = Calendar.getInstance();
				birthUser.setTimeInMillis(birth.getTime());
				long idUser = rs.getLong("id_user");
				String nicknameUser = rs.getString("nickname_user");
				String password = rs.getString("password_user");
				
				user = new User(idUser, nicknameUser, birthUser, password);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean existsNickname(String nickname) {
			User nick = getByNick(nickname);
			if(nick.getNicknameUser() != null) {
				return true;
			} else {
				return false;
			}
	}
	
}
