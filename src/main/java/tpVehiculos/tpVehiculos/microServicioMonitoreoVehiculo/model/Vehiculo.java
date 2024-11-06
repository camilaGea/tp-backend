package tpVehiculos.tpVehiculos.microServicioMonitoreoVehiculo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int patente;
    @ManyToOne
    private Modelo modelo;

    public Vehiculo() {
    }

    public Vehiculo(Long id, int patente, Modelo modelo) {
        this.id = id;
        this.patente = patente;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getPatente() {
        return patente;
    }
    public void setPatente(int patente) {
        this.patente = patente;
    }
    public Modelo getModelo() {
        return modelo;
    }
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(id, vehiculo.id);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
