ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY MM DD';
select sysdate from dual;

## 19-10-10 정리해야됨

-------------------------------------------------------------------------------------------------
# OBJECT
- table     : D.D / 유저 정의
- index     : 아직 안함
- view      : select문에 이름 붙여둔거라 생각하셈
- senquence : 자동번호생성기
- synonym   : 아직 안함



CREATE SEQUENCE DEPT_DEPTNO
START WITH 1 		--1부터
INCREMENT BY 1		-- 1씩+
MINVALUE 1
MAXVALUE 100
NOCYCLE
NOCACHE;
--사용처 : 어플리케이션 => INSERT문

INSERT INTO DEPT VALUES(1, 부서명, 위치);
INSERT INTO DEPT VALUES(DEPT_DEPTNO.NEXTVAL, '연구', '서울');

-- 안쓰기는 해도 먼가 번호 줘야할때 (P.K.인 경우) 비어있으면 중복되면 안되니까 사용함
RDBMS -> 1테이블엔 반드시 1개의 P.K가 존재해야함(의미는 없어도 있어야댐) (ex.게시물 번호)
게시판 게시물 인덱스(라는 말은 없었는데) 흠.. 게시물 번호 같은거 매길때 시퀀스로 적당히 PK값 줄때 사용댐

공유가능한 객체라는데 (?)
-- 여러 컬럼도 ㅇㅋ
INSERT INTO EMP(EMPNO, ENAME, SAL, DEPTNO) 
VALUES (DEPT_DEPTNO.NEXTVAL, 'AA', 3000, 10);

-- SEQUENCE : 자동번호 발생기
-- 공유 가능한 객체
-- 주로 응용프로그램에서 DB로 데이터 INSERT할 때
-- PK컬럼의 VALUE 값 지정시 사용
-- 99.9% 이렇다



-- 항상 연속된 번호를 부여한다...????? X -> 실제로는 그렇지 않다.AVG_DEPTNO
-- 번호에 gap이 생길 수 있다고 함
-- 롤백이나 여러 테이블에서 동일한 시퀀스를 같이 사용할 수도 있으니까
-- 공유가능한 객체이르모 (다른 테이블에 시퀀스값을 줄 수도 있으니까)


-- 시퀀스를 주로 이런 용도로 쓰지는 않지만
시퀀스 옵션
SELECT DEPT_DEPTNO.NEXTVAL, EMPNO, ENAME
FROM EMP;

여러번 실행시
ERROR at line 1:
ORA-08004: sequence DEPT_DEPTNO.NEXTVAL exceeds MAXVALUE and cannot be instantiated
-- 아까 시퀀스 100까지 맥스로 해둬서 그럼
-- CYCLE 쓰면 다시 민으로 가는데 딱히 쓰지는 않음
-- CACHE 20 한번 접근시 시퀀스 20개씩 가져옴 NO CACHE면 매번 1개씩임


DESC USER_SEQUENCES;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 SEQUENCE_NAME                             NOT NULL VARCHAR2(30)
 MIN_VALUE                                          NUMBER
 MAX_VALUE                                          NUMBER
 INCREMENT_BY                              NOT NULL NUMBER
 CYCLE_FLAG                                         VARCHAR2(1)
 ORDER_FLAG                                         VARCHAR2(1)
 CACHE_SIZE                                NOT NULL NUMBER
 LAST_NUMBER                               NOT NULL NUMBER


SEQUENCE_NAME                   MIN_VALUE  MAX_VALUE INCREMENT_BY C O CACHE_SIZE  LAST_NUMBER
------------------------------ ---------- ---------- ------------ - - ---------- -----------
DEPT_DEPTNO                             1        100            1 N N          0        101
--------------------------------------------------------------------------------------------


ALTER SEQUENCE DEPT_DEPTNOCYCLE;하면 시퀀스 설정 바꿀 수 있음

SELECT DEPT_DEPTNO.NEXTVAL, EMPNO
FROM EMP;

DROP SEQUENCE DEPT_DEPTNO;



---------------------------------------------------------------

## index

SQL> SELECT RONUM, ROWID, EMPNO
  2  FROM EMP;
SELECT RONUM, ROWID, EMPNO

SQL> SELECT EMPNO, ENAME, SAL
  2  FROM EMP
  3  WHERE ROWID='AAAR3sAAEAAAACXAAL';	<<-- DB가 가능한 가장 빠른 찾아오는 방법이 이것

  ROWID 서치가 가장 빠르다.






