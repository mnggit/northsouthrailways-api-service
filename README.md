# northsouthrailways-api-service

Read Me:

This is the webservice for the railways-app.

This application provides the REST API for feteching routes:

GET /travelPaths?cityStart=${cityStart}&cityEnd=${cityEnd}

northsouthrailways-api-service is built in Spring Boot, the source code for this project can be cloned from this git repository. 

The application can be run from the IDE (e.g. Eclipse) as a Java application.

Future Improvements:

northsouthrailways-api-service currently uses hardcoded graph data this in the future will need to be moved to a database. 

Spring Boot is chosen because it's a Java based framework and can easily be used to create microservices.
