create table email(
      id int not null primary key,
      address varchar_ignorecase(50) not null,
      description varchar_ignorecase(50) not null,
      date DATE );
