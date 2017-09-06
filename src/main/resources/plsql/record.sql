
---cursor record------
declare
cust_record1 customer%rowtype;
cursor c_customer is select id,name,salary from customer where id=3;
begin
open c_customer;
fetch c_customer into cust_record1;
dbms_output.put_line(cust_record1.id);
dbms_output.put_line(cust_record1.name);
dbms_output.put_line(cust_record1.salary);
close c_customer;
end;

----user defined record------
declare
type user_record is record(
title varchar2(20),
author varchar2(20),
price number);

u1 user_record;
u2 user_record;
begin
u1.title :='java';
u1.author:='complet';
u1.price:=100;

dbms_output.put_line(u1.title||u1.price||u1.author);
end;












