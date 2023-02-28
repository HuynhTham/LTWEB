package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class LanguageFilter extends HttpFilter implements Filter {
       
 
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String lang = request.getParameter("lang");
		if(lang!=null) {
				req.getSession().setAttribute("LANG", lang);
		}
		chain.doFilter(request, response);
		
	}

	

}
