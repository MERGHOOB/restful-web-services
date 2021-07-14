### user table structrue
create table user (
id integer not null, 
birth_date timestamp, 
name varchar(255), 
primary key (id)
)

#Richardson Maturity Model
Level 0 - expose SOAP web services in Rest style
ex: http://server/getPosts
ex: http://server/deletePosts
ex: http://server/doThis

Level 1: Expose Resources with proper URIs
ex: http://server/posts
ex: http://server/posts/10
Note: improper user of HTTP

Level 2: level 1 + http method

Level 3: level 2 + HATEOS
Data + next possible action

#Best practice
Consumer first - think from the perspective of your consumer
Great Documentation - Make sure your consumer understands it well
Best use of HTTP method - GET, POST, DELETE, PUT, 
RESPONSE STATUS - 
200 -SUCCESS
404- RESOURCE NOT FOUND
400 - BAD Request
201 - Created
401- UNAUTHORIZED
500- SERVER ERROR

NO SECURE INFO in URI

Use PLURAL
-Prefer users to /user

Use Nouns for Resources but exception is everywhere ( be consistent in approaching these exceptions)

exception - /search
PUT /gists/{id}/start
DELETE /gists/{id}/start


