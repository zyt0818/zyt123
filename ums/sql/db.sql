create sequence seq_profile;


create table profile(
     id number primary key,
     name varchar2(20 char) not null, 
     birthday varchar2(20 char)not null, 
     gender varchar2(4 char), 
     career varchar2(20 char), 
     address varchar2(50 char), 
     mobile varchar2(20 char)
)

insert into profile
select seq_profile.nextval,
dbms_random.string('l',dbms_random.value(5, 20)),
to_char(add_months(sysdate, dbms_random.value(12*18, 12*50) * -1), 'yyyy-MM-dd'),
decode(ceil(dbms_random.value(0, 2)), 1, '男', '女'),
decode(ceil(dbms_random.value(0, 6)), 1, '程序员', 2, '测试员', 3, '分析员', 4, '设计员', 5, '翻译员', '管理员'),
decode(ceil(dbms_random.value(0, 6)), 1, '湖南', 2, '湖北', 3, '广东', 4, '广西', 5, '北京', '上海'),
'180'||ceil(dbms_random.value(10000000,99999999)) from dual connect by level <= 1000;

select count(1) from  profile;
insert into profile values(seq_profile.nextval,'张三','1982-07-07','男','程序员','湖南','1234566');
insert into profile values(seq_profile.nextval,'张四','1982-07-07','男','程序员','湖南','1234566');
insert into profile values(seq_profile.nextval,'张五','1982-07-07','男','程序员','湖南','1234566');
insert into profile values(seq_profile.nextval,'张六','1982-07-07','男','程序员','湖南','1234566');

commit;

select * from profile;
select * from FilmType;
create sequence seq_FilmType start with 1001;