-- FULL TABLE SCAN 방식
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE ENAME = 'SCOTT'

-- 이러면 ROWID 서치 되긴 하는데
SELECT (SELECT ROWID
		FROM EMP
		WHERE ENAME = 'SMITH')
FROM DUAL;


자주 검색되는 컬럼의 이름과 ROWID
저장해놓은 객체 index

CREATE INDEX IDX_EMP_ENAME
ON EMP(ENAME);

빠른검색을 위한 방법은 책/db 비슷
본문/테이블
index/index
키워드/자주검색되는컬럼의value
페이지번호/rowid


index는 테이블이랑 다른 저장 장손에 있음
컬럼밸류 로아이디 포함


index 
많을수록 select 쿼리 속도는 빠르지만 dml(업데이트나 추가)는 느려짐
필요한 애들에만
--(내가쓴거아님)dml속도가 떨어지는 것을 감수하면서도 select속도가 향상되기를 기대할때
자주 검색되는 컬럼(where)조건
join조건으로 사용되는 컬럼
primary key, unique 제약이 걸려있는 컬럼 -->> 오라클은 항상 자동으로 index 생성함
분포가 고른 컬럼에 걸어준다.
우리반 남자 컬럼 같은데는 분포가 완전 몰려있으니까 그런데는 인덱스 걸면 안됨


-- select -> row id 보고 접근 하는군
-- 인덱스 있으면 어떻게 작동?


---------------------------------
---------------------------------
----------어려워진대
conn sys/oracle as sysdba

-- 인덱스를 정말 쓰고 있을까?
스콧 : set autotrace on
권한 없음
권한주자
@c:\app\ln4so\product\11.2.0\dbhome_1\sqlplus\admin\plustrce.sql
몬가 명령어들이 저장되어있음

---------------------------------
set echo on

drop role plustrace;	--누가 썼을지도 모르니 지우고
create role plustrace;

grant select on v_$sesstat to plustrace
grant select on v_$statname to plustrace;
grant select on v_$mystat to plustrace;
grant plustrace to dba with admin option;

set echo off
---------------------------------

grant plustrace to scott;

-- 스콧으로 돌아가서
set autotrace on

머 조회 함 해보면 실행계획부터 쫙 나옴

#emp테이블 조회 풀테이블스캔임
Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation         | Name | Rows  | Bytes | Cost (%CPU)| Time     |
--------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |      |    14 |   532 |     3   (0)| 00:00:01 |
|   1 |  TABLE ACCESS FULL| EMP  |    14 |   532 |     3   (0)| 00:00:01 |
--------------------------------------------------------------------------


# 아까 인덱스 만든 스콧은 인덱스로 로아이디 접근하고 에 인덱스 레인지 스캔임
Execution Plan
----------------------------------------------------------
Plan hash value: 3977601012
--------------------------------------------------------------------------------
| Id  | Operation                   | Name          | Rows  | Bytes | Cost (%CPU)| Time     |
--------------------------------------------------------------------------------
|   0 | SELECT STATEMENT            |               |     1 |    14 |     2   (0)| 00:00:01 |
|   1 |  TABLE ACCESS BY INDEX ROWID| EMP           |     1 |    14 |     2   (0)| 00:00:01 |
|*  2 |   INDEX RANGE SCAN          | IDX_EMP_ENAME |     1 |       |     1   (0)| 00:00:01 |
--------------------------------------------------------------------------------





앞으로 어떻게 처리했는지 보고 싶으면 오토트레이스 기능을 쓰자

-----------------------------------------------------------------------------------------------------------------

DESC USER_INDEXES

SELECT INDEX_NAME, INDEX_TYPE, TABLE_NAME, UNIQUENESS
FROM USER_INDEXES;
        

INDEX_NAME    INDEX_TY TABLE_NAME                     UNIQUENES
------------- -------- ------------------------------ ---------
HW_CUST_ID_PK NORMAL   HW_CUST                        UNIQUE
EMP1_EMPNO_PK NORMAL   EMP1                           UNIQUE
PK_EMP        NORMAL   EMP                            UNIQUE
IDX_EMP_ENAME NORMAL   EMP                            NONUNIQUE
SYS_C0011053  NORMAL   DEPT1                          UNIQUE
SYS_C0011054  NORMAL   DEPT1                          UNIQUE
PK_DEPT       NORMAL   DEPT                           UNIQUE


