1. 테스트 전용 계정을 생성 한다. ( ID: TEST_ACCOUNT PW: TIGER )
conn system/ORACLE
CREATE USER TEST_ACCOUNT
IDENTIFIED BY TIGER;

2. DB에 LOGIN 가능하게 권한을 부여 한다.
GRANT CONNECT, RESOURCE TO TEST_ACCOUNT;

3. 사원이름과 직업, 급여, 급여등급 을 출력하라?

TEST_ACCOUNT>>

GRANT SELECT ON SCOTT.EMP TO TEST_ACCOUNT;  
GRANT SELECT ON SCOTT.SALGRADE TO TEST_ACCOUNT; 

SELECT ENAME, JOB, SAL, GRADE
FROM SCOTT.EMP INNER JOIN SCOTT.SALGRADE
ON SAL BETWEEN LOSAL AND HISAL;

4. 20 번 부서의 사원들과 같은 월급을 받는 사원들의 이름과 월급과 부서번호를 출력하라
SELECT SAL
FROM SCOTT.EMP
WHERE DEPTNO = 20

SELECT ENAME, SAL, DEPTNO
FROM SCOTT.EMP
WHERE SAL IN (SELECT SAL
              FROM SCOTT.EMP
              WHERE DEPTNO = 20)
AND DEPTNO != 20;

5. 이름에  T  를 포함하고 있는 사원들과  동일한 부서에서 근무하고 있는 사원의 사원 번호와 이름을  출력하라

SELECT EMPNO, ENAME
FROM SCOTT.EMP
WHERE DEPTNO = (SELECT DEPTNO
                FROM SCOTT.EMP
                WHERE ENAME LIKE '%T%');

6. BLAKE 이란 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하라(SUBQUERY와 JOIN 두가지 방법 모두 기술)

SELECT ENAME, HIREDATE
FROM EMP
WHERE HIREDATE > (SELECT HIREDATE
                FROM EMP
                WHERE ENAME = 'BLAKE');


SELECT E.ENAME, E.HIREDATE
FROM EMP E INNER JOIN EMP C
ON E.HIREDATE > C.HIREDATE
AND C.ENAME = 'BLAKE';

7. TEST_ACCOUNT 계정에 테이블을 생성하고 이 테이블에 SELECT, UPDATE 
할수 있는 권한을 SCOTT에 부여 한다. 

SYS>>
--RESOURCE에 CREATE SESSION, CREATE TABLE, DROP ANY TABLE 권한이 들어있으므로
--GRANT CREATE TABLE TO TEST_ACCOUNT는 생략 가능
--위에서 이미 GRANT RESOURCE TO TEST_ACCOUNT 해줬음.
TEST_ACCOUNT>>
CREATE TABLE HW_TABLE(
    NO NUMBER(2),
    MSG VARCHAR2(20));
TEST_ACCOUNT or SYSDBA>>
GRANT SELECT, UPDATE ON TEST_ACCOUNT.HW_TABLE TO SCOTT;

   SQL> DESC USERDATA
 이름           널?         유형
 ------------  --------  ---------------------------
 NO                       NUMBER(2)
 MSG                      VARCHAR2(20)

8. SCOTT계정에서  EMP 테이블을 복사한 COPY_EMP5  생성하라
CREATE TABLE COPY_EMP5
AS
SELECT *
FROM EMP;


9. COPY_EMP5 테이블 10번 부서사원들의 사번 이름 급여 부서번호만 
볼수 있는 CEMP5 뷰를 생성하시오.
CREATE VIEW CEMP5
AS
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM COPY_EMP5
WHERE DEPTNO = 10;

10. 이 VIEW를 SELECT할수 있는 권한을 TEST_ACCOUNT에 부여하시오.
GRANT SELECT ON CEMP5 TO TEST_ACCOUNT;

11. TEST_ACCOUNT에서 CEMP5를 통해서 데이터 접근이 가능한지 SELECT 해보세요.
SELECT *
FROM SCOTT.CEMP5;

뷰도 오브젝트이기 때문에 오브젝트에 대한 권한을 가지고 있어야 접근이 가능할 것이다.
10번에서 VEMP5 오브젝트에 대해 SELECT할 수 있는 권한을 주었으므로 가능하다.



