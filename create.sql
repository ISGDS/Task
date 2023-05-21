create table event_descriptor (type_id integer not null, subclass_id integer, subclass_name varchar(255), type_name varchar(255), primary key (type_id)) engine=InnoDB
create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
create table markets_entity (id bigint not null, action varchar(255), betting_status varchar(255), display bit, display_order integer, in_running bit, isbirtransition bit, max_accumulator integer, min_accumulator integer, name varchar(255), offered_in_running bit, resulted bit, sort varchar(255), type_id integer, type_link_id integer, language_id bigint not null, primary key (id)) engine=InnoDB
create table participants_entity (id bigint not null, label varchar(255), name varchar(255), language_id bigint not null, primary key (id)) engine=InnoDB
create table selections_entity (id bigint not null, action varchar(255), betting_status varchar(255), characteristic bit, display bit, display_order integer, name varchar(255), participant_key bit, price_denominator bit, price_numerator integer, language_id bigint not null, primary key (id)) engine=InnoDB
alter table markets_entity add constraint FK2o7ipf5q2id0dnwkba822mn9k foreign key (language_id) references markets_entity (id)
alter table participants_entity add constraint FK1uiv46h82dk8myvvam7u6cvqt foreign key (language_id) references markets_entity (id)
alter table selections_entity add constraint FKo20kektyrjjg8vq69pdkwgcaf foreign key (language_id) references markets_entity (id)
