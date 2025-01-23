/*
do: Fazer o  Update (Atualizar) dos produtos
DO: fazer o Delete dos produtos
 */
package br.com.zup.demo.services;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import br.com.zup.demo.models.Produtos;
import br.com.zup.demo.repository.ProdutosRepository;
import br.com.zup.demo.dto.ProdutosDTO;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProdutosServices {
    private final ProdutosRepository produtosRepository;

    public ProdutosServices(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    //---------------------------------------------------------------------------------
    public ProdutosDTO cadastrarProduto(ProdutosDTO produtosDTO) {
        //Validações

        if (produtosDTO.getNomeProduto() == null) {
            System.out.println("Nome do produto não pode estar vazio (sem nada escrito)");
        } else if (produtosDTO.getNomeProduto().trim().length() == 1 && produtosDTO.getNomeProduto().trim().length() == 2) {
            System.out.println("O produto não pode ter menos de 3 letraas no nome");
        } else if (produtosDTO.getNomeProduto().trim().length() <= 101) {
            System.out.println("O nome do produto não pode ter mais de 100 caracteres");
        }
        if (produtosDTO.getDescricaoProduto().trim().length() <= 101) {
            System.out.println("A descriçao do produto não pode ter mais de 100 carateres");
        } else if (produtosDTO.getDescricaoProduto() == null) {
            System.out.println("O produto precisa de uma descrição! Pois sem descrição diminui a chance do cliente comprar");
        }

        if (produtosDTO.getPrecoProduto() == 0) {
            System.out.println("O produto não pode ser cadastrado sem preço!");
        }
        if (produtosDTO.getQuantidadeemestoqueProdutos() >= -1) {
            System.out.println("A quantide do produto em estoque tem que ser ao menos um numero 0 ou maor");
        } else if (produtosDTO.getQuantidadeemestoqueProdutos() == 0) {
            System.out.println("Aviso! Não temos o produto em estoque");
        }
        do {
            if (produtosDTO.getCategoriaProduto() == "1") {
                produtosDTO.setCategoriaProduto("Eletrônicos");
            } else if (produtosDTO.getCategoriaProduto() == "2") {
                produtosDTO.setCategoriaProduto("Roupas");
            } else if (produtosDTO.getCategoriaProduto() == "3") {
                produtosDTO.setCategoriaProduto("Alimentos");
            } else
                System.out.println("A categoria citada do produto  digitado não existe! Digite o numero 1 para Eletrônicos, 2 para Roupas, 3 para Alimentos ");

        } while (produtosDTO.getCategoriaProduto() == "1" || produtosDTO.getCategoriaProduto() == "2" || produtosDTO.getCategoriaProduto() == "3");

        // Convertendo o DTO para a entidade produtos
        Produtos produto = new Produtos();
        produto.setCategoria(produtosDTO.getCategoriaProduto());
        produto.setDescricao(produtosDTO.getDescricaoProduto());
        produto.setNome(produtosDTO.getNomeProduto());
        produto.setPreco(produtosDTO.getPrecoProduto());
        produto.setQuantidadeemestoque(produtosDTO.getQuantidadeemestoqueProdutos());
        // Salvando no banco de dados
        Produtos produtoSalvo = produtosRepository.save(produto);
        // Retornando o cliente salvo como DTO
        return new ProdutosDTO(produtoSalvo.getCategoria(), produtoSalvo.getDescricao(), produtoSalvo.getNome(), produtoSalvo.getPreco(), produtoSalvo.getQuantidadeemestoque(), produtoSalvo.getId());

    }

    //--------------------------------------------------------------
    // Metodo para listar todos os clientes e convertê-los em DTOs
    //listar produtos
    public List<ProdutosDTO> listarprodutos() {
        List<Produtos> produtos = produtosRepository.findAll();
        // Convertendo a lista de entidades para uma lista de DTOs
        return produtos.stream()
                .map(produtoss -> new ProdutosDTO(produtoss.getCategoria(), produtoss.getDescricao(), produtoss.getNome(), produtoss.getPreco(), produtoss.getQuantidadeemestoque(), produtoss.getId()))
                .collect(Collectors.toList());
    }
    //---------------------------------------------------------------------
    // Atualizar um produto existente

    //---------------------------------------------------------------------
    // deletarprodutos

}

