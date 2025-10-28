package com.example.datn.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        String redirectURL = "/home"; // mặc định nếu không có role

        for (GrantedAuthority authority : authorities) {
            String role = authority.getAuthority();
            if (role.equals("ADMIN")) {
                redirectURL = "/admin";
                break;
            } else if (role.equals("USER")) {
                redirectURL = "/home";
                break;
            }
        }

        response.sendRedirect(redirectURL);
    }
}
