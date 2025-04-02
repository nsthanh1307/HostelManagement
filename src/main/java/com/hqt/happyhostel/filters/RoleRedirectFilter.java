package com.hqt.happyhostel.filters;

import com.hqt.happyhostel.dao.AccountDAO;
import com.hqt.happyhostel.dto.Account;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RoleRedirectFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Cookie[] c = httpRequest.getCookies();
        String token = null;
        String url = null;
        //Bắt resource lúc mới vào web, nếu có cookie rồi thì vào thẳng trang của role đó
        String uri = httpRequest.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String resource = uri.substring(lastIndex+1);

        HttpSession session = httpRequest.getSession(false);

        Account acc = null;
        if ((c != null || session.getAttribute("USER") != null) && ("".equals(resource) || "success".equals(resource) || "login".equals(resource) || "loginPage".equals(resource))) {
            for (Cookie cookie : c) {
                if (cookie.getName().equals("selector")) {
                    token = cookie.getValue();
                }
            }

            acc = (token != null) ? new AccountDAO().getAccountByToken(token) : (Account) session.getAttribute("USER");
            if(acc != null) {
                int role = acc.getRole();
                if (role == 0) url = "dashboard";
                if (role == 1) url = "dashboard";
                if (role == 2) url = "dashboard";
                httpResponse.sendRedirect(url);
            }
            else chain.doFilter(request, response);
        }
        else
            chain.doFilter(request, response);
    }
}
