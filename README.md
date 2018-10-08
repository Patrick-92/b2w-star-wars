# Desafio back-end - B2W

Desenvolvimento de API que contenha os dados dos planetas do mundo Star Wars.
### Tecnologias
- FrameWork Spring Boot versão 1.5.6.
- Java versão 1.8.
- Mongodb versão 4.0.2.

### Requisitos
- API REST
- Dados dos planetas:
  - Nome
  - Clima
  - Terreno
  - Aparições - (número de filmes em que o planeta apareceu)
  
Obs.: Os dados da coluna "Aparições" serão preenchidos atarvés da API pública do Star Wars: https://swapi.co/

### Funcionalidades
- Adicionar um planeta (com nome, clima e terreno)
- Listar planetas - http://localhost:8080/api/planetas/
- Buscar por nome - http://localhost:8080/api/planetas/nome/[nome_do_planeta]
- Buscar por ID - http://localhost:8080/api/planetas/[id_do_planeta]
- Remover planeta - http://localhost:8080/api/planetas/[id_do_planeta]

Obs.: Dados são retornados em formato JSON

Backup do banco de dados incluso no projeto.
