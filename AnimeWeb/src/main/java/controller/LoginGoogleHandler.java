package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import database.DAOAccounts;
import model.Account;
import model.Constants;
import model.UserGoogleDto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Form;

/**
 * @author heaty566
 */
@WebServlet(urlPatterns = { "/anime-main/login-google" })
public class LoginGoogleHandler extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String code = request.getParameter("code");
//		String accessToken = getToken(code);
//		UserGoogleDto user = getUserInfo(accessToken);
//		System.out.println(user);

	}

	public static String getToken(String code) throws ClientProtocolException, IOException {
		// call api to get token
		String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
				.bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
						.add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
						.add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
						.add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
				.execute().returnContent().asString();

		JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
		String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
		return accessToken;
	}

	public static UserGoogleDto getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
		String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
		String response = Request.Get(link).execute().returnContent().asString();

		UserGoogleDto googlePojo = new Gson().fromJson(response, UserGoogleDto.class);

		return googlePojo;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String code = request.getParameter("code");
		String accessToken = getToken(code);
		UserGoogleDto userGoogle = getUserInfo(accessToken);
		System.out.println(userGoogle);
		String idg = userGoogle.getId();
		String email = userGoogle.getEmail();
		String userName = userGoogle.getName();
		Account user = null;
		DAOAccounts daoAccounts = new DAOAccounts();
		try {
			System.out.println(idg);
			System.out.println(userGoogle);
			int idUserGoogle;
			idUserGoogle = daoAccounts.findIdUserGoogle(idg, email);
			System.out.println(idUserGoogle);

			if (idUserGoogle == -1) {
				daoAccounts.addGoogle(idg, email, userName);
				System.out.println("dont");
				int idUser = daoAccounts.findIdUserAccount(email, 2);
				user = daoAccounts.loginAccountByGoogle(idUser, 2);
				System.out.println(user);
				session.setAttribute("user", user);
				session.setAttribute("isAdmin", user.isAdmin());
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				user = daoAccounts.loginAccountByGoogle(idUserGoogle, 2);
				session.setAttribute("user", user);
				session.setAttribute("isAdmin", user.isAdmin());
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println("Loi sql");
			e.printStackTrace();

		}

		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";

	}
}