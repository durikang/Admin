package com.global.controller;



import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.global.action.Action;
import com.global.action.ActionForward;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 처리 작업 진행
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// getRequestURI() : "/프로젝트명/파일명(*.do)" 라는 
		//                   문자열을 반환해 주는 메서드.
		String uri = request.getRequestURI();
		System.out.println("URI >>> " + uri);
		
		// getContextPath() : 현재 프로젝트명을 문자열로 반환해 주는 메서드.
		String path = request.getContextPath();
		System.out.println("Path >>> " + path);
		
		String command = uri.substring(path.length() + 1);
		System.out.println("Command >>> " + command);
		
		
		Action action = null;
		
		ActionForward forward = null;
		
		Properties prop = new Properties();
		
		/*
		 * Properties 클래스
		 * - java.util 패키지에 존재하는 클래스.
		 * - Properties 클래스는 HashTable의 하위(자식) 클래스
		 * - 보통은 환경변수 및 속성 값을 Properties 파일에 저장하여
		 *   쉽게 접근할 수 있는 장점이 있음.
		 * - Properties 파일은 일련의 키(key) - 값(value) 의
		 *   한 쌍으로 이루어져 있음.
		 * - 보통은 파일에 저장을 하여 사용을 함. 파일 이름을
		 * 	 *.properties 라는 이름으로 끝나게 함.
		 * - FileInputStream 클래스에 Properties 파일을
		 *   인자로 넣어서 그 스트림으로부터 파일을 가져올 때 많이
		 *   사용을 함. 인자로 들어온 Properties 파일을 읽게 됨.
		 * - 읽어 들일 때 사용하는 메서드는 load() 라는 메서드를 
		 *   이용하여 파일을 읽어 들이게 됨.
		 */
		
		String fileName = FrontController.class.getResource("/com/global/controller/mapping.properties").getPath();
		
		prop.load(new FileReader(fileName));
		
		String value = prop.getProperty(command);
		
		System.out.println("Value >>> " + value);
		
		if(value.substring(0,7).equals("execute")) {
			StringTokenizer st = new StringTokenizer(value, "|");
			
			String url_1 = st.nextToken(); // "execute"
			String url_2 = st.nextToken(); // "패키지명.클래스명"
			
			try {
				Class<?> url = Class.forName(url_2);
				
				// 동적으로 로딩된 클래스(객체)의 생성자(기본생성자)를 가져오는 메서드.
				Constructor<?> constructor = url.getConstructor();
				
				// 가져온 생성자를 이용하여 newInstance() 메서드를 호출하여
				// 객체(인스턴스)를 생성하는 메서드
				action = (Action)constructor.newInstance();
				
				// 비지니스 로직 메서드 호출
				// 즉, 생성된 객체의 execute()를 호출하여 실행하는 문장이다.
				forward = action.execute(request, response);
			
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else { // value에 들어온 값이 "execute|...." 이 아닌 경우
			
			forward = new ActionForward();
			forward.setRedirect(false); // true => .do    false=> .jsp 이동
			forward.setPath(value);
			
			
		}
		
		
		if(forward != null) {
			if(forward.isRedirect()) { // true 인 경우
				response.sendRedirect(forward.getPath());
				
			} else { // false인 경우 => view page로 이동
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				
				rd.forward(request, response);
				
			}
		}
		
		
		
		
		
	}
}




