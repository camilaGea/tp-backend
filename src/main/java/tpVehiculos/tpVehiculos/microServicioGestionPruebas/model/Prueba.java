package tpVehiculos.tpVehiculos.microServicioGestionPruebas.model;
import jakarta.persistence.*;
import tpVehiculos.tpVehiculos.microServicioMonitoreoVehiculo.model.Vehiculo;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "pruebas")
public class Prueba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo; // Referencia al ID del vehículo
    @ManyToOne
    @JoinColumn(name = "interesado_id")
    private Interesado interesado; // Referencia al ID del interesado
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado; // Referencia al ID del empleado
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private String comentarios;

    public Prueba(Long id, Vehiculo vehiculo, Interesado interesado, Empleado empleado, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, String comentarios) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.interesado = interesado;
        this.empleado = empleado;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.comentarios = comentarios;
    }

    public Prueba() {

    }

    // Getters y setters

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
    public Interesado getInteresado() {
        return interesado;
    }
    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public void setEmppleado(Empleado emppleado) {
        this.empleado = emppleado;
    }
    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }
    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }
    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }
    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }
    public String getComentarios() {
        return comentarios;
    }
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prueba prueba = (Prueba) o;
        return Objects.equals(id, prueba.id);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
