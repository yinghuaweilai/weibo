package cn.jhc.db;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.h2.util.New;

import cn.jhc.bean.Article;
/**
 * CRUD(Create, Retrieve, Update, Delete)
 * @author luyanfei
 *
 */
public class ArticleDao {
	public static void save(QueryRunner runner, Article article) throws SQLException {
		final String sql = "insert into article (title, content, creator, publishDate) "
				+ "values(?,?,?,?)";
		runner.execute(sql, article.getTitle(), article.getContent(), article.getCreator(), article.getPublishDate());
	}
	
	public static void delete(QueryRunner runner, int id) throws SQLException {
		final String sql = "delete from article where id=?";
		runner.execute(sql, id);
	}
	
	public static void update(QueryRunner runner, Article newArticle) {
		
	}
	
	public static List<Article> list(QueryRunner runner, int pageNum) throws SQLException {
		final String sql = "select id, title, content, creator, publishDate from article "
				+ "order by publishDate desc limit ? offset ?";
		return runner.query(sql,new BeanListHandler<>(Article.class), 30, pageNum * 30);
	}
	
	public static Article show(QueryRunner runner, int id) {
		return null;
	}
	
	public static long total(QueryRunner runner) throws SQLException {
		final String sql = "select count(id) from article";
		return runner.query(sql, new ScalarHandler<Long>());
	}
}
