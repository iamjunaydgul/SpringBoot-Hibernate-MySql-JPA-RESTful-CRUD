---------------------------------------Basic MVC CRUD Application----------------------------------

About:	Build simple Restful CRUD API for a simple Employee MS application using Spring Boot, Mysql, 
	JPA and Hibernate.

Login Page-> implemented using spring security
Home Page-> crud operations
___________________________

Tools&Technologies:	
	Spring Boot
	Spring Security
	Spring MVC
	Hibernate
	JSPs
	Bootstrap
	Postman
	Spring Tool Suite(STS)
___________________________

Steps to Setup:	
	1: Clone the application through url or import as existing project in eclipse
	(https://github.com/iamjunaydgul/SpringBoot-Hibernate-MySql-JPA-RESTful-CRUD.git)
	
	2: Create Mysql Database
	(create database databaseName)
	
	3:Change mysql username and password as per your installation
	(1:open src/main/resources/application.properties)
	(2:spring.datasource.url, spring.datasource.username and spring.datasource.password as per your mysql installation)
	(3:jdbc:mysql://localhost:3306/(your database name here)?useSSL=false)
	
	4:Build and run the app
	(The app will start running at http://localhost:8080/test(whatever your port is) mine was 5500)
	
NOTE:	http://{url}:{port}/test/ -> it will take you to spring security default login page where it ask for username & password and
				     for security reason i changed to,
					username= bcm
					password= secret123
NOTE:	
	make sure you entered /test after port number like this-> http://localhost:5500/test/ ---- test is application Name
____________________________

Explore Rest APIs:(Postman collection for the REST apis)

	List All Employees____(GET http://{url}:{port}/test/bcm/employees) e.g(http://localhost:5500/test/bcm/employees)
	
	LIST by id____________(GET http://{url}:{port}/test/bcm/employees/{id})
	
	UPDATE________________(PUT http://{url}:{port}/test/bcm/employees/{id} + JSON BODY)

	DELETE________________(DELETE http://{url}:{port}/test/bcm/employees/{id})

	CREATE
		1:POST http://{url}:{port}/test/bcm/employees
		2:Options to choose on postman: POST / raw / JSON (application/json)
   	 	
		{"firstName":"Larayb","lastName":"Gul", "dob":"4/23/01", "hireDate":"4/23/01", "ssn":"AAA"}
		NOTE: dob is of type LocalDate works only after 2000 & hireDate by default uses todays date you can change it
		      and age is restricted to 18 otherwise post request throw error
____________________________
NOTE-> for oAuth2 
	uncomment the code for oAuth2 in application.properties and put your details accordingly
	& also in ViewController.java :)


