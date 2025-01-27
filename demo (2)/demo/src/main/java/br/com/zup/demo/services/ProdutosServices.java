
package br.com.zup.demo.services;

import br.com.zup.demo.dto.ProdutosDTO;
import br.com.zup.demo.models.Produtos;
import br.com.zup.demo.repository.ProdutosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutosServices {
    private final ProdutosRepository produtosRepository;

    public ProdutosServices(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public ProdutosDTO cadastrarProduto(ProdutosDTO produtosDTO) {
        // Validação do nome do produto
        if (produtosDTO.getNomeProduto() == null || produtosDTO.getNomeProduto().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode estar vazio.");
        }
        if (produtosDTO.getNomeProduto().trim().length() < 3) {
            throw new IllegalArgumentException("O nome do produto deve ter pelo menos 3 caracteres.");
        }
        if (produtosDTO.getNomeProduto().trim().length() > 100) {
            throw new IllegalArgumentException("O nome do produto não pode ter mais de 100 caracteres.");
        }

        // Validação da descrição do produto
        if (produtosDTO.getDescricaoProduto() == null || produtosDTO.getDescricaoProduto().trim().isEmpty()) {
            throw new IllegalArgumentException("O produto precisa de uma descrição.");
        }
        if (produtosDTO.getDescricaoProduto().trim().length() > 500) {
            throw new IllegalArgumentException("A descrição do produto não pode ter mais de 500 caracteres.");
        }

        // Validação do preço do produto
        if (produtosDTO.getPrecoProduto() <= 0) {
            throw new IllegalArgumentException("O produto deve ter um preço maior que zero.");
        }

        // Validação da quantidade em estoque
        if (produtosDTO.getQuantidadeemestoqueProdutos() < 0) {
            throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa.");
        }

        // Validação da categoria do produto
        switch (produtosDTO.getCategoriaProduto()) {
            case "1":
                produtosDTO.setCategoriaProduto("Eletrônicos");
                break;
            case "2":
                produtosDTO.setCategoriaProduto("Roupas");
                break;
            case "3":
                produtosDTO.setCategoriaProduto("Alimentos");
                break;
            default:
                throw new IllegalArgumentException("Categoria inválida! Escolha: 1 para Eletrônicos, 2 para Roupas, 3 para Alimentos.");
        }

        // Convertendo o DTO para a entidade Produtos
        Produtos produto = new Produtos();
        produto.setCategoria(produtosDTO.getCategoriaProduto());
        produto.setDescricao(produtosDTO.getDescricaoProduto());
        produto.setNome(produtosDTO.getNomeProduto());
        produto.setPreco(produtosDTO.getPrecoProduto());
        produto.setQuantidadeemestoque(produtosDTO.getQuantidadeemestoqueProdutos());

        // Salvando no banco de dados
        Produtos produtoSalvo = produtosRepository.save(produto);

        // Retornando o produto salvo como DTO
        return new ProdutosDTO(
                produtoSalvo.getCategoria(),
                produtoSalvo.getDescricao(),
                produtoSalvo.getNome(),
                produtoSalvo.getPreco(),
                produtoSalvo.getQuantidadeemestoque(),
                produtoSalvo.getId()
        );
    }

    // Listar produtos
    public List<ProdutosDTO> listarProdutos() {
        return produtosRepository.findAll().stream()
                .map(produto -> new ProdutosDTO(produto.getCategoria(), produto.getDescricao(), produto.getNome(), produto.getPreco(), produto.getQuantidadeemestoque(), produto.getId()))
                .collect(Collectors.toList());
    }

    // Atualizar produto
    public ProdutosDTO atualizarProduto(Long id, ProdutosDTO produtosDTO) {
        Optional<Produtos> produtoOptional = produtosRepository.findById(id);
        // Validação do nome do produto
        if (produtosDTO.getNomeProduto() == null || produtosDTO.getNomeProduto().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode estar vazio.");
        }
        if (produtosDTO.getNomeProduto().trim().length() < 3) {
            throw new IllegalArgumentException("O nome do produto deve ter pelo menos 3 caracteres.");
        }
        if (produtosDTO.getNomeProduto().trim().length() > 100) {
            throw new IllegalArgumentException("O nome do produto não pode ter mais de 100 caracteres.");
        }

        // Validação da descrição do produto
        if (produtosDTO.getDescricaoProduto() == null || produtosDTO.getDescricaoProduto().trim().isEmpty()) {
            throw new IllegalArgumentException("O produto precisa de uma descrição.");
        }
        if (produtosDTO.getDescricaoProduto().trim().length() > 500) {
            throw new IllegalArgumentException("A descrição do produto não pode ter mais de 500 caracteres.");
        }

        // Validação do preço do produto
        if (produtosDTO.getPrecoProduto() <= 0) {
            throw new IllegalArgumentException("O produto deve ter um preço maior que zero.");
        }

        // Validação da quantidade em estoque
        if (produtosDTO.getQuantidadeemestoqueProdutos() < 0) {
            throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa.");
        }

        // Validação da categoria do produto
        switch (produtosDTO.getCategoriaProduto()) {
            case "1":
                produtosDTO.setCategoriaProduto("Eletrônicos");
                break;
            case "2":
                produtosDTO.setCategoriaProduto("Roupas");
                break;
            case "3":
                produtosDTO.setCategoriaProduto("Alimentos");
                break;
            default:
                throw new IllegalArgumentException("Categoria inválida! Escolha: 1 para Eletrônicos, 2 para Roupas, 3 para Alimentos.");
        }
        if (produtoOptional.isPresent()) {
            Produtos produto = produtoOptional.get();
            produto.setNome(produtosDTO.getNomeProduto());
            produto.setPreco(produtosDTO.getPrecoProduto());
            produto.setDescricao(produtosDTO.getDescricaoProduto());
            produto.setCategoria(produtosDTO.getCategoriaProduto());
            produto.setQuantidadeemestoque(produtosDTO.getQuantidadeemestoqueProdutos());

            Produtos produtoAtualizado = produtosRepository.save(produto);
            return new ProdutosDTO(produtoAtualizado.getCategoria(), produtoAtualizado.getDescricao(), produtoAtualizado.getNome(), produtoAtualizado.getPreco(), produtoAtualizado.getQuantidadeemestoque(), produtoAtualizado.getId());
        } else {
            throw new RuntimeException("Produto não encontrado!");
        }
    }

    // Deletar produto
    public void deletarProduto(Long id) {
        produtosRepository.deleteById(id);
    }
}
