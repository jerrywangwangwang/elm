package com.neuedu.elm_servlet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 
 * 鏁版嵁搴撶浉鍏冲伐鍏风被
 */
public class DBUtil {
	
    public static final ThreadLocal<Connection> TL = new ThreadLocal<>();
	
	public static Connection getConnection(){
		//杩欐牱淇濊瘉姣忎釜绾跨▼con瀵硅薄鏄敮涓�鐨�
		Connection con = TL.get();
		try {
			if(con == null){
				con = createConnection();
				TL.set(con);
				System.out.println("2"+con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  con;
	}
	
	
	/**
	 * 鍒涘缓閾炬帴
	 * @throws Exception 
	 */
	private static Connection createConnection() throws Exception{
		Connection con = null;
		if(con == null){
			Class.forName(Constant.DRIVER);
			con = DriverManager.getConnection(Constant.URL, Constant.USERNAME, Constant.PASSWORD);
		}
		
		return con;
		
	}
	 
	public static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
				TL.remove();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement ps) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 寮�鍚簨鍔�
	 */
	public static void beginTransaction(){
		Connection con = TL.get();
		try {
			if(con == null){
				con = createConnection();
				TL.set(con);
				System.out.println("3"+con);
			}
			System.out.println("4"+con);
			con.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 鎻愪氦浜嬪姟
	 */
	public static void commitTransaction(){
		Connection con = TL.get();
		try {
			if(con == null){
				con = createConnection();
				TL.set(con);
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 鍥炴粴浜嬪姟
	 */
	public static void rollbackTransaction(){
		Connection con = TL.get();
		try {
			if(con == null){
				con = createConnection();
				TL.set(con);
			}
			con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
