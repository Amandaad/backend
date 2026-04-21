# Backend Spring Boot

Projeto backend em Java com Spring Boot para gerenciamento de usuários.

## Requisitos
- Java 17+
- Maven 3.9+

## Como executar
```bash
mvn spring-boot:run
```

Aplicação disponível em `http://localhost:8080`.

## Endpoints
- `GET /api/usuarios` - lista usuários
- `GET /api/usuarios/{id}` - busca usuário por id
- `POST /api/usuarios` - cria usuário
- `PUT /api/usuarios/{id}` - atualiza usuário
- `DELETE /api/usuarios/{id}` - remove usuário

### Exemplo de payload
```json
{
  "nome": "João da Silva",
  "email": "joao@email.com"
}
```

## Testes
```bash
mvn test
```
