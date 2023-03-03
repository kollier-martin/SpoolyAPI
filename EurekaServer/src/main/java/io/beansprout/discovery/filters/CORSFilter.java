package io.beansprout.discovery.filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Global configuration for a CORSFilter
 *
 * @date
 * @author Kollier Martin
 */
@SuppressWarnings("NullableProblems")
@Component
public class CORSFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(
      HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
      throws ServletException, IOException {
    resp.setHeader("Access-Control-Allow-Origin", "*");
    resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, PATCH");
    resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Authentication");
    chain.doFilter(req, resp);
  }
}
