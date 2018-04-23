package com.java00123.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class CharSetFilter
 */
public class CharSetFilter implements Filter {
	private String charSet;
    /**
     * Default constructor. 
     */
    public CharSetFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("CharSetFilter¹ýÂËÆ÷doFilter");
		request.setCharacterEncoding(this.charSet);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("CharSetFilter¹ýÂËÆ÷init");
		this.charSet = fConfig.getInitParameter("charSet");
	}

}
