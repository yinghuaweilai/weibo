package cn.jhc.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.dbutils.QueryRunner;

import cn.jhc.bean.User;
import cn.jhc.db.UserDao;

@WebServlet("/uploadMulti.do")
@MultipartConfig(maxRequestSize=10*1024*1024)
public class MultiPartRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String vcode = getContent(req.getPart("vcode"));
		String expected = (String) req.getSession().getAttribute("vcode");
		if(!vcode.equals(expected)) {
			resp.sendRedirect("./register.jsp");
			return;
		}
		
		String uploadsPath = req.getServletContext().getRealPath("/uploads");
		File uploadsDir = new File(uploadsPath);
		if(!uploadsDir.exists()) {
			uploadsDir.mkdir();
		}
		
		Part filePart = req.getPart("file");
		String fileName = filePart.getSubmittedFileName();
		String extName = fileName.substring(fileName.lastIndexOf("."));
		String savedName = System.currentTimeMillis() + extName;		
		filePart.write(uploadsPath + File.separator + savedName);
		
		Part usernamePart = req.getPart("username");
		String username = getContent(usernamePart);
		
		Part pwdPart = req.getPart("pwd");
		String password = getContent(pwdPart);
		
		String sex = getContent(req.getPart("sex"));
		
		String interests = "";
		for(Part part : req.getParts()) {
			if(part.getName().equals("interests")) {
				interests += getContent(part) + ",";
			}
		}
		
		QueryRunner runner = (QueryRunner) req.getServletContext().getAttribute("runner");
		User user = new User(username, password, savedName, sex, interests);
		try {
			UserDao.register(runner, user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.sendError(500);
		}
 		resp.sendRedirect("./uploads/" + savedName);
	}
	
	private String getContent(Part part) throws IOException {
		String result = "";
		try(Scanner scanner = new Scanner(part.getInputStream())) {
			result = scanner.next();
		}	
		return result;
	}
}
