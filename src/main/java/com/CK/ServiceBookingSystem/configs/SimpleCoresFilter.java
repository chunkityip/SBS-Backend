package com.CK.ServiceBookingSystem.configs;

import jakarta.servlet.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCoresFilter implements Filter {

    @Value("${app.client.url}")
    private String clientAppUrl = " ";

    public SimpleCoresFilter() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        // Check if res is an instance of HttpServletResponse
        if (res instanceof HttpServletResponse) {
            HttpServletResponse response = (HttpServletResponse) res;
            HttpServletRequest request = (HttpServletRequest) req;

            // Get the Origin header value from the request
            String originHeader = request.getHeader("Origin");

            // Allow requests from the actual Origin value
            response.setHeader("Access-Control-Allow-Origin", originHeader);
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "*");

            if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
                // Preflight request (OPTIONS): Set status OK and return
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                // Regular request: Forward the request to the next filter
                chain.doFilter(req, res);
            }
        } else {
            // If res is not an instance of HttpServletResponse, pass it to the next filter
            chain.doFilter(req, res);
        }
    }





    @Override
    public void destroy() {

    }

}

