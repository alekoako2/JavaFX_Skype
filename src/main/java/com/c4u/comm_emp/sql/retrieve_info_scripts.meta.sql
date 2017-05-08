create or replace function loadhistory(id_user integer)
returns table (
  appointment_id integer,
  appointment_date date,
  massage_time varchar(10),
  massage_comment varchar(500),
  massage_paid boolean,
  massage_duration varchar(10),
  planner_title varchar(50), 
  planner_time varchar(10),
  planner_duration varchar(10),
  planner_notes varchar(800),
  menu_ids integer[],
  menu_names text[],
  menu_individual_price double precision[],
  menu_items_quantity integer[], 
  total_price double precision
)
as $$

begin 
return query
select
a.app_id, a.date_time, m.time, m.mass_comment, m.paid, m.duration, p.plan_title, p.plan_time, p.plan_duration, p.plan_notes, array_agg(me.menu_id), array_agg(f.menu_name), array_agg(f.price), array_agg(me.quantity),  sum(f.price*me.quantity)  from appointments a full join massage_appointments m on a.app_id=m.app_id full join planner p on p.app_id=a.app_id full join orders o on o.app_id=a.app_id full join menu_to_order me on me.order_id=o.order_id  full join menu f on f.menu_id=me.menu_id
group by a.app_id, m.time, m.paid, m.mass_comment, m.duration, p.plan_time, p.plan_duration, p.plan_notes, p.plan_title, a.date_time;
end;
$$language plpgsql;

create or replace function testval(username varchar(40), passphrase varchar(40))
returns my_new_type as 
$BODY$
declare
   rec my_new_type;
begin
select (pass_phrase=passphrase) into rec.validation_result from users where email=username;
select user_id into rec.id_of_user from users where email=username;
select user_type into rec.type_user from users where email=username;
return rec;
end;
$BODY$
language plpgsql;
