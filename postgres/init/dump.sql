--
-- PostgreSQL database cluster dump
--

\restrict ZCwaG1MMdhRy3ecGqe1il3PqJQiPUzBaxxo58cGab0pxAdUJo95g5sGgPuUfTAE

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Drop databases (except postgres and template1)
--

DROP DATABASE soft;




--
-- Drop roles
--

DROP ROLE "user";


--
-- Roles
--

CREATE ROLE "user";
ALTER ROLE "user" WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'SCRAM-SHA-256$4096:HtaT+PqibgME1M+iR4i2QQ==$WoV2PZHgA03A5+VJKIyjS59Wi/gYPt3cEa8nZDyLylo=:t4+onhOG85YnoshyTnYKOfkCeWgxNWG2z+AZyFZ8FY8=';

--
-- User Configurations
--








\unrestrict ZCwaG1MMdhRy3ecGqe1il3PqJQiPUzBaxxo58cGab0pxAdUJo95g5sGgPuUfTAE

--
-- Databases
--

--
-- Database "template1" dump
--

--
-- PostgreSQL database dump
--

\restrict PQRnr8XUd54xfM7fDF3EF00P7M4MSLiNUfRQ0bfMlPpIF56byccHme4NLhohgZR

-- Dumped from database version 18.3 (Debian 18.3-1.pgdg13+1)
-- Dumped by pg_dump version 18.3 (Debian 18.3-1.pgdg13+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

UPDATE pg_catalog.pg_database SET datistemplate = false WHERE datname = 'template1';
DROP DATABASE template1;
--
-- Name: template1; Type: DATABASE; Schema: -; Owner: user
--

CREATE DATABASE template1 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';


ALTER DATABASE template1 OWNER TO "user";

\unrestrict PQRnr8XUd54xfM7fDF3EF00P7M4MSLiNUfRQ0bfMlPpIF56byccHme4NLhohgZR
\connect template1
\restrict PQRnr8XUd54xfM7fDF3EF00P7M4MSLiNUfRQ0bfMlPpIF56byccHme4NLhohgZR

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE template1; Type: COMMENT; Schema: -; Owner: user
--

COMMENT ON DATABASE template1 IS 'default template for new databases';


--
-- Name: template1; Type: DATABASE PROPERTIES; Schema: -; Owner: user
--

ALTER DATABASE template1 IS_TEMPLATE = true;


\unrestrict PQRnr8XUd54xfM7fDF3EF00P7M4MSLiNUfRQ0bfMlPpIF56byccHme4NLhohgZR
\connect template1
\restrict PQRnr8XUd54xfM7fDF3EF00P7M4MSLiNUfRQ0bfMlPpIF56byccHme4NLhohgZR

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE template1; Type: ACL; Schema: -; Owner: user
--

REVOKE CONNECT,TEMPORARY ON DATABASE template1 FROM PUBLIC;
GRANT CONNECT ON DATABASE template1 TO PUBLIC;


--
-- PostgreSQL database dump complete
--

\unrestrict PQRnr8XUd54xfM7fDF3EF00P7M4MSLiNUfRQ0bfMlPpIF56byccHme4NLhohgZR

--
-- Database "postgres" dump
--

--
-- PostgreSQL database dump
--

\restrict Cg18eJyoexiwfX7jhiOHdZ0gczovU6nhQFX5PqDDp84LTuxzNVafACEYporWZ4N

-- Dumped from database version 18.3 (Debian 18.3-1.pgdg13+1)
-- Dumped by pg_dump version 18.3 (Debian 18.3-1.pgdg13+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE postgres;
--
-- Name: postgres; Type: DATABASE; Schema: -; Owner: user
--

CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';


ALTER DATABASE postgres OWNER TO "user";

\unrestrict Cg18eJyoexiwfX7jhiOHdZ0gczovU6nhQFX5PqDDp84LTuxzNVafACEYporWZ4N
\connect postgres
\restrict Cg18eJyoexiwfX7jhiOHdZ0gczovU6nhQFX5PqDDp84LTuxzNVafACEYporWZ4N

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: user
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- PostgreSQL database dump complete
--

\unrestrict Cg18eJyoexiwfX7jhiOHdZ0gczovU6nhQFX5PqDDp84LTuxzNVafACEYporWZ4N

--
-- Database "soft" dump
--

--
-- PostgreSQL database dump
--

\restrict 1YxnVFAqCJ5BSAd2jOXyWQP17UUyb50gsCJh8DN6zy2fiMErZTrcYciljjbKnXN

-- Dumped from database version 18.3 (Debian 18.3-1.pgdg13+1)
-- Dumped by pg_dump version 18.3 (Debian 18.3-1.pgdg13+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: soft; Type: DATABASE; Schema: -; Owner: user
--

CREATE DATABASE soft WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';


ALTER DATABASE soft OWNER TO "user";

\unrestrict 1YxnVFAqCJ5BSAd2jOXyWQP17UUyb50gsCJh8DN6zy2fiMErZTrcYciljjbKnXN
\connect soft
\restrict 1YxnVFAqCJ5BSAd2jOXyWQP17UUyb50gsCJh8DN6zy2fiMErZTrcYciljjbKnXN

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
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
-- Name: positions; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.positions (
    id bigint NOT NULL,
    title character varying(255) NOT NULL
);


ALTER TABLE public.positions OWNER TO "user";

--
-- Name: positions_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

ALTER TABLE public.positions ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.positions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: projects; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.projects (
    id bigint NOT NULL,
    budget numeric(38,2),
    description character varying(255),
    end_date date,
    name character varying(255) NOT NULL,
    start_date date,
    status character varying(255) NOT NULL,
    CONSTRAINT projects_status_check CHECK (((status)::text = ANY (ARRAY[('DRAFT'::character varying)::text, ('PLANNING'::character varying)::text, ('ACTIVE'::character varying)::text, ('ON_HOLD'::character varying)::text, ('COMPLETED'::character varying)::text, ('CANCELLED'::character varying)::text])))
);


ALTER TABLE public.projects OWNER TO "user";

--
-- Name: projects_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

ALTER TABLE public.projects ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.projects_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: roles; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    label character varying(255),
    name character varying(255) NOT NULL
);


ALTER TABLE public.roles OWNER TO "user";

--
-- Name: roles_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.roles_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.roles_seq OWNER TO "user";

--
-- Name: task_comment; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.task_comment (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    text character varying(255),
    task_id bigint,
    user_id bigint
);


ALTER TABLE public.task_comment OWNER TO "user";

--
-- Name: task_comment_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

ALTER TABLE public.task_comment ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.task_comment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: tasks; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.tasks (
    id bigint NOT NULL,
    deadline date,
    description character varying(255),
    priority character varying(255),
    status character varying(255) NOT NULL,
    title character varying(255) NOT NULL,
    assignee_id bigint,
    project_id bigint NOT NULL,
    CONSTRAINT tasks_status_check CHECK (((status)::text = ANY (ARRAY[('NEW'::character varying)::text, ('IN_PROGRESS'::character varying)::text, ('DONE'::character varying)::text, ('STALLED'::character varying)::text])))
);


ALTER TABLE public.tasks OWNER TO "user";

--
-- Name: tasks_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

ALTER TABLE public.tasks ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.tasks_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: time_entries; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.time_entries (
    id bigint NOT NULL,
    hours numeric(38,2),
    work_date date,
    task_id bigint NOT NULL
);


ALTER TABLE public.time_entries OWNER TO "user";

--
-- Name: time_entries_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

ALTER TABLE public.time_entries ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.time_entries_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: user_positions; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.user_positions (
    user_id bigint NOT NULL,
    position_id bigint NOT NULL
);


ALTER TABLE public.user_positions OWNER TO "user";

--
-- Name: user_roles; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.user_roles (
    user_id bigint NOT NULL,
    role_id integer NOT NULL
);


ALTER TABLE public.user_roles OWNER TO "user";

--
-- Name: users; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    active boolean NOT NULL,
    email character varying(255),
    lastname character varying(255),
    name character varying(255),
    password character varying(255),
    username character varying(255),
    assignee_id bigint
);


ALTER TABLE public.users OWNER TO "user";

--
-- Name: users_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE public.users_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_seq OWNER TO "user";

--
-- Data for Name: positions; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.positions (id, title) FROM stdin;
1	Разработчик
2	Frontend-разработчик
3	Backend-разработчик
4	UI/UX-дизайнер
5	Системный аналитик
6	Администратор
\.


--
-- Data for Name: projects; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.projects (id, budget, description, end_date, name, start_date, status) FROM stdin;
1	350000.00	Лендинг + CRM для записи пациентов	2026-04-30	Сайт для клиники "Здоровье"	2026-01-15	ACTIVE
2	890000.00	MVP для iOS и Android	2026-06-15	Мобильное приложение для доставки	2026-02-01	ACTIVE
3	210000.00	Обмен данными между внутренней системой и 1С	2026-03-20	Интеграция с 1С	2025-11-10	COMPLETED
4	420000.00	Корпоративный трекер для команды разработки	2026-07-01	Внутренняя система учёта задач	2026-03-01	PLANNING
5	180000.00	Построение дашбордов в Power BI	2026-05-10	Анализ данных клиентов	2026-02-10	ON_HOLD
\.


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.roles (id, label, name) FROM stdin;
1	Администратор	ADMIN
2	Менеджер	MANAGER
3	Разработчик	DEVELOPER
4	HR	HR
5	Дизайнер	DESIGNER
\.


--
-- Data for Name: task_comment; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.task_comment (id, created_at, text, task_id, user_id) FROM stdin;
1	2026-03-25 20:40:15.460117	Добавить не много	1	1
2	2026-03-25 20:40:24.404684	можно еще\r\n	1	1
3	2026-03-25 21:15:43.405889	Привет	1	1
4	2026-03-25 21:17:23.355682	Привет	8	1
5	2026-03-25 21:17:33.780243	фывафыва	8	1
6	2026-03-25 21:17:37.751133	фывафыва	8	1
\.


--
-- Data for Name: tasks; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.tasks (id, deadline, description, priority, status, title, assignee_id, project_id) FROM stdin;
1	2026-02-10	Figma, утвердить с заказчиком	HIGH	DONE	Создать макет главной страницы	\N	1
2	2026-03-05	HTML + валидация + отправка на бэк	MEDIUM	IN_PROGRESS	Разработать форму записи	\N	1
3	\N	VPS + Let's Encrypt	LOW	NEW	Настроить хостинг и SSL	\N	1
4	2026-03-20	Установить код, настроить цели	MEDIUM	NEW	Подключить аналитику (Яндекс.Метрика)	\N	1
5	2026-02-28	REST, JWT, документация в Swagger	HIGH	IN_PROGRESS	Спроектировать архитектуру API	\N	2
6	2026-03-15	React Native, работа с состоянием	MEDIUM	IN_PROGRESS	Реализовать экран корзины	\N	2
7	\N	Проверка на iPhone 12–15	HIGH	NEW	Тестирование на iOS-устройствах	\N	2
8	2026-04-01	Кэширование, lazy load	LOW	STALLED	Оптимизация загрузки изображений	\N	2
9	2026-01-20	1C + Java-сервис	HIGH	DONE	Написать обработчик выгрузки	\N	3
10	2026-02-10	Полный цикл: создание → передача → приём	MEDIUM	DONE	Протестировать обмен данными	\N	3
11	2026-02-25	Техническое описание для поддержки	LOW	DONE	Документировать интеграцию	\N	3
12	2026-03-10	Интервью с разработчиками и менеджерами	HIGH	DONE	Собрать требования от команды	\N	4
13	2026-03-12	Spring Boot vs Node.js	MEDIUM	DONE	Выбрать стек технологий	\N	4
14	2026-02-28	Выгрузка за 2025 год	HIGH	IN_PROGRESS	Собрать исходные данные из CRM	\N	5
15	\N	Связи, меры, визуализация	MEDIUM	STALLED	Построить модель в Power BI	\N	5
16	\N	Баг при нажатии кнопки сохранить	\N	NEW	Исправить баг	2	1
17	\N	Figma, утвердить с заказчиком	\N	DONE	Создать макет главной страницы	\N	1
18	\N	Figma, утвердить с заказчиком	\N	STALLED	Создать макет главной страницы	10	1
19	\N	1C + Java-сервис	\N	IN_PROGRESS	Написать обработчик выгрузки	6	3
\.


--
-- Data for Name: time_entries; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.time_entries (id, hours, work_date, task_id) FROM stdin;
1	3.50	2026-02-05	1
2	2.00	2026-02-08	1
3	4.00	2026-02-25	2
4	3.00	2026-02-26	2
5	1.50	2026-02-27	2
6	2.00	2026-03-01	2
7	6.00	2026-02-20	5
8	2.50	2026-02-22	5
9	4.00	2026-03-01	6
10	3.50	2026-03-02	6
11	2.00	2026-03-05	6
12	1.00	2026-03-10	6
13	2.00	2026-02-18	8
14	8.00	2026-01-15	9
15	4.00	2026-01-18	9
16	3.00	2026-01-25	10
17	5.00	2026-02-01	10
18	2.00	2026-02-05	10
19	4.00	2026-02-20	11
20	3.00	2026-03-05	12
21	2.00	2026-03-07	12
22	4.00	2026-03-11	13
23	5.00	2026-02-15	14
24	3.00	2026-02-18	14
25	2.50	2026-02-20	14
26	1.50	2026-02-22	14
27	4.00	2026-02-10	15
28	3.00	2026-02-12	15
29	2.00	2026-02-14	15
30	1.00	2026-02-16	15
\.


--
-- Data for Name: user_positions; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.user_positions (user_id, position_id) FROM stdin;
2	2
2	3
3	3
4	4
5	5
6	2
6	3
7	2
8	3
9	4
9	5
1	6
10	5
11	2
11	3
\.


--
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.user_roles (user_id, role_id) FROM stdin;
1	1
1	5
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: user
--

COPY public.users (id, active, email, lastname, name, password, username, assignee_id) FROM stdin;
1	t	admin@hwru.ru	Исаеков	Ильдар	$2a$10$lRe5OvvqppbI/4i5/F2/d.U1QXxxX12bFgchlkJM87QjJ9Bc.Yp0y	admin	\N
2	t	user1@example.com	Первый	Первый	$2a$10$XcF6Z7qWvKJ8fQ9sR2tU.Oe3mN4pL5rS6uV7wY8zA9bB0cC1dD2eE	user1	\N
10	t	user9@example.com	Девятый	Девятый	$2a$10$FkN4h5yEzRQ6nY7aZ0bB.Wm1uV2xT3zA4cC5dD6eE7fF8gG9hH0iI	user9	\N
8	t	user7@example.com	Седьмой	Седьмой	$2a$10$DiL2f3wCzPO4lW5yX8zZ.Uk9sT0vR1xY2aA3bB4cC5dD6eE7fF8gG	user7	\N
4	t	user3@example.com	Третий	Третий	$2a$10$ZeH8b9sYxLK0hS1uT4vV.Qg5oP6rN7tU8wX9yA0zB1cC2dD3eE4fF	user3	\N
3	t	user2@example.com	Второй	Второй	$2a$10$YdG7a8rXwKJ9gR0tS3uU.Pf4nO5qM6sT7vW8xZ9yA0bB1cC2dD3eE	user2	\N
9	t	user8@example.com	Восьмой	Восьмой	$2a$10$EjM3g4xDzQP5mX6zY9aA.Vl0tU1wS2yZ3bB4cC5dD6eE7fF8gG9hH	user8	\N
7	t	user6@example.com	Шестой	Шестой	$2a$10$ChK1e2vBzON3kV4xW7yY.Tj8rS9uQ0wX1zA2bB3cC4dD5eE6fF7gG	user6	\N
11	t	user10@example.com	Десятый	Десятый	$2a$10$GlO5i6zFzSR7oZ8bA1cC.Xn2vW3yU4aB5dD6eE7fF8gG9hH0iI1jJ	user10	\N
5	t	user4@example.com	Четвёртый	Четвёртый	$2a$10$AfI9c0tZyML1iT2vU5wW.Rh6pQ7sO8uV9xY0zA1bB2cC3dD4eE5fF	user4	\N
6	t	user5@example.com	Пятый	Пятый	$2a$10$BgJ0d1uAzNM2jU3wV6xX.Si7qR8tP9vW0yZ1aA2bB3cC4dD5eE6fF	user5	\N
\.


--
-- Name: positions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.positions_id_seq', 1, false);


--
-- Name: projects_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.projects_id_seq', 5, true);


--
-- Name: roles_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.roles_seq', 51, true);


--
-- Name: task_comment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.task_comment_id_seq', 6, true);


--
-- Name: tasks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.tasks_id_seq', 19, true);


--
-- Name: time_entries_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.time_entries_id_seq', 30, true);


--
-- Name: users_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('public.users_seq', 1, true);


--
-- Name: positions positions_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.positions
    ADD CONSTRAINT positions_pkey PRIMARY KEY (id);


--
-- Name: projects projects_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.projects
    ADD CONSTRAINT projects_pkey PRIMARY KEY (id);


--
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- Name: task_comment task_comment_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.task_comment
    ADD CONSTRAINT task_comment_pkey PRIMARY KEY (id);


--
-- Name: tasks tasks_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (id);


--
-- Name: time_entries time_entries_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.time_entries
    ADD CONSTRAINT time_entries_pkey PRIMARY KEY (id);


--
-- Name: positions uka43ripgiua3gemywbgdqmokc4; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.positions
    ADD CONSTRAINT uka43ripgiua3gemywbgdqmokc4 UNIQUE (title);


--
-- Name: roles ukofx66keruapi6vyqpv6f2or37; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT ukofx66keruapi6vyqpv6f2or37 UNIQUE (name);


--
-- Name: user_positions user_positions_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.user_positions
    ADD CONSTRAINT user_positions_pkey PRIMARY KEY (user_id, position_id);


--
-- Name: user_roles user_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (user_id, role_id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: user_positions fk49ffcx0xclhe2oof19cty66v0; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.user_positions
    ADD CONSTRAINT fk49ffcx0xclhe2oof19cty66v0 FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: users fk5u5lw05ea2jdvgkstqdjecge9; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk5u5lw05ea2jdvgkstqdjecge9 FOREIGN KEY (assignee_id) REFERENCES public.users(id);


--
-- Name: task_comment fk7kiv45on4bf6my8w8mhefy9jy; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.task_comment
    ADD CONSTRAINT fk7kiv45on4bf6my8w8mhefy9jy FOREIGN KEY (task_id) REFERENCES public.tasks(id);


--
-- Name: tasks fkekr1dgiqktpyoip3qmp6lxsit; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT fkekr1dgiqktpyoip3qmp6lxsit FOREIGN KEY (assignee_id) REFERENCES public.users(id);


--
-- Name: time_entries fkfohb8frbtyjjx7ebqujd0v9tq; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.time_entries
    ADD CONSTRAINT fkfohb8frbtyjjx7ebqujd0v9tq FOREIGN KEY (task_id) REFERENCES public.tasks(id);


--
-- Name: user_roles fkh8ciramu9cc9q3qcqiv4ue8a6; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fkh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id) REFERENCES public.roles(id);


--
-- Name: user_roles fkhfh9dx7w3ubf1co1vdev94g3f; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: task_comment fko2c4nu60419sd7mn9qexf4cqa; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.task_comment
    ADD CONSTRAINT fko2c4nu60419sd7mn9qexf4cqa FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: user_positions fkqieyn6an8qsrf02uvgsieege6; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.user_positions
    ADD CONSTRAINT fkqieyn6an8qsrf02uvgsieege6 FOREIGN KEY (position_id) REFERENCES public.positions(id);


--
-- Name: tasks fksfhn82y57i3k9uxww1s007acc; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT fksfhn82y57i3k9uxww1s007acc FOREIGN KEY (project_id) REFERENCES public.projects(id);


--
-- PostgreSQL database dump complete
--

\unrestrict 1YxnVFAqCJ5BSAd2jOXyWQP17UUyb50gsCJh8DN6zy2fiMErZTrcYciljjbKnXN

--
-- PostgreSQL database cluster dump complete
--

