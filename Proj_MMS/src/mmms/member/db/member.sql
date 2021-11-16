create table mms_member(
if number primary key,
name varchar2(12) not null unique,
addr varchar2(50) not null,
nation varchar2(12) not null,
email varchar2(30) not null,
age number
);

create sequence mms_mamber_id_seq;
