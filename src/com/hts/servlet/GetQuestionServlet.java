package com.hts.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.hts.entity.CalculationResult;
import com.hts.sql.QuestionSqlOperation;
import com.hts.util.Util;

/**
 * Servlet implementation class GetQuestionServlet
 */
@WebServlet("/GetQuestionServlet")
public class GetQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		try {
				int count =Integer.parseInt(request.getParameter("count"));
				List<CalculationResult>list=QuestionSqlOperation.getCalculationResultList(count);	
				List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
				for(int i=0;i<list.size();i++){
					Map<String,Object>map=new HashMap<>();
					map.put("formula", list.get(i).getFormula());
					map.put("result", list.get(i).getResult());
					map.put("flag", list.get(i).getFlag());
					map.put("correct", list.get(i).getCorrect());
					data.add(map);
				}
				JSONArray array=Util.toJsonArray(data);
				System.out.println(array.toString());
				pw.write(array.toString());
				pw.flush();
				pw.close();
				request.getSession().setAttribute("resultList", list);
				//request.getRequestDispatcher("show2.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				request.setAttribute("mess", "false");
				request.getSession().removeAttribute("resultList");
				request.getRequestDispatcher("show.jsp").forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
