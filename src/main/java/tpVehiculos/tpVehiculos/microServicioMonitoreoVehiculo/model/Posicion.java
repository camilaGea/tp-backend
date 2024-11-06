package tpVehiculos.tpVehiculos.microServicioMonitoreoVehiculo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Vehiculo vehiculo;
    private LocalDateTime fecha_hora;
    private String latitud;
    private String longitud;

    public Posicion() {
    }
    public Posicion(Long id, Vehiculo vehiculo, LocalDateTime fecha_hora, String latitud, String longitud) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.fecha_hora = fecha_hora;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }
    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }
    public String getLatitud() {
        return latitud;
    }
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
    public String getLongitud() {
        return longitud;
    }
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return Objects.equals(id, posicion.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
