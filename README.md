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

### Entrada de dados
No momento do cadastro as informações serão enviadas em formato JSON, respeitando algumas restrições de envio:
{
  "nome":"[nome_do planeta]"
  "clima":"[tipos_de_clima]" -> se tipos de clima > 1 a separação de entre os tipos deverá ser por vírgulas. Ex.: "tipo1, tipo2"
  "terreno":"[tipos_de_terreno]" -> se tipos de terreno > 1 a separação de entre os tipos deverá ser por vírgulas. Ex.: "tipo1, tipo2"
}

Os Dados nas buscas por id e por nome são retornados em formato JSON. A alteração na ordem de envio dos componentes do formulário não causa erro na execução do cadastro. 

Backup do banco de dados incluso no projeto.
