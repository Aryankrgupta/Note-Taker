package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Service {
	Connection conn = GetConnection.conn;
	public void register(Register r) {
		String qry = "insert into user_info (user_name, password) values(?, ?)";
		try {
			PreparedStatement stat = conn.prepareStatement(qry);
			stat.setString(1, r.getUserName());
			stat.setString(2, r.getPassword());
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Register getUser(String user) {
		String qry = "Select * from user_info where user_name = ?";
		try {
			PreparedStatement stat = conn.prepareStatement(qry);
			stat.setString(1, user);
			stat.executeQuery();
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				Register r = new Register(rs.getString(2), rs.getString(3), rs.getInt(1));
				return r;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int addnote(Notes n) {
		String qry = "insert into note_info (title, note, user_id) values(?, ?, ?)";
		try {
			PreparedStatement stat = conn.prepareStatement(qry);
			stat.setString(1, n.getTitle());
			stat.setString(2, n.getNote());
			stat.setString(3, n.getId());
			int no = stat.executeUpdate();
			return no;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	public List<Notes> getNotes(int userId) {
		List<Notes> noteList = new ArrayList<>();
		String qry = "select * from note_info where user_id = ?";
		try {
			PreparedStatement stat = conn.prepareStatement(qry);
			stat.setInt(1, userId);
			ResultSet rs =  stat.executeQuery();
			while(rs.next()) {
				Notes n = new Notes(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(5), rs.getString(4));
				noteList.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return noteList;
	}
	public boolean login(String user, String password) {
		String qry = "select * from user_info where user_name = ? and password = ?";
		try {
			PreparedStatement stat = conn.prepareStatement(qry);
			stat.setString(1, user);
			stat.setString(2, password);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public void delete(int id) {
		String qry = "delete from note_info where note_id = ?";
		try {
			PreparedStatement stat = conn.prepareStatement(qry);
			stat.setInt(1, id);
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Register getUser(int id) {
		String qry = "Select * from user_info where user_id = ?";
		try {
			PreparedStatement stat = conn.prepareStatement(qry);
			stat.setInt(1, id);
			stat.executeQuery();
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				Register r = new Register(rs.getString(2), rs.getString(3), rs.getInt(1));
				return r;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Notes getNoteById(int id) {
		String qry = "select * from note_info where note_id = ?";
		try {
			PreparedStatement stat = conn.prepareStatement(qry);
			stat.setInt(1, id);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				Notes n = new Notes(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(5), rs.getString(4));
				return n;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public int update(Notes n) {
		String qry = "update note_info set title = ? , note = ? where note_id = ?";
		try {
			PreparedStatement stat = conn.prepareStatement(qry);
			stat.setString(1, n.getTitle());
			stat.setString(2, n.getNote());
			stat.setString(3, n.getId());
			int no = stat.executeUpdate();
			return no;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	

}
