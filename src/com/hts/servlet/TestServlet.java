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
import com.alibaba.fastjson.JSONObject;
import com.hts.entity.Fraction;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		  List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		  Map<String, Object>map=new HashMap<>();
		Fraction f=new Fraction(2,3);
		Fraction f1=new Fraction(4,5);
		map.put("molecular", f.getMolecular());
		map.put("denominator", f.getDenominator());
		data.add(map);
		 Map<String, Object>map1=new HashMap<>();
			map1.put("molecular", f1.getMolecular());
			map1.put("denominator", f1.getDenominator());
			data.add(map1);
			JSONArray array=toJsonArray(data);
			pw.write(array.toString());
			pw.flush();
			pw.close();
	}
	public static JSONArray toJsonArray( List<Map<String, Object>>data){
		JSONArray array =new JSONArray();
		for(Map<String,Object>rowItem:data){
			JSONObject json=new JSONObject();
			try{
				for(Map.Entry<String, Object>entry:rowItem.entrySet()){
					json.put(entry.getKey(), entry.getValue());
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			array.add(json);
		}
		
		return array;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
