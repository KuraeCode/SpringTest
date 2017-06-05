create table contact
(
	ID int not null auto_increment,
	FIRST_NAME varchar(60) not null,
	LAST_NAME varchar(40) not null,
	BIRTH_DATE date,
	unique UQ_CONTACT_1 (FIRST_NAME, LAST_NAME),
	PRIMARY KEY (ID)
);
create table contact_tel_detail
(
	ID int not null auto_increment,
	CONTACT_ID int not null,
	TEL_TYPE varchar(20) not null,
	TEL_NUMBER varchar(20) not null,
	unique UQ_CONTACT_TEL_DETAIL_1 (CONTACT_ID, TEL_TYPE),
	PRIMARY KEY (ID),
	constraint FK_CONTACT_TEL_DETAIL_1 foreign key (CONTACT_ID) references contact (ID)
);

