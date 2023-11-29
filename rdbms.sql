-- Select unique job from EMP table. 
SELECT DISTINCT deptno,job FROM emp ;

-- List the details of the emps in asc order of the Dptnos and desc of Jobs?
SELECT * FROM emp ORDER BY deptno ASC,job DESC;
         
-- Display all the unique job groups in the descending order?         
SELECT DISTINCT job FROM emp ORDER BY job DESC;

-- List the emps who joined before 1981.
SELECT * FROM emp WHERE hiredate<('1981-1-1');

-- List the Empno, Ename, Sal, Daily sal of all emps in the asc order of Annsal
select Empno ,ename ,sal,sal/30,12*sal annsal from emp order by annsal asc;

-- List the Empno, Ename, Sal, Exp of all emps working for Mgr 7369
select Empno,ename,sal from emp where mgr = 7369;

-- Display all the details of the emps who’s Comm. Is more than their Sal?
SELECT * FROM emp WHERE comm>sal;

-- List the emps who are either ‘CLERK’ or ‘ANALYST’ in the Desc order. 
SELECT * FROM emp WHERE job='CLERK' OR job='ANALYST' ORDER BY job DESC;

-- List the emps Who Annual sal ranging from 22000 and 45000.
SELECT * FROM emp WHERE 12*sal BETWEEN 24000 AND 50000;

-- List the Enames those are starting with ‘S’ and with five characters. 
 SELECT  *  FROM emp WHERE ename like 'S%';

-- List the emps whose Empno not starting with digit78. 
SELECT  * from emp WHERE Empno not like '78%';

-- List all the Clerks of Deptno 20. 
SELECT * FROM emp WHERE job ='CLERK' AND deptno = 20;

-- List the Emps of Deptno 20 who’s Jobs are same as Deptno10.
select * from emp where deptno=20 and job in ( select distinct job from emp where deptno=10);

-- List the Emps who’s Sal is same as FORD or SMITH in desc order of Sal.
SELECT * FROM emp WHERE sal IN (SELECT sal FROM emp e WHERE e.ename IN ('FORD','SMITH') AND emp.Empno <> e.Empno);

-- Find the highest sal of EMP table.  
SELECT * FROM emp WHERE sal IN (SELECT max(sal) FROM emp);

-- List the emps whose jobs same as SMITH or ALLEN
select * from emp where job in (select job from emp e where e.ename in ('SMITH','ALLEN') and emp.Empno <> e.Empno);

-- Find the total sal given to the MGR
SELECT sum(sal) FROM emp WHERE job = 'MANAGER';

-- List the emps whose names contains ‘A’. 
SELECT * FROM emp WHERE ename LIKE '%A%';

-- Find all the emps who earn the minimum Salary for each job wise in ascending order. 
SELECT * FROM emp WHERE sal IN (SELECT min(sal) FROM emp GROUP BY job) ORDER BY sal ASC;

-- List the emps whose sal greater than Blake’s sal. 
SELECT * FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename = 'BLAKE');


