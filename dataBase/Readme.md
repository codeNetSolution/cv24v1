## Build 

docker build -t cvxml -f basecv .

docker run -d --name cvxml -p 1020:3306 cvxml


## pour accéder au docker 
docker exec -it cvxml /bin/bash

## pour accéder à la base de donnée dans le docker 

mariadb -u root -p 
admin 
use cv_base




##Spring app 

npm install 

mvn spring-boot:run
