# ProjetoMiniMercado

## Sobre a atividade:
Complete o código: O sistema deve permitir a criação, leitura, atualização e exclusão (CRUD) de produtos. No entanto, para garantir a integridade dos dados, é necessário implementar validações nos campos do produto. Siga as instruções abaixo para implementar as validações necessárias utilizando as boas práticas e crie um README.md para documentar como testar as requisições da aplicação.

- 1. Requisitos do Produto:
    - [x]  Cada produto deve conter os seguintes campos:
        - [x]  Nome (obrigatório): Deve ter no mínimo 3 e no máximo 100 caracteres.            
        - [x]  Descrição (opcional): Pode ter no máximo 500 caracteres.            
        - [x]  Preço (obrigatório): Deve ser um número maior que 0.            
        - [x]  Quantidade em Estoque (obrigatório): Deve ser um número inteiro maior ou igual a 0.
        - [x]  Categoria (obrigatório): Deve ser selecionada entre as opções pré-definidas (ex.: Eletrônicos, Roupas, Alimentos).
            
- 2. Validações a Implementar:
    - Ao criar ou atualizar um produto:
        - [ ]  Verifique se todos os campos obrigatórios estão preenchidos.
        - [ ]  Certifique-se de que o nome do produto não exceda os limites de caracteres.
        - [ ]  Valide que o preço e a quantidade em estoque atendem aos critérios especificados.
        - [ ]  Garanta que a categoria selecionada seja válida.
    - Ao excluir um produto:        
        Confirme se o produto realmente existe antes de excluí-lo.
    Entrega:
    
    - Implemente o CRUD com as validações em Java.
    - Crie um pequeno conjunto de testes para validar as regras implementadas.
    - Documente brevemente como executar o sistema e os testes nos endpoints.
