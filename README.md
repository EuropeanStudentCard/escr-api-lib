# escr-api-lib

# Library for a self hosted API 


**language**
JAVA 11
 
 **framework**
Spring Boot

**state**
Test

European Student Card offers the possibility to HEI to expose a RESTful API to allow the router to consume their data in order to restitute them to the student service provider

The advantage is that no personal data is helding in the router. The disadvantage is that the student cannot apply to proposed online services on the router

To expose an API you need to register the route in the institution identity space of the router.

To add the library to your local project, Find the "how to" in the "doc" folder of this repo. 

Here is the route that the lib allows to expose :


## Endpoint

**/{HEI-domain}/{HEI-route}/{europeanStudentCardNumber}**
METHOD : GET
HEADERs : 
- Content-Type →application/json
- key : `< production API key fielded in the ESC institution form>`

REQUIRED PARAMETERS :
the European Student Card Number according to ESC standart :
 String type "europeranStudentCardNumber"


|Responses| Codes  |
|--|--|
| Success | 200 |
|Not Found|400|
| Internal Error | 500|

**Response body format in case of success**
```json
{
      "europeanStudentCardNumber": "e6480dc0-9fba-1035-a6bd-001932465463",
      "europeanStudentIdentifier": "",     
      "expiryDate": "2018-12-01T09:45:11.000Z",
      "academicLevel": 7
}
```
the first three fields are required

Refers to ESC router documentation to get detailed attributes.
