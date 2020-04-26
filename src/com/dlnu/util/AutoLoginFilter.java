package com.dlnu.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dlnu.pojo.User;
import com.dlnu.service.UserService;


@WebFilter("/*")
public class AutoLoginFilter implements Filter {
	 //private UserDao userDao = null;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        //从session中获取用户信息
        String username = (String)session.getAttribute("username");
        Cookie cookie = null;
        //如果从session中获取用户信息为空，才需要获取cookie进行登录以及存放到session中，否则放行。
        if(username == null){
            Cookie[] cookies = request.getCookies();
            if(cookies != null && cookies.length > 0){
                for (Cookie c : cookies) {
                    if(c.getName().equals("AUTO_LOGIN")){
                        cookie = c;
                        break;
                    }
                }
            }
        }
        //cookie不为空，说明存在自动登录的cookie
        if(cookie != null){
            //读取cookie的值存放到session中
            String[] userInfo = cookie.getValue().split("-");
            User u = new User();
            u.setUserName(userInfo[0]);
            u.setPassword(userInfo[1]);
            //调用service登录
            UserService service = new UserService();
            int userBack = service.checkLogin(u.getUserName(),u.getPassword());
            //登陆成功
            if(userBack == 4){
                session.setAttribute("username",u.getUserName());
            }
        }
        //如果不存在，直接放行
        chain.doFilter(request, resp);
    }

  

}
