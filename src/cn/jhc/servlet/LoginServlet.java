package cn.jhc.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import cn.jhc.bean.User;
import cn.jhc.db.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		QueryRunner runner = (QueryRunner) request.getServletContext().getAttribute("runner");
		User user = null;
		try {
			user = UserDao.login(runner, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(user != null) {
			request.getSession().setAttribute("currentUser", user);
			response.sendRedirect("./dashboard.jsp");
		} else {
			request.getSession().setAttribute("errMsg", "用户名或密码错误！");
			response.sendRedirect("./login.jsp");
		}
	}

}
