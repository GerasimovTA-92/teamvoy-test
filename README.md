# Teamvoy

## **Contents**
1. [Task](#Task)
2. [Features](#Features)
3. [Project structure](#Project-structure)
4. [Technologies](#Technologies)
5. [How to run project](#How-to-run-project)
____

## **Task**

Create Spring Boot application using Java 11 that serves Rest API for creating orders for some goods for example iPhones.

Requirements

- As a manager you should be able to add goods to db so clients will be able to buy them
- As a manager/client you should be able to list all available goods and their prices and quantities
- As a client you should be able to place orders for goods (multiple allowed for example in you order you can buy iPhone 13 Pro 5 units, and iPhone 11 10 units)
- Your application should manage risks and automatically delete not paid orders after 10 minutes after creation
- As a client you should be able to pay for your order so provide endpoint that will mark clients order as paid
  
[:arrow_up:Contents](#Contents)
____

## **Features**

* create Product/Goods if you Admin
* login as Admin
* login as User
* display all Users if you Admin
* add goods to Shopping Cart
* complete order

[:arrow_up:Contents](#Contents)
____

## **Project structure**

### Project built on 3-tier architecture:
1. Data access layer (DAO).
2. Application layer (service).
3. Presentation layer (controllers).

Entities relation: One to one between User/Role, Product/Goods and User/ShoppingCart. Many to one between User/Order. 
One to many between ShoppingCart/Goods and Order/Goods

[:arrow_up:Contents](#Contents)
____

## **Technologies**
* Java 8
* Spring Boot
* Spring Data
* Apache Maven
* Spring Boot Security
* H2 DB

[:arrow_up:Contents](#Contents)
____

## **How to run project**

### Tools to run project:
* IntelliJ Idea Ultimate

### How to run
1. Clone this project
2. To test the functionality you can use the collection in [Postman](src/main/resources/test.postman_collection.json)

[:arrow_up:Contents](#Contents)
____