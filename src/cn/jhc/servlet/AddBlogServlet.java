package cn.jhc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import cn.jhc.Global;
import cn.jhc.bean.Article;
import cn.jhc.bean.User;
import cn.jhc.db.ArticleDao;

/**
 * Servlet implementation class AddBlogServlet
 */
@WebServlet("/add.do")
public class AddBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		QueryRunner runner = 
				(QueryRunner) request.getServletContext().getAttribute(Global.KEY_RUNNER);
		User user = (User) request.getSession().getAttribute("currentUser");
		Article article = new Article();
		article.setTitle(title);
		article.setContent(content);
		article.setPublishDate(new Date());
		article.setCreator(user.getId());
		
		try {
			ArticleDao.save(runner, article);
		} catch (SQLException e) {
			e.printStackTrace();
			//TODO: 跳转到错误页面。
		}
		response.sendRedirect("./list.do");
		
	}

}
