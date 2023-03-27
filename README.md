Cake Manager Micro Service (fictitious)
=======================================

The cakemanager micro service provides the following features:

1. By accessing /api/cakes, it is possible to list the cakes in the JSON format

2. It is possible to add a new cake.

3. It is possible to update an existing cake.

4. It is possible to delete an existing cake.

5. The entire system has been migrated to the Spring-DataJPA, ensuring the API follows the REST principles

6. Suitable tests have been added as part of TDD process

7. The application has been authenticated using the Spring security keeping in mind seperation of concerns

8. Continous integration on the Circle CI system has been added to provide the stable build on the repo

The latest build details can be found below:

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/sudha91/cakemanager-ci/tree/circleci-project-setup.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/sudha91/cakemanager-ci/tree/circleci-project-setup)


9. The application has been containarized using the docker and the latest image can be found at docker pull sudhamk/waraclespringapplication:latest 
and is accessible at http://192.168.99.100:8080/api/cakes

10. To run the service locally, use
mvn spring-boot:run

and can be accessed at http://localhost:8080/api/cakes


Thanks for the opportunity!
