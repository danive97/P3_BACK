#Definicion del dockerfile, del backend de mi app
FROM openjdk:11-jdk-slim
COPY "./target/userAPI-0.0.1-SNAPSHOT.jar" "app.jar"
COPY "./Users.json" "Users.json"
COPY "./Presta.json" "Presta.json"
COPY "./Equipo.json" "Equipo.json"
EXPOSE 9091
ENTRYPOINT ["java", "-jar", "app.jar"]