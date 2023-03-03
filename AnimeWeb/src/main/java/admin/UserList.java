package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DAOAccounts;
import model.Account;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/admin/UserList")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UserList() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String offsetAttribue = (String) request.getParameter("offset");
		
		DAOAccounts daoAccount = new DAOAccounts();
		int countNormalAccount =daoAccount.getSizeListAccountNormal()/7;
		int limitList = countNormalAccount%7==0?countNormalAccount:countNormalAccount+1;
		
		
		int offset = offsetAttribue==null?1:Integer.valueOf(offsetAttribue);
		
		if(offset<1) offset=1;
		if(offset>limitList)offset =limitList;
		System.out.println((offset-1)*7);
		List<Account> listAccount = daoAccount.getListAccountNormal((offset-1)*7, 7);
		request.setAttribute("offset", offset);
		request.setAttribute("listAccount", listAccount);
		request.setAttribute("limitList", limitList);
		request.getRequestDispatcher("/admin/User-List.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
