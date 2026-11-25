#!/usr/bin/env bash
# Automated Evaluation & Step Advancement Script for SSD Week 2 Lab
# Evaluates Unit Tests and advances README.md upon successful merge to main

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "$SCRIPT_DIR/../.." && pwd)"
STEP_FILE="$REPO_ROOT/.github/current_step.txt"
STEPS_DIR="$REPO_ROOT/.github/steps"
README_FILE="$REPO_ROOT/README.md"

cd "$REPO_ROOT"

# Determine current step (defaults to 1)
CURRENT_STEP=1
if [ -f "$STEP_FILE" ]; then
  CURRENT_STEP=$(cat "$STEP_FILE" | tr -d '[:space:]')
fi

echo "============================================================"
echo "🤖 SSD Interactive Lab Evaluator — Week 2 (Interfaces)"
echo "   Current Step: $CURRENT_STEP"
echo "============================================================"

ADVANCED=false

if [ "$CURRENT_STEP" = "1" ]; then
  echo "🔍 Evaluating Step 1: Counter Interface Contract..."
  if mvn -B test -Dtest=Step1CounterTest; then
    echo "✅ Step 1 tests passed!"
    echo "2" > "$STEP_FILE"
    cp "$STEPS_DIR/step-2.md" "$README_FILE"
    ADVANCED=true
    NEXT_STEP="Step 2: Implement WordProcessor.java"

    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## 🎉 Step 1 Passed!" >> "$GITHUB_STEP_SUMMARY"
      echo "Great job understanding the \`Counter\` interface contract! Your repository has been updated with instructions for **Step 2: Implement WordProcessor.java**." >> "$GITHUB_STEP_SUMMARY"
      echo "👉 Run \`git pull origin main\` locally to get the updated README in your IDE!" >> "$GITHUB_STEP_SUMMARY"
    fi
  else
    echo "❌ Step 1 tests failed."
    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## ❌ Step 1 Tests Failed" >> "$GITHUB_STEP_SUMMARY"
      echo "Review your interface declaration in \`src/main/java/counter/Counter.java\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* Ensure it is declared as \`public interface Counter\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* Ensure methods \`countWords\`, \`countLetters\`, and \`getLength\` are declared returning \`int\`." >> "$GITHUB_STEP_SUMMARY"
    fi
    exit 1
  fi

elif [ "$CURRENT_STEP" = "2" ]; then
  echo "🔍 Evaluating Step 2: WordProcessor Implementation..."
  if mvn -B test -Dtest=Step1CounterTest,Step2WordProcessorTest; then
    echo "✅ Step 2 tests passed!"
    echo "3" > "$STEP_FILE"
    cp "$STEPS_DIR/step-3.md" "$README_FILE"
    ADVANCED=true
    NEXT_STEP="Step 3: Encapsulation & Fallback State"

    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## 🎉 Step 2 Passed!" >> "$GITHUB_STEP_SUMMARY"
      echo "Great work implementing sentence analysis in \`WordProcessor.java\`! Your repository has been updated with instructions for **Step 3: Encapsulation & Fallback State**." >> "$GITHUB_STEP_SUMMARY"
      echo "👉 Run \`git pull origin main\` locally to get the updated README in your IDE!" >> "$GITHUB_STEP_SUMMARY"
    fi
  else
    echo "❌ Step 2 tests failed."
    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## ❌ Step 2 Tests Failed" >> "$GITHUB_STEP_SUMMARY"
      echo "Review your implementation in \`src/main/java/counter/WordProcessor.java\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* Make sure \`WordProcessor implements Counter\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* \`countWords(sentence)\` should split on spaces: \`sentence.split(\" \").length\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* \`countLetters(sentence)\` should count characters using \`Character.isLetter(ch)\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* \`getLength(sentence)\` should return \`sentence.length()\`." >> "$GITHUB_STEP_SUMMARY"
    fi
    exit 1
  fi

elif [ "$CURRENT_STEP" = "3" ]; then
  echo "🔍 Evaluating Step 3: Encapsulation & Fallback State..."
  if mvn -B test; then
    echo "✅ Step 3 tests passed! Exercise fully completed!"
    echo "completed" > "$STEP_FILE"
    cp "$STEPS_DIR/completed.md" "$README_FILE"
    ADVANCED=true
    NEXT_STEP="Exercise Completed"

    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## 🏆 100% Complete! All Steps Passed!" >> "$GITHUB_STEP_SUMMARY"
      echo "You have successfully completed Week 2: Interfaces in Java and practiced Git Branching! Your README has been updated to the completion badge." >> "$GITHUB_STEP_SUMMARY"
    fi
  else
    echo "❌ Step 3 tests failed."
    if [ -n "$GITHUB_STEP_SUMMARY" ]; then
      echo "## ❌ Step 3 Tests Failed" >> "$GITHUB_STEP_SUMMARY"
      echo "Review your implementation in \`src/main/java/counter/WordProcessor.java\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* Ensure \`private String text = \"\";\` is declared with getters and setters." >> "$GITHUB_STEP_SUMMARY"
      echo "* In all three counting methods, if \`sentence == null\`, fall back to \`this.text\`." >> "$GITHUB_STEP_SUMMARY"
      echo "* Ensure non-null arguments override the fallback text." >> "$GITHUB_STEP_SUMMARY"
    fi
    exit 1
  fi

else
  echo "🎉 Lab was already completed. Verifying all tests remain green..."
  mvn -B test
  if [ -n "$GITHUB_STEP_SUMMARY" ]; then
    echo "## ✅ All Tests Passing (Lab Complete)" >> "$GITHUB_STEP_SUMMARY"
  fi
fi

# If the step advanced, commit and push changes back to the student repo
if [ "$ADVANCED" = "true" ]; then
  echo "🚀 Committing updated README and advancing step to: $NEXT_STEP"
  git config user.name "github-actions[bot]"
  git config user.email "github-actions[bot]@users.noreply.github.com"
  git add "$README_FILE" "$STEP_FILE"
  git commit -m "🤖 [GitHub Skills] Advance to $NEXT_STEP [skip ci]"
  git push origin main
  echo "✅ Step successfully unlocked!"
fi
