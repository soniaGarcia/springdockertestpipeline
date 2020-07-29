package com.test.demoquerydslmongo.rest;

import com.test.demoquerydslmongo.repository.VehiculoRepository;
import com.test.demoquerydslmongo.model.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sonia
 */
@RestController
@RequestMapping(value = "/vehiculos")
public class VehiculosRest {

    @Autowired
    VehiculoRepository vehiculoRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehiculo> getVehiculos() {
        Iterable<Vehiculo> iterator = vehiculoRepository.findAll();
        List<Vehiculo> result = new ArrayList<>();
        iterator.forEach(result::add);
        return result;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void addVehiculo(@RequestBody @Valid Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
    }
}
