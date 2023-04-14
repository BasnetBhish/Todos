# Task and Board Service


1. A system for creating and maintaining the tasks for managing the work.
2. I have used H2 as in memory database.
3. For API specifications I have used swagger for ease of testing and validating the response.
4. I have used default health check endpoint of actuator for this application. It can be accessed via `http://localhost:8080/actuator/health` this url. I have provided the custom health check endpoint as well.
5. You can access the swagger via `http://localhost:8080/swagger-ui.html`.


There are APIs present for:
1. Creating a new task
2. Updating a task
3. Deleting a task
4. Fetching a task
5. Updating the status of the task
6. Updating the assignee of the task

And under the Board API:
1. You can get all the tasks under a board
2. Fetch all the tasks assigned to a user.
3. Fetch all the tasks according to status.

### How to start the application?
```
For starting the application please import the application in any of the preferred IDE (Intellij, Eclipse, STS, etc.)

Application can be started by executing the main method present in class TodosApplication.
```