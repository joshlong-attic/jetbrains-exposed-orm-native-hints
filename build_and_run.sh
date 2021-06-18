#!/usr/bin/env bash
mvn  -Pnative -DskipTests=true package  && ./target/exposed-hints             