FROM gradle:8.11-jdk21 AS build

WORKDIR /app

# Copia os arquivos de dependência primeiro (melhor uso de cache)
COPY build.gradle settings.gradle ./
COPY gradle gradle

# Baixa as dependências antes de copiar o código fonte
RUN gradle dependencies --no-daemon || true

# Copia o restante do projeto
COPY src ./src

# Compila e gera o JAR, pulando os testes
RUN gradle bootJar --no-daemon -x test


FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copia apenas o JAR gerado no estágio anterior
COPY --from=build /app/build/libs/*.jar app.jar

# Porta padrão do Spring Boot
EXPOSE 8080

# Inicia a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]