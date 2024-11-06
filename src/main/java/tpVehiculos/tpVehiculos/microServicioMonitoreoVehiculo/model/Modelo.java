package tpVehiculos.tpVehiculos.microServicioMonitoreoVehiculo.model;

import jakarta.persistence.*;

@Entity
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;


}