인덱스 수동, 자동(이거 이름도 역시 SYS_머시기)
자동으로 생성시 (PK, UK는 자동으로 만듬) 제약조건의 이름과 같이 만듬
제약조건은 오브젝트가 아니니까 

-- AUTO : PK UK
-- 자동으로 생성되는 인덱스는 삭제가 안됨

ORA-02429: cannot drop index used for enforcement of unique/primary key

-- PK UK 내부 구조상 인덱스를 쓰고 있기 때문에..

-- 흘려들으셈
B*tree구조 (밸런스)
오라클 인덱스는 B-tree(binary search tree)에 대한 원리를 기반으로 하고 있다.
 B-tree 인덱스는 컬럼안에 독특한 데이터가 많을 때 가장 좋은 효과를 낸다.




---------------------------------- 막간 실습 --------------------------------
SELECT EMPNO, ENAME, SAL, JOB
FROM EMP
WHERE JOB = 'MANAGER';

-- 잡 컬럼으로 검색을 마니함
-- 잡 컬럼에 IDX_EMP_JOB이라는 인덱스를 생성
-- 1. 인덱스를 생성
-- 2. 셀렉문을 사용해서 인덱스를 사용하고 있는지 확인

# 인덱스 생성방식
CREATE INDEX IDX_EMP_JOB
ON EMP(JOB);

#오토트레이스 온
SET AUTOTRACE ON

# 인덱스 사용하고 있는지
SELECT EMPNO, ENAME, SAL, JOB
FROM EMP
WHERE JOB = 'MANAGER';

# 인덱스는 안녕하신지
SELECT INDEX_NAME, INDEX_TYPE, TABLE_NAME, UNIQUENESS
FROM USER_INDEXES;

INDEX_NAME    INDEX_TY TABLE_NAME                     UNIQUENES
------------- -------- ------------------------------ ---------
HW_CUST_ID_PK NORMAL   HW_CUST                        UNIQUE
EMP1_EMPNO_PK NORMAL   EMP1                           UNIQUE
PK_EMP        NORMAL   EMP                            UNIQUE
IDX_EMP_JOB   NORMAL   EMP                            NONUNIQUE   <<<<<<
IDX_EMP_ENAME NORMAL   EMP                            NONUNIQUE
SYS_C0011053  NORMAL   DEPT1                          UNIQUE
SYS_C0011054  NORMAL   DEPT1                          UNIQUE
PK_DEPT       NORMAL   DEPT                           UNIQUE

--------------------------------------------------------------------------------------

DROP INDEX IDX_EMP_JOB;

출력해보면 인덱스를 안쓰고 풀테이블스캔하는 모습을 볼 수 있음




-------------------------------------------------------------------------------------------
synonym동의어


CREATE synonym E1
FOR EMP;

관리자로 GRANT CREATE SYNONYM TO SCOTT;

-- SELECT * FROM EMP
-- SELECT * FROM E1;

E1이 EMP라는 테이블의 별칭임



-------------------------------------------------------------------------------------------


새로운 사용자 만들기

CREATE USER USER1
IDENTIFIED BY TIGER;

#만들고나서 유저에게 권한 설정해줘야 사용 가능함

CONNECT USER1/TIGER



PRIVILEGE
	1. SYSTEM PRIVILEGE : DB전체에 영향 (전권 소유자 : DBA)
		부여
		GRANT 권한 TO 사용자명;
			회수
		REVOKE 권한 FROM 사용자명;
	2. OBJECT PRIVILEGE : OBJECT에만 국한 (전권 소유자 : 오브젝트 만든놈(생성자))
		부여
			GRANT 권한 ON OBJECT명 TO 사용자명;
			(그 오브젝트에 뭔짓거릴 할 수 있는 권한을 사용자에게 준다는 소리)
		회수
			REVOKE 권한 ON OBJECT명 FROM 사용자명;

로그인은 1에 영향

DCL ( DATA CONTROL LANGUAGE ) : 권한을 컨트롤한다는 얘기임 (부여 회수)




GRANT CONNECT, RESOURCE TO USER1;
커넥트는 접속하고 관련된 권한(접속 )
리소스는 자원사용과 관련된 권한(테이블을 만든다던지)
유저1에게 줘보자

유저1로 로그인해도 테이블을 볼 수 없음


