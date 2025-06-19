# Usa una imagen base de Java 17
FROM eclipse-temurin:17-jdk

# Crea un directorio dentro del contenedor
WORKDIR /app

# Copia todo el código fuente al contenedor
COPY . .

# Da permisos de ejecución a mvnw
RUN chmod +x mvnw

# Construye el proyecto (sin pruebas)
RUN ./mvnw clean package -DskipTests

# Expón el puerto que usa tu app (ajusta si no es 8080)
EXPOSE 8080

# Ejecuta el .jar generado (ajusta si el nombre es diferente)
CMD ["java", "-jar", "target/proyecto-biblioteca-0.0.1-SNAPSHOT.jar"]
