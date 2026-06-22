package Final.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Isso é importante para o Spring reconhecer
public interface VendaRepository extends JpaRepository<Venda, Long> {
}