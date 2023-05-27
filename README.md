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



