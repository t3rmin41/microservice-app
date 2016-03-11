SET statement_timeout = 0;

SET lock_timeout = 0;

SET client_encoding = 'UTF8';

SET standard_conforming_strings = on;

SET check_function_bodies = false;

SET client_min_messages = warning;

SET row_security = off;

CREATE TABLE public.buses (bus_id bigint NOT NULL, model character varying(255), capacity bigint, CONSTRAINT bus_primarykey PRIMARY KEY (bus_id)) WITH (OIDS=FALSE );

ALTER TABLE public.buses OWNER TO postgres;

INSERT INTO public.buses (bus_id, model, capacity) VALUES (1, 'Volvo', 45);
INSERT INTO public.buses (bus_id, model, capacity) VALUES (2, 'Skoda', 35);
