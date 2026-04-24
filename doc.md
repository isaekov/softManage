docker exec postgres pg_dump -U postgres > postgres/init/001-init.sql


docker compose exec postgres psql -U user -d soft

\i /docker-entrypoint-initdb.d/dump.sql