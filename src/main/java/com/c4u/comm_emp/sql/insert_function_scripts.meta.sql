create or replace function addappointment(id_user integer, time_date date)
returns integer as $$
declare temp_id integer;
begin 
  insert into appointments(user_id, date_time) values(id_user, time_date);
  select app_id into temp_id from appointments where user_id=id_user and date_time=time_date;
return temp_id;
end;
$$language plpgsql;

create or replace function addcities(id_country integer) 
returns table(city_name varchar(40)) as
$BODY$   
  select ci.city_name from cities ci where country_id=id_country order by city_name;
$BODY$
LANGUAGE sql;

create or replace function addcountries()
returns TABLE(country_name varchar(40), country_id integer) as
$BODY$   
  select c.country_name, c.country_id from countries c order by c.country_name;
$BODY$
LANGUAGE sql;

create or replace function check_app_id(id_user integer, time_date date)
returns integer as $$
declare temp_id integer;
begin
select app_id into temp_id from appointments where user_id=id_user and date_time=time_date;
  IF
    temp_id is null THEN
    perform addappointment(id_user, time_date);
    select app_id into temp_id from appointments where user_id=id_user and     date_time=time_date;
  end IF;
  return temp_id;
end;
$$language plpgsql;

create or replace function check_massage_app(id_user integer, time_date date)
returns boolean as $$
declare temp_id integer;
         exists boolean;
begin
select m.app_id into temp_id from massage_appointments m inner join appointments a on a.app_id=m.app_id where user_id=id_user and date_time=time_date;
 if temp_id is not null then 
  exists:=true;
 else exists:=false; end if;
 return exists;
end;
$$langauge plpgsql;


create or replace function check_menu_app(id_user integer, time_date date)
returns boolean as $$
declare temp_id integer;
         exists boolean;
begin
  select m.app_id into temp_id from orders m inner join appointments a on a.app_id=m.app_id where user_id=id_user and date_time=time_date;
 if temp_id is not null then 
  exists:=true;
 else exists:=false; end if;
 return exists;
end;
$$langauge plpgsql;
 
create or replace function check_planner_app(id_user integer, time_date date)
returns boolean as $$
declare temp_id integer;
         exists boolean;
begin
  select p.app_id into temp_id from planner p inner join appointments a on a.app_id=p.app_id where user_id=id_user and date_time=time_date;
 if temp_id is not null then 
  exists:=true;
 else exists:=false; end if;
 return exists;
end;
$$langauge plpgsql;


create or replace function insert_menu_id(menu_ids integer[])
returns void as$$
begin
  insert into menu_to_order(menu_id) (select t.i from unnest(menu_ids) as t(i));
end;
$$language plpgsql;

create or replace function set_food_order(id_user integer, appp_id integer)
returns text as $$
declare food_ids_string varchar(20);
begin
  select array_to_string(array_agg(food_id), ',') into food_ids_string from food_orders where users_id = id_user and app_id = appp_id;
return food_ids_string;
end;
$$language plpgsql


create or replace function set_massage_appointment(id_user integer, time_date date, hour time without time zone, ispaid boolean, massage_comment varchar(500), mass_provider varchar(20), mass_duration varchar(10))
returns void AS $$
begin
  insert into massage_appointments(time,paid,mass_comment, provider, duration, app_id) values(hour,ispaid,massage_comment, mass_provider, mass_duration, (select app_id from appointments where user_id=id_user AND date_time=time_date));
end;
$$LANGUAGE plpgsql;

create or replace function set_plan(id_user integer, time_date date, planner_title varchar(50), planner_time varchar(10), planner_duration varchar(10), planner_note varchar(800))
returns void as $$
begin 
  insert into planner(plan_title, plan_time, plan_duration, plan_notes, app_id) values(planner_title, planner_time, planner_duration, planner_note, (select app_id from appointments where user_id=id_user AND date_time=time_date));
end;
$$LANGUAGE plpgsql;


create or replace function set_menu(id_user integer, time_date date, id_food integer)
returns void as $$
begin
  insert into food_orders(users_id, foods_id, app_id, food_name) values(id_user, id_food, (select app_id from appointments where user_id=id_user and date_time=time_date), (select menu_name from food where menu_id=foods_id));
end;
$$language plpgsql;








