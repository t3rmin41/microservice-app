SET statement_timeout = 0;

SET lock_timeout = 0;

SET client_encoding = 'UTF8';

SET standard_conforming_strings = on;

SET check_function_bodies = false;

SET client_min_messages = warning;

SET row_security = off;

CREATE SEQUENCE car_sequence START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

ALTER TABLE car_sequence OWNER TO postgres;

CREATE TABLE public.cars (car_id bigint NOT NULL DEFAULT NEXTVAL('car_sequence'), model character varying(255), manufacturer character varying(255),  price double precision, CONSTRAINT car_primarykey PRIMARY KEY (car_id)) WITH (OIDS=FALSE );

ALTER TABLE public.cars OWNER TO postgres;

INSERT INTO public.cars (car_id, model, manufacturer, price) VALUES (nextval('car_sequence'), 'Land Cruiser', 'Toyota', 12111.88);

