create table if not exists User (
  id varchar(4) not null,
  username varchar(25) not null,
  password varchar(25) not null,
  name varchar(50) not null,
  surname varchar(50) not null,
  city varchar(25) not null,
  createdAt timestamp not null,
  points integer
);