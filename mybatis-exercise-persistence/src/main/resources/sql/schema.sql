CREATE TABLE users (
  	user_id INTEGER  GENERATED BY DEFAULT AS IDENTITY(start with 1000, increment by 1) NOT NULL,
  	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
   	email_address VARCHAR(50) NOT NULL UNIQUE,
   	birth_date Date NOT NULL,
	cre_ts TIMESTAMP NOT NULL,
	mod_ts TIMESTAMP NOT NULL,
	version INTEGER NOT NULL,
   	PRIMARY KEY (user_id)
);

CREATE TABLE territories (
  	territory_id INTEGER NOT NULL,
  	country_name VARCHAR(30) NOT NULL,
	nr_balls_per_day INTEGER NOT NULL,
   	nr_balls_per_campaign  INTEGER NOT NULL,
   	vinning_rate INTEGER NOT null,
	cre_ts TIMESTAMP NOT NULL,
	mod_ts TIMESTAMP NOT NULL,
	version INTEGER NOT NULL,
   	PRIMARY KEY (territory_id)
);

CREATE TABLE coupon_registration (
  	registration_id  INTEGER GENERATED BY DEFAULT AS IDENTITY(start with 1000, increment by 1) NOT NULL,
  	coupon_code VARCHAR(20) NOT NULL UNIQUE,
	winner CHAR(1),
   	user_id INTEGER NOT NULL,
   	territory_id  INTEGER NOT null,
   	submission_ts TIMESTAMP NOT NULL,
	cre_ts TIMESTAMP NOT NULL,
	mod_ts TIMESTAMP NOT NULL,
	version INTEGER NOT NULL,
   	PRIMARY KEY (registration_id)
);

CREATE TABLE daily_statistics (
  	daily_statistic_id INTEGER GENERATED BY DEFAULT AS IDENTITY(start with 1000, increment by 1) NOT NULL,
  	statistic_day CHAR(10) NOT NULL UNIQUE,
  	daily_count INTEGER NOT NULL,
	cre_ts TIMESTAMP NOT NULL,
	mod_ts TIMESTAMP NOT NULL,
	version INTEGER NOT NULL,
   	PRIMARY KEY (daily_statistic_id)
);

ALTER TABLE coupon_registration
ADD FOREIGN KEY (user_id) 
REFERENCES users(user_id);

ALTER TABLE coupon_registration
ADD FOREIGN KEY (territory_id) 
REFERENCES territories(territory_id);



