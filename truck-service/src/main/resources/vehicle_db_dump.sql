--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.1
-- Dumped by pg_dump version 9.5.1

-- Started on 2016-03-06 12:49:56

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2112 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 183 (class 1259 OID 16404)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 16396)
-- Name: trucks; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE trucks (
    id integer NOT NULL,
    title character varying(255),
    price double precision,
    created timestamp without time zone DEFAULT now() NOT NULL,
    updated timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE trucks OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 16394)
-- Name: trucks_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE trucks_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE trucks_id_seq OWNER TO postgres;

--
-- TOC entry 2113 (class 0 OID 0)
-- Dependencies: 181
-- Name: trucks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE trucks_id_seq OWNED BY trucks.id;


--
-- TOC entry 1983 (class 2604 OID 16399)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY trucks ALTER COLUMN id SET DEFAULT nextval('trucks_id_seq'::regclass);


--
-- TOC entry 2114 (class 0 OID 0)
-- Dependencies: 183
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hibernate_sequence', 1, false);


--
-- TOC entry 2103 (class 0 OID 16396)
-- Dependencies: 182
-- Data for Name: trucks; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY trucks (id, title, price, created, updated) FROM stdin;
1	Iveco	5000.9799999999996	2016-03-05 09:17:27.47676	2016-03-05 09:17:27.47676
\.


--
-- TOC entry 2115 (class 0 OID 0)
-- Dependencies: 181
-- Name: trucks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('trucks_id_seq', 1, true);


--
-- TOC entry 1987 (class 2606 OID 16403)
-- Name: truck_primarykey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY trucks
    ADD CONSTRAINT truck_primarykey PRIMARY KEY (id);


--
-- TOC entry 2111 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-03-06 12:49:57

--
-- PostgreSQL database dump complete
--

