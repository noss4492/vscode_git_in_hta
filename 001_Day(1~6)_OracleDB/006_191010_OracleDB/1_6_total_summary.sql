



[DAY 6]********************************************************
#191010 정리본

[팁]  -- NLS_DATE_FORMAT 꼴뵈기 싫으면
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY/MM/DD';
SELECT SYSDATE FROM DUAL;
------------------------------------------------------------------------
# OBJECT
- table	   : 1. 데이터딕셔너리 / 2. 유저정의테이블
- index    : 접근에서 쓰임
- view     : 
- sequence : 자동 번호 생성기(대기표기계)
- synonym  : 동의어, 대체이름(테이블, 뷰, 시퀀스, 프로시저등에 대한)
------------------------------------------------------------------------
SEQUENCE 에 대해서

# 기본 format
CREATE SEQUENCE DEPT_DEPTNO
START WITH 1	-- 1부터
INCREMENT BY 1	-- 1씩 증가
MINVALUE 1      -- 1부터
MAXVALUE 100    -- 100까지
NOCYCLE         -- CYCLE옵션, 이걸 쓰면 다시 MINVALUE부터 돈다.
NOCACHE;        -- CACHE옵션, 이걸 쓰면 묶음(여러개씩)으로 시퀀스 번호를 받아온다.

주 사용처 : 동작중인 어플리케이션에서의 INSERT문

# 생각
RDBMS 테이블 하나에는 반드시 1개의 primary key가 존재해야한다. 
(의미는 없더라도) (어떻게든 넣어야 하는데) 
순서대로 숫자를 ROW에 하나씩 뿌려주면 중복X NULL X를 만족할테니까 이런 논리
(ex. 게시물 번호)
한마디로 동작되면서 발생하는 row들에 어떻게든 (중복x, null x)번호를 줘야해서

# 주의
공유가능한 객체이므로 연속된 번호를 뿌려주는 것이 아니라 띄엄띄엄 간헐적인
번호로 뿌려질 수 있다.
(번호에 gap이 생길 수 있음)
(롤백이나 여러 테이블에서 시퀀스를 같이 사용할 수 있으니까)

ex. 일반적인 INSERT와의 차이점을 생각해보자
INSERT INTO DEPT VALUES(1, 부서명, 위치);
INSERT INTO DEPT VALUES(DEPT_DEPTNO.NEXTVAL, '연구', '서울');

ex. 여러 컬럼도 ㅇㅋ
INSERT INTO EMP(EMPNO, ENAME, SAL, DEPTNO) 
VALUES (DEPT_DEPTNO.NEXTVAL, 'AA', 3000, 10);


ALTER SEQUENCE DEPT_DEPTNO
    CYCLE;              <<- (등 시퀀스 옵션을 주면 됨)

DROP SEQUENCE DEPT_DEPTNO;

# 요약
시퀀스 : 은행 대기표 확장판
공유 가능한 객체임
주로 응용프로그램에서 DB로 데이터를 INSERT할 때 (사람이 하지는 않지요)
PK컬럼의 value 지정시 사용됨
대부분 이렇다.


------------------------------------------------------------------------
INDEX 에 대해서

1. 개요.
    자주 검색되는 컬럼의 이름과 ROWID
    저장해놓은 객체 index

2. 문법.
CREATE INDEX IDX_EMP_ENAME
ON EMP(ENAME);




index는 테이블이랑 다른 저장 장손에 있음
컬럼밸류 로아이디 포함


빠른검색을 위한 방법은 책/db 비슷
본문/테이블
index/index
키워드/자주검색되는컬럼의value
페이지번호/rowid

-- 테이블 분할, 세그먼트, 클러스터 등등 여러가지가 있던데... 





SELECT RONUM, ROWID, EMPNO
FROM EMP;
SELECT RONUM, ROWID, EMPNO

SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE ROWID='AAAR3sAAEAAAACXAAL';	
-- DB가 가능한 가장 빠른 찾아오는 방법이 이것이라고 한다.

ROWID 서치가 가장 빠르다.

-- FULL TABLE SCAN 방식
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE ENAME = 'SCOTT'

-- 내 잡생각. 이러면 ROWID 서치 되긴 하는데 빠르진 않겠지.
SELECT (SELECT ROWID
		FROM EMP
		WHERE ENAME = 'SMITH')
FROM DUAL;






