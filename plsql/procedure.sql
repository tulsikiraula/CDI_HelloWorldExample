create or replace procedure message
as 
begin
dbms_output.put_line('this is my first procedure');
end;


--execute the created procedure
execute message;

--execute the created procedure from plsql block

begin
message;
end;

