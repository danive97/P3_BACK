#Definicion del dockerfile, del backend de mi app
#Usamos openjdk de java 11
FROM openjdk:11-jdk-slim
#Copiamos los siguientes ficheros, el snapchot jar, para crear el .jar de nuestra app
COPY "./target/api-0.0.1-SNAPSHOT.jar" "app.jar"
#Copiamos los ficheros json de mi api
COPY "./Users.json" "Users.json"
COPY "./Presta.json" "Presta.json"
COPY "./Equipo.json" "Equipo.json"
#Establecemos el puerto 9090 donde correrá nuestra API
EXPOSE 9090
#Elaboramos el .jar de tipo aplicación Java
ENTRYPOINT ["java", "-jar", "app.jar"]