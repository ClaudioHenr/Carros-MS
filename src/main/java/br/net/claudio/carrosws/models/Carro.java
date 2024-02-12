package br.net.claudio.carrosws.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_carros")
public class Carro {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name="brand")
    private String brand;
    @Column(name="model")
    private String model;
    @Column(name="year")
    private int year;

    Carro() {
        super();
    }

    Carro(Long id, String brand, String model, int year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public Carro(CarroDTO carroDTO) {
        this.brand = carroDTO.getBrand();
        this.model = carroDTO.getModel();
        this.year = carroDTO.getYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
