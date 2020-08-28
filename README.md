# exemplo-microservice
Pequeno exemplo de como integrar microserviços. 
Para utilizar esse exemplo, basta apenas atentar para a configuração presente no diretório /microservice-repo/fornecedor.yml para modificar a url do banco de dados.

spring:
  datasource:
    password: admin
    username: root
    url: jdbc:mysql://${MYSQL_HOST:localhost}:3306/fornecedor
  jpa:
    hibernate:
      ddl-auto: update
