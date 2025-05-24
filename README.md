# EventTrackerProject

## Overview

This full-stack project implements a REST API using Spring and JPA.

### Database:
![divelogdb ER Diagram](DB/divelogdb.png)

## REST API

Implemented with JPA entities representing the database tables and their relationships.

Sprint `RestController` request mappings provide the HTTP API endpoints.

### Endpoints

| HTTP Verb | URI             | Request Body | Response Body | Status |
|-----------|-----------------|--------------|---------------|---------|
| GET       | `/api/dives`    |              | List of dives | 200   |
| GET       | `/api/dives/17` |              | Single dive   | 200 or 404 |
| POST      | `/api/dives`    | JSON of new dive       | JSON of created dive | 201 or 400 |
| PUT       | `/api/dives/17` | JSON for updating dive | JSON of updated dive | 200, 404, or 400 |
| DELETE    | `/api/dives/17` |              | | 204, 404, or 400 |

