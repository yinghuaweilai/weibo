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

import cn.jhc.Global;
import cn.jhc.db.ArticleDao;

/**
 * Servlet implementation class DelServlet
 */
@WebServlet("/del.do")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id = Integer.valueOf(sid).intValue();
		String ajax = request.getParameter("ajax");
		
		QueryRunner runner = (QueryRunner) request.getServletContext().getAttribute(Global.KEY_RUNNER);
		
		try {
			ArticleDao.delete(runner, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ajax != null && ajax.equals("true")) {
			response.setContentType("application/json");
			response.getWriter().println("{\"ok\": 1}");
		} else {
			response.sendRedirect("./list.do");
		}
	}



}