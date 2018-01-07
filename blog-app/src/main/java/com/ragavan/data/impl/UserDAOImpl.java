package com.ragavan.data.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ragavan.data.UserDAO;
import com.ragavan.models.Role;
import com.ragavan.models.User;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int save(User user) {
		String sql = "insert into users(username,password,email_id,activation_code)values (?,?,?,?)";
		Object[] params = { user.getUserName(), user.getPassword(), user.getEmailId(), user.getActivationCode() };
		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int update(User user) {
		String sql = "update users set username=?,password=?,email_id=?,role_id=? where id=?";
		Object[] params = { user.getUserName(), user.getPassword(), user.getEmailId(), user.getRoleId().getId(),
				user.getId() };
		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int delete(int id) {
		String sql = "delete from users where id=?";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public List<User> list() {
		final String sql = "select users.id,username,password,email_id,role_name from users join role on role.id=users.role_id";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final User user = new User();
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmailId(rs.getString("email_id"));
			Role role = new Role();
			role.setRoleName(rs.getString("role_name"));
			user.setRoleId(role);
			return user;
		});
	}

	@Override
	public User listOne(String name) {
		final String sql = "select id,username,password,email_id,role_id from users where username=?";
		Object[] params = { name };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> fetchData(rs));
	}

	private User fetchData(ResultSet rs) throws SQLException {
		final User user = new User();
		user.setId(rs.getInt("id"));
		user.setUserName(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setEmailId(rs.getString("email_id"));
		Role role = new Role();
		role.setId(rs.getInt("role_id"));
		user.setRoleId(role);
		return user;
	}

}
