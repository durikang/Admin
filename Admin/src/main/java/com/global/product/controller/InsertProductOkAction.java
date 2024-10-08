package com.global.product.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.global.action.Action;
import com.global.action.View;
import com.global.controller.FrontController;
import com.global.product.model.ProductDAO;
import com.global.product.model.ProductDTO;
import com.global.product.model.ProductImageDAO;
import com.global.product.model.ProductImageDTO;

public class InsertProductOkAction implements Action {

    @Override
    public View execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 첨부파일이 저장될 위치(경로) 설정
        String root = request.getSession().getServletContext().getRealPath("/");
        String saveFolder = root + "/resources/product/img";
        int fileSize = 10 * 1024 * 1024; // 10MB

        // 파일 업로드를 위한 MultipartRequest 객체 생성
        MultipartRequest multi = new MultipartRequest(
                request,
                saveFolder,
                fileSize,
                "UTF-8",
                new DefaultFileRenamePolicy()
        );

        // 파라미터 가져오기 및 null 체크
        String product_name = getParameterSafe(multi, "proName");
        String product_category = getParameterSafe(multi, "proCategory");
        String product_info = getParameterSafe(multi, "proInfo");
        int product_price = parseIntSafe(multi.getParameter("proPrice"));
        int product_su = parseIntSafe(multi.getParameter("proSu"));

        // DTO 설정
        ProductDTO product = new ProductDTO();
        ProductImageDTO image = new ProductImageDTO();

        product.setName(product_name);
        product.setCategoryId(product_category);
        product.setDescription(product_info);
        product.setPrice(product_price);
        product.setStockQuantity(product_su);

        
        
        // DAO 객체 생성 및 데이터베이스에 제품 정보 저장
        ProductDAO dao = ProductDAO.getInstance();
        int product_id = dao.insertProduct(product);
        
        ProductDTO prod = dao.getProduct(product_id);
        
        PrintWriter out = response.getWriter();

        if (product_id > 0) {
            // 이미지 파일명 가져오기
            // 이미지 정보 저장
            ProductImageDAO imageDAO = ProductImageDAO.getInstance();
            String product_imagename = multi.getParameter("proimagename");
            String product_image = multi.getFilesystemName("proimage");
            
            image.setImageId(product_imagename);
            image.setImageUrl(product_image);
            int img = imageDAO.insertImgProduct(prod, image);

            
            System.out.println("product_imagename :: ");
            

            if (img > 0) {
                out.println("<script>");
                out.println("alert('상품 등록 및 이미지 등록 성공!!!')");
                out.println("location.href='main.go'");
                out.println("</script>");
            } else {
                out.println("<script>");
                out.println("alert('상품 등록 성공, 이미지 등록 실패~~~')");
                out.println("location.href='main.go'");
                out.println("</script>");
            }
        } else {
            out.println("<script>");
            out.println("alert('상품 등록 실패~~~')");
            out.println("history.back()");
            out.println("</script>");
        }

        return null;
    }

    // 안전하게 파라미터 값을 가져오는 메서드
    private String getParameterSafe(MultipartRequest multi, String paramName) {
        String value = multi.getParameter(paramName);
        return (value != null) ? value.trim() : "";
    }

    // 안전하게 콘텐츠 타입을 가져오는 메서드
    private String getContentTypeSafe(MultipartRequest multi, String paramName) {
        String value = multi.getContentType(paramName);
        return (value != null) ? value.trim() : "";
    }

    // 안전하게 정수로 변환하는 메서드
    private int parseIntSafe(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            return 0; // 적절히 처리하거나 기본값 설정
        }
    }

}