SELECT * FROM SCHEMA.EMP;SHO
SELECT * FROM SCOTT.EMP;		//요게 FM으로 쓴 것임
//스키마의 이름은 사용자와 같음
//스키마란 임의의 사용자가 생성한 모든 데이터베이스 객체들을 말하며,
//스키마 이름은 그 사용자의 이름과 같다.

오브젝트를 저장할 수 있는 도메인이 스키마
관점에 따라 외부스키마 내부스키마 개념스키마



GRANT SELECT ON EMP TO USER1; 유저 1에게 EMP테이블 셀렉할 수 있는 권한을 준 것임
다시 유저로 가서 SELECT * FROM SCOTT.EMP; 해보면 된다.

남의 테이블이면 SCOTT.EMP 일케 써야하지만 내꺼면 생략해서 EMP 일케 ㅇㅋ
-------------------------------------------------------------------------------------------

GRANT UPDATE
ON EMP
TO USER1;

USER1>UPDATE SCOTT.EMP
  2  SET SAL = 100;

된다.

REVOKE SELECT, UPDATE ON EMP FROM USER1;
이제 유저 1은 셀렉해서 쿼리로 정보를 읽을 수도 업데이트로 해당 테이블에 접근해서 데이터를 바꿀 수도 없음

-- 유저1의 커넥트 리소스 회수하기
REVOKE CONNECT, RESOURCE FROM USER1;



DDL : GRANT, REVOKE
GRANT 머시기 TO 저시기
REVOKE 머시기 TO 저시기
DDL, DCL 사용시 오토 COMMIT된다는 점을 기억하자.

CREATE USER USER2
IDENTIFIED BY TIGER
PASSWORD EXPIRE
ACCOUNT UNLOCK;









## 19-10-08 그래서 정리함







-------------------------------------------------------------------------------------------------
# 일반적인 분류
DML : SELECT, INSERT, UPDATE, DELETE
		일부에서는 DQL or QUERY : SELECT
DCL : COMMIT, ROLLBACK, GRANT, REVOKE
		일부에서는 TCL : COMMIT, ROLLBACK

# 수업에서의 정의
QUERY : SELECT
DML : INSERT, UPDATE, DELETED
TCL : COMMIT, ROLLBACK, SAVEPOINT
DDL : CREATE, ALTER, DROP, RENAME, TRUNCATE, COMMENT

-------------------------------------------------------------------------------------------------
# TABLE의 종류는 두가지가 있음
1. data dictionary (얘는 메타데이터를 담고 있는 테이블이다.)
2. user-define
data dictionary는 오라클 설치시 자동으로 만들어짐
오라클이 유지 관리하기 위해 사용하고 있음


// query : 질의어, 정보 수집에 대한 요청에 쓰이는 컴퓨터 언어임(ㅇㅎ)
// 보통 DML할 일은 없음 (DDL도 마찬가지일거 같은데) 이런거 많은 회사는 탈주 ㄱ


[팁] #
SET SQLPROMPT "_USER>"
_USER이 어떤 지정된 변수인가봄

-------------------------------------------------------------------------------------------------
# data dictionary 작명법
접두사 + 관심키워드 + 복수형

접두사
USER_ : 유저가 만든거와 관련된 정보    
ALL_ : 접근 권한이 있는 모든 것과 정보
DBA_ : DBA만 접근해야되는 정보
V$ : 동적, 성능과 관련된 정보
-------------------------------------------------------------------------------------------------
# OBJECT
- table
- index
- view
- senquence
- synonym

-------------------------------------------------------------------------------------------------
# View

-- View란? 물리적 테이블에 근거한 논리적 가상테이블의 역할
-- 보안목적으로 사용됨(해당 유저는 특정 영역만 볼 수 있게? 만들어봐야 알듯)
-- 조인 문장의 단순화
-- 이외에 여러가지 목적으로 쓰임
-- 많이 사용할 것을 권장함(성능의 향상을 위해)

// 내 생각. 그냥 포인터써서 보는거랑 같음 간접참조 개념인듯
(가상으로 만들어지는 테이블이라는 이름은 사실과 조금 다를지도 모르겠다고 생각함)
이름 그대로 정말로 view만을 위해서 만들어진 개념으로 보인다.
실제의 테이블을 비춰서 보여준다. 반사망원경 같다고 해야할까?

