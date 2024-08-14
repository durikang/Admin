
    
    -- 사용자 데이터를 삽입하기 위한 PL/SQL 스크립트
BEGIN
    FOR I IN 1..105
    LOOP
        -- 랜덤 데이터를 생성하기 위한 변수를 선언합니다.
        DECLARE
            v_user_id VARCHAR2(50);
            v_password VARCHAR2(100);
            v_name VARCHAR2(100);
            v_email VARCHAR2(100);
            v_age NUMBER;
            v_job VARCHAR2(100);
            v_location VARCHAR2(100);
        BEGIN
            -- 사용자 아이디는 'user'와 순번을 조합하여 생성합니다.
            v_user_id := 'user' || TO_CHAR(1000 + I); -- 'user1001', 'user1002' 등

            -- 비밀번호는 'password'와 순번을 조합하여 생성합니다.
            v_password := 'password' || TO_CHAR(1000 + I);

            -- 이름은 랜덤으로 한국 이름을 생성합니다.
            v_name := DBMS_RANDOM.STRING('X', 5); -- 임시 이름 (랜덤 5자리 문자열)

            -- 이메일은 아이디를 기반으로 생성합니다.
            v_email := v_user_id || '@example.com';

            -- 나이는 20에서 60 사이의 랜덤 숫자로 설정합니다.
            v_age := TRUNC(DBMS_RANDOM.VALUE(20, 60));

            -- 직업은 랜덤으로 한국 직업을 설정합니다.
            CASE TRUNC(DBMS_RANDOM.VALUE(1, 6))
                WHEN 1 THEN v_job := '학생';
                WHEN 2 THEN v_job := '회사원';
                WHEN 3 THEN v_job := '교사';
                WHEN 4 THEN v_job := '의사';
                WHEN 5 THEN v_job := '프로그래머';
                ELSE v_job := '기타';
            END CASE;

            -- 위치는 랜덤으로 한국 도시를 설정합니다.
            CASE TRUNC(DBMS_RANDOM.VALUE(1, 6))
                WHEN 1 THEN v_location := '서울';
                WHEN 2 THEN v_location := '부산';
                WHEN 3 THEN v_location := '대구';
                WHEN 4 THEN v_location := '인천';
                WHEN 5 THEN v_location := '광주';
                ELSE v_location := '대전';
            END CASE;

            -- CUSTOMER 테이블에 데이터 삽입
            INSERT INTO CUSTOMER (
                USER_NO, USER_ID, PASSWORD, NAME, EMAIL, AGE, JOB, LOCATION
            ) VALUES (
                I + 2, v_user_id, v_password, v_name, v_email, v_age, v_job, v_location
            );
        EXCEPTION
            WHEN DUP_VAL_ON_INDEX THEN
                -- 유니크 제약 조건 위반 시, 오류를 무시하고 계속 진행합니다.
                NULL;
        END;
    END LOOP;
END;
/





select *
from(select ROWNUM RNUM, A.* 
from(select *
    from CUSTOMER order by 1 desc) A)
where RNUM BETWEEN 1 AND 10;


CREATE OR REPLACE VIEW CUSLIST
AS select *
from(select ROWNUM RNUM, A.* 
from(select *
    from CUSTOMER order by 1 desc) A);
    
select *
from cuslist
where rnum between 1 and 10 and IS_DELETED='Y';

select *
from customer where IS_DELETED='Y';
select *
from CUSTOMER where is_deleted ='Y';

update customer set is_deleted ='Y'  where user_no between 30 and 70;

commit;

