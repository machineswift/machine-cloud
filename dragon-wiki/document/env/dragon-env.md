## redis
docker run -d --name redis-6.2.6 -p 6379:6379 redis:6.2.6 --requirepass "redis"

## mysql
docker run -p 3306:3306 --name mysql_8_0_26  -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0.26    --character-set-server=utf8mb4 --collation-server=utf8mb4_general_ci
CREATE DATABASE dragon_system CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
CREATE DATABASE dragon_meta CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;


## nacos
docker pull nacos/nacos-server:v2.0.3
docker run -d  --name nacos -p 8848:8848 --env MODE=standalone nacos/nacos-server:v2.0.3

http://127.0.0.1:8848/nacos/index.html
nacos/nacos

## sentinel
docker run --name sentinel  -d -p 8858:8858 -d  machineswift/sentinel-dashboard:1.8.2

http://localhost:8858/
sentinel/sentinel