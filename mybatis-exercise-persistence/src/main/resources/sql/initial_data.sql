insert into users(first_name, last_name,email_address, birth_date)
values('Jakab','Gipsz','jakab@gipsz.hu','1982-01-01');

insert into users(first_name, last_name,email_address,birth_date)
values('Michael','Brems','michael@brems.de','1978-12-12');

insert into territories(territory_id,country_name, nr_balls_per_day,nr_balls_per_campaign,vinning_rate)
values(1000,'Hungary',100,5000,80);

insert into territories(territory_id,country_name, nr_balls_per_day,nr_balls_per_campaign,vinning_rate)
values(1001,'Germany',250,10000,40);

insert into coupon_registration(coupon_code, winner,user_id,territory_id, submission_ts)
values('12345678900','N',1000,1000,current_timestamp);

insert into coupon_registration(coupon_code, winner,user_id,territory_id,submission_ts)
values('98765432100','N',1001,1001,current_timestamp);

insert into coupon_registration(coupon_code, winner,user_id,territory_id,submission_ts)
values('98765432101','N',1000,1000,current_timestamp);


