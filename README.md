# EventTrackerProject

## Overview

Week 12 homework for Skill Distillery.

Full-stack REST API project using MySQL, Spring Boot, Spring Data JPA.

## How to run
* TODO: URL of app deployed on EC2

## Database Schema


## REST Endpoints

| HTTP Verb | URI                  | Request Body | Response Body | Response Codes |
|-----------|----------------------|--------------|---------------|----------------|
| GET       | `/api/caves`      |              | List Caves    | 200 |
| GET       | `/api/caves/17`   |              | Representation of _cave_ `17` | 200, 404 |
| POST      | `/api/caves`      | Representation of a new _cave_ resource | Representation of created _cave_ | 201, 400 |
| PUT       | `/api/caves/17`   | Representation of a new version of _cave_ `17` | Representation of updated _cave_ | 200, 404, 400 |
| DELETE    | `/api/caves/17`   |              | | 204, 404, 400 |

## HTML/JavaScript Front End using XHR/AJAX

blah blah blah

## Technologies Used

* BLAH
* BLAH

## Lessons Learned