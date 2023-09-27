<h1 align="center">
  API reativa com Spring Web Flux
</h1>

<p align="center">
 <img src="https://img.shields.io/badge/Tipo-Aprendizado-blue" alt="Aprendizado" />
</p>

Simples API de cadastro de usuários para entender como funciona uma API reativa

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring WebFlux](https://docs.spring.io/spring-framework/reference/web/webflux.html)
- [Spring Data R2DBC](https://spring.io/projects/spring-data-r2dbc)
- [H2 Database](https://www.h2database.com/html/download.html)
- [MySQL Database](https://www.mysql.com/downloads/)

## Práticas adotadas

- API REST
- API Reativa
- Consultas com Spring Data R2DBC
- Injeção de Dependências
- Testes automatizados

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar .\target\spring-reactive-api-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io):

- Criar Tarefa 
```
$ http POST :8080/users username="luccas" password="12345" email="luccas@mail.com"

{
  "email": "luccas@mail.com",
  "id": 5,
  "password": "12345",       
  "username": "luccas"       
}
```

- Listar Tarefas
```
$ http GET :8080/users

[
  {
    "email": "email@mail.com",
    "id": 1,
    "password": "12345",
    "username": "luccas"
  },
  {
    "email": "email@mail.com",
    "id": 2,
    "password": "12345",
    "username": "luccas"
  },
  {
    "email": "email@mail.com",
    "id": 3,
    "password": "12345",
    "username": "luccas"
  },
  {
    "email": "email@mail.com",
    "id": 4,
    "password": "12345",
    "username": "luccas"
  },
  {
    "email": "luccas@mail.com",
    "id": 5,
    "password": "12345",
    "username": "luccas"
  }
]
```
