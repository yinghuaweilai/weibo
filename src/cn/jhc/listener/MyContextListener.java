package cn.jhc.listener;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.dbutils.QueryRunner;
import org.h2.jdbcx.JdbcDataSource;

import cn.jhc.Global;
import cn.jhc.bean.Article;
import cn.jhc.bean.User;
import cn.jhc.db.ArticleDao;
import cn.jhc.db.UserDao;

@WebListener
public class MyContextListener implements ServletContextListener, Global {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String path = sce.getServletContext().getRealPath("/WEB-INF/myblogsa");
//		System.out.println(path);
		JdbcDataSource ds = new JdbcDataSource();
		ds.setURL("jdbc:h2:" + path);
		QueryRunner runner = new QueryRunner(ds);
		sce.getServletContext().setAttribute(KEY_RUNNER, runner);
		
		String sql = "create table if not exists user("
				+ "id int auto_increment primary key,"
				+ "username varchar(128) unique not null,"
				+ "password varchar(128) not null,"
				+ "filename varchar(128) not null,"
				+ "sex char(1) not null,"
				+ "interests varchar(128))";	
		String sql2 = "create table if not exists article("
				+ "id int auto_increment primary key,"
				+ "title varchar(128) not null,"
				+ "content text,"
				+ "creator int references user(id),"
				+ "publishDate datetime)";
		try {
			runner.execute(sql);
			runner.execute(sql2);
			insertData(runner);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void insertData(QueryRunner runner) throws SQLException {
		for(int i=0 ; i<40; i++) {
			User user = new User("user" + i, "pass" + i, "filename" + i, "M", "interests" + i);
			if(UserDao.exists(runner, "user" +i)) {
				break;
			}
			UserDao.register(runner, user);
			User creator = UserDao.login(runner, "user" + i, "pass" + i);
			for(int j=0; j<50; j++) {
				Article article = new Article();
				article.setTitle(creator.getUsername() + "╣дндуб" + j);
				article.setContent("content " + j);
				article.setPublishDate(new Date());
				article.setCreator(creator.getId());
				ArticleDao.save(runner, article);
			}
		}
	}

}
