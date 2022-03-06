from openjdk:8u151-jre-slim
copy ./build/libs/admin_usuarios-0.0.1-SNAPSHOT.jar /app/admin_usuarios.jar
entrypoint java -jar /app/admin_usuarios.jar
