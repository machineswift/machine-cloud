FROM openjdk:11
MAINTAINER machine <machineswift@qq.com>
ADD sentinel-dashboard.jar sentinel-dashboard.jar
EXPOSE 8858
ENTRYPOINT java -Dserver.port=8858 -Dcsp.sentinel.dashboard.server=localhost:8858 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar



# Build
docker build -t machineswift/sentinel-dashboard:1.8.2 .

# commit
docker push machineswift/sentinel-dashboard:1.8.2