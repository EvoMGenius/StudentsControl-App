#!/usr/bin/env sh

echo "Starting to wait for Service at host '${1:-localhost}'"
while ! nc -z -v -w30 ${1:-localhost} ${2:-3306};
do
  echo "Waiting for '${1:-localhost}' to be ready";
  sleep 5;
done;
