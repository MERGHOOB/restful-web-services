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
