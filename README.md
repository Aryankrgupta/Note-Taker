# Note Taker

## Prerequisites

- Java Development Kit (JDK)
- Apache Tomcat Server
- MySQL Database
- Your favorite IDE (Eclipse, IntelliJ, etc.)

## MySQL Query for database
create table user_info(
	user_id int auto_increment primary key,
    user_name varchar(20) not null unique,
    password varchar(20) not null
);

create table note_info (
	note_id int auto_increment primary key,
    title text,
    note text,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id int not null,
    CONSTRAINT FK_user_id FOREIGN KEY (user_id)
    REFERENCES user_info(user_id)
);
