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

        String redirectURL = "/home"; // mặc định

        for (GrantedAuthority authority : authorities) {
            String role = authority.getAuthority();

            // So sánh với ROLE_ADMIN và ROLE_USER
            if (role.equals("ROLE_ADMIN")) {  // ✅ Thêm ROLE_
                redirectURL = "/admin";
                break;
            } else if (role.equals("ROLE_USER")) {  // ✅ Thêm ROLE_
                redirectURL = "/";
                break;
            }
        }

        response.sendRedirect(redirectURL);
    }
}
