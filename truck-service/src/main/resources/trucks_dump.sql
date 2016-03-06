--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.1
-- Dumped by pg_dump version 9.5.1

CREATE TABLE trucks (
    id serial,
    created timestamp without time zone,
    price double precision,
    title character varying(255),
    updated timestamp without time zone,
    CONSTRAINT truck_primarykey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.trucks
  OWNER TO postgres;

INSERT INTO trucks (title, price) VALUES ('Iveco', 5000.98);
