#!/bin/bash

set -euo pipefail
set -x  # Debug mode

NETWORK_NAME="banknet"
SUBNET="172.25.0.0/16"
GATEWAY="172.25.0.1"

if ! docker network inspect "$NETWORK_NAME" >/dev/null 2>&1; then
  echo "Creating external Docker network '$NETWORK_NAME'..."
  docker network create \
    --driver bridge \
    --subnet "$SUBNET" \
    --gateway "$GATEWAY" \
    "$NETWORK_NAME"
  echo "Network '$NETWORK_NAME' created."
else
  echo "Network '$NETWORK_NAME' already exists."
fi
