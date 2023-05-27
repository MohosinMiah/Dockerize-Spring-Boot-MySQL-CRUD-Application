## Dockerize-Spring-Boot-MySQL-CRUD-Application

## Step By Step

1) First pull MYSQL 
<code> docker pull mysql</code>

2) Create docker network
<code> docker network create springboot_mysql_net</code>

springboot_mysql_net will be network name.

3) List of network
docker netwrork ls

4) Run mysql container in Docker network
<code> docker run  -p 3307:3306 --name mysqldb --network springboot_mysql_net -e MYSQL_ROOT_PASSWORD=mohosin -e MYSQL_DATABASE=blog_app -e MYSQL_USER=mohosin -e MYSQL_PASSWORD=mohosin -d mysql:latest</code>

5) Docker Container logs 
<code>docker logs -f mysqldb</code>

6) Docker container Interaction
<code>docker exec -it 2d6d basc</code>
Login mysql in Docker docker exec -it mysqldb bash Note: mysqldb(container name)
<strong>2d6d</strong> is the first four digit of container.

7) To login in terminal
<code>mysql -u root -p </code>
and provide necessary credentails

8) To see database  <code>show databases; </code> Here we can use other mysql commands

9) Generate JAR file 
<code>mnv clean package</code>

10) Build the docker file
<code>docker build -t springboot_crud_restapi .</code>
or we can provide tag name
<code>docker build -t springboot_crud_restapi:0.1.RELEASE .</code>

11) Run our build Docker Image and run it same network that is running mysql
<code>docker run --network springboot_mysql_net --name springboot_mysql_crud_container -p 8080:8080 springboot_crud_restapi:latest </code>
To run in Detach mode
<code>docker run --network springboot_mysql_net --name springboot_mysql_crud_container -p 8088:8080 -d springboot_crud_restapi:latest </code>
To see the images <code>docker images</code>

12) Docker container logs
<code>docker logs -f first_4_contain_id</code>
To get the container list : <code>docker ps</code>

13) To access  container like to see the mysql container
<code> docker exec -it container_name bash</code> 

14) To access mySQL 
<code>mysql -u root -p</code>

15) List of databases
<code>show databases;</code>

16) To access specifi database
<code>use database_name;</code>

17) List of tables after access specific Database
<code> show tables; </code>

18) To see the table data
<code> select * from table_name; </code>

## Docker compose is basically run or configure  multiple service in multiple container in single command
19) <code>docker compose up</code>

20) <code>docker compose down</code>

## Docker compose up with custom Docker Build 
21) <code>docker compose up -d --build  </code>

