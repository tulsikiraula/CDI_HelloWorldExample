create or replace procedure message
as 
begin
dbms_output.put_line('this is my first procedure');
end;


--execute the created procedure
--execute message;

--execute the created procedure from plsql block

--begin
--message;
--end;

create or replace 
PROCEDURE UPDATEEMPLOYEENAME(id in number , name in varchar2 , salary in number) IS 
BEGIN
insert into employee values (id,name,salary);
END UPDATEEMPLOYEENAME;



 
create or replace procedure getEmployeeDetails(id in Employee.id%type , result out varchar2) Is
begin
	declare
	cursor employee_cursor is select name from employee where id = id;
	begin
		open employee_cursor;
		fetch employee_cursor into result;
		close employee_cursor;
	end 
	result := result;
end getEmployeeDetails;

