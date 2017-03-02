package com.hts.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hts.entity.CalculationResult;

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
		request.setCharacterEncoding("utf-8");
		String []answer=request.getParameterValues("answer");
		List<CalculationResult>list=(List<CalculationResult>) request.getSession().getAttribute("resultList");
		int count =0;
		for(int i=0;i<answer.length;i++){
			if(list.get(i).getResult().equals(answer[i].trim())){
				list.get(i).setFlag(answer[i]+"正确");
				count++;
			}
			else{
				list.get(i).setFlag(answer[i]+"错误   正确答案为："+list.get(i).getResult());
			}
		}
		for(int i=0;i<list.size();i++){
			list.get(i).setCorrect(count*1.0/list.size()*100+"%");
		}
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
