insert into customer values(2,'Neha',600);


declare
c_id customer.id%type;
c_name customer.name%type;
c_salary customer.salary%type;

cursor cust_cursor is select id,name,salary from customer;
begin
open cust_cursor;
loop
fetch cust_cursor into c_id,c_name,c_salary;
exit when cust_cursor%notfound;
dbms_output.put_line(c_id||c_name||c_salary);

end loop;
close cust_cursor;
end;
