# Exercício 1

## Requisitos:

`1.` Crie uma entidade "Task" com os seguintes atributos:
- ID (UUID)
- Título (texto, obrigatório)
- Descrição (texto)
- Data de criação (data/hora, obrigatório)
- Concluída (booleano)

`2.` Crie um repositório (interface) para a entidade "**Task**" com as operações básicas de CRUD (Create, Read, Update, Delete).

`3.` Crie uma camada de serviço(Service) para as regras de negócio.

`4.` Crie uma cama de mapeamento(Mapper) da “**Task**” para a resposta:
- Para transformação da entidade “**Task**” em “**TaskResponse**” pode usar o que achar mais conveniente, o uso de bibliotecas não é obrigatório.

`5.` Crie a resposta da aplicação: “**TaskResponse**”

`6.` Crie a entrada da aplicação: “**TaskRequest**”
- Adicionar validação de obrigatoriedade para os campos necessários.

`7.` Os Getters e Setters podem ser gerados da maneira que for melhor;

`8.` Crie um controlador (controller) para a entidade "**Task**" com os seguintes endpoints:

#### Listar todas as tarefas
- Método: **GET**
- Endpoint: **/tasks**
- Parâmetros de consulta: completed (opcional, booleano): filtrar tarefas por status de conclusão (true para tarefas concluídas, false para tarefas não concluídas).
- Resposta: lista de tarefas no formato JSON.
#### Criar uma nova tarefa
- Método: **POST**
- Endpoint: **/tasks**
- Corpo da requisição: objeto JSON representando a nova tarefa com os campos **title**, **description** e **creationDate**.
- Resposta: objeto JSON da tarefa criada, incluindo o ID gerado.
#### Atualizar uma tarefa existente
- Método: **PUT**
- Endpoint: **/tasks/{taskId}**
- Parâmetros de caminho: taskId (UUID): ID da tarefa a ser atualizada.
- Corpo da requisição: objeto JSON contendo os campos atualizados da tarefa.
- Resposta: objeto JSON da tarefa atualizada.
#### Excluir uma tarefa
- Método: **_DELETE_**
- Endpoint: **/tasks/{taskId}**
- Parâmetros de caminho: taskId (UUID): ID da tarefa a ser excluída.
- Resposta: **vazio (status 204 No Content)**.
#### Marcar uma tarefa como concluída
- Método: **PATCH**
- Endpoint: **/tasks/{taskId}/complete**
- Parâmetros de caminho: taskId (UUID): ID da tarefa a ser marcada como concluída.
- Resposta: objeto JSON da tarefa atualizada com o campo completed definido como true.

`9.` Implemente as funcionalidades dos endpoints utilizando os métodos do repositório.

`10.` Escolha o banco de dados de sua preferência, justificando a escolha com base nos requisitos do projeto, como escalabilidade, desempenho ou simplicidade.

`11.` Integre o Swagger à aplicação para documentar a API:
- Adicione a dependência do Swagger ao arquivo de configuração do projeto (por exemplo, pom.xml para projetos Maven ou build.gradle para projetos Gradle).
- Configure o Swagger para gerar a documentação da API automaticamente.
- Verifique se a documentação da API pode ser acessada por meio de uma interface do Swagger.

## Requisitos adicionais:

- A aplicação deve registrar logs em seus fluxos de execução.
- A aplicação deve seguir o padrão REST em suas respostas.
- Criar um job para exclusão de tasks concluidas com mais de 10 dias de criação.
    - Dicas **"@schedule"**

