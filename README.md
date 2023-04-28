<h1 align = "center"> User Management System Validations </h1>

<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.0.6-brightgreen.svg" />
</a>
</p>
This project is a Managing User data built using Spring Boot with Java.

---

## Framework Used
* Spring Boot

---

## Language Used
* Java

---

## Data Model

The User data model is defined in the User class, which has the following attributes:
```
userId : unique identifier for each user(and should not be Empty).
userName : name of the user(should not be null).
dateOfBirth : DOB of user(Date of birth should be in the format yyyy-MM-dd).
email : Email of user (accepts only valid email).
phoneNumber : Phone Number of user(Phone number should be in the format XX-XXXXXXXXXX).
date : User Registered date (Date should be in format dd/mm/yyyy).
time : Registered time of User(time should be in the format HH:mm:ss).
```

---

## Data Flow

1. The user sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.

4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

---

## Functions used :-

### API Endpoints :-
</br>

>* PostMapping: /addUser
```
This endpoint makes a call to method in UserService class which is connected to database. In database we add a new user given through API.
```

>* GetMapping: "/getAllUsers"
```
This endpoint makes a call to method in UserService class which retrieves data of all users from database. This data is sent to controller which is then sent through the API to client.
```

>* GetMapping: "/getUser/{userId}"
```
This endpoint returns data of specific user based on userId through API.
```

>* PutMapping : "/updateUserInfo/{userId}"
```
This endpoint makes a call to method in UserService class which is connected to database. In database we update and validate a user by userid given through API.
```

>* DeleteMapping : "/deleteUser/{userid}"
```
This endpoint makes a call to method in UserService class which is connected to database. In database we delete a user by userId given through API.
```

---

## Data structure Used
>* Hashmap
```
We have used HashMap data structure as a database to implement CRUD Operations like create , read , update and delete .
```

>* ArrayList
```
We have used ArrayList data structure for GetMapping to return list of all the restaurants to the client .
```
---

## Project Summary

This project is a user management system implemented using the Spring framework. It provides endpoints for adding, retrieving, updating, and deleting user information. The user model includes attributes such as userId, username, dateOfBirth, email, phoneNumber, date, and time. The project uses Spring Validation API to validate the fields in the User model, including @NotNull, @NotEmpty, @NotBlank , @Email, @Pattern, and @DateTimeFormat annotationsand Custom validations .

In summary, this project provides a simple and effective way to manage user information using the Spring framework. The code is well-documented, and the endpoints are implemented with validation to ensure data integrity. It can be a useful tool for anyone looking to build a user management system using Spring.

## Author

👤 **Ajinkya Padule**

* GitHub: [AjinkyaPersonal](https://github.com/AjinkyaPersonal)

* LinkedIn: [Ajinkya Padule](https://www.linkedin.com/in/ajinkya-padule-04b8541a6/)
    
---

## 🤝 Contributing

Contributions, issues and feature requests are welcome!<br />Feel free to check [issues page]("url").
    
---
    
## Show your support

Give a ⭐️ if this project helped you!
    
---
    
## 📝 License

Copyright © 2023 [Ajinkya Padule](https://github.com/AjinkyaPersonal).<br />

This project is [MIT]("url") licensed.
    
---
