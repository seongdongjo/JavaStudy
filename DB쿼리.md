```
#)피벗테이블 

- Pivot 사용전
일단, 입학인원이 0명이라도 조회되어야 되기때문에 Outer join을 사용

select
    b.department_name,
    admission_year,
    if(admission_year is not null, sum(1), 0) as cnt
from
    student_table a
    right outer join department_table b
    on a.department_id = b.department_id
group by b.department_id, a.admission_year
order by admission_year
```

<img src="https://raw.githubusercontent.com/seongdongjo/JavaStudy/main/DB%EC%BF%BC%EB%A6%AC%EC%9D%B4%EB%AF%B8%EC%A7%80/1.PNG" width="650" height="200" /><br><br>

```
하지만 위와 같이 Group by 조건에 의해 연도에 없는 학과들은 조회가 안되거나,
같은 학과지만 연도가 달라 중복되어 보이게된다.

목표는 각학과별 연도별로 입학인원수를 조회하는 것이다.
피벗을 사용하면 아래와 같다.
```
<img src="https://raw.githubusercontent.com/seongdongjo/JavaStudy/main/DB%EC%BF%BC%EB%A6%AC%EC%9D%B4%EB%AF%B8%EC%A7%80/2.PNG" width="650" height="200" /><br><br>

```
#)Pivot 사용 후
- 먼저 학생테이블에서 학과별, 연도별로 수를 구한다.
select
    department_id, admission_year, count(1) as cnt
from student_table
group by department_id, admission_year
```
<img src="https://raw.githubusercontent.com/seongdongjo/JavaStudy/main/DB%EC%BF%BC%EB%A6%AC%EC%9D%B4%EB%AF%B8%EC%A7%80/3.PNG" width="650" height="200" /><br><br>

```
#) 피벗테이블을 만들때는 피벗의 컬림이 되어 줄 키가 필요하다
위 데이터에서는 admission_year(입학연도)가 해당 키가 된다.
해당 키를 통해서 피벗형태로 만들어주는 쿼리는 아래와 같다.

select
    b.department_name as '학과',
    max(if(a.admission_year = '2022', cnt, 0)) as '2022',
    max(if(a.admission_year = '2021', cnt, 0)) as '2021',
    max(if(a.admission_year = '2020', cnt, 0)) as '2020'
from
    (  //위에 데이터를 채우기 위한 쿼리
        select department_id, admission_year, sum(1) as cnt
        from student_table
        group by department_id, admission_year
    ) a
    right outer join department_table b
    on a.department_id = b.department_id
group by b.department_id;
```
<img src="https://raw.githubusercontent.com/seongdongjo/JavaStudy/main/DB%EC%BF%BC%EB%A6%AC%EC%9D%B4%EB%AF%B8%EC%A7%80/4.PNG" width="650" height="200" /><br><br>

```
- if문을 통해서 키와 동일한 컬럼을 세팅한다.
- 추가로 학과테이블과 조인을 함으로서 1명도 입학하지 않은 학과도 조회되도록 한다.
```

```
#)여러개 가능 
CONCAT(B.CNTR_SZ, '/', B.CNTR_TP, '/', B.CNTR_FE) AS CNTR_SZ_TP
````
<img src="https://raw.githubusercontent.com/seongdongjo/JavaStudy/main/DB%EC%BF%BC%EB%A6%AC%EC%9D%B4%EB%AF%B8%EC%A7%80/5.PNG" width="650" height="300" /><br><br>

```
아래는 예제로 쓰일 테이블이다.
```
<img src="https://raw.githubusercontent.com/seongdongjo/JavaStudy/main/DB%EC%BF%BC%EB%A6%AC%EC%9D%B4%EB%AF%B8%EC%A7%80/6.PNG" width="650" height="300" /><br><br>

```
#)Inner Join
Inner Join은 ON절과 함께 사용되며, ON절의 조건을 만족하는 데이터만을 가져온다.

> select * from reservation inner join customer on reservation.name = customer.name
아래쿼리도 같은 결과이다.
> select * from reservation join customer on reservation.name = customer.name
아래쿼리도 같은 결과이다.
> select * from reservation, customer where reservation.name = customer.name
mysql에서는 join,inner join, cross join 모두 같은의미이다.
```
<img src="https://raw.githubusercontent.com/seongdongjo/JavaStudy/main/DB%EC%BF%BC%EB%A6%AC%EC%9D%B4%EB%AF%B8%EC%A7%80/7.PNG" width="650" height="300" /><br><br>

```
#)LEFT JOIN
매칭되는 행이 없어도 결과에 포함시키고, 없는 경우 NULL로 표시

