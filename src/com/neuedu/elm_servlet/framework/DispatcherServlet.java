package com.neuedu.elm_servlet.framework;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * 前端控制器
 *
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet{

	private static final long serialVersionUID = 11225819846010890L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//
			String servletPath = request.getServletPath();
			
			//分发的实现
			String[] path = servletPath.split("/");
			
			//控制器名
			String controllerName = path[1];
			String methodName = path[2];
			
			//反射
			try {
				//通过反射加载类信息
				Class<?> clazz = Class.forName("com.neuedu.elm_servlet.controller."+controllerName);
				//获取一个类对象
				Object newInstance = clazz.newInstance();
				//获取对应方法对象
				Method method = clazz.getMethod(methodName, new Class[]{HttpServletRequest.class});
				//执行该方法
				Object invoke = method.invoke(newInstance, new Object[]{request});
				
				ObjectMapper om = new ObjectMapper();
				
				PrintWriter writer = response.getWriter();
				
				writer.print(om.writeValueAsString(invoke));
			} catch (Exception e) {
				System.out.println("DispatcherServlet:"+controllerName);
				System.out.println("DispatcherServlet:"+methodName);
				e.printStackTrace();
			} 
			
			
			
			
			
		
	
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
}
