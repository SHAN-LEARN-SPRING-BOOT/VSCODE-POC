# Setting up Keycloak  

* Install Keycloak
* Create New Realm
* Create New Client 
    - 'Disable Client Authentication'
    - 'Disable Service account roles'
    - 'Enable only ***Standard Flow*** and ***Direct access grants***'
    - Add redirect URI
* Add new roles  by picking correct realm and correct realm
* Make a POST request to get access token 
    - URL sill be http://localhost:8080/realms/{{YOUR_REALM}}/protocol/openid-connect/token 
    - PAYLOAD will be as given below (x-www-form-urlencoded):
```
    grant_type: "password"
    username: "<<YOUR_USERNAME>>"
    password: "<<YOUR_PASSWORD>>"
    client_id: "<<YOUR_CLIENT_ID>>"
``` 
* Retrieve the access token received in above API call response and send it as "Bearer" token  
* Refer requests ***"1) GET Token -- User (Authorization Code Fow)"*** , ***"1) GET Token -- User (Authorization Code Fow)"***, ***"Hello (Admin)*** and ***"Hello (Global)"*** in POSTMAN collection ***"spring-boot-3-poc-secure.postman_collection.json"*** 