# 뷰의 개념적 동작(실제로는 다를 수도 있음)
SELECT *
FROM EMPVW30	<<<<--조회해보니 얘가 뷰다 싶으면
(EMPVW30) -> (SELECT EMPNO, ENAME, SAL, DEPTNO
		FROM EMP
		WHERE DEPTNO = 30)
이렇게 내부 동작이 이루어짐(서브쿼리 처럼, 포인터 간접 참조 처럼)
(뷰가 접근 주소 같은 역할인듯)

ex) 조인 문장의 단순화
CREATE VIEW EMP_DEPT
AS
SELECT E.ENAME, D.DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTN

ex) 뷰에 update를 갈겨버리면 비추고 있는 테이블 해당 자리의 데이터가 추가/수정 됨
UPDATE EMPVW30
SET SAL = 1250
WHERE ENAME = 'MARTIN'

ex) 아 맞다 역으로 탐색해서 끄집어냄, 뷰에 담긴 텍스트 조회임, 
USER_VIEWS에 TEXT 컬럼 말고 다른 애들도 많이 들어있음.(VIEW_NAME, TEXT)
TEXT를 강조하시던데 뭔가 이유라도 있는걸까
SELECT TEXT
FROM USER_VIEWS
WHERE VIEW_NAME='뷰이름'

// dict가 데이터딕셔너리 테이블인거 같은데

-------------------------------------------------------------------------------------------------
## 권한 주기
SHOW USER (현재누구)
GRANT CREATE VIEW TO SCOTT; (뷰만드는권한 부여)
//만들랬더니 일반 유저는 뷰 만들기 권한이 없었음


-- VIEW의 수정

-- CREATE TABLE 테이블명 .. ~~
-- ALTER TABLE, ~~~

-- CREATE VIEW 뷰명 ~~~
-- ALTER xxxxx

-- SELECT문의 변경 => 데이터딕셔너리


CREATE OR REPLACE VIEW임. alter view 따위는 없다.

-------------------------------------------------------------------------------------------------


# 심플뷰
AS 밑 서브쿼리 단순화
# 컴플렉스뷰
AS 밑에 JOIN, GROUP BY, HAVING이 오면

// 왜 이렇게 나눠서 보는 것?
// 왜? -> 흠.. 그냥 경우들을 묶어서 분류한 것 일 뿐인 듯

SIMPLE VIEW   |  COMPLEX VIEW
DML(O)        |  DML(될수도 안될수도)
업데이트 아까 해봤는데 됐음 ㅇㅋ, 컴플렉스뷰는 보장못함
// 컴플렉스뷰인경우 보장 못하는 이유는 뭐 multiple row function으로 묶어버리면 컬럼이 묶여버리고 join해버리면 키가 뒤섞이고 등등... 여러가지 이유에 의해 프로그램이 판단할 경우의 수가 많아져버리기 떄문인듯함. 그냥 케바케라서 시스템 프로그래머가 못 만들었다는 소리임.

# join해버렸을 때 뷰에 dml(insert, update, delete) 대부분 안됨
CREATE VEIW EMP_DEPT
AS
SELECT E.ENAME, D.NAME
FROM EMP E INNER JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;

# group도 마찬가지로 대부분 안됨
CREATE VIEW AVG_DEPTNO
AS
SELECT DEPTNO, AVG(SAL) AVGSAL
FROM EMP
GROUP BY DEPTNO;


-------------------------------------------------------------------------------------------------
DB의 제약조건에 대해서 말하려고 하시는듯
DB
- 무결성
- 동시성

// 데이터 트랜잭션 특성을 설명하려고 하시는듯 (이건 그냥 내 주석이다.)
// 데이터 베이스는 acid규칙을 만족하게 설계되었다.
// 원자성atomicity    : 하나 되면 다 되야지
// 일관성consistency : DB 무결성 조건을 만족해야함
// 고립성isolation     : 트랜잭션이 실행되는 동안 다른 트랜잭션이 그 트랜잭션에는 접근할 수 없다.
// 지속성durability    : 트랜잭션이 끝난 뒤에는 그 결과가 데이터베이스에 유지되어야함

//원자성 => 회복
//일관성 => 동시성 제어 => 무결성 제약조건
//고립성 => 동시성 제어
//지속성 => 회복

이 규칙을 지키면서 병행제어 하고 있다.


읽기 일관성
- A에서 커밋되기 전의 결과가 B에는 반영되지 않음. B는 A에서 변경한걸 볼 수가 없지

