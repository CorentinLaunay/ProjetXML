#!/bin/bash
echo Starting server
mvn clean install -Djetty.http.port=8082 jetty:run
mvn generate-sources jaxb2:generate
exit 0
