#!/usr/bin/env bash
# Clone script for SSD Week 2 Lab: Interfaces & Git Branching
# Organization: The-British-College-Nepal
# Repository: ssd-2026-week2-interfaces

set -e

REPO_URL="https://github.com/The-British-College-Nepal/ssd-2026-week2-interfaces.git"
TARGET_DIR="ssd-2026-week2-interfaces"

echo "============================================================"
echo "🚀 SSD Week 2 Lab: Interfaces & Git Branching"
echo "   Cloning starter repository..."
echo "============================================================"

if [ -d "$TARGET_DIR" ]; then
  echo "⚠️ Directory '$TARGET_DIR' already exists. Please remove or rename it before cloning."
  exit 1
fi

git clone "$REPO_URL" "$TARGET_DIR"

if [ $? -eq 0 ]; then
  echo ""
  echo "✅ Repository successfully cloned into '$TARGET_DIR'!"
  echo ""
  echo "👉 Next Steps:"
  echo "   cd $TARGET_DIR"
  echo "   git checkout -b feature/step1-counter"
  echo "   Open the project in IntelliJ IDEA or Eclipse."
  echo "============================================================"
else
  echo "❌ Failed to clone repository. Check your network connection and GitHub permissions."
fi
