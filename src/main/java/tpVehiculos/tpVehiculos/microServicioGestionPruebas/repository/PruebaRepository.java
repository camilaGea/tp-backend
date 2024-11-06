package tpVehiculos.tpVehiculos.microServicioGestionPruebas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpVehiculos.tpVehiculos.microServicioGestionPruebas.model.Prueba;
import tpVehiculos.tpVehiculos.microServicioMonitoreoVehiculo.model.Vehiculo;

import java.util.List;

//Repositorio para la entidad Prueba
public interface PruebaRepository extends JpaRepository<Prueba, Long> {
    List<Prueba> findByFechaHoraFinIsNull(); // Pruebas en curso (sin fecha de fin)
    List<Prueba> findByVehiculo(Vehiculo vehiculo);
}
