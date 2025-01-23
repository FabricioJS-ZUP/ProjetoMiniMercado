package br.com.zup.demo.repository;
import br.com.zup.demo.models.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository  extends JpaRepository<Produtos, Long>{
}
