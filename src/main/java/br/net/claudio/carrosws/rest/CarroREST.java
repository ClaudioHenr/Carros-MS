package br.net.claudio.carrosws.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.net.claudio.carrosws.models.Carro;
import br.net.claudio.carrosws.models.CarroDTO;
import br.net.claudio.carrosws.repository.CarroRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
public class CarroREST {
    @Autowired
    private CarroRepository repo;
    
    @GetMapping("/carros")
    public List<CarroDTO> listarTodos() {
        List<Carro> lista = repo.findAll();
        List<CarroDTO> listaDTO = new ArrayList<>();
        for (Carro carro : lista) {
            CarroDTO carroDTO = new CarroDTO(carro); 
            listaDTO.add(carroDTO);
        }
        return listaDTO;
    };

    @PostMapping("/carros")
    public CarroDTO inserirCarro(@RequestBody CarroDTO carroDTO) {
        Carro carro = new Carro(carroDTO);
        repo.save(carro);
        // Procurar carro salvo no BD
        Optional<Carro> carroOpt = repo.findById(carro.getId());
        CarroDTO car = new CarroDTO(carroOpt.get());
        return car;
    }
    
    @GetMapping("/carros/{id}")
    public CarroDTO getCar(@PathVariable("id") Long id) {
        Optional<Carro> carroOpt = repo.findById(id);
        CarroDTO carroDTO = new CarroDTO(carroOpt.get());
        return carroDTO;
    }

    @GetMapping("/carros/marca/{brand}")
    public List<CarroDTO> getCarByBrand(@PathVariable("brand") String brand) {
        List<Carro> listaCarros = repo.findByBrandContainingIgnoreCase(brand);
        List<CarroDTO> listaCarroDTOs = new ArrayList<>();
        for (Carro carro : listaCarros) {
            CarroDTO carroDTO = new CarroDTO(carro);
            listaCarroDTOs.add(carroDTO);
        }
        return listaCarroDTOs;
    }
    
}
