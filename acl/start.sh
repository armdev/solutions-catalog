#!/usr/bin/env bash

set -euo pipefail

# === Colors for terminal output ===
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# === Check prerequisites ===
command -v mvn >/dev/null 2>&1 || { echo -e "${YELLOW}Maven is not installed.${NC}"; exit 1; }
command -v docker >/dev/null 2>&1 || { echo -e "${YELLOW}Docker is not installed.${NC}"; exit 1; }

# === Build the Java project ===
echo -e "${GREEN}Building the project with Maven...${NC}"
mvn clean package -T 1C -Dmaven.test.skip=true

# === Build and start containers ===
echo -e "${GREEN}Starting Docker containers...${NC}"
docker compose up -d --build

# === Show running containers ===
echo -e "${GREEN}Currently running containers:${NC}"
docker ps

# === Tail logs from bank-tax-exchange ===

docker logs -f core-adapter-service
