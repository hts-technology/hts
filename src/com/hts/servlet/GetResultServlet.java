package com.hts.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hts.entity.CalculationResult;
import com.hts.entity.TimerReturn;
import com.hts.test.Test;



/**
 * Servlet implementation class GetResultServlet
 */
@WebServlet("/GetResultServlet")
public class GetResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
				int count =Integer.parseInt(request.getParameter("count"));
				List<CalculationResult>list=Test.getCalculationResultList(count);		
				request.getSession().setAttribute("resultList", list);
				response.sendRedirect("show2.jsp");
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
	
	public static void getQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {		
		
			
	}

}
