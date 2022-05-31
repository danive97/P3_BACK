#Definicion del dockerfile, del backend de mi app
FROM openjdk:11-jdk-slim
COPY "./target/api-0.0.1-SNAPSHOT.jar" "app.jar"
COPY "./User.json" "User.json"
COPY "./Presta.json" "Presta.json"
COPY "./Equipo.json" "Equipo.json"
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]