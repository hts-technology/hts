package com.hts.servlet;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hts.test.Test;

/**
 * Servlet implementation class LanguageServlet
 */
@WebServlet("/LanguageServlet")
public class LanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LanguageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String page=request.getParameter("page");
		if(page.equals("firstPage")){
			getFirstPagePara( request, response);
		}
		if(page.equals("secondPage")){
			getSecondPagePara( request, response);
		}
		if(page.equals("thirdPage")){
			getThirdPagePara( request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void getFirstPagePara(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String lanaguage=(String) request.getSession().getAttribute("lanaguage");
		if(lanaguage==null){lanaguage="simpleChinese";}
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		Properties prop = new Properties(); 
		if(lanaguage.trim().equals("simpleChinese")){
			InputStream  inputStream= Test.class.getClassLoader().getResourceAsStream("simpleChinese.properties");
			prop.load(inputStream);     ///加载属性列表
		}		
		else if(lanaguage.trim().equals("traditionalChinese")){
			InputStream  inputStream= Test.class.getClassLoader().getResourceAsStream("traditionalChinese.properties");
			prop.load(inputStream);     ///加载属性列表
		}		
		else{
			InputStream  inputStream= Test.class.getClassLoader().getResourceAsStream("English.properties");
			prop.load(inputStream);     ///加载属性列表			
		}
		String firstPage1=prop.getProperty("firstPage1");
		String firstPage2=prop.getProperty("firstPage2");
		Map<String,String>map=new HashMap<>();
		map.put("firstPage1", firstPage1);
		map.put("firstPage2", firstPage2);
		String json=JSON.toJSONString(map);
		pw.print(json);
	}
	
	public void getSecondPagePara(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String lanaguage=(String) request.getSession().getAttribute("lanaguage");
		if(lanaguage==null){lanaguage="simpleChinese";}
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		Properties prop = new Properties(); 
		if(lanaguage.trim().equals("simpleChinese")){
			InputStream  inputStream= Test.class.getClassLoader().getResourceAsStream("simpleChinese.properties");
			prop.load(inputStream);     ///加载属性列表			
		}
		
		else if(lanaguage.trim().equals("traditionalChinese")){
			InputStream  inputStream= Test.class.getClassLoader().getResourceAsStream("traditionalChinese.properties");
			prop.load(inputStream);     ///加载属性列表
		}
		
		else{
			InputStream  inputStream= Test.class.getClassLoader().getResourceAsStream("English.properties");
			prop.load(inputStream);     ///加载属性列表
		}
		String secondPage1=prop.getProperty("secondPage1");
		String secondPage2=prop.getProperty("secondPage2");
		String secondPage3=prop.getProperty("secondPage3");
		String secondPage4=prop.getProperty("secondPage4");
		String secondPage5=prop.getProperty("secondPage5");
		String secondPage6=prop.getProperty("secondPage6");
		Map<String,String>map=new HashMap<>();
		map.put("secondPage1", secondPage1);
		map.put("secondPage2", secondPage2);
		map.put("secondPage3", secondPage3);
		map.put("secondPage4", secondPage4);
		map.put("secondPage5", secondPage5);
		map.put("secondPage6", secondPage6);
		String json=JSON.toJSONString(map);
		pw.print(json);
	}
	public void getThirdPagePara(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String lanaguage=(String) request.getSession().getAttribute("lanaguage");
		if(lanaguage==null){lanaguage="simpleChinese";}
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		Properties prop = new Properties(); 
		if(lanaguage.trim().equals("simpleChinese")){
			InputStream  inputStream= Test.class.getClassLoader().getResourceAsStream("simpleChinese.properties");
			prop.load(inputStream);     ///加载属性列表			
		}
		
		else if(lanaguage.trim().equals("traditionalChinese")){
			InputStream  inputStream= Test.class.getClassLoader().getResourceAsStream("traditionalChinese.properties");
			prop.load(inputStream);     ///加载属性列表
		}
		
		else{
			InputStream  inputStream= Test.class.getClassLoader().getResourceAsStream("English.properties");
			prop.load(inputStream);     ///加载属性列表
		}
		String thirdPage1=prop.getProperty("thirdPage1");
		String thirdPage2=prop.getProperty("thirdPage2");
		Map<String,String>map=new HashMap<>();
		map.put("thirdPage1", thirdPage1);
		map.put("thirdPage2", thirdPage2);
		String json=JSON.toJSONString(map);
		pw.print(json);
	}
}