- Todos os responses das API`s devem respeitar o formato snake case (snake_case), sem que vocês modifiquem o padrão do java.
    - Dica **"@JsonProperty"**

`1.` Adicione um atributo de "Prioridade" à entidade "Task"

Prioridade (enum, obrigatório): alta, média, baixa.
`2.` Crie um endpoint adicional para obter tarefas por prioridade

Método: GET
Endpoint: /tasks/priority/{priorityLevel}
Parâmetros de caminho: priorityLevel (string): o nível de prioridade das tarefas a serem obtidas (alto, médio, baixo).
Resposta: lista de tarefas no formato JSON que correspondem ao nível de prioridade especificado.
`3.` Crie um endpoint adicional para alterar a prioridade de uma tarefa:

Método: PATCH
Endpoint: /tasks/{taskId}/priority
Parâmetros de caminho: taskId (UUID): ID da tarefa cuja prioridade será alterada.
Corpo da requisição: objeto JSON contendo o novo nível de prioridade.
Resposta: objeto JSON da tarefa atualizada.

Implemente um job para alertar sobre tasks de alta prioridade não concluídas com mais de 2 dias de criação.

`4.` Adicionar funcionalidade para pesquisar tarefas

Método: GET
Endpoint: /tasks/search/{keyword}
Parâmetros de caminho: keyword (string): a palavra-chave para pesquisar nas tarefas.
Resposta: lista de tarefas no formato JSON que correspondem à palavra-chave especificada.

### Exercícios Adicionais e Opcionais

```text
1. Adicione a funcionalidade de atribuir uma tarefa a um usuário.
2. Crie uma nova entidade "User" com os seguintes atributos: ID (UUID), Nome (texto, obrigatório), Email (texto, obrigatório, único).
3. Crie uma relação entre a entidade "Task" e "User" (uma tarefa pode ser atribuída a apenas um usuário, mas um usuário pode ter várias tarefas).
4. Atualize os endpoints de tarefas para incluir a atribuição a um usuário.
5. Crie um novo endpoint para listar todas as tarefas atribuídas a um usuário específico (por ID de usuário).
6. Adicione a funcionalidade de comentários nas tarefas.
7. Crie uma nova entidade "Comment" com os seguintes atributos: ID (UUID), Texto (texto, obrigatório), Data de criação (data/hora, obrigatório).
8. Crie uma relação entre a entidade "Task" e "Comment" (uma tarefa pode ter vários comentários, mas um comentário pertence a apenas uma tarefa).
9. Crie endpoints para adicionar, listar e excluir comentários de uma tarefa.
10. Implemente a funcionalidade de categorizar tarefas.
11. Crie uma nova entidade "Category" com os seguintes atributos: ID (UUID), Nome (texto, obrigatório), Descrição (texto).
12. Crie uma relação entre a entidade "Task" e "Category" (uma tarefa pode pertencer a várias categorias, e uma categoria pode ter várias tarefas).
13. Crie endpoints para criar, listar, atualizar e excluir categorias.
14. Atualize os endpoints de tarefas para permitir a atribuição a categorias.
15. Implemente a funcionalidade de anexos em tarefas.
16. Crie uma nova entidade "Attachment" com os seguintes atributos: ID (UUID), Nome do arquivo (texto, obrigatório), URL do arquivo (texto, obrigatório), Data de upload (data/hora, obrigatório).
17. Crie uma relação entre a entidade "Task" e "Attachment" (uma tarefa pode ter vários anexos, mas um anexo pertence a apenas uma tarefa).
18. Crie endpoints para adicionar e remover anexos de uma tarefa.
19. Implemente a funcionalidade de sub-tarefas.
20. Crie uma nova entidade "Subtask" com os seguintes atributos: ID (UUID), Título (texto, obrigatório), Concluída (booleano).
21. Crie uma relação entre a entidade "Task" e "Subtask" (uma tarefa pode ter várias sub-tarefas, mas uma sub-tarefa pertence a apenas uma tarefa).
22. Crie endpoints para criar, listar, atualizar e excluir sub-tarefas de uma tarefa.
23. Implemente uma funcionalidade que permita aos usuários compartilhar tarefas.
24. Adicione um campo "compartilhadoCom" na entidade "Task" que pode ser uma lista de usuários.
25. Crie endpoints para compartilhar uma tarefa com um ou mais usuários e para remover um usuário da lista de compartilhamento de uma tarefa.
26. Adicione uma funcionalidade de notificações.
27. Crie uma nova entidade "Notification" com os seguintes atributos: ID (UUID), Usuário (referência à entidade "User"), Mensagem (texto), Data (data/hora, obrigatório).
28. Crie um job que verifica tarefas com data de criação superior a 5 dias que ainda não foram concluídas e envia uma notificação ao usuário responsável e aos usuários com quem a tarefa foi compartilhada.
29. Adicione uma funcionalidade de etiquetas (tags).
30. Crie uma nova entidade "Tag" com os seguintes atributos: ID (UUID), Nome (texto, obrigatório).
31. Adicione um campo "tags" à entidade "Task" que pode ser uma lista de tags.
32. Crie endpoints para adicionar e remover tags de uma tarefa.
33. Implemente um sistema de permissões.
34. Adicione um campo "role" à entidade "User" que pode ser uma das seguintes opções: ADMIN, USER.
35. Implemente uma lógica no serviço e no controlador que só permite a usuários ADMIN criar, atualizar e excluir usuários, enquanto usuários USER só podem ler usuários.
36. Implemente um sistema de versionamento de tarefas.
37. Crie uma nova entidade "TaskVersion" com os seguintes atributos: ID (UUID), Task (referência à entidade "Task"), Título (texto), Descrição (texto), Data (data/hora, obrigatório).
38. Sempre que uma tarefa for atualizada, crie uma nova entrada na table "TaskVersion" com a versão anterior da tarefa.
39. Crie um endpoint para listar o histórico de versões de uma tarefa.
```