#!/bin/bash

set -e  # Exit on error
set -o pipefail  # Catch errors in pipelines

# Enable debug mode
set -x

if ! docker network inspect banknet >/dev/null 2>&1; then
  echo "Creating docker network 'banknet'..."
  docker network create --driver bridge banknet
else
  echo "Docker network 'banknet' already exists."
fi




# Run TimescaleDB container using Docker Compose
echo "Starting Oracle container with Docker Compose..."
docker compose --file oracle12.yml --compatibility up -d --build

echo "Oracle container started successfully."

# Display the status of the Oracle container
echo "Checking Oracle container status..."
docker ps --filter "name=timescale" --format "table {{.ID}}\t{{.Names}}\t{{.Status}}\t{{.Ports}}"

# Display the logs of the Oracle container
echo "Displaying Oracle container logs (last 100 lines)..."
docker logs oracle --tail 100

# Disable debug mode
set +x

docker ps -a
