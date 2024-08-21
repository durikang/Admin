DROP TABLE REPLY CASCADE CONSTRAINTS;                                -- 댓글 테이블 삭제
DROP TABLE CART_ITEM CASCADE CONSTRAINTS;                            -- 장바구니에 담긴 상품 관리 테이블 삭제
DROP TABLE CART CASCADE CONSTRAINTS;                                 -- 사용자 장바구니 관리 테이블 삭제
DROP TABLE PRODUCT_IMAGE CASCADE CONSTRAINTS;                        -- 상품 이미지 관리 테이블 삭제
DROP TABLE PRODUCT_REVIEW CASCADE CONSTRAINTS;                       -- 상품 리뷰 테이블 삭제
DROP TABLE PRODUCT CASCADE CONSTRAINTS;                              -- 상품 관리 테이블 삭제
DROP TABLE PRODUCT_CATEGORY CASCADE CONSTRAINTS;                     -- 상품 카테고리 관리 테이블 삭제
DROP TABLE BOARD CASCADE CONSTRAINTS;                                -- 게시글 관리 테이블 삭제
DROP TABLE CATEGORY CASCADE CONSTRAINTS;                             -- 게시판 카테고리 관리 테이블 삭제
DROP TABLE ORDER_ITEM CASCADE CONSTRAINTS;                           -- 주문 항목 관리 테이블 삭제
DROP TABLE ORDERS CASCADE CONSTRAINTS;                               -- 주문 관리 테이블 삭제
DROP TABLE PAYMENT CASCADE CONSTRAINTS;                              -- 결제 관리 테이블 삭제
DROP TABLE SHIPMENT CASCADE CONSTRAINTS;                             -- 배송 관리 테이블 삭제
DROP TABLE ADMIN_ROLE CASCADE CONSTRAINTS;                           -- 관리자 역할 관리 테이블 삭제
DROP TABLE ADMIN CASCADE CONSTRAINTS;                                -- 관리자 계정 관리 테이블 삭제
DROP TABLE CUSTOMER CASCADE CONSTRAINTS;                             -- 회원 정보 관리 테이블 삭제


-- 회원 정보를 관리하는 테이블
CREATE TABLE CUSTOMER (
    USER_NO NUMBER PRIMARY KEY,                     -- 회원 번호 (Primary Key)
    USER_ID VARCHAR2(50) UNIQUE NOT NULL,           -- 회원 아이디 (Unique)
    PASSWORD VARCHAR2(100) NOT NULL,                -- 회원 비밀번호
    NAME VARCHAR2(100) NOT NULL,                    -- 회원 이름
    EMAIL VARCHAR2(100),                            -- 회원 이메일 주소
    AGE NUMBER,                                     -- 회원 나이
    JOB VARCHAR2(100),                              -- 회원 직업
    LOCATION VARCHAR2(100),                         -- 회원 사는 곳
    CREATED_AT DATE DEFAULT SYSDATE,                -- 회원 등록일
    UPDATED_AT DATE,                                -- 회원 정보 수정일
    MILEAGE NUMBER DEFAULT 0,                       -- 회원 마일리지
    IS_DELETED CHAR(1) DEFAULT 'N' CHECK (IS_DELETED IN ('Y', 'N'))                  -- 회원 삭제 여부 (Default: N)
);



-- 관리자 계정을 관리하는 테이블
CREATE TABLE ADMIN (
    ADMIN_ID NUMBER PRIMARY KEY,                    -- 관리자 번호 (Primary Key)
    USER_ID VARCHAR2(50) UNIQUE NOT NULL,           -- 관리자 아이디 (Unique)
    PASSWORD VARCHAR2(100) NOT NULL,                -- 관리자 비밀번호
    NAME VARCHAR2(100) NOT NULL,                    -- 관리자 이름
    EMAIL VARCHAR2(100),                            -- 관리자 이메일 주소
    IS_DELETED CHAR(1) DEFAULT 'N' CHECK (IS_DELETED IN ('Y', 'N'))                  -- 관리자 계정 삭제 여부 (Default: N)
);

