/*package com.learning.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.learning.model.User;

public class UserRowMapper implements RowMapper<User>{


	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	       User user = new User();
	       user.setUserId(rs.getInt("userId"));
	       user.setUserName(rs.getString("userName"));
	       user.setUserEmail(rs.getString("userEmail"));
	       user.setAddress(rs.getString("address"));
	       return user;
	}

}*/