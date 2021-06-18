#!/usr/bin/env bash
echo "This assumes you have GraalVM and the native-image tool setup!"
mvn  -Pnative -DskipTests=true clean package  && ./target/demo