CREATE TABLE ADMIN_ROLL (
    ROLL_CODE VARCHAR2(100) PRIMARY KEY,             -- 역할 코드 (Primary Key)
    ROLL_NAME VARCHAR2(100) NOT NULL,                -- 역할 이름
    ADMIN_ID NUMBER,                                 -- 관리자의 ID
    FOREIGN KEY (ADMIN_ID) REFERENCES ADMIN(ADMIN_ID) -- 관리자 테이블의 외래 키 참조
);

-- 게시판 카테고리를 관리하는 테이블
CREATE TABLE CATEGORY (
    CATEGORY_ID NUMBER PRIMARY KEY,                 -- 카테고리 번호 (Primary Key)
    NAME VARCHAR2(100) NOT NULL,                    -- 카테고리 이름
    DESCRIPTION VARCHAR2(255)                       -- 카테고리 설명
);

-- 게시판 게시글을 관리하는 테이블
CREATE TABLE BOARD (
    BOARD_ID NUMBER PRIMARY KEY,                              -- 게시글 번호 (Primary Key)                 
    USER_NO NUMBER,                                           -- 게시글 작성자 (CUSTOMER 테이블 참조)
    CATEGORY_ID NUMBER,                                       -- 게시글 카테고리 (CATEGORY 테이블 참조)
    TITLE VARCHAR2(200) NOT NULL,                             -- 게시글 제목
    CONTENT CLOB,                                             -- 게시글 내용
    CREATED_AT DATE DEFAULT SYSDATE,                          -- 게시글 작성일
    UPDATED_AT DATE,                                          -- 게시글 수정일
    IS_DELETED CHAR(1) DEFAULT 'N',                           -- 게시글 삭제 여부 (Default: N)
    FOREIGN KEY (USER_NO) REFERENCES CUSTOMER(USER_NO),       -- FOREIGN KEY로 CUSTOMER 테이블의 USER_NO 참조
    FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY(CATEGORY_ID) -- FOREIGN KEY로 CATEGORY 테이블의 CATEGORY_ID 참조
);

-- 게시글의 댓글을 관리하는 테이블
CREATE TABLE REPLY (
    REPLY_ID NUMBER PRIMARY KEY,                            -- 댓글 번호 (Primary Key)
    BOARD_ID NUMBER,                                        -- 댓글이 달린 게시글 (BOARD 테이블 참조)
    USER_NO NUMBER,                                         -- 댓글 작성자 (CUSTOMER 테이블 참조)
    CONTENT CLOB,                                           -- 댓글 내용
    CREATED_AT DATE DEFAULT SYSDATE,                        -- 댓글 작성일
    UPDATED_AT DATE,                                        -- 댓글 수정일
    IS_DELETED CHAR(1) DEFAULT 'N' CHECK (IS_DELETED IN ('Y', 'N')),                         -- 댓글 삭제 여부 (Default: N)
    FOREIGN KEY (BOARD_ID) REFERENCES BOARD(BOARD_ID),      -- FOREIGN KEY로 BOARD 테이블의 BOARD_ID 참조
    FOREIGN KEY (USER_NO) REFERENCES CUSTOMER(USER_NO)      -- FOREIGN KEY로 CUSTOMER 테이블의 USER_NO 참조
);

-- 상품 카테고리를 관리하는 테이블
CREATE TABLE PRODUCT_CATEGORY (
    CATEGORY_ID NUMBER PRIMARY KEY,                         -- 상품 카테고리 번호 (Primary Key)
    NAME VARCHAR2(100) NOT NULL,                            -- 상품 카테고리 이름
    DESCRIPTION VARCHAR2(255)                               -- 상품 카테고리 설명
);

