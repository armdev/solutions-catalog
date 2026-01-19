#!/usr/bin/env bash

set -e
# Stop any running containers
docker compose --file postgres-compose.yml down

# Start the containers
docker compose --file postgres-compose.yml --compatibility up -d --build
docker logs --follow postgresql-master
