package br.com.zup.demo.controllers;

import br.com.zup.demo.dto.ProdutosDTO;
import br.com.zup.demo.services.ProdutosServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    private final ProdutosServices produtosServices;

    public ProdutosController(ProdutosServices produtosServices) {
        this.produtosServices = produtosServices;
    }

    // Criar produto
    @PostMapping
    public ResponseEntity<ProdutosDTO> cadastrarProduto(@RequestBody ProdutosDTO produtosDTO) {
        return ResponseEntity.ok(produtosServices.cadastrarProduto(produtosDTO));
    }

    // Listar produtos
    @GetMapping
    public ResponseEntity<List<ProdutosDTO>> listarProdutos() {
        return ResponseEntity.ok(produtosServices.listarProdutos());
    }

    // Atualizar produto
    @PutMapping("/{id}")
    public ResponseEntity<ProdutosDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutosDTO produtosDTO) {
        return ResponseEntity.ok(produtosServices.atualizarProduto(id, produtosDTO));
    }

    // Endpoint para deletar produto
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        try {
            produtosServices.deletarProduto(id);
            return ResponseEntity.ok("Produto com ID " + id + " foi excluído com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}