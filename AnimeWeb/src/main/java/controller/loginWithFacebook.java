package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import database.DAOAccounts;
import model.Account;

/**
 * Servlet implementation class loginWithFacebook
 */
@WebServlet("/anime-main/loginWithFacebook")
public class loginWithFacebook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		String name = null, email = null, id = null;
		if (action.equals("Face")) {
			name = request.getParameter("name");
			email = request.getParameter("email");
			id = request.getParameter("id");
		}
		Account account = null;

		DAOAccounts dao = new DAOAccounts();
		try {
			account = dao.checkAcountFacebook(email, id);
			System.out.println(account);
			if (account != null) {
				session.setAttribute("user", account);
				session.setAttribute("isAdmin", account.isAdmin());
				request.getRequestDispatcher("/anime-main/index.jsp").forward(request, response);
			} else {
				dao.insertAcountFB(name, id, email);
				account = dao.checkAcountFacebook(email, id);

				session.setAttribute("user", account);
				session.setAttribute("isAdmin", account.isAdmin());
				request.getRequestDispatcher("/anime-main/index.jsp").forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
