package com.global.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.action.Action;
import com.global.action.View;
import com.global.product.model.ProductDAO;
import com.global.product.model.ProductDTO;
import com.global.product.model.ProductImageDAO;
import com.global.product.model.ProductImageDTO;

public class ListProductAction implements Action {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ProductDAO productDao = ProductDAO.getInstance();
		
		ProductImageDAO ImageDao = ProductImageDAO.getInstance();
		
		List<ProductDTO> productlist = productDao.getProductList();
		
		List<ProductImageDTO> imagelist = ImageDao.getProductImageList();
		
		request.setAttribute("List", productlist);
		
		System.out.println("List >>> "+ productlist);
		
		
		return new View("main.go").setUrl("/views/product/productList.jsp");
		
	}

}
