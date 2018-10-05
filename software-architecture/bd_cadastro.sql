create database bd_cadastro;
use bd_cadastro;

create table if not exists `bd_cadastro`.`Customer`(
	`id_customer` int not null,
    `id_country` int not null,
	`name_user` varchar(40) not null,
	`phone` varchar(40) not null,
    `age` int not null,
    `creditLimit` double,
    primary key (`id_customer`),
    CONSTRAINT `fk_Customer_Country`
    FOREIGN KEY (`id_country`)
    REFERENCES `bd_cadastro`.`Country` (`id_country`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
 
)

create table if not exists `bd_cadastro`.`Country`(
	`id_country` int not null,
	`name` varchar(40) not null,
	`acronym` varchar(5) not null,
    `phoneDigits` int not null,
	primary key (`id_country`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

 SELECT * FROM bd_cadastro.Country;
  SELECT name FROM bd_cadastro.Country;
 select * from bd_cadastro.Customer;
 TRUNCATE TABLE bd_cadastro;
 DELETE FROM bd_cadastro.Country WHERE id = 1;
  DELETE FROM bd_cadastro.Customer WHERE id = 1;
  SELECT id, name_user,phone,age,creditLimit,name FROM Country JOIN Customer USING (id)
  SELECT * FROM bd_cadastro.Country JOIN bd_cadastro.Customer USING (id);
  SELECT id, name_user,phone,age,creditLimit,name,phoneDigits FROM Country JOIN Customer USING (id)
  SELECT id, name_user,phone,age,creditLimit,name,phoneDigits FROM Country JOIN Customer USING (id)
  INSERT INTO bd_cadastro.Customer VALUES('2','1','Vinicius','159','25','200')
  UPDATE bd_cadastro.Customer SET id_customer='3',id_country='1', name_user='Juan',  phone='788', age='22',creditLimit='100' WHERE id_customer='3'
    UPDATE bd_cadastro.Customer SET id='3', name_user='Thalita',  phone='741', age='22',creditLimit='100' WHERE name_user='ricardo'
    SELECT id_customer,id_country ,name_user,phone,age,creditLimit,name,phoneDigits FROM Country JOIN Customer USING (id_country)