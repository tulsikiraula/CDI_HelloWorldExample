DECLARE 
   message  varchar2(20):=' "ekrerjerjrke"'; 
BEGIN 
   dbms_output.put_line(message); 
END; 

DECLARE 
   SUBTYPE name IS char(20); 
   SUBTYPE message IS varchar2(100); 
   salutation name; 
   greetings message; 
BEGIN 
   salutation := 'Reader '; 
   greetings := 'Welcome to the World of PL/SQL'; 
   dbms_output.put_line('Hello ' || salutation || greetings); 
END;

SET SERVEROUTPUT OFF;


DECLARE 
name1 char(13) DEFAULT 'Tulsi kiraula';
a integer:=20;
b integer:=20;
c integer;
BEGIN
name1:='hello';
dbms_output.put_line(name1);
c:=a+b;
dbms_output.put_line('value of c is' || c);
Declare
d int:=50;
begin
if(c=d)
then
dbms_output.put_line('Both numbers are equals');
elsif(d=30)
then
dbms_output.put_line('value of d is ' || d);
else 
dbms_output.put_line('no are not equal ');
end if;
end;
END;
