package br.com.zup.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.zup.demo.dto.ProdutosDTO;
import br.com.zup.demo.models.Produtos;
import br.com.zup.demo.services.ProdutosServices;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    private final  ProdutosServices produtosServices;

    public ProdutosController(ProdutosServices produtosServices) {
        this.produtosServices = produtosServices;
    }

    //Criar produto
    @PostMapping
    public ProdutosDTO cadastrarProduto(@RequestBody ProdutosDTO produtosDTO) {
    return produtosServices.cadastrarProduto(produtosDTO);
    }
    // Endpoint para listar todos os clientes
    @GetMapping
    public List<ProdutosDTO> listarprodutos(){
        return produtosServices.listarprodutos();
    }
}
