create database petpals;
use petpals;
CREATE TABLE pet (
    name VARCHAR(100),
    age INT,
    breed VARCHAR(100)
);
create table donations(
donor_name varchar(100),
 amount INT
 );
 create table participants
 ( participant_name varchar(100),
   event_name varchar(100)
   );
   create table adoption_events(
   event_id int,
   event_name varchar(100),
   event_date date
   );