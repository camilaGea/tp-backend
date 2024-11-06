package tpVehiculos.tpVehiculos.microServicioGestionPruebas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lejago;
    private String nombre;
    private String apellido;
    private int telefono_contacto;

    public Empleado() {
    }

    public Empleado(Long lejago, String nombre, String apellido, int telefono_contacto) {
        this.lejago = lejago;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono_contacto = telefono_contacto;
    }

    // Getters y setters
    public Long getLejago() {
        return lejago;
    }
    public void setLejago(Long lejago) {
        this.lejago = lejago;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getTelefono_contacto() {
        return telefono_contacto;
    }
    public void setTelefono_contacto(int telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return lejago == empleado.lejago;
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(lejago);
    }
}
