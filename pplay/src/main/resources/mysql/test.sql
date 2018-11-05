/*create database yimengweimagame;*/
use  yimengweimagame;
DROP TABLE IF EXISTS User;
/*设置安全模式为0（解除安全模式）*/
set sql_safe_updates=0;
CREATE TABLE IF NOT EXISTS User(
   `id` INT not null AUTO_INCREMENT,
   `name` VARCHAR(100) NOT NULL,
   `account` VARCHAR(50) NOT NULL,
   `password` varchar(50) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into User(name,account,password)values('姜成骅','morenbo','123456');
update User as u set u.password='0a2dba520f707233a079f25a51c1da6f' where u.name='姜成骅';