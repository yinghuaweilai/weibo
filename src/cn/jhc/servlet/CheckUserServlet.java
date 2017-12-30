package cn.jhc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;

import cn.jhc.db.UserDao;

/**
 * Servlet implementation class CheckUserServlet
 */
@WebServlet("/check.do")
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		QueryRunner runner = (QueryRunner) request.getServletContext().getAttribute("runner");
		boolean isExists = false;
		try {
			isExists = UserDao.exists(runner, username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isExists) {
			out.println("{\"ok\": 0}");
		} else {
			out.println("{\"ok\": 1}");
		}
	}

}
