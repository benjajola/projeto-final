package Final.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Produtorepository extends JpaRepository<Produto, Long> {
    
    // ESTE MÉTODO RESOLVE O REQUISITO DO INSIGHT:
    // Ele vai ao banco de dados e traz todos os produtos que estão com quantidade abaixo do que indicares.
    List<Produto> findByQuantidadeLessThan(int quantidadeMinima);
}