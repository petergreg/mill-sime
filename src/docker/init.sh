#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE USER mill_admin with PASSWORD  'password';
	CREATE SCHEMA IF NOT EXISTS inventory AUTHORIZATION mill_admin;
EOSQL
