FROM ubuntu:latest AS build

# Atualizar e instalar o OpenJDK
RUN apt-get update
RUN apt-get install openjdk-21-jdk -y

# Definir o diretório de trabalho
WORKDIR /app

# Copiar os arquivos do projeto para o contêiner
COPY . .

# Instalar o Maven
RUN apt-get install maven -y

# Executar o Maven para construir o projeto
RUN mvn clean install

FROM openjdk:21

# Expor a porta 8080
EXPOSE 8080

# Copiar o JAR construído do estágio de build para o contêiner final
COPY --from=build /app/target/deploy_render-1.0.0.jar app.jar

# Definir o comando de entrada para executar a aplicação
ENTRYPOINT [ "java", "-jar", "app.jar" ]