package com.hts.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		String time=(String)request.getParameter("time");		
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

			List<TimerReturn>timeList=(List<TimerReturn>) request.getSession().getAttribute("timeList");
			Cookie [] c=request.getCookies();
			if(timeList==null){
				timeList=new ArrayList<>();				
				for(int i=0;i<c.length;i++){
					if(c[i].getName().equals("timeList")){
						String message=c[i].getValue();
						System.out.println(message);
						String [] totalTimeList=message.split("M");
						for(int j=0;j<totalTimeList.length;j++){
							String [] perTimeList=totalTimeList[j].split(",");
							TimerReturn timeReturn=new TimerReturn(perTimeList[0]+"",perTimeList[1],perTimeList[2],perTimeList[3]);
							timeList.add(timeReturn);
						}
					}
				}
			}
			String perTimeList=list.size()+","+time+","+(list.size()-count)+","+count*1.0/list.size()*100+"%";
			boolean flag=true;
			for(int i=0;i<c.length;i++){
				if(c[i].getName().equals("timeList")){
					String totalTimeList=c[i].getValue()+"M"+perTimeList;
					Cookie c1=new Cookie("timeList", totalTimeList);
					c1.setMaxAge(3600*24*30*12);
					response.addCookie(c1);
					flag=false;
				}
			}
			if(flag==true){
				Cookie c1=new Cookie("timeList", perTimeList);
				c1.setMaxAge(3600*24*30*12);
				response.addCookie(c1);
			}
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
