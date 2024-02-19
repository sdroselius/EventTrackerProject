# EventTrackerProject

## Overview

This app allows a user to track their favorite books and authors.

It consists of a RESTful API for performing CRUD operations, and front ends implemented in both JavaScrip/HTML using XHR, as well as an Angular front end.

## To Run

The app is deployed to Amazon AWS on an EC2 instance running MariaDB and Tomcat10.

You can access it at: http://52.38.48.168:8080/ReadingList

## REST API:

| HTTP Verb | URI               | Request Body | Response Body | Status Codes |
|-----------|-------------------|--------------|---------------|---------|
| GET       | `/api/books`      |              | List of all _book_ entities | 200 |
| GET       | `/api/books/17`   |              | JSON of _book_ `17` | 200,404 |
| POST      | `/api/books`      | JSON of a new _book_ entity  | JSON of created _book_ | 201,400 |
| PUT       | `/api/books/17`   | JSON of a new version of _book_ `17` | JSON of updated _book_ | 200,404,400 |
| DELETE    | `/api/books/17`   |              |               | 204,404,400|
| GET       | `/api/authors`      |              | List of all _author_ entities | 200 |