DML시 원본값들은 롤백 세그먼트(OR UNOB 세그먼트)에 저장됨
(트랜잭션, SAVEPOINT 같이)

-- 
LOCK은 트랜잭션간 상호 파괴적인 행위를 막기위한 오라클의 보호관리 메카니즘이래
흠 설명이 좀 ?
- 최소단위 지정 -> DML로 발생되는 락은 최소 단위가 ROW단위
- 자동으로 지정됨
-


-실습 상황1 (블로킹)
1. A에서 SCOTT의 월급을 200으로 설정
2. B에서 SCOTT의 월급을 100으로 설정
3. 이러면 락 상태로 A에서 결정을 내리기 전까지는 B에서는 대기
(한 쓰레드(?)가 자원을 독점하여 사용하기 떄문 , 일관성을 유지하기 위해서)
4. A에서 결정을 내리면 락이 풀리고 B에서도 업데이트가 된다.

Why? -> A에서 롤백 세그먼트 메모리 공간을 독점하고 있으므로 B는 대기 


//롤백 세그먼트
트랜잭션 진행시 그 이전 이미지를 기록하기 위해 사용되는 CIRCULAR구조의 세그먼트
프로세스가 데이터베이스의 데이터에 변경 할 때 이전 값을 저장하는데 사용된다고 함.
(레지스터에서 뭔가 담아뒀다가 꺼내 쓰는데 이거랑 비슷한 느낌인듯)


-실습 상황2 (row단위로 이루어짐)
1. A에서 SCOTT의 월급을 100으로
2. B에서 SMITH의 200으로 -> 다른 ROW면 락에 안 걸린다는 얘기를 하기 위해서
3. B에서 SCOTT의 200으로 -> 같은 ROW면 락에 걸린다는 걸 보여줌 

-실습 상황3 교착상태(DEADLOCK) 만들기 
1. A 스콧 월급 UPDATE
2. B 스밋 월급 UPDATE
3. A 스밋 월급 UPDATE - 락(B가 끝날때 까지 기다려야함)
4. B 스콧 월급 UPDATE - 락(A가 끝낼때 까지 기다려야함)
둘이서는 해결이 안됨


## 이 때의 오라클 동작
A의 마지막 명령 1개는 취소됨
//(B에서 데드락이 걸리는 행위를 하면 이를 프로그램이 판단하여
(에러나면 패킷 날려주는거 처럼) A의 마지막 명령을 취소시킨다고함)



Dead Lock 해결방법
- 시간마다 나눠서             ( TDM )
- 업무를 한쪽에 이관해버림 (한 쪽(프로세스)에 몰빵)



# constraint(제약조건)에 관한 설명
EMP                                                 DEPT
EMPNO    ENAME    SAL      DEPTNO  |   DEPTNO    DNAME    LOC
중복(X)  중복(O)                             :=            
NULL(X)  NULL(x)                           
primary    not      check         foreign key primary    unique
key         null                           참조


DEPTNO 중복 X, NULL X
DEPTNO(1,2,3,4) = DEPTNO(1,2,3,4)  <<5번 부서따위 있어선 안됨
DNAME 중복X, UNIQUE



무결성을 지키기위해
DML 할 때마다 제약조건을 만족하는지 검사하고
만족하면 실행, 아니면 실행안함


제약조건
1. 테이블 정의 시에
	1-1. 컬럼레벨 정의 방식
	  컬럼명 DATATYPE [CONSTRAINT 제약명] 제약종류
		[]로 제약에 이름을 줄 수 있음
		제약명을 생략했다면 제약에 이름이 없는 것이 아니라
		오라클이 제약명을 SYS_C숫자 형식으로 임의 부여
	1-2. 테이블 레벨 정의 방식
 		컬럼명 DATATYPE,
		컬럼명 DATATYPE,
		CONSTRAINT 제약명 제약종류(컬럼명),
		CONSTRAINT 제약명 제약종류(컬럼명),


