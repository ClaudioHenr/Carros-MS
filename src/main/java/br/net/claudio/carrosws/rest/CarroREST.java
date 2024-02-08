package br.net.claudio.carrosws.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.claudio.carrosws.models.Carro;
import br.net.claudio.carrosws.models.CarroDTO;
import br.net.claudio.carrosws.repository.CarroRepository;

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

}
