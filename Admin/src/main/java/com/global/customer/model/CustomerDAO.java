package com.global.customer.model;

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

public class CustomerDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;

	private static CustomerDAO instance = null;

	public static CustomerDAO getInstance() {
		if (instance == null)
			instance = new CustomerDAO();
		return instance;
	}

	// DB를 연동하는 작업을 위한 매서드
	// JDBC방식이 아닌 DBCP 방식으로 DB와 연동하는 작업 진행
	public void openConn() {

		try {
			// 1단계 : JNDI 서버 객체 생성
			// 자바의 네이밍 서비스(JNDI)에서 이름과 실제 객체를
			// 연결해 주는 개념이 Context 객체이며, InitialContext 객체는
			// 네이밍 서비스를 이용하기 위한 시작점이 된다.

			Context initCtx = new InitialContext();

			// 2단계 : Context 객체를 얻어와야 함.
			// "java:comp/env"라는 이름의 인수로 Context 객체를 얻어옴.
			// "java:comp/env"는 현제 웹 애플리케이션에서
			// 네이밍 서비스를 이용 시 루트 디렉토리라고 생각하면 됨.
			// 즉, 현재 웹 애플리케이션이 사용할 수 있는 모든 자원은
			// "java:comp/env" 아래에 위치를 하게 됨
			Context envctx = (Context) initCtx.lookup("java:comp/env");

			// 3단계 : lookup() 메서드를 이용하여 매칭되는 커넥션을 찾아옴.
			// "java:comp/env" 아래에 위치한 "jdbc/myoracle" 자원을
			// 얻어옴. 이 자원이 바로 데이터 소스(커넥션풀)임.
			// 여기서 "jdbc/myoracle" 은 context.xml 파일에 추가했던
			// <Resource> 태그 안에 있던 name 속성의 값임.

			DataSource ds = (DataSource) envctx.lookup("jdbc/myoracle");

			// 4 단계 : DataSoure 객체를 이요하여 컨넥션을 하나 가져오면 됨.
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
	
	public List<CustomerDTO> selectList(int currentPage, int boardLimit, char status,String sort) {
	    List<CustomerDTO> list = new ArrayList<>();
	    String orderBy = "USER_NO DESC";
	    if ("asc".equals(sort)) {
	        orderBy = "USER_NO ASC";
	    }

	    String sql = "SELECT * FROM ( SELECT row_number() OVER (ORDER BY " + orderBy + ") AS rnum, c.* FROM CUSTOMER c WHERE c.is_deleted = ?) WHERE rnum BETWEEN ? AND ?";

	    try {
	        openConn();
	        int startRow = (currentPage - 1) * boardLimit + 1;
	        int endRow = startRow + boardLimit - 1;

	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, String.valueOf(status));
	        pstmt.setInt(2, startRow);
	        pstmt.setInt(3, endRow);

	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            CustomerDTO member = new CustomerDTO();
	            member.setUserNo(rs.getInt("user_no"));
	            member.setUserId(rs.getString("user_id"));
	            member.setPassword(rs.getString("password"));
	            member.setName(rs.getString("name"));
	            member.setEmail(rs.getString("email"));
	            member.setAge(rs.getInt("age"));
	            member.setJob(rs.getString("job"));
	            member.setLocation(rs.getString("location"));
	            member.setCreatedAt(rs.getDate("created_at"));
	            member.setUpdatedAt(rs.getDate("updated_at"));
	            member.setMileage(rs.getInt("mileage"));
	            member.setIsDeleted(rs.getString("is_deleted").charAt(0));

	            list.add(member);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeConn(rs, pstmt, conn);
	    }
	    return list;
	}


	// 모든 회원 조회 시 정렬 옵션 추가
	public List<CustomerDTO> selectList(int currentPage, int boardLimit, String sort) {
	    List<CustomerDTO> list = new ArrayList<>();
	    String orderBy = "USER_NO DESC";
	    if ("asc".equals(sort)) {
	        orderBy = "USER_NO ASC";
	    }

	    sql = "SELECT * FROM ( SELECT row_number() OVER (ORDER BY " + orderBy + ") AS rnum, c.* FROM CUSTOMER c ) WHERE rnum BETWEEN ? AND ?";

	    try {
	        openConn();
	        int startRow = (currentPage - 1) * boardLimit + 1;
	        int endRow = startRow + boardLimit - 1;

	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, startRow);
	        pstmt.setInt(2, endRow);

	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            CustomerDTO member = new CustomerDTO();
	            member.setUserNo(rs.getInt("user_no"));
	            member.setUserId(rs.getString("user_id"));
	            member.setPassword(rs.getString("password"));
	            member.setName(rs.getString("name"));
	            member.setEmail(rs.getString("email"));
	            member.setAge(rs.getInt("age"));
	            member.setJob(rs.getString("job"));
	            member.setLocation(rs.getString("location"));
	            member.setCreatedAt(rs.getDate("created_at"));
	            member.setUpdatedAt(rs.getDate("updated_at"));
	            member.setMileage(rs.getInt("mileage"));
	            member.setIsDeleted(rs.getString("is_deleted").charAt(0));

	            list.add(member);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeConn(rs, pstmt, conn);
	    }
	    return list;
	}

	/* 회원 상세 정보*/
	public CustomerDTO selectMember(int num) {
		CustomerDTO member = null;
		try {
			sql = "select * from CUSTOMER where USER_NO = ?";
			openConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new CustomerDTO();
				member.setUserNo(rs.getInt(1));
				member.setUserId(rs.getString(2));
				member.setPassword(rs.getString(3));
				member.setName(rs.getString(4));
				member.setEmail(rs.getString(5));
				member.setAge(rs.getInt(6));
				member.setJob(rs.getString(7));
				member.setLocation(rs.getString(8));
				member.setCreatedAt(rs.getDate(9));
				member.setUpdatedAt(rs.getDate(10));
				member.setMileage(rs.getInt(11));
				member.setIsDeleted(rs.getString(12).charAt(0));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, conn);
		}

		return member;
	}

	public int updateStudent(CustomerDTO member, int num) {
		int res = 0;

		try {
			sql = "update CUSTOMER set NAME = ?, PASSWORD = ?, LOCATION = ? where USER_NO = ?";
			openConn();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getLocation());
			pstmt.setInt(4, member.getUserNo());

			res = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(pstmt, conn);
		}
		return res;
	}

	public int getMemberCount() {
		int count = 0;

		try {
			openConn();
			sql = "select count(*) from CUSTOMER";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, conn);
		}

		return count;
	}

	public int getMemberCount(char status) {

		int count = 0;

		try {
			openConn();
			sql = "select count(*) from CUSTOMER";
			// 상태에 따라 SQL 조건 추가
			if (status == 'Y') {
				sql += " WHERE is_deleted = 'Y' order by 1 desc";
			} else if (status == 'N') {
				sql += " WHERE is_deleted = 'N' order by 1 desc";
			}
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, conn);
		}

		return count;

	}

	public int insertMember(CustomerDTO insertMember) {
		int maxNum = 0;
		int res = 0;

		try {
			openConn();

			sql = "select max(USER_NO) from CUSTOMER";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				maxNum = rs.getInt(1);
			}

			sql = "INSERT INTO CUSTOMER VALUES (?, ?, ?, ?, ?, ?, ?, ?, DEFAULT, NULL, 0, DEFAULT)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, maxNum + 1); // USER_NO
			pstmt.setString(2, insertMember.getUserId()); // USER_ID
			pstmt.setString(3, insertMember.getPassword()); // PASSWORD
			pstmt.setString(4, insertMember.getName()); // NAME
			pstmt.setString(5, insertMember.getEmail()); // EMAIL
			pstmt.setInt(6, insertMember.getAge()); // AGE
			pstmt.setString(7, insertMember.getJob()); // JOB
			pstmt.setString(8, insertMember.getLocation()); // LOCATION
			// CREATED_AT은 SYSDATE로 자동 설정
			// UPDATED_AT은 NULL로 설정 (아직 수정되지 않았으므로)
			// MILEAGE는 0으로 초기화
			res = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, conn);
		}

		return res;
	}

	public boolean checkDuplicateId(String USER_ID) {
		boolean isDuplicate = false;

		try {
			openConn();
			sql = "select * from CUSTOMER where USER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, USER_ID);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 결과가 있다면 아이디가 중복됨
				isDuplicate = true;
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, conn);
		}

		return isDuplicate;
	}

	public int deleteStudent(int num) {
		int res = 0;

		try {
			openConn();
			sql = "update customer set IS_DELETED = 'Y' where USER_NO= ? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			res = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(pstmt, conn);
		}

		return res;
	}

}
