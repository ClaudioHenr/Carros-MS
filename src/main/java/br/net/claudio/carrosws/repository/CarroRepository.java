package br.net.claudio.carrosws.repository;

import br.net.claudio.carrosws.models.Carro;
import org.springframework.data.jpa.repository.*;

import java.util.List;
import java.util.Optional;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    
    public Optional<Carro> findById(Long id);

    public List<Carro> findByBrandContainingIgnoreCase(String brand);

}
