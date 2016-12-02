# akkahttp_postgres_simple_api
#####Please change src/main/resources/application.conf to your environment.

##CRUD
#####Create
```
curl -v -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"title":"titletitle","body":"bodybody"}' http://localhost:8080/posts
```
#####Read
```
curl -v -H "Accept: application/json" -H "Content-type: application/json" -X GET -d http://localhost:8080/posts
```
#####Update
```
curl -v -H "Accept: application/json" -H "Content-type: application/json" -X PUT -d '{"title":"titletitletitle","body":"bodybodybody"}' http://localhost:8080/posts/1
```
#####Delete
```
curl -v -H "Accept: application/json" -H "Content-type: application/json" -X DELETE -d http://localhost:8080/posts/1
```
#####Search
```
curl -v -H "Accept: application/json" -H "Content-type: application/json" -X GET -d http://localhost:8080/posts?title=titletitle
```
