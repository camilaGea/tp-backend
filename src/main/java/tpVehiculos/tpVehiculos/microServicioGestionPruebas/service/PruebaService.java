package tpVehiculos.tpVehiculos.microServicioGestionPruebas.service;

import org.springframework.stereotype.Service;
import tpVehiculos.tpVehiculos.microServicioGestionPruebas.model.Interesado;
import tpVehiculos.tpVehiculos.microServicioGestionPruebas.model.Prueba;
import tpVehiculos.tpVehiculos.microServicioGestionPruebas.repository.PruebaRepository;
import tpVehiculos.tpVehiculos.microServicioMonitoreoVehiculo.model.Vehiculo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

//Servicio de lógica para pruebas
@Service
public class PruebaService {
    private final PruebaRepository pruebaRepository;

    public PruebaService(PruebaRepository pruebaRepository) {
        this.pruebaRepository = pruebaRepository;
    }

    public Prueba crearPrueba(Prueba prueba) {
        // 1. Validar si la licencia del interesado está vencida o tiene restricciones
        if (!esLicenciaValida(prueba.getInteresado())) {
            throw new IllegalArgumentException("Licencia inválida o con restricciones");
        }
        // 2. Verificar si el vehículo está disponible para la prueba
        if (!esVehiculoDisponible(prueba.getVehiculo())) {
            throw new IllegalArgumentException("El vehículo no está disponible para la prueba");
        }
        // Validar licencia, restricciones, y disponibilidad del vehículo
        return pruebaRepository.save(prueba);
    }

    public boolean esVehiculoDisponible(Vehiculo vehiculo) {
        // Obtener todas las pruebas asociadas al vehículo
        List<Prueba> pruebas = pruebaRepository.findByVehiculo(vehiculo); // Aquí asumo que tienes un método en el repositorio para encontrar las pruebas de un vehículo

        if (pruebas.isEmpty()) {
            return true;  // Si no hay pruebas, el vehículo está disponible
        }
        // Verificar que todas las pruebas tengan el comentario "finalizado"
        for (Prueba prueba : pruebas) {
            if (!"finalizado".equalsIgnoreCase(prueba.getComentarios())) {
                return false;  // Si alguna prueba no tiene el comentario "finalizado", el vehículo no está disponible
            }
        }
        return true; // Si todas las pruebas tienen el comentario "finalizado", el vehículo está disponible
    }

    private boolean esLicenciaValida(Interesado interesado) {
        // Verificar si la fecha de vencimiento de la licencia no está pasada y si no tiene restricciones
        if (interesado == null || interesado.getFecha_vencimiento_licencia() == null) {
            return false;
        }
        // Convertir Date a LocalDate si es necesario
        LocalDate fechaVencimiento = interesado.getFecha_vencimiento_licencia()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        return fechaVencimiento.isAfter(LocalDate.now()) && !interesado.getRestringido();
    }

    public List<Prueba> listarPruebasEnCurso() {
        return pruebaRepository.findByFechaHoraFinIsNull();
    }

    public Prueba finalizarPrueba(Long id, String comentario) {
        Prueba prueba = pruebaRepository.findById(id).orElseThrow(() -> new RuntimeException("Prueba no encontrada"));
        prueba.setFechaHoraFin(LocalDateTime.now());
        prueba.setComentarios(comentario);
        return pruebaRepository.save(prueba);
    }
}
