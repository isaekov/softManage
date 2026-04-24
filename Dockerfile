FROM eclipse-temurin:23-jdk AS builder
WORKDIR /app

# Копируем Maven Wrapper файлы
COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw

# Скачиваем зависимости
RUN ./mvnw dependency:go-offline -B

# Копируем исходный код
COPY src ./src

# Собираем
RUN ./mvnw clean package -DskipTests -B

# Runtime stage
FROM eclipse-temurin:23-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]