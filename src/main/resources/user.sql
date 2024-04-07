create database testdb99;
use testdb99;

create table user (
    u_id int primary key auto_increment,
    u_name varchar(255),
    u_age varchar(255),
    u_sex varchar(255),
    u_phone varchar(255),
    u_birth varchar(255),
    u_hobbies varchar(255),
    u_money int
);

insert into user (u_name, u_age, u_sex, u_phone, u_birth, u_hobbies, u_money)
values ('张三', '20', '男', '1234567890', '1990-01-01', '篮球,足球', 2000),
       ('李四', '25', '女', '9876543210', '1995-01-01', '唱歌,跳舞', 2000),
       ('王五', '30', '男', '5555555555', '1990-01-01', '篮球,游泳', 2000),
       ('赵六', '35', '女', '6666666666', '1985-01-01', '阅读,旅行', 2000),
       ('钱七', '40', '男', '7777777777', '1990-01-01', '篮球,跑步', 2000);
