create or replace function changePassword(username varchar(40), password varchar(20))
RETURNS void AS $$
begin
  update users set pass_phrase=password where email=username;
end;
$$ language plpgsql