FROM openjdk:17
EXPOSE 8082
ADD target/springmongoravi.jar springmongoravi.jar
ENTRYPOINT ["java","jar","springmongoravi.jar"]