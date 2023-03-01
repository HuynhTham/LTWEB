package controller;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Log.Log;
import database.DAOAccounts;
import database.JDBiConnector;
import model.Account;
import model.Encode;

/**
 * Servlet implementation class Register
 */
@WebServlet("/anime-main/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		String phoneNumber = request.getParameter("phoneNumber");
		String password = request.getParameter("password");
		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		boolean verify = model.VerifyRecaptcha.verify(gRecaptchaResponse);
		String validateCode = (String) session.getAttribute("validateCode");
		Date dateSendmail = (Date) session.getAttribute("dateSendmail");
		String emailCode =request.getParameter("emailCode");
		String ipClient = request.getRemoteAddr();
		Log log = new Log(Log.INFO, -1, ipClient, "RegisterServlet", null, 0);
		Account account;
		DAOAccounts daoAccounts = new DAOAccounts();
		String errorMess = "";
		String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
		Pattern pattern;
		Matcher matcher;
		boolean isValidPassword;
		Date now;
		boolean isExpire;
		long timeDiff;
		String direct;
		JDBiConnector jdbiConnector= new JDBiConnector();
		try {
			if (verify) {
				if (userName.equals("") || userName.length() < 8) {
					errorMess = "Tên tài khoản không được để trống hoặc ít hơn 8 ký tự";
					log.setLevel(Log.ALERT);
					log.setContent("Tên tài khoản không hợp lệ");
					direct="/signup.jsp";
					
					
				}
				if (password.equals("") || password.length() < 8 || password.length() > 25) {
					errorMess = "Mật khẩu phải từ 8 đến 25 ký tự";
					log.setLevel(Log.ALERT);
					log.setContent("Mật khẩu không hợp lệ");
					direct="/signup.jsp";
					
					
				}
				pattern = Pattern.compile(passwordPattern);
				matcher = pattern.matcher(password);
				isValidPassword=matcher.matches();
				if(!isValidPassword) {
					errorMess = "Mật khẩu phải bao gồm chữ hoa, chữ thường, ký tự đặc biệt, chữ số";
					log.setLevel(Log.ALERT);
					log.setContent("Tên tài khoản không hợp lệ");
					direct="/signup.jsp";
						
					
				}else {
					now = new Date();
					timeDiff =(now.getTime() - dateSendmail.getTime()) / (60 * 1000);
					isExpire = timeDiff<5;
					if(!isExpire) {
						errorMess = "Mã xác thực đã hết hạn";
						log.setLevel(Log.ALERT);
						log.setContent("Mã xác thực hết hạn");
						direct="/signup.jsp";
						
						
					}else {
						if(!emailCode.equalsIgnoreCase(validateCode)) {
							errorMess = "Mã xác thực không hợp lệ";
							log.setLevel(Log.WARNING);
							log.setContent("Mã xác thực không hợp lệ");
							direct="/signup.jsp";
							
						}else {
							account = daoAccounts.findUserByUserNameandEmail(userName, email);
							if (account != null) {
								if (account.getEmail().equalsIgnoreCase(email)) {
									errorMess = "Email đã được đăng kí cho tài khoản khác";
									log.setLevel(Log.ALERT);
									log.setContent("Email đã tồn tại");
									direct="/signup.jsp";
								
									
								} else {
									errorMess = "Tên tài khoản đã tồn tại";
									log.setLevel(Log.ALERT);
									log.setContent("Tài khoản đã tồn tại");
									direct="/signup.jsp";
								
									
								}
							} else {
								daoAccounts.addBaseUser(userName, password, email,fullName,phoneNumber);
								//dang ky thanh cong
								log.setLevel(Log.INFO);
								log.setContent("Đăng kí thành công");
								direct="/Index";
							
								
								
							}
						}
					}
				}
			
			} else {
				errorMess = "Vui lòng xác nhận captcha";
				direct="/signup.jsp";
			
			}
			request.setAttribute("errorSignup", errorMess);
			jdbiConnector.insert(log);
			request.getRequestDispatcher("/anime-main"+direct).forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
