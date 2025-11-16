#!/usr/bin/env bash

# Colors for output
GREEN="\033[0;32m"
BLUE="\033[0;34m"
YELLOW="\033[1;33m"
NC="\033[0m" # No Color

# Massive list of fun yet professional commit messages
messages=(
  "Refactoring the universe"
  "Fixing stuff nobody asked for"
  "Performance boosted by 0.0001%"
  "Code cleanup: because hygiene matters"
  "Microservice unlocked"
  "Stabilizing the unstable"
  "Improved readability for future generations"
  "Another day, another commit"
  "Removed dead code. RIP."
  "Optimized like a pro"
  "Fixing bugs I created earlier"
  "Production-ready... I hope"
  "Better logs, better life"
  "Future-proofing the past"
  "Documentation added. Miracles happen!"
  "Secret feature deployed"
  "Made everything 1% faster"
  "Less code, more power"
  "Patch applied bravely"
  "Making it work... eventually"
  "Chasing performance ghosts"
  "Removing TODOs from 2 months ago"
  "Test coverage? Slightly better"
  "Stabilizing chaos"
  "Hotfixing like a firefighter"
  "Upgraded logic from 'meh' to 'ok'"
  "Unbreaking things"
  "Unlocking Level 2 DevOps"
  "Injecting quality"
  "Deploying pure magic"
  "Fixing the mess I found"
  "Cleaned code. Mom would be proud"
  "Because Git forced me"
  "Auto-commit: trust me, I'm a developer"
  "Refactor: Now with 30% more elegance"
  "This commit deserves a coffee"
  "Making things smoother than butter"
  "Feature delivered. Customer happy. Probably."
  "Quality increased by ±5%"
)

# Pick a random message
RANDOM_MESSAGE="${messages[$RANDOM % ${#messages[@]}]}"

echo -e "${BLUE}>> Pulling latest changes...${NC}"
git pull

echo -e "${BLUE}>> Adding changes...${NC}"
git add .

# Prevent empty commit
if git diff --cached --quiet; then
  echo -e "${YELLOW}>> No changes staged. Nothing to commit.${NC}"
  exit 0
fi

echo -e "${GREEN}>> Committing with message:${NC} \"$RANDOM_MESSAGE\""
git commit -m "$RANDOM_MESSAGE"

echo -e "${GREEN}>> Pushing...${NC}"
git push

echo -e "${GREEN}✔ All done!${NC}"

