1. Dockerfile

Download the image for mysql: docker pull mysql

Run the postgres server docker: docker run --name mysqldb -e MYSQL_DATABASE=book_store -e MYSQL_USER=root -e MYSQL_PASSWORD=welocmE$rooT$ -d mysql

Create jar file: gradle build

Build application container: docker build -t demo .

Run container: docker run -d -p 8080:8080 --name demo --link mysqldb


2. docker-compose
Created docker-compose.yml
Run docker-compose: docker-compose -f docker-compose up 