package com.global.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from customer where id = ? and pw = ?";
		
		try{
			
			openConn();
			
			// sql실행
			rs = pstmt.executeQuery();
			
			if(rs.next()){ // 로그인 성공(인증의 수단 session)
				String userId = rs.getString("userId");
				String name = rs.getString("name");
			
				session.setAttribute("user_id", id);
				session.setAttribute("user_name", name);
				
				response.sendRedirect("login_welcome.jsp"); // 페이지이동
				
			} else{ // 로그인 실패
				response.sendRedirect("login_fail.jsp"); // 실패 페이지
			}
		} catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("login.jsp"); // 에러가 난 경우도 리다이렉트
		} finally{
			try{
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}

}
