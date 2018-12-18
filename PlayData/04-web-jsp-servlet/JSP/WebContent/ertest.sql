
/* Drop Tables */

DROP TABLE Customer CASCADE CONSTRAINTS;
DROP TABLE department CASCADE CONSTRAINTS;
DROP TABLE locations CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE Customer
(
	id varchar2(4) NOT NULL,
	name varchar2(30) NOT NULL,
	age number(3,0),
	tel varchar2(30) UNIQUE,
	dep_no number(3,0) NOT NULL,
	location_id number(4,0) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE department
(
	dep_no number(3,0) NOT NULL,
	dep_name varchar2(30),
	PRIMARY KEY (dep_no)
);


CREATE TABLE locations
(
	location_id number(4,0) NOT NULL,
	location_name varchar2(30),
	PRIMARY KEY (location_id)
);



/* Create Foreign Keys */

ALTER TABLE Customer
	ADD FOREIGN KEY (dep_no)
	REFERENCES department (dep_no)
;


ALTER TABLE Customer
	ADD FOREIGN KEY (location_id)
	REFERENCES locations (location_id)
;



