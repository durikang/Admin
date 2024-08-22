package com.global.product.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.global.action.Action;
import com.global.action.View;

public class InsertProductOkAction implements Action {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		
		// 상픔 등록 폼 페이지에서 넘어온 데이터들을
				// 가지고 DB에 저장하는 비지니스 로직.
				
				// 첨부파일이 저장될 위치(경로) 설정.
				String saveFolder = "C:\\ncs_global\\jsp_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\18_MiniShopMall\\upload";
				
				// 첨부파일 용량(크기) 제한. - 파일 업로드 최대 크기 
				int fileSize = 10 * 1024 * 1024;   // 10MB
				
				// 파일 업로드를 위한 객체 생성.
				MultipartRequest multi = new MultipartRequest(
						request,           // request 객체
						saveFolder,        // 첨부파일이 저장될 위치 
						fileSize,          // 첨부 파일 최대 크기 
						"UTF-8",           // 한글 처리
						new DefaultFileRenamePolicy()
				);
				
				String name = multi.getParameter("proName").trim();
				String num = multi.getContentType("proCategory").trim();
				String info = multi.getParameter("proInfo").trim();
				int price = multi.getParameter("proprice").trim();
				int su = multi.getParameter("prosu").trim();
				
				
				/*
					20240822
				*/
		
		return null;
	}

}