ex) a. 테이블 생성시에 제약조건을 거는 방법. 
(2가지 방법. 1_ 한열에 전부 명시, 2_ 데이터형 정의 후 마지막에 명시(이는 복수컬럼 묶어 사용 가능)
CREATE TABLE EMP1
	(EMPNO NUMBER(4) CONSTRAINT EMP1_EMPNO_PK PRIMARY KEY,
	ENAME VARCHAR2(20) NOT NULL,
	SAL NUMBER(7,2),
	DEPTNO NUMBER(2),
	CONSTRAINT EMP1_SAL_CK CHECK(SAL BETWEEN 500 AND 5000),
	CONSTRAINT EMP1_DEPTNO_FK FOREIGN KEY(DEPTNO)
	REFERENCES DEPT1(DEPTNO));



## 내가 생성한 제약조건에 대한 정보 확인
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, SEARCH_CONDITION
FROM USER_CONSTRAINTS					<<-메타데이터(이 프로그램이 유지관리하기 위해서는 이 테이블의 컬럼을 참조하여 마구마구 사용하겠지)
WHERE TABLE_NAME IN ('EMP1', 'DEPT1')





CONSTRAINT_NAME                     C TABLE_   SEARCH_CONDITION (CHECK경우 제약조건은)
----------------------------------------   - ------   --------------------
SYS_C0011053(임의로 생성된 애들)  P DEPT1
SYS_C0011055                            C EMP1     "ENAME" IS NOT NULL
EMP1_SAL_CK                            C EMP1     SAL BETWEEN 500 AND 5000
EMP1_EMPNO_PK                       P EMP1
EMP1_DEPTNO_FK                      R EMP1     FOREIGN KEY
6 rows selected.


만드는 사람들이 이렇게 만들어 놓았다. 5개로 제약조건(pk, fk, u, r, check)로 각각 구별하고 
NOT NULL은 CHECK의 조건에 들어있는 특수한 경우로 만들어 두었다.





b. 테이블 생성 후에 추가하는 방법

ALTER TABLE 테이블명
ADD 테이블레벨정의방식(ex. 컬럼명 

ALTER TABLE DEPT1
ADD CONSTRAINT DEPT1_LOC_UK(라는제약) UNIQUE(라는 제약조건) (LOC);

LOC 같은 거 인서트하면 에러남
(제약이 유니크로 바꼇으니까)

ALTER TABLE DEPT1
DROP CONSTRAINT DEPT1_LOC_UK;



----------------------------------------------------------------------------------------------------


[팁] # 여기다가도 FROM 쓸 수 있다
DELETE [FROM] DEPT1
WHERE DEPTNO = 1;


----------------------------------------------------------------------------------------------------
# 포린키 실습. 줄여서 정리가 안된다. 일단 부모-자식 관계를 실습함.
자식은 부모를 레퍼런스하고 있으므로 부모의 컬럼에 속한 데이터를 따라야하며
부모는 자식을 남기고 삭제될 수 없음.

1,2번 부서 있다고 가정시
INSERT INTO EMP1 VALUES (2222, 'KILL', 3000, 999);
999번 부서는 없으니까

ORA-02291: integrity constraint (SCOTT.EMP1_DEPTNO_FK) violated - parent key
not found
부모? 이 에러는 레퍼런스하는 테이블에 없는 값이 있나봄

DEPT.DEPTNO 레퍼런스 되는 애 (parent, master)
EMP.DEPTNO 참조하는 애 (child, slave) 



## 참조하는애 있으면 부모는 못 없앰
SQL> SELECT * FROM EMP1;

     EMPNO ENAME                       SAL     DEPTNO
---------- -------------------- ---------- ----------
       111 HONG                       3000          1

SQL> SELECT * FROM DEPT1;

    DEPTNO DNAME                LOC
---------- -------------------- --------------------
         1 A                    B
         2 AA                   BB

SQL> DELETE FROM DEPT1
  2  WHERE DEPTNO = 1;
DELETE FROM DEPT1
*
ERROR at line 1:
ORA-02292: integrity constraint (SCOTT.EMP1_DEPTNO_FK) violated - child record
found


DROP TABLE EMP1 PURGE
#흘려넘기셈
레퍼런시스 딜릿 온 캐스케이드 옵션이 있음 함부로 만들지 마셈

----------------------------------------------------------------------------------------------------




[팁] #
이미 (추가하고자하는)제약을 위배중일시 그 제약을 추가할 수 없음



----------------------------------------------------------------------------------------------------
NOT NULL
UNIQUE 

1. NULL 추가 할 수 있을까? ㅇㅋ 당근 여러개도 당근 ㅇㅋ 
NULL을 중복체크할 생각은 못했네 당근 NULL은 할당, 비교, 연산이 안되므로 안됨







