package com.snowfish.cn;

import java.io.IOException;
import java.nio.file.WatchKey;
import java.nio.file.Watchable;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class AFilter
 */
@WebFilter("/*")
public class AFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    System.out.println(" a 拦截你！！");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init");
	}

}
