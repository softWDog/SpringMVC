package com.dengguoxian.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dengguoxian.controller.Controller;
import com.dengguoxian.controller.InputProductController;
import com.dengguoxian.controller.SaveProductController;

/**
 * Servlet implementation class DispatcherServlet,负责分发请求
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
	private Controller controller;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		// 找出最后一个“/”后面的串，及请求的action
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		String dispathcerUrl=null;
		if(action.equals("product_input.action")){
			controller=context.getBean("InputProductController", InputProductController.class);
			dispathcerUrl=controller.handleRequest(request, response);
		}
		else if(action.equals("product_save.action")){
			controller=context.getBean("SaveProductController", SaveProductController.class);
			dispathcerUrl=controller.handleRequest(request, response);
		}
		if(dispathcerUrl!=null){
			RequestDispatcher rd=request.getRequestDispatcher(dispathcerUrl);
			rd.forward(request, response);
		}
	}

}
