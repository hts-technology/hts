package com.hts.sql;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hts.entity.CalculationResult;
import com.hts.entity.Fraction;


public class QuestionSqlOperation {
	private static String driverName = "com.mysql.jdbc.Driver";// jdbc4.0以后不需要
	private static String url = "jdbc:mysql://115.28.11.59:3306/questionBand";
	private static String userName = "root";
	private static String password = "1107604329";
	public static void registerDriver() {
		try {
			Class.forName(driverName);// jdbc4.0以前需要这句进行驱动注册
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("找不到驱动");
		}
	}
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		registerDriver();
		System.out.println("正在连接数据库...");
		conn = DriverManager.getConnection(url, userName, password);
		System.out.println("数据库已连接!");
		return conn;

	}
	public static void closeConnection(Connection conn) {
		System.out.println("正在释放所有资源...");
		
			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
	}
	
	/*
	 * 释放所有资源
	 */
	public static void realeaseAll(ResultSet rs,Statement st,Connection conn){
		if(rs!=null){
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (st!=null){
			try {
				st.close();
				st = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		closeConnection(conn);
	}
	public static void writerToDB(){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs=null;
		try {
			conn = QuestionSqlOperation.getConnection();
			stat = conn.createStatement();
			Scanner sc=new Scanner(new File("E://questionBandcopy.txt"));
			while(sc.hasNextLine()){
				String temp[]=sc.nextLine().split("=");
				 String sql="INSERT INTO QB values('"+temp[0]+"=','"+temp[1]+"')";
				 stat.execute(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeConnection(conn);
		}
	}
	public static List<CalculationResult> getCalculationResultList(int count){
		List<CalculationResult> list=new ArrayList<>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs=null;
		String sql ="select * from QB order by RAND() limit  "+count;
		try {
			conn = QuestionSqlOperation.getConnection();
			stat = conn.createStatement();
			rs=stat.executeQuery(sql);		
			while(rs.next()){
				CalculationResult c=new CalculationResult();
				c.setFormula(rs.getString("question"));
				c.setResult(rs.getString("answer"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
		return list;
	}
public static void main(String[] args) throws SQLException {
	QuestionSqlOperation.writerToDB();
}
}
