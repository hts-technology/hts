package com.hts.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hts.entity.CalculationResult;
import com.hts.entity.TimerReturn;
import com.hts.test.Test;

/**
 * Servlet implementation class DealWithResult
 */
@WebServlet("/DealWithResultServlet")
public class DealWithResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealWithResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lanaguage=(String) request.getSession().getAttribute("lanaguage");
		if(lanaguage==null){
			lanaguage="simpleChinese";
		}
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
		String message1=prop.getProperty("answer1");
		String message2=prop.getProperty("answer2");
		request.setCharacterEncoding("utf-8");
		String []answer=request.getParameterValues("answer");
	
		@SuppressWarnings("unchecked")
		List<CalculationResult> list=(List<CalculationResult>) request.getSession().getAttribute("resultList");			
		int count =0;
		for(int i=0;i<list.size();i++){
			if(list.get(i).getResult().equals(answer[i].trim())){
				list.get(i).setFlag(answer[i]+" "+message1);
				count++;
			}
			else{
				list.get(i).setFlag(answer[i]+" "+message2+list.get(i).getResult());
			}
		}	
		for(int i=0;i<list.size();i++){
			list.get(i).setCorrect(count*1.0/list.size()*100+"%");
		}

			@SuppressWarnings("unchecked")
			String time=(String)request.getParameter("time");		
			List<TimerReturn>timeList=(List<TimerReturn>) request.getSession().getAttribute("timeList");
			if(timeList==null){timeList=new ArrayList<>();}
			TimerReturn timeReturn=new TimerReturn(list.size()+"",time,list.size()-count+"",count*1.0/list.size()*100+"%");
			timeList.add(timeReturn);
			request.getSession().setAttribute("flag", "true");
			request.getSession().setAttribute("timeList", timeList);
		
		request.setAttribute("resultList2", list);
		request.getRequestDispatcher("showResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
