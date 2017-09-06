
create or replace function firstFunction6(a in number)
return number
as
c number;
begin 
if(c=1) then
 c:=1;
else
 c:=c*firstFunction6(a);
end if;
return c;
end;

declare
val number;
begin
val:=firstFunction6(5);
dbms_output.put_line(val);
end;