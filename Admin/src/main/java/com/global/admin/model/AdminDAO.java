package com.global.admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AdminDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;

	private static AdminDAO instance = null;

	public static AdminDAO getInstance() {
		if (instance == null)
			instance = new AdminDAO();
		return instance;
	}

	// DB를 연동하는 작업을 위한 매서드
	// JDBC방식이 아닌 DBCP 방식으로 DB와 연동하는 작업 진행
	public void openConn() {

		try {
			Context initCtx = new InitialContext();
			Context envctx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/myoracle");

			conn = ds.getConnection();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeConn(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null && !rs.isClosed())
				rs.close();
			if (stmt != null && !stmt.isClosed())
				stmt.close();
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeConn(Statement stmt, Connection conn) {
		try {
			if (stmt != null && !stmt.isClosed())
				stmt.close();
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkRoleCodeDuplicateId(String roleCode) {
		try {
			openConn();
			sql = "select * from admin_role where ROLL_CODE = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, roleCode);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConn(rs, pstmt, conn);
		}
		
		return false;
	}

	public int insertAdminRole(AdminRoleDTO dto) {
		int res = 0;
		try {
			openConn();
			sql = "insert into ADMIN_ROLE values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getRoleCode());
			pstmt.setString(2, dto.getRoleName());
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConn(pstmt, conn);
		}
		
		return res;
	}
	// InsertForm 메뉴갖고오는 용도
	public List<AdminRoleDTO> getAdminRoleList() {
		List<AdminRoleDTO> roleList = new ArrayList<>();
		
		try {
			openConn();
			sql = "select * from (select row_number() over (order by 1) as rnum, ar.* from ADMIN_ROLE ar )";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AdminRoleDTO dto = new AdminRoleDTO();
				dto.setRnum(rs.getInt(1));
				dto.setRoleCode(rs.getString(2));
				dto.setRoleName(rs.getString(3));
				roleList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, conn);
		}
		
		return roleList;
	}
	// List 뿌려주는 용도 Paging 처리
	public List<AdminRoleDTO> getAdminRoleList(int currentPage, int boardLimit) {
		List<AdminRoleDTO> roleList = new ArrayList<>();
		
		try {
			openConn();
			sql = "select * from (select row_number() over (order by 1) as rnum, ar.* from ADMIN_ROLE ar ) where rnum between ? and ?";
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (currentPage - 1) * boardLimit + 1;
			int endRow = startRow + boardLimit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AdminRoleDTO dto = new AdminRoleDTO();
				dto.setRnum(rs.getInt(1));
				dto.setRoleCode(rs.getString(2));
				dto.setRoleName(rs.getString(3));
				roleList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, conn);
		}
		
		return roleList;
	}
	

	public int insertAdmin(AdminDTO admin) {
		int res = 0, maxNum = 0;
		
		try {
			openConn();
			sql = "select max(admin_id) from admin";
			
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				maxNum = rs.getInt(1);
			}
			
			sql = "insert into admin values(?,?,?,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maxNum+1);
			pstmt.setString(2, admin.getUserId());
			pstmt.setString(3, admin.getPassword());
			pstmt.setString(4, admin.getName());
			pstmt.setString(5, admin.getEmail());
			pstmt.setString(6, admin.getRoleCode());

			res=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConn(rs,pstmt, conn);
		}
		
		return res;
	}

	public int getAdminRoleListCount() {
		int count = 0;
		try {
			openConn();
			sql = "select count(*) from (select row_number() over (order by 1) as rnum, ar.* from ADMIN_ROLE ar )";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, conn);
		}
		return count;
	}

	public List<AdminDTO> getAdminList(int currentPage, int boardLimit) {
		List<AdminDTO> adminList = new ArrayList<>();
		
		try {
			openConn();
			sql = "select * from (select row_number() over (order by 1) as rnum, ar.* from ADMIN ar ) where rnum between ? and ?";
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (currentPage - 1) * boardLimit + 1;
			int endRow = startRow + boardLimit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AdminDTO dto = new AdminDTO();
				dto.setAdminId(rs.getInt(2));
				dto.setUserId(rs.getString(3));
				dto.setPassword(rs.getString(4));
				dto.setName(rs.getString(5));
				dto.setEmail(rs.getString(6));
				dto.setRoleCode(rs.getString(7));
				dto.setIsDeleted(rs.getString(8).charAt(0));
				
				adminList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, conn);
		}
		
		return adminList;
	}

	public int getAdminListCount() {
		int count = 0;
		try {
			openConn();
			sql = "select count(*) from (select row_number() over (order by 1) as rnum, ar.* from ADMIN ar )";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, conn);
		}
		return count;
	}

	public AdminDTO getAdminInfo(int no) {
		AdminDTO admin = null;
		
		try {
			openConn();
			sql = "select * from ADMIN where ADMIN_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				admin = new AdminDTO();
				admin.setAdminId(rs.getInt(1));
				admin.setUserId(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setName(rs.getString(4));
				admin.setEmail(rs.getString(5));
				admin.setRoleCode(rs.getString(6));
				admin.setIsDeleted(rs.getString(7).charAt(0));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, conn);
		}
		
		return admin;
	}

	public int updateAdmin(AdminDTO admin) {
		
		
		
		
		return 0;
	}
}
