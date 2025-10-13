# EasyAccess

Sistema de gerenciamento para condomínios, desenvolvido em Java com Spring Boot.

## Descrição
O EasyAccess é uma aplicação web que facilita o controle de áreas comuns, reservas, moradores, visitantes e usuários do sistema em condomínios residenciais.

## Estrutura do Projeto
```
├── src/main/java/br/com/easyaccess/easyaccess/
│   ├── controller/        # Controllers REST
│   ├── dto/               # Data Transfer Objects
│   ├── entity/            # Entidades JPA
│   ├── repository/        # Repositórios Spring Data
│   ├── service/           # Serviços de negócio
│   └── EasyaccessApplication.java # Classe principal
├── src/main/resources/
│   ├── application.properties # Configurações
│   ├── static/                # Arquivos estáticos
│   └── templates/             # Templates
├── build.gradle               # Configuração do Gradle
├── settings.gradle            # Configuração de módulos
```

## Como executar
1. Certifique-se de ter o Java 17+ e Gradle instalados.
2. Execute o comando abaixo na raiz do projeto:
   ```
   ./gradlew bootRun
   ```
   Ou no Windows:
   ```
   gradlew.bat bootRun
   ```
3. Acesse `http://localhost:8080` no navegador.

## Dependências principais
- Spring Boot
- Spring Data JPA
- H2 Database (ou configure outro banco em `application.properties`)

## Exemplos de uso
- Reservar área comum: POST `/reservas`
- Listar moradores: GET `/moradores`

## Testes
Para rodar os testes:
```
./gradlew test
```

## Contato
Desenvolvido por [Seu Nome].
Email: seu.email@dominio.com
