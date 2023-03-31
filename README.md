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

- A role of manager with username manager and password manager123 has been added to access the endpoints Update an existing cake and add a new cake(along with User role)
- A role of user with username user and password user123 has been added who is authorized to get the list of cakes in the system
- A role of admin with username admin and password admin123 has been added who has access to deleting an existing cake(along with user role)

Any access to endpoint with unauthorized role throws an 403 Forbidden exception

The details above could be used for logging into the application

8. Continous integration on the Circle CI system has been added to provide the stable build on the repo

The latest build details can be found below:

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/sudha91/cakemanager-ci/tree/circleci-project-setup.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/sudha91/cakemanager-ci/tree/circleci-project-setup)


9. The application has been containarized using the docker and the latest image can be found at docker pull sudhamk/waraclespringapplication:latest 
and is accessible at http://192.168.99.100:8080/api/cakes

10. To run the service locally, use
mvn spring-boot:run

and can be accessed at http://localhost:8080/api/cakes


Thanks for the opportunity!
