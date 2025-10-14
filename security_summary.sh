#!/bin/bash

ORG="onecx"
OUTPUT="SECURITY_SUMMARY.md"

echo "# Code Scanning Alerts for $ORG Organization" > $OUTPUT
echo "_Generated on $(date -u +"%Y-%m-%dT%H:%M:%SZ") UTC_" >> $OUTPUT

echo >> $OUTPUT

echo "Fetching repositories..."
REPOS=$(gh repo list $ORG --limit 1000 --public --json name -q '.[].name')

for REPO in $REPOS; do
  echo "\n## Repository: $REPO" >> $OUTPUT
  ALERTS=$(gh api repos/$ORG/$REPO/code-scanning/alerts -q '.[]')
  if [ -z "$ALERTS" ]; then
    echo "No alerts found." >> $OUTPUT
    continue
  fi
  echo "| Rule | Severity | State | Created At |" >> $OUTPUT
  echo "|------|----------|-------|------------|" >> $OUTPUT
  gh api repos/$ORG/$REPO/code-scanning/alerts --jq '.[] | "| " + .rule.id + " | " + .rule.severity + " | " + .state + " | " + .created_at + " |"' >> $OUTPUT

done
