package cn.jhc.db;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.jhc.bean.User;

public class UserDao {
	public static User login(QueryRunner runner, String username, String password) throws SQLException {
		final String sql = "select id,username,password,filename,sex,interests from user where username = ? and password = ?";
		return runner.query(sql, new BeanHandler<>(User.class), username, password);
	}
	
	public static void register(QueryRunner runner, User user) throws SQLException {
		final String sql = "insert into user(username, password, filename, sex, interests) "
				+ "values(?, ?, ?, ?, ?)";
		runner.execute(sql, user.getUsername(), user.getPassword(), user.getFilename(), user.getSex(), user.getInterests());
	}
	
	public static boolean exists(QueryRunner runner, String username) throws SQLException {
		final String sql = "select count(id) from user where username = ?";
		Long result = runner.query(sql, new ScalarHandler<>(), username);
		return result.longValue() == 1L;
	}

}
