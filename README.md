# Projet XML 

## Main

### Walkthrough 

(foreach command, run in right folder)

- Install NodeJS : [NodeJS](https://nodejs.org/en/download/)

- Install Bower : `npm install -g bower`

- Install polymer-cli : `npm install -g polymer-cli`

- Run : `bower install` in client

- Launch the client : `polymer serve`

- Launch BaseX Server : `java -cp BaseX867.jar org.basex.BaseXServer`

- Launch our server : `mvn clean install -Djetty.http.port=8082 jetty:run -e`

- App should be available at : http://127.0.0.1:8081
