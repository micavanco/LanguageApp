create table if not exists User (
  user_id integer not null primary key,
  username varchar(25) not null,
  password varchar(25) not null,
  name varchar(50) not null,
  surname varchar(50) not null,
  city varchar(25) not null,
  createdAt timestamp not null,
  points integer
);

create table if not exists Languages (
  lang_id integer not null primary key,
  question varchar(255) not null,
  answer varchar(255) not null,
  language varchar(25) not null,
  questionNumber integer not null
);

create table if not exists Sessions (
  session_id integer not null primary key,
  user_id integer not null,
  lang_id integer not null,
  foreign key (user_id) references User(user_id),
  foreign key (lang_id) references Languages(lang_id),
  points integer not null
);