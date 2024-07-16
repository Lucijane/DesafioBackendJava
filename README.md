# Projeto de API REST com Spring Boot

## Descrição
Este projeto é uma API RESTful construída com Spring Boot 3.3.1, Java 21, PostgreSQL 16.3-2, e Hibernate ORM core 6.5.2.Final. A API gerencia entidades de `Servidor` e `Pedido de Especialização`, permitindo criar, listar, aprovar e indeferir pedidos de especialização.

## Requisitos
- Java 21
- Spring Boot 3.3.1
- PostgreSQL 16.3-2 (Windows x64)
- Hibernate ORM core 6.5.2.Final

## Endpoints

### Servidor

#### POST /servidor
Cria um novo servidor.

**Requisição:**
```json
{
    "cpf": "12345678901",
    "email": "example@example.com",
    "matricula": "12345",
    "nome": "João da Silva",
    "dataNascimento": "1980-05-15",
    "sexo": "M",
    "tipo": "PROFESSOR"
}
Resposta:

json
{
    "id": 1,
    "cpf": "12345678901",
    "email": "example@example.com",
    "matricula": "12345",
    "nome": "João da Silva",
    "dataNascimento": "1980-05-15",
    "sexo": "M",
    "tipo": "PROFESSOR"
}
GET /servidor
Lista todos os servidores.

Pedido de Especialização
POST /pedido-especializacao
Cria um novo pedido de especialização.

Requisição:

json
{
    "area": "Ciência da Computação",
    "tipo": "MESTRADO",
    "cargaHoraria": 400,
    "valorTotal": 500.00,
    "status": "PENDENTE",
    "servidor": {
        "id": 1,
        "cpf": "12345678901",
        "email": "example@example.com",
        "matricula": "12345",
        "nome": "João da Silva",
        "dataNascimento": "1980-05-15",
        "sexo": "M",
        "tipo": "PROFESSOR"
    }
}
GET /pedido-especializacao
Lista todos os pedidos de especialização.

POST /pedido-especializacao/{id}/deferir
Deferir (aprovar) um pedido de especialização.

Requisição:

json
{
    "motivo": "DEFERIDO"
}
Resposta:

json
{
    "id": 1,
    "servidor": {
        "id": 1,
        "cpf": "12345678901",
        "email": "example@example.com",
        "matricula": "12345",
        "nome": "João da Silva",
        "dataNascimento": "1980-05-15",
        "sexo": "M",
        "tipo": "PROFESSOR"
    },
    "area": "Ciência da Computação",
    "tipo": "MESTRADO",
    "cargaHoraria": 400,
    "valorTotal": 500.00,
    "status": "DEFERIDO"
}
GET /api/pedido-especializacao/deferidos
Lista todos os pedidos de especialização deferidos.

POST /pedido-especializacao/{id}/indeferir
Indeferir (reprovar) um pedido de especialização.

Requisição:

json
{
    "motivo": "Falta de documentação necessária"
}
Resposta:

json
{
    "id": 1,
    "servidor": {
        "id": 1,
        "cpf": "12345678901",
        "email": "example@example.com",
        "matricula": "12345",
        "nome": "João da Silva",
        "dataNascimento": "1980-05-15",
        "sexo": "M",
        "tipo": "PROFESSOR"
    },
    "area": "Ciência da Computação",
    "tipo": "MESTRADO",
    "cargaHoraria": 400,
    "valorTotal": 500.00,
    "status": "INDEFERIDO",
    "motivoIndeferimento": "Falta de documentação necessária"
}
GET /pedido-especializacao/indeferidos
Lista todos os pedidos de especialização indeferidos.

Como Usar
Clone o repositório

git clone https://github.com/seu-usuario/seu-repositorio.git
Navegue até o diretório do projeto


cd seu-repositorio
Configure o banco de dados PostgreSQL
Altere as configurações necessárias no arquivo application.yml
Compile e execute o projeto

./mvnw spring-boot:run
Contribuição
Sinta-se à vontade para contribuir com este projeto enviando pull requests. Todas as contribuições são bem-vindas!

