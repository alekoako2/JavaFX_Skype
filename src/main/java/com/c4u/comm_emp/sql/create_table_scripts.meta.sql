create table appointments(
  user_id integer,
  date_time date,
  app_id serial
);

create table cities( 
  city_name varchar(40),
  country_id integer, 
  city_id integer
);

create table countries (
  country_id serial,
  country_name varchar(40) not null, 
  constraint country_pk primary key(country_id)
);

create table massage_appointments(
time time without time zone, 
  paid boolean, 
  mass_comment varchar(500), 
  app_id integer,
  provider varchar(20),
  duration varchar(10),
  mass_id serial
);

create table menu(
  menu_id integer,
  price double precision,
  directory text, 
  menu_name text
);

create table menu_to_order( 
  menu_id INTEGER REFERENCES menu(menu_id) ON UPDATE CASCADE ON DELETE CASCADE,
  order_id INTEGER REFERENCES orders(order_id) ON UPDATE CASCADE ON DELETE CASCADE
);

create table orders(
  order_id serial, 
  app_id integer
);

create table organizations(
  organization_id integer not null,
  organization_name varchar(50) not null,
  constraint org_pk primary key (organization_id)
);

create table planner(
  plan_title varchar(50), 
  plan_time varchar(10), 
  plan_duration varchar(10), 
  plan_notes varchar(800),
  app_id integer, 
  plan_id serial,
  constraint plan_pk_key primary key(plan_id)
);

create table users(
  user_id serial, 
  first_name varchar(40) not null, 
  last_name varchar(40) not null, 
  email varchar(50) not null, 
  pass_phrase varchar(40) not null, 
  country varchar(40) not null, 
  city varchar(40) not null, 
  address varchar(60) not null,
  date_time date, 
  title boolean,
  organization varchar(50),
  user_type varchar(50)
  constraint pk_key primary key (user_id)
);

create table users_to_orgs (
  users_id INTEGER REFERENCES users(user_id) ON UPDATE CASCADE ON DELETE CASCADE,
  org_id INTEGER REFERENCES organizations(organization_id) ON UPDATE CASCADE ON DELETE CASCADE,
  primary key (users_id, org_id)
);

CREATE TYPE my_new_type AS (
validation_result boolean,
id_of_user integer,
  type_of_user text
);


