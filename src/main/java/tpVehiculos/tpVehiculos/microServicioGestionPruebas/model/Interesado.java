package tpVehiculos.tpVehiculos.microServicioGestionPruebas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

@Entity
public class Interesado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo_Documento;
    private String documento;
    private String nombre;
    private String apellido;
    private Boolean restringido;
    private int nro_licencia;
    private Date fecha_vencimiento_licencia;

    public Interesado() {
    }
    public Interesado(Long id, String tipo_Documento, String documento, String nombre, String apellido, Boolean restringido, int nro_licencia, Date fecha_vencimiento_licencia) {
        this.id = id;
        this.tipo_Documento = tipo_Documento;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.restringido = restringido;
        this.nro_licencia = nro_licencia;
        this.fecha_vencimiento_licencia = fecha_vencimiento_licencia;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTipo_Documento() {
        return tipo_Documento;
    }
    public void setTipo_Documento(String tipo_Documento) {
        this.tipo_Documento = tipo_Documento;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
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
    public Boolean getRestringido() {
        return restringido;
    }
    public void setRestringido(Boolean restringido) {
        this.restringido = restringido;
    }
    public int getNro_licencia() {
        return nro_licencia;
    }
    public void setNro_licencia(int nro_licencia) {
        this.nro_licencia = nro_licencia;
    }
    public Date getFecha_vencimiento_licencia() {
        return fecha_vencimiento_licencia;
    }
    public void setFecha_vencimiento_licencia(Date fecha_vencimiento_licencia) {
        this.fecha_vencimiento_licencia = fecha_vencimiento_licencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interesado that = (Interesado) o;
        return id == that.id;
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
