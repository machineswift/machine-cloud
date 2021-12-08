
docker run -p 3306:3306 --name mysql_8_0_26  -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0.26  --character-set-server=utf8mb4 --collation-server=utf8mb4_general_ci

CREATE DATABASE dragon_system CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

CREATE DATABASE dragon_meta CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;