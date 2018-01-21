@echo off
echo Wait please... Starting Server...
start mvn clean install -Djetty.http.port=8082 jetty:run
TIMEOUT /t 30 /nobreak
:loop
TIMEOUT /t 20 /nobreak
start /W cmd /c mvn generate-sources jaxb2:generate
goto loop