>select * from people AS p LEFT JOIN university as u ON p.ID = u.UID;
```
<img src="https://raw.githubusercontent.com/seongdongjo/JavaStudy/main/DB%EC%BF%BC%EB%A6%AC%EC%9D%B4%EB%AF%B8%EC%A7%80/8.PNG" width="650" height="300" /><br><br>

```
테이블을 보면 왼쪽테이블에는 ID가 6이 있고 오른쪽테이블에는 ID가 5만 있다.
근데 우리는 왼쪽테이블을 기준으로 했기때문에 왼쪽테이블은 일단 다 찍는다.

people 테이블의 ID가 6인 데이터도 university와 매칭되는게 없지만,
결과에 포함되었습니다.

그 이유는 LEFT JOIN 이기 떄문이다. 왼쪽테이블을 기준으로
```
```
#)RIGHT JOIN
매칭되는 행이 없어도 결과에 포함시키고, 없는 경우 NULL로 표시해준다.
오른쪽테이블 먼저 일단 다 찍어라.
> select * from people AS p RIGHT JOIN university u ON p.ID = u.UID;
```
<img src="https://raw.githubusercontent.com/seongdongjo/JavaStudy/main/DB%EC%BF%BC%EB%A6%AC%EC%9D%B4%EB%AF%B8%EC%A7%80/9.PNG" width="650" height="300" /><br><br>

```
#)unionall 사용  -> AS 로 컬럼이름 다 만들어놓고 UNION ALL을 통해 한줄씩 row를 붙여나간다 생각, 컬럼갯수가 일치해야함!!!

SELECT JIJUM, ORDER_NO, CNTR_NO, 
    IFNULL(CHARGE_AMT,0) AS PICKUP_CHARGE,  
	IFNULL(CLAIM_DIVI,'N') AS PICKUP_TAXYN,
    0 AS STORAGE_CHARGE, 'N' AS STORAGE_TAXYN,   
	0 AS CANCEL_CHARGE,  'N' AS CANCEL_TAXYN,
    0 AS WAITING_CHARGE, 'N' AS WAITING_TAXYN,   
    0 AS LOADING_CHARGE, 'N' AS LOADING_TAXYN,
    0 AS SHUTTLE_CHARGE, 'N' AS SHUTTLE_TAXYN,   
    0 AS W_SURCHARGE,    'N' AS W_SUR_TAXYN,
    0 AS C_SURCHARGE,    'N' AS C_SUR_TAXYN,    
    0 AS TANK_SURCHARGE, 'N' AS TANK_SUR_TAXYN,
    0 AS H_SURCHARGE,    'N' AS H_SUR_TAXYN,     
    0 AS REWORK_CHARGE,  'N' AS REWORK_TAXYN,
    0 AS EU_CHARGE,      'N' AS EU_TAXYN,       
    0 AS CC_CHARGE,      'N' AS CC_TAXYN,
    0 AS OTHER_CHARGE,   'N' AS OTHER_TAXYN
    FROM TRORDA
    WHERE JIJUM = '1'
    AND ORDER_NO = '120240523O0004'
    AND CHARGE_CODE = '01'  /* 선픽업비 */
    UNION ALL
        SELECT JIJUM, ORDER_NO, CNTR_NO,  0, 'N',  
        IFNULL(CHARGE_AMT,0) AS STORAGE_CHARGE, IFNULL(CLAIM_DIVI,'N') AS STORAGE_TAXYN,
        0, 'N',  0, 'N',  0, 'N',  0, 'N',  0, 'N',  0, 'N',  0, 'N',  0, 'N',  0, 'N',  0, 'N',  0, 'N',  0, 'N'
        FROM TRORDA
        WHERE JIJUM = '1'
        AND ORDER_NO = '120240523O0004'
        AND CHARGE_CODE = '02'  /* 보관료 */

        //밑에 캔슬비 등등 더 있는데 생략했다.
```
<img src="https://raw.githubusercontent.com/seongdongjo/JavaStudy/main/DB%EC%BF%BC%EB%A6%AC%EC%9D%B4%EB%AF%B8%EC%A7%80/10.PNG" width="650" height="300" /><br><br>

```
SELECT TRIM(BOTH FROM ' 2023.11.30(2023.11.30) ') FROM DUAL //좌우 공백제거


```