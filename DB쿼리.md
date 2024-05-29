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


