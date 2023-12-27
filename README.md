# Recipe Collection Finder

## Description
This project is a Java-based application that parses a recipe.txt file and stores the data in a Java Collection. It uses the Apache Commons CSV project for parsing. The data is stored in a POJO (Recipe) and is accessible through a set of RESTful endpoints created using Spring Boot.

## Features
- Parses recipes.txt file using Apache Commons CSV.
- Stores data in Recipe objects within a Java Collection.
- Provides RESTful endpoints to access and filter recipe data.

## Endpoints
- /gluten-free - Returns recipes that are gluten-free.
- /vegan - Returns vegan recipes.
- /vegan-and-gluten-free - Returns recipes that are both vegan and gluten-free.
- /vegetarian - Returns vegetarian recipes.
- /all-recipes - Returns all recipes.

## Getting Started
- Setup Project: Clone this repository and import it into your IDE.
- Start Spring Boot Application: Run the application to start the Spring Boot server.
- Access Endpoints: Use an API testing tool like Postman to access the endpoints.

## Prerequisites
- Java
- Maven
- Apache Commons CSV
- Spring Boot (start.spring.io for setup)

## Installation
- Download a fresh Spring Boot project from [start.spring.io](https://start.spring.io/).
- Import the project into your IDE.
  - This project is using [Apache Commons CSV Central 1.10.0](https://mvnrepository.com/artifact/org.apache.commons/commons-csv/1.10.0). You may  
- Add dependencies for Apache Commons CSV in your pom.xml.

## Usage
- Run the application and make HTTP requests to the provided endpoints to filter and access the recipe data.

## Contributing
- Contributions, issues, and feature requests are welcome. Please check the issues page before opening a new issue.

## License
- [MIT]()