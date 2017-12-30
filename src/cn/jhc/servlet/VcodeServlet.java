package cn.jhc.servlet;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VcodeServlet
 */
@WebServlet("/vcode")
public class VcodeServlet extends HttpServlet {
	private static final int IMAGE_HEIGHT = 36;
	private static final int IMAGE_WIDTH = 120;
	private static final long serialVersionUID = 1L;
	private static final Random RANDOM = new Random();
	private static final String CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedImage bufferedImage = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = (Graphics2D) bufferedImage.getGraphics();
		graphics2d.setFont(new Font("Arial", Font.BOLD, 24));
		String code = rand();
		request.getSession().setAttribute("vcode", code);
		graphics2d.drawString(code, 20, 30);
		response.setContentType("image/png");
		ImageIO.write(bufferedImage, "PNG", response.getOutputStream());
	}
	
	private String rand() {
		String result = "";
		for(int i=0; i<4; i++) {
			int index = RANDOM.nextInt(CHARS.length());
			result += CHARS.substring(index, index + 1);
		}
		return result;
	}

}
