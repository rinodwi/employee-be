--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: division; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.division (
    division_id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.division OWNER TO postgres;

--
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    id bigint NOT NULL,
    create_date timestamp without time zone,
    last_position character varying(255),
    name character varying(255),
    nik bigint,
    type character varying(255),
    divisions_id bigint,
    positions_id bigint
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- Name: position; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."position" (
    position_id bigint NOT NULL,
    level integer,
    name character varying(255)
);


ALTER TABLE public."position" OWNER TO postgres;

--
-- Name: seq_divisions; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_divisions
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_divisions OWNER TO postgres;

--
-- Name: seq_employees; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_employees
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_employees OWNER TO postgres;

--
-- Name: seq_positions; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_positions
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_positions OWNER TO postgres;

--
-- Data for Name: division; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.division (division_id, name) FROM stdin;
1	umum
2	IT
3	HRD
4	Loading
5	Ticket
\.


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (id, create_date, last_position, name, nik, type, divisions_id, positions_id) FROM stdin;
15	2020-09-18 15:47:04.887		rino	1	NEW EMPLOYEE	1	1
16	2020-09-18 15:51:07.921		rino	1	NEW EMPLOYEE	1	1
12	2020-09-18 15:33:23.189		rino	1	PROMOTE	1	2
13	2020-09-18 15:33:23.189	Asisten Manager	rino	1	DEMOTE	1	2
\.


--
-- Data for Name: position; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."position" (position_id, level, name) FROM stdin;
1	1	Staff
2	2	Supervisor
3	3	Asisten Manager
4	4	Manager
\.


--
-- Name: seq_divisions; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_divisions', 1, true);


--
-- Name: seq_employees; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_employees', 16, true);


--
-- Name: seq_positions; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_positions', 1, true);


--
-- Name: division division_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.division
    ADD CONSTRAINT division_pkey PRIMARY KEY (division_id);


--
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- Name: position position_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."position"
    ADD CONSTRAINT position_pkey PRIMARY KEY (position_id);


--
-- Name: employee fkbhobuxw7nt31qbs79upga3epg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fkbhobuxw7nt31qbs79upga3epg FOREIGN KEY (divisions_id) REFERENCES public.division(division_id);


--
-- Name: employee fkoirych5dvbt07n9a5hokx3okq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fkoirych5dvbt07n9a5hokx3okq FOREIGN KEY (positions_id) REFERENCES public."position"(position_id);


--
-- PostgreSQL database dump complete
--

