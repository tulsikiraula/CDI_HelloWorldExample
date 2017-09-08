create or replace function updateSalary(id in number)
return number
as
sal  number;
begin
update employee set salary=5000 where id=id;
select salary into sal from employee where id=id;
return sal;
commit;
end;
