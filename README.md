# WebAppRESTapi
Basic Description: Java backend with React frontend that communicates using REST API.

Steps to run the REST API:
1. Open the project in Eclipse IDE.
2. Install Spring Tools 4 from Eclipse Marketplace.
3. Open the file in WebAppRESTapi\SpringBoot-Backend\src\main\java\net\javatutorial\springboot\SpringBootBackendApplication.java
4. Run the above file as a Spring Boot App.
5. Go to http://localhost:8080/users to access the API.

Steps to run the Unit test:
1. Assuming that the first two of the above steps are already performed, we proceed with the next step.
2. Open the file in WebAppRESTapi\SpringBoot-Backend\src\test\java\net\javatutorial\springboot\controller\UserControllerTest.java
3. Run the above file as JUnit Test.

Steps to run the Integration test: 
1. Open the file in WebAppRESTapi\SpringBoot-Backend\src\test\java\net\javatutorial\springboot\controller\UserControllerIntegrationTest.java
2. Run the above file as JUnit Test.

Steps to run the React frontend:
1. After the Spring Boot App is running, we proceed with the following steps.
2. Open the folder "React frontend" in VS Code.
3. Open a New Terminal and type "npm start" to run the React app.
4. Go to http://localhost:3000/ to observe the React frontend consume the GET method of the REST API.

Resources consulted:
1. https://spring.io/guides/tutorials/rest/
2. https://spring.io/guides/gs/testing-web/
3. https://stackabuse.com/how-to-test-a-spring-boot-application/
4. https://create-react-app.dev/docs/getting-started
5. https://stackoverflow.com/questions/24371734/firefox-cross-origin-request-blocked-despite-headers

Future improvements to the project:
1. Adding a full CRUD functionality to the REST API and having the React frontend change/delete the data.
