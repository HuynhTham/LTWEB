package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class Auth extends HttpFilter implements Filter {
       
  
    public Auth() {
        super();
        }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest httpRequest = (HttpServletRequest) request;
		 HttpServletResponse httpRespone = (HttpServletResponse) response;
		 String url = httpRequest.getRequestURL().toString();
		 boolean check = url.endsWith(".jsp") && (url.endsWith("login.jsp") || url.endsWith("signup.jsp"));
		    if(check && httpRequest.getSession().getAttribute("user")!=null) {
		     	httpRespone.sendRedirect(httpRequest.getContextPath()+"/anime-main/Index");
		    	return;
		    }
		chain.doFilter(request, response);
	}

		public void init(FilterConfig fConfig) throws ServletException {
		}

}
