# customer-challenge
Project to handle customers registration

### How start the project

- Install **Java 17**.
- Instal **Docker** and **docker-compose**.*
- Open a command terminal and go to project root folder.
- Run command `./gradlew clean build`.**
- Make sure ports **8080, 8081 and 5432** are unoccupied.
- Run command `docker-compose up`.***

Notes:
- If you don't want to install **docker**, you can just install a **postgreSQL** database and configure it as in the *application.yml* file config. You also need to run the application with `./gradlew bootRun`
- This command will use *gradle wrapper* in the project. But you can use your own gradle installation too. Run `gradle clean build` at the project root. Recommended version: 7.4.1
- Make sure the gradle build generated the file `build/libs/customer-challenge-0.0.1-boot.jar`, the docker file needs it to set up the application. You can remove the `app` service from *docker-compose.yml* to just run the postgreSQL database and run the application with gradle or an IDE program.

### Requests Collection

Import the collection bellow on POSTMAN or another tool to do http requests:

[Download Collection](https://www.getpostman.com/collections/0a099223d1328abc3b91)

### Cloud

The application was also deployed on the **Heroku**, but with a free postgreSQL instance. So it's configs can be automatically updated, breaking the application.

### Endpoints documentation

The documentation of endpoints are also availabe through swagger-ui. After running the application, access the address below.

```
http://localhost:8080/swagger-ui/index.html
```
```
https://customer-challenge.herokuapp.com/swagger-ui/index.html
```

### Monitoring

At the project was added the dependency *actuator* to monitor the application "health".
```
http://localhost:8080/actuator/health
```
```
https://customer-challenge.herokuapp.com/actuator/health
```