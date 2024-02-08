package br.net.claudio.carrosws.repository;

import br.net.claudio.carrosws.models.Carro;
import org.springframework.data.jpa.repository.*;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    
    public Carro findByBrand(String brand);

}
