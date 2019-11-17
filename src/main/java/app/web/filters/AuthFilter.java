package app.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/view/home.jsf","/view/add-job.jsf", "/view/details.jsf","/view/delete.jsf"})
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String isLogged = (String) ((HttpServletRequest) servletRequest).getSession().getAttribute("username");

        if (isLogged == null){
            ((HttpServletResponse) servletResponse).sendRedirect("/view/login.jsf");
            return;
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