-- 상품 정보를 관리하는 테이블
CREATE TABLE PRODUCT (
    PRODUCT_ID NUMBER PRIMARY KEY,                                      -- 상품 번호 (Primary Key)
    CATEGORY_ID NUMBER,                                                 -- 상품 카테고리 (PRODUCT_CATEGORY 테이블 참조)
    NAME VARCHAR2(100) NOT NULL,                                        -- 상품 이름
    DESCRIPTION CLOB,                                                   -- 상품 설명
    PRICE NUMBER NOT NULL,                                              -- 상품 가격
    STOCK_QUANTITY NUMBER,                                              -- 재고 수량
    CREATED_AT DATE DEFAULT SYSDATE,                                    -- 상품 등록일
    UPDATED_AT DATE,                                                    -- 상품 수정일
    IS_DELETED CHAR(1) DEFAULT 'N' CHECK (IS_DELETED IN ('Y', 'N')),                                     -- 상품 삭제 여부 (Default: N)
    FOREIGN KEY (CATEGORY_ID) REFERENCES PRODUCT_CATEGORY(CATEGORY_ID)  -- FOREIGN KEY로 PRODUCT_CATEGORY 테이블의 CATEGORY_ID 참조
);

-- 상품 이미지를 관리하는 테이블
CREATE TABLE PRODUCT_IMAGE (
    IMAGE_ID NUMBER PRIMARY KEY,                                -- 이미지 번호 (Primary Key)
    PRODUCT_ID NUMBER,                                           -- 이미지가 연결된 상품 (PRODUCT 테이블 참조)
    IMAGE_URL VARCHAR2(255) NOT NULL,                           -- 이미지 URL
    DESCRIPTION VARCHAR2(255),                                  -- 이미지 설명
    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID)      -- FOREIGN KEY로 PRODUCT 테이블의 PRODUCT_ID 참조
);

-- 상품 리뷰를 관리하는 테이블
CREATE TABLE PRODUCT_REVIEW (
    REVIEW_ID NUMBER PRIMARY KEY,                               -- 리뷰 번호 (Primary Key)
    PRODUCT_ID NUMBER,                                          -- 리뷰 대상 상품 (PRODUCT 테이블 참조)
    USER_NO NUMBER,                                             -- 리뷰 작성자 (CUSTOMER 테이블 참조)
    RATING NUMBER CHECK (RATING BETWEEN 1 AND 5),               -- 리뷰 평점 (1~5)
    COMM CLOB,                                                  -- 리뷰 내용
    CREATED_AT DATE DEFAULT SYSDATE,                            -- 리뷰 작성일
    UPDATED_AT DATE,                                            -- 리뷰 수정일
    IS_DELETED CHAR(1) DEFAULT 'N' CHECK (IS_DELETED IN ('Y', 'N')),                             -- 리뷰 삭제 여부 (Default: N)
    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID),    -- FOREIGN KEY로 PRODUCT 테이블의 PRODUCT_ID 참조
    FOREIGN KEY (USER_NO) REFERENCES CUSTOMER(USER_NO)          -- FOREIGN KEY로 CUSTOMER 테이블의 USER_NO 참조
);

-- 사용자 장바구니를 관리하는 테이블
CREATE TABLE CART (
    CART_ID NUMBER PRIMARY KEY,                                 -- 장바구니 번호 (Primary Key)
    USER_NO NUMBER,                                             -- 장바구니 소유자 (CUSTOMER 테이블 참조)
    CREATED_AT DATE DEFAULT SYSDATE,                            -- 장바구니 생성일
    FOREIGN KEY (USER_NO) REFERENCES CUSTOMER(USER_NO)          -- FOREIGN KEY로 CUSTOMER 테이블의 USER_NO 참조
);

-- 장바구니에 담긴 상품 항목을 관리하는 테이블
CREATE TABLE CART_ITEM (
    CART_ITEM_ID NUMBER PRIMARY KEY,                            -- 장바구니 항목 번호 (Primary Key)
    CART_ID NUMBER,                                             -- 해당 장바구니 (CART 테이블 참조)
    PRODUCT_ID NUMBER,                                          -- 장바구니에 담긴 상품 (PRODUCT 테이블 참조)
    QUANTITY NUMBER NOT NULL,                                   -- 상품 수량
    FOREIGN KEY (CART_ID) REFERENCES CART(CART_ID),             -- FOREIGN KEY로 CART 테이블의 CART_ID 참조
    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID)     -- FOREIGN KEY로 PRODUCT 테이블의 PRODUCT_ID 참조
);


-- DAO에 쓰일 코드
-- sql = "select * from CUSTOMER WHERE IS_DELETED = 'N' order by 1 desc";
