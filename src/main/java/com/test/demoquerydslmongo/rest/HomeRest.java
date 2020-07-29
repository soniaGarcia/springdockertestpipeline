package com.test.demoquerydslmongo.rest;

import com.test.demoquerydslmongo.repository.VehiculoRepository;
import com.test.demoquerydslmongo.model.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.querydsl.core.types.Predicate;
import com.test.demoquerydslmongo.model.QVehiculo;
import java.util.Optional;
import org.bson.types.ObjectId;

/**
 *
 * @author Sonia
 */
@RestController
public class HomeRest {

    @Autowired
    VehiculoRepository vehiculoRepository;

    @RequestMapping("/")
    public String home() {
        return "Hello Spring Boot with Docker";
    }

    @RequestMapping("/test")
    public String helloWorld() {
        return consultarById("5ed95350b2ebd3cba1beec5c", "Hola mundo");
    }

    @RequestMapping("/consulta/{id}")
    public String consultaRegistro(@PathVariable String id) {
        return consultarById(id, "No existe registro con ese ID");
    }

    private String consultarById(String id, String nullMessage) {
        String devolver = nullMessage;
        QVehiculo qVehiculo = QVehiculo.vehiculo;
        Predicate predicate = qVehiculo.id.eq(new ObjectId(id));
        Optional<Vehiculo> result = vehiculoRepository.findOne(predicate);
        if (result.isPresent()) {
            devolver = result.get().toString();
        }
        return devolver;
    }

}
