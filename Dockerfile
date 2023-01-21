FROM openjdk:17
EXPOSE 8080
ADD target/springmongoravi.jar springmongoravi.jar
ENTRYPOINT ["java","jar","springmongoravi.jar"]