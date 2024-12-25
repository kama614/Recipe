package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import dto.Admin;

public class AdminDaoImpl implements AdminDao {

	private DataSource ds;

	public AdminDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public Admin findByLoginIdAndPass(String loginId, String loginPass) throws Exception {
		Admin admin = null;
		try (var con = ds.getConnection()) {
			String sql = " SELECT * FROM admins "
					+ " WHERE login_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (BCrypt.checkpw(loginPass, rs.getString("login_pass"))) {
					admin = mapToAdmin(rs);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return admin;
	}

	private Admin mapToAdmin(ResultSet rs) throws Exception {
		
		return new Admin((Integer)rs.getObject("id"),rs.getString("login_id"),rs.getString("login_pass"),rs.getString("name"));
	}

}
