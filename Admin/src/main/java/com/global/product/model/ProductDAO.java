package com.global.product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	// 싱글톤
	public static ProductDAO instance=null;

	// 기본생성자
	public ProductDAO() {}


	public static ProductDAO getInstance() {

		if (instance == null) {
			instance = new ProductDAO();
		}
		return instance;
	}

	
	public void openConn() {

		try {

			// 1단계 : JNDI 서버 객체 생성
			// 자바의 네이밍 서비스(JNDI)에서 이름과 실제 객체를
			// 연결해 주는 개념이 Context 객체이며, InitialContext 객체는
			// 네이밍 서비스를 이용하기 위한 시작점이 됨.
			Context initCtx = new InitialContext();

			// 2단계 : Context 객체를 얻어와야 함.
			// "java:comp/env"라는 이름의 인수로 Context 객체를 얻어옴.
			// "java:comp/env"는 현재 웹 애플리케이션에서
			// 네이밍 서비스를 이용 시 루트 디렉토리라고 생각하면 됨.
			// 즉, 현재 웹 애플리케이션이 사용할 수 있는 모든 자원은
			// "java:comp/env" 아래에 위치를 하게 됨.
			Context ctx = (Context) initCtx.lookup("java:comp/env");

			// 3단계 : lookup() 메서드를 이용하여 매칭되는 커넥션을 찾아옴.
			// "java:comp/env" 아래에 위치한 "jdbc/myoracle" 자원을
			// 얻어옴. 이 자원이 바로 데이터 소스(커넥션풀)임.
			// 여기서 "jdbc/myoracle" 은 context.xml 파일에 추가했던
			// <Resource> 태그 안에 있던 name 속성의 값임.
			DataSource ds = (DataSource) ctx.lookup("jdbc/myoracle");

			// 4단계 : DataSource 객체를 이용하여 커넥션을 하나 가져오면 됨.
			con = ds.getConnection();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // openConn() end

	// DB에 연결된 자원을 종료하는 메서드.
	public void closeConn(ResultSet rs, PreparedStatement pstmt, Connection con) {

		try {

			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // closeConn() end

	// jsp_bbs 테이블의 전체 게시물을 조회하는 메서드.

	public void closeConn(PreparedStatement pstmt, Connection con) {

		try {

			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // closeConn() end


	public int insertProduct(ProductDTO dto) {

		int result = 0, count = 0;
		
		int product_id=0;
		
		try {
		
		openConn();
		
		sql = "SELECT MAX(PRODUCT_ID) FROM PRODUCT";
		
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			count = rs.getInt(1) + 1;
			
			
		}
		
		sql = "INSERT INTO PRODUCT VALUES(?,?,?,?,?,?,SYSDATE,null, 'N')";
		
		
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1,count);
		pstmt.setString(2, dto.getCategoryId());
		pstmt.setString(3, dto.getName());
		pstmt.setString(4, dto.getDescription());
		pstmt.setInt(5, dto.getPrice());
		pstmt.setInt(6, dto.getStockQuantity());
		
		
		pstmt.executeUpdate();
		
		product_id = count;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		
		return product_id;
	}


	public ProductDTO getProduct(int product_id) {
		ProductDTO product = null;
		try {
			openConn();
			sql = "select * from product where product_id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, product_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				product = new ProductDTO();
				product.setProductId(rs.getInt(1));
				product.setCategoryId(rs.getString(2));
				product.setName(rs.getString(3));
				product.setDescription(rs.getString(4));
				product.setPrice(rs.getInt(5));
				product.setStockQuantity(rs.getInt(6));
				product.setCreatedAt(rs.getDate(7));
				product.setUpdatedAt(rs.getDate(8));
				product.setIsDeleted(rs.getString(9).charAt(0));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}


	public List<ProductDTO> getProductList() {

		List<ProductDTO> list = new ArrayList<ProductDTO>();

		try {
		
		openConn();
		
		sql = "SELECT * FROM PRODUCT ORDER BY 1 ASC";
		
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			ProductDTO dto = new ProductDTO();
		
			dto.setProductId(rs.getInt(1));
			dto.setCategoryId(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setDescription(rs.getString(4));
			dto.setPrice(rs.getInt(5));
			dto.setStockQuantity(rs.getInt(6));
			dto.setCreatedAt(rs.getDate(7));
			dto.setUpdatedAt(rs.getDate(8));
			dto.setIsDeleted(rs.getString(9).charAt(0));
			
			list.add(dto);
		
		}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		
		
		
		return list;
	}
}
