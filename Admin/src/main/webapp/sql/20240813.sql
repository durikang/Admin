-- 분석함수
-- 1) row_number() 함수
--  정렬이 되어 있는 결과에 대하여 번호를 할당하는 함수
--  형식) row_number() over(order by 정렬시 컬럼명)
select * from (select row_number() over(order by board_no desc) as rnum, b.* from board b) where rnum >= ? and rnum <= ?;




SELECT * FROM ( SELECT row_number() OVER (ORDER BY USER_NO DESC) AS rnum, c.* FROM CUSTOMER c WHERE c.is_deleted = ?) WHERE rnum BETWEEN ? AND ?;


CREATE OR REPLACE VIEW CUSLIST
AS select *
from(select ROWNUM RNUM, A.* 
from(select *
    from CUSTOMER) A);
    
select *
from(select ROWNUM RNUM, A.* 
from(select *
    from CUSTOMER) A)
WHERE is_deleted ='N' and ROWNUM BETWEEN 1 AND 10
order by 1 desc;


SELECT *
FROM CUSLIST 
WHERE ROWNUM BETWEEN 1 AND 10 and is_deleted ='Y'
order by 1 desc;

select count(*) from CUSTOMER WHERE is_deleted = 'Y' order by 1 desc;

SELECT * FROM CUSLIST  WHERE rnum BETWEEN 21 AND 30;
SELECT * FROM CUSLIST WHERE is_deleted = 'Y' AND RNUM BETWEEN 41 AND 50;
