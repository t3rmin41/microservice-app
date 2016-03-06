--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.1
-- Dumped by pg_dump version 9.5.1

SET statement_timeout = 0;

SET lock_timeout = 0;

SET client_encoding = 'UTF8';

SET standard_conforming_strings = on;

SET check_function_bodies = false;

SET client_min_messages = warning;

SET row_security = off;

CREATE TABLE trucks (id serial, price double precision, title character varying(255), created timestamp without time zone, updated timestamp without time zone, CONSTRAINT truck_primarykey PRIMARY KEY (id)) WITH ( OIDS=FALSE );

ALTER TABLE public.trucks OWNER TO postgres;

INSERT INTO trucks (id, title, price, created, updated) VALUES (1, 'Iveco', 5000.98, NOW(), NOW());
