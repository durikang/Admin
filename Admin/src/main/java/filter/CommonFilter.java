package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CommonFilter
 */
/*  
	filterName을 통해서 역확을 하는 필터인지 지정을 해주고
	urlPatterns을 통해서 어떠한 서블릿을 가기 전에 거칠 것인지를 지정해준다.

@WebFilter(filterName="encoding",urlPatterns="/*")
*/
public class CommonFilter extends HttpFilter implements Filter {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4887447250812765498L;

	/*
		서블릿 필터는 request, response가 서블릿이나 JSP 등 리소스에 도달하기 전
		필요한 전/후 처리 작업을 맡는다.
		필터는 FilterChain을 통해 여러 개 혹은 연쇄적으로 사용 가능하다.
		
		필터 클래스를 등록하는 방법
		1. WEB-INF/web.xml 파일에 필터를 등록해야만 사용 가능
		2. 하지만 최근에는 web.xml에 등록하지 않고 @WebFilter라는 어노테이션으로 대체해서 사용하는 추세임
		
		Filter 라이프 사이클
		- init() : 컨테이너가 필터를 인스턴스화 할 때 호출, 필터 설정 관련 코드 작성 가능
		- doFilter() : 컨테이너가 현재 요청에 필터 적용을 하겠다 판단되면 호출
						ServletRequest, ServletResponse, FilterChain 객체
		- destroy()	:	컨테이너가 필터 인스턴스를 제거할 때 호출
	
	*/	
	public CommonFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("CommonFilter가 소멸 되었습니다.");
	}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        System.out.println("-- doFilter() 동작합니다. -- ");
        
        HttpServletRequest hrequest = (HttpServletRequest) request;
        HttpServletResponse hresponse = (HttpServletResponse) response;
    
        if(hrequest.getMethod().equalsIgnoreCase("post")) {
            System.out.println("POST 전송시에만 인코딩 설정.");
            request.setCharacterEncoding("UTF-8");
        }

        // 응답에 대한 인코딩 설정
        response.setCharacterEncoding("UTF-8");
        hresponse.setContentType("text/html;charset=UTF-8");

        // pass the request along the filter chain
        chain.doFilter(request, response);
        
        System.out.println("-- doFilter() 이후 처리되는 코드입니다. --");
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("CommonFilter 초기화");

	}

}
