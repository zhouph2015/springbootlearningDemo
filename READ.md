Introduction:

This is a Spring boot application. it build with gradle and provide the following REST endpoint:
1) a "Hello World" REST endpoint. 

2) a REST endpoint that accepts a JSON object containing a paragraph of text and returns a JSON array of objects. 

3) a REST endpoint that accepts a number, N, and returns a JSON array with the first N Fibonacci numbers. The time complexity is O(n)

4) a REST endpoint that creates two threads that become deadlocked with each other.

6) a REST endpoint that queries an external REST service using Spring RestTemplate

How to run and start the project:
GitHub repository: https://github.com/zhouph2015/springbootlearningDemo.git

1. git clone https://github.com/zhouph2015/springbootlearningDemo.git to your local machine
2. import the project to your IDE like Eclipse
3. Right click project->gradle->Refresh Gradle Project
4. Right clock project->Run as->Spring boot App

Curl command to test this project:
1. Test the "Hellow World" REST endpoint
curl localhost:8080/api/hellow

2. Test the REST endpoint which will return a list of words counts
curl -H "Content-Type: application/json" -X POST http://localhost:8080/api/wordcounts -d "{\"message\":\"Austin is snowing snowing\"}"

3. Test the REST endpoint which will return the nth Fibonacci numbers
curl localhost:8080/api/fibonacci?number=10
it will the first Fibonacci number with the default number = 1

4. Test the REST endpoint to detect the deadlock
curl localhost:8080/api/deadlock
it will detect the deadlock and return the id of two thread that caused the deadlock

5. Test the REST endpoint to queries an external REST Servce
curl localhost:8080/api/externalservice?url=https://jsonplaceholder.typicode.com